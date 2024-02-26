package com.etsugo.cgtraining.polymorphisme;

public abstract class PolyParent
{
	public 
//	abstract
	Object myMethod(Object obj) throws Exception
//	;
	{
		return "parent";
	}
	
	public void myMethod2(String toto)
	{
		System.out.println("PolyParent::myMethod2(String)");
	}
}
