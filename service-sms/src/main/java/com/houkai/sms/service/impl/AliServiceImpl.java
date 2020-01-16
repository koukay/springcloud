package com.houkai.sms.service.impl;

import com.houkai.common.dto.sms.SmsSendRequest;
import com.houkai.common.dto.sms.SmsTemplateDto;
import com.houkai.common.entity.Sms;
import com.houkai.common.entity.SmsTemplate;
import com.houkai.sms.constant.SmsStatusEnum;
import com.houkai.sms.mapper.SmsMapper;
import com.houkai.sms.mapper.SmsTemplateMapper;
import com.houkai.sms.service.AliService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AliServiceImpl implements AliService {
    /**
     *   缓存用于替换内容的模板
     */
    private Map<String, String> templateMaps = new HashMap<String, String>();

    @Autowired
    private SmsTemplateMapper smsTemplateMapper;

    @Autowired
    private SmsMapper smsMapper;
    @Override
    public int senSms(SmsSendRequest request) {
        log.info(request.toString());
        for (String phoneNumber : request.getReceivers()) {
            List<SmsTemplateDto> templates = request.getData();
            Sms sms= new Sms();
            sms.setPhoneNumber(phoneNumber);
            for (SmsTemplateDto template : templates) {
                //从DB加载模板内容至缓存
                if (!templateMaps.containsKey(template.getId())) {
                    SmsTemplate smsTemplate = smsTemplateMapper.selectByTemplateId(template.getId());
                    System.out.println(smsTemplate.getContent());
                    templateMaps.put(template.getId(),smsTemplate.getContent());
                }

                //替换占位符
                String content = templateMaps.get(template.getId());
                for (Map.Entry<String, Object> entry : template.getTemplateMap().entrySet()) {
                    content = StringUtils.replace(content, "${" + entry.getKey() + "}", "" + entry.getValue());
                }

                // 发生错误时，不影响其他手机号和模板的发送
                try {
                    int result = send(phoneNumber, template.getId(), template.getTemplateMap());

                    // 组装SMS对象
                    sms.setSendTime(new Date());
                    sms.setOperator("");
                    sms.setSendFlag(1);
                    sms.setSendNumber(0);
                    sms.setSmsContent(content);

                    if (result != SmsStatusEnum.SEND_SUCCESS.getCode()) {
                        throw new Exception("短信发送失败");
                    }
                } catch (Exception e) {
                    sms.setSendFlag(0);
                    sms.setSendNumber(1);
                    log.error("发送短信（" + template.getId() + "）失败：" + phoneNumber, e);
                } finally {
                    sms.setCreateTime(new Date());
                    smsMapper.insert(sms);
                }
            }

        }
        return 0;
    }


    private int send(String phoneNumber, String templateId, Map<String, ?> map) throws Exception {
        JSONObject param = new JSONObject();
        param.putAll(map);

        return sendMsg(phoneNumber, templateId, param.toString());
    }

    private int sendMsg(String phoneNumber, String templateCode, String param) {
        /**
         * 按照短信供应商的api编写即可
         */
        return SmsStatusEnum.SEND_SUCCESS.getCode();

    }
}
