package com.etsugo.explorejava.classloading;

public class ClassToTest extends ClassToTestParent
{
	static {
		System.out.println("Initialize " + ClassToTest.class.getName());
	}
	
	static void reportInitialization() {
		System.out.println("Initialized");
	}
}
