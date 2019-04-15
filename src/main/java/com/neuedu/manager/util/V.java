package com.neuedu.manager.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import com.neuedu.manager.ex.BaseException;
import com.neuedu.manager.ex.InvalidParamException;
public class V {
	/**
	 * 验证字符串是否为空
	 * @param str
	 * @return
	 * @throws InvalidParamException 
	 */
	public static void isEmpty(HttpServletRequest req,String... strs) {
		for(int i =0; i < strs.length; i++) {
			String key = strs[i];
			String str = req.getParameter(key);
			if(str == null || str.length() == 0) {
				try {
					throw new InvalidParamException(str + "不能为空");
				} catch (BaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}
	
	/**
	 * 自动创建对象
	 * @param req
	 * @param clz
	 * @param keys
	 * @return
	 */
	public static <T> T entity(HttpServletRequest req,Class clz,String[] keys) {
		try {
			//创建对象
			T instance = (T) clz.newInstance();
			for(String key : keys) {
				//获取指定参数
				String paramValue = req.getParameter(key);
				String param = NameUtil.toCamel(key, true);
				//构造set方法名称
				String setMethod = "set" + param;
			    //获取参数类型
				String paramName = NameUtil.toCamel(key, false);
				Field field = clz.getDeclaredField(paramName);
				Class paramType = field.getType();
				//参数类型的字符串表示
				String typeName = paramType.getTypeName();
				Object value = null;
				//根据参数类型将获取的参数转换为对应类型
				if(typeName.equals("java.lang.Integer") || typeName.equals("int")) {
					value = Integer.parseInt(paramValue);
				} else if(typeName.equals("java.lang.Double") || typeName.equals("double")) {
					value = Double.parseDouble(paramValue);
				} else if(typeName.equals("java.lang.Long") || typeName.equals("long")) {
					value = Long.parseLong(paramValue);
				} else {
					value = paramValue;
				}
				//调用set方法为对象赋值
				Method method = clz.getMethod(setMethod, paramType);
				method.invoke(instance, value);
			}
			
			return instance;
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * 从请求中获取指定参数
	 * @param req
	 * @param key
	 * @param def
	 * @return
	 */
	public static String getData(HttpServletRequest req, String key, String def) {
		String value = req.getParameter(key);
		if(value == null) {
			return def;
		}
		return value;
	}
}
