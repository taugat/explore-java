package com.etsugo.cgtraining.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler
{
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable
	{
		System.out.println("Invoke : " + arg0.getClass().descriptorString() + " method : " + arg1.getName());
		return 10;
	}

}
