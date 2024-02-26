package com.etsugo.cgtraining.polymorphisme;

public interface PolyInterface2
{
	default
	Object myMethod(Object obj) throws Exception
//	;
	{
		return "polyI2";
	}
}
