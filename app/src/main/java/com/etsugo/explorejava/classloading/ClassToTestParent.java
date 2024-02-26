package com.etsugo.cgtraining.classloading;

public class ClassToTestParent
{
	static {
		System.out.println("Initialize " + ClassToTestParent.class.getName());
	}
	
	static void reportLoaded() {
		System.out.println("Initialized");
	}
}
