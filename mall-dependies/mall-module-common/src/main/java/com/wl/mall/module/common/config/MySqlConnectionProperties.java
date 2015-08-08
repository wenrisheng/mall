package com.wl.mall.module.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("mySqlConnectionProperties")
@ConfigurationProperties(locations = {"classpath:mysql_datasource.yml"}, prefix="datasource")
public class MySqlConnectionProperties extends AbstractConnectionProperties {

			
}
