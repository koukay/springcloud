CREATE TABLE `tbl_passenger_info` (
  `id` int(11) NOT NULL DEFAULT '0',
  `phone_number` varchar(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `passenger_name` varchar(24) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `head_img` varchar(255) DEFAULT NULL,
  `passenger_type` tinyint(4) DEFAULT NULL,
  `register_type` smallint(6) DEFAULT NULL,
  `last_login_method` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_app_version_update` (
  `id` int(11) NOT NULL DEFAULT '0',
  `platform_type` int(11) DEFAULT NULL,
  `notice_type` int(11) DEFAULT NULL,
  `prompt` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `download_url` varchar(255) DEFAULT NULL,
  `operator_id` int(11) DEFAULT NULL,
  `app_type` int(11) DEFAULT NULL,
  `app_version` varchar(255) DEFAULT NULL,
  `use_status` int(11) DEFAULT NULL,
  `version_code` int(11) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

