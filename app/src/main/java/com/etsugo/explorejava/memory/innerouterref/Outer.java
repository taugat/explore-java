package com.etsugo.explorejava.memory.innerouterref;

public class Outer
{

	private Inner inner;

	public Outer()
	{
		inner = new Inner(this) {};
	}

	public void setInner(Inner inner)
	{
		this.inner = inner;
		
	}

}
