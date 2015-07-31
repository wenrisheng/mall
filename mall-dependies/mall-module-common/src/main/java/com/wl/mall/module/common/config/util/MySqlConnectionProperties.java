package com.wl.mall.module.common.config.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("mySqlConnectionProperties")
@ConfigurationProperties(locations = {"classpath:mysql_datasource.properties"}, prefix="datasource")
public class MySqlConnectionProperties extends AbstractConnectionProperties {

			
}
