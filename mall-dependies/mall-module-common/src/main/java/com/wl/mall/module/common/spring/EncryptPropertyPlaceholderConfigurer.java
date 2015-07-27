package com.wl.mall.module.common.spring;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.wl.mall.util.security.DESUtils;



public class EncryptPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {

	// 需要解密的
	private String[] encryptPropNames = { "username", "password" };

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {

		// TODO Auto-generated method stub
		if (isEncryptProp(propertyName)) {
			String decryptValue = DESUtils.getDecryptString(propertyValue);
			return decryptValue;
		} else {
			return propertyValue;

		}
		// return super.convertProperty(propertyName, propertyValue);
	}

	/**
	 * 判断是否是加密的属性
	 * 
	 * @param propertyName
	 * @return
	 */
	private boolean isEncryptProp(String propertyName) {

		for (String encryptpropertyName : encryptPropNames) {
			if (encryptpropertyName.equals(propertyName))
				return true;
		}
		return false;
	}
}
