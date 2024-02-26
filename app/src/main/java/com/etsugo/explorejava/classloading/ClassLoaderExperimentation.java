package com.etsugo.explorejava.classloading;

import java.sql.DriverManager;
import java.util.ArrayList;

public class ClassLoaderExperimentation
{
	public static void main(String[] args)
	{
		// Appplication or system class loader : loads our own files in the classpath.
		// It loads files found in the classpath environment variable, -classpath, or -cp command line option : -cp "folder/*;."
		System.out.println("this class loader    : " + ClassLoaderExperimentation.class.getClassLoader());
		System.out.println("System class loader  : " + ClassLoader.getSystemClassLoader());
		
		// Extension class loaders : load classes that are an extension of the standard core Java classes
		// load lib/ext or any other mentioned in java.ext.dir : -Djava.ext.dirs=folder
		System.out.println("DriverManager loader : " + DriverManager.class.getClassLoader());
		System.out.println("Plateform classloader: " + ClassLoader.getPlatformClassLoader()); // if <9 ClassLoader.getSystemClassLoader().getParent();
		
		// Bootstrap or primordial class loader : is the parent of all the others.
		// displays null because it's written in native code, so it doesn’t show up as a Java class
		// load /lib
		System.out.println("ArrayList loader     : " + ArrayList.class.getClassLoader());
		
		/*
		 *  Visibility Principle:
		 *  A class loaded by a parent ClassLoader is visible to the child ClassLoaders
		 *  but a class loaded by a child ClassLoader is not visible to the parent ClassLoaders.
		 */
		try
		{
			ClassLoader.getSystemClassLoader().loadClass("java.sql.DriverManager");
			System.out.println("System class loader loads DriverManager");
		}
		catch(ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
//			Class.forName(null, false, null)
			ClassLoader.getPlatformClassLoader().loadClass("com.etsugo.cgtraining.classloading.ClassLoaderExperimentation");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("this is not visible for platform class loader");
			e.printStackTrace();
		}
		
		
//		ClassLoader classLoader;
//		classLoader.loadClass(null);
		
		//list classes arg : --verbose:class , -Xlog:class+load=info:classloaded.txt (>=9)
		
		
	}

}
