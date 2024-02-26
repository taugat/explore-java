package com.etsugo.explorejava.polymorphisme;

public class PolyChild
extends PolyParent
//implements PolyInterface, PolyInterface2
{
	
	public void myMethod2(Object toto)
	{
		System.out.println("PolyChild::myMethod2(Object)");
	}
	
	public static void main(String[] args) throws Exception
	{
		Object object = new Object() {
			@Override
			public int hashCode()
			{
				// TODO Auto-generated method stub
				return 10;
			}
		};
		System.out.println(System.identityHashCode(object));
		System.out.println(object.hashCode());
		
//		new PolyChild().myMethod2("");
//		((PolyParent)new PolyChild()).myMethod2("toto");
//		
//		System.out.println(
//		new PolyChild().myMethod("tutu", "toto")
//		);
	}

	public Object myMethod(Object obj1, Object... objs) throws Exception
	{
		Object object = objs[0];
		// TODO Auto-generated method stub
		return "toto";
	}
	
	@Override
	public Object myMethod(Object oj2) throws Exception
	{
		// TODO Auto-generated method stub
		return "tutu";
	}

//	@Override
//	public Object myMethod(Object obj) throws Exception
//	{
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public String myMethod(Object obj) throws Exception
//	{
//		// TODO Auto-generated method stub
//		return (String) PolyInterface.super.myMethod(obj);
//	}
	/*
	 * Override :
	 * 1. the params stay the same.
	 * 2. The return type can extends origin type
	 * 3. The thrown exceptions can extends origin thrown + Runtime
	 * 4. the visibility is greater than origin
	 */
//	@Override
//	public String myMethod(Object obj) throws FileNotFoundException, ClosedChannelException, RuntimeException
//	{
//		// TODO Auto-generated method stub
//		return null;
//	}

	//Overload
	
}
