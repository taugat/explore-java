package com.etsugo.explorejava.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.logging.Logger;

public class Main
{
	private static Logger logger = Logger.getLogger("com.etsugo.cgtraining.reflection.main");
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		//Use of Proxy
		Runnable newProxyInstance = (Runnable) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[] {Runnable.class}, new MyInvocationHandler());
		newProxyInstance.run();
		
		//Get fields
		Field[] aClassFields = new AClass().getClass().getDeclaredFields();
		Arrays.asList(aClassFields).forEach(field -> logger.info(field.getName()));
		
		//Check modifiers
		logger.info( "" +
		Modifier.isPublic(Class.forName("com.etsugo.cgtraining.reflection.AClass").getModifiers())
		);
		
		//Constructors
		Constructor<?>[] constructors = Class.forName("com.etsugo.cgtraining.reflection.AClass").getConstructors();
		
		AClass newInstance = (AClass) constructors[0].newInstance();
		logger.info("" + newInstance);
		
		//Set a public field
		aClassFields[1].set(newInstance, 22);
		logger.info("" + aClassFields[1].get(newInstance));
		//Set a private field
		aClassFields[0].trySetAccessible();
		aClassFields[0].set(newInstance, "tutu");
		logger.info("" + aClassFields[0].get(newInstance));
		
//		System.out.println(Class.forName("com.etsugo.cgtraining.reflection.AClass").getAnnotations()[0]);
		
	}
}
