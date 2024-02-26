package com.etsugo.cgtraining.polymorphisme;

public interface PolyInterface
{
	default
	Object myMethod(Object obj) throws Exception
//	;
	{
		return "polyI1";
	}
}
