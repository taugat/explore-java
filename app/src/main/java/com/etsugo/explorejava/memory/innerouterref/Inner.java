package com.etsugo.explorejava.memory.innerouterref;

public abstract class Inner
{

	private Outer outer;

	public Inner(Outer outer)
	{
		this.outer = outer;
	}

}
