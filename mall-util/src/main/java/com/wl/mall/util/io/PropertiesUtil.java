package com.wl.mall.util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * 属性文件工具类
 * 
 * @author 纪建宏
 *
 */
public class PropertiesUtil {

	public static Properties loadProperties(String filePath) throws IOException {
		File file = FileUtil.getFile(filePath);
		InputStream inputStream =  new FileInputStream(file);
		Reader reader = new InputStreamReader(inputStream);
	Properties properties =	loadProperties(reader);
	return properties;
	}
	
	/**
	 * 加载属性文件
	 * 
	 * @param file
	 *            文件
	 * @param encoding
	 *            编码
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static Properties loadProperties(File file, String encoding)
			throws UnsupportedEncodingException, IOException {
		return loadProperties(new FileInputStream(file), encoding);
	}

	/**
	 * 加载属性文件
	 * 
	 * @param inputStream
	 *            输入源
	 * @param encoding
	 *            编码
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static Properties loadProperties(InputStream inputStream,
			String encoding) throws UnsupportedEncodingException, IOException {
		return loadProperties(new InputStreamReader(inputStream, encoding));
	}

	/**
	 * 加载属性文件
	 * 
	 * @param reader
	 *            输入源
	 * @return
	 * @throws IOException
	 */
	public static Properties loadProperties(Reader reader) throws IOException {
		Properties properties = new Properties();
		properties.load(reader);
		return properties;
	}

	/**
	 * 加载属性文件为LinkedHashMap对象，用于保存配置顺序
	 * 
	 * @param reader
	 *            输入源
	 * @return
	 * @throws IOException
	 */
	public static LinkedHashMap<String, String> loadPropertiesAsLinkedHashMap(
			Reader reader) throws Exception {
		LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();

		PropertiesConfiguration config = new PropertiesConfiguration();
		config.load(reader);
		//本身读取就是正常顺序,还进行转换？？
		Iterator<String> keys = config.getKeys();

		while (keys.hasNext()){
			String key = keys.next();
			String val = config.getString(key);
			result.put(key,val);
		}

		return result;
	}
	
	/**
	 * 加载属性文件为LinkedHashMap对象，用于保存配置顺序
	 * 
	 * @param reader
	 *            输入源
	 * @return
	 * @throws IOException
	 */
	public static LinkedHashMap<String, String> getMapFromPropertiesFile(
			String filePath) throws Exception {
		File file = FileUtil.getFile(filePath);
		InputStream inputStream =  new FileInputStream(file);
		Reader reader = new InputStreamReader(inputStream);
		LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();

		PropertiesConfiguration config = new PropertiesConfiguration();
		config.load(reader);
		//本身读取就是正常顺序,还进行转换？？
		Iterator<String> keys = config.getKeys();

		while (keys.hasNext()){
			String key = keys.next();
			String val = config.getString(key);
			result.put(key,val);
		}

		return result;
	}


}
