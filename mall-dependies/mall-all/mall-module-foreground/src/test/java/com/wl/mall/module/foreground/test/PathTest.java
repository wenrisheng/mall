package com.wl.mall.module.foreground.test;

import java.io.IOException;
import java.util.Properties;

import com.wl.mall.module.common.config.database.EntityManagerProductFactory;
import com.wl.mall.util.io.FileUtil;
import com.wl.mall.util.io.PropertiesUtil;
import com.wl.mall.util.path.PathUtil;

public class PathTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		String projectPath = PathUtil.getProjectPath();
//		String realPath = PathUtil.getRealPath();
//		String classPath = PathUtil
//				.getAppPath(EntityManagerProductFactory.class);
//		String  classPathString1 = FileUtil.getClassPath();
//		System.out.println("projectPath:" + projectPath);
//		System.out.println("realPath:" + realPath);
//		System.out.println("classPath:" + classPath);
//		System.out.println("classPathString1:" + classPathString1);
//		
//	Properties	properties = PropertiesUtil.loadProperties(classPath + "hibernate.properties");
//System.out.println(properties.getProperty("test"));


Class testClass =  EntityManagerProductFactory.class;
ClassLoader loader = testClass.getClassLoader();
//获得类的全名，包括包名
		String clsName = testClass.getName();

		// 将类的class文件全名改为路径形式

		String clsPath = clsName.replace(".", "/") + ".class";

		// 调用ClassLoader的getResource方法，传入包含路径信息的类文件名

		java.net.URL url = loader.getResource(clsPath);

		// 从URL对象中获取路径信息

		String realPath = url.getPath();
		System.out.println("realPath" + realPath);
		// 去掉路径信息中的协议名"file:"

		int pos = realPath.indexOf("file:");

		if (pos > -1) {

			realPath = realPath.substring(pos + 5);

		}

		// 去掉路径信息最后包含类文件信息的部分，得到类所在的路径

		pos = realPath.indexOf(clsPath);

		realPath = realPath.substring(0, pos - 1);
System.out.println("realPath" + realPath);
		// 如果类文件被打包到JAR等文件中时，去掉对应的JAR等打包文件名

		if (realPath.endsWith("!")) {

			realPath = realPath.substring(0, realPath.lastIndexOf("/"));

		}

		java.io.File file = new java.io.File(realPath);

		realPath = file.getAbsolutePath();

		try {

			realPath = java.net.URLDecoder.decode(realPath, "utf-8");
			System.out.println("realPath" + realPath);
			
			Properties	properties = PropertiesUtil.loadProperties(realPath  +"/" + "hibernate.properties");
			System.out.println(properties.getProperty("test"));
		} catch (Exception e) {

			throw new RuntimeException(e);

		}
	
	}

}
