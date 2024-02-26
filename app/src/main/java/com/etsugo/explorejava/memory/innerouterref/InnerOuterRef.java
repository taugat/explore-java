package com.etsugo.cgtraining.memory.innerouterref;

public class InnerOuterRef
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread.sleep(5_000);
		createOutIn();
		System.gc();
		Thread.sleep(10_000);
	}

	private static void createOutIn()
	{
		for (int i = 0; i < 10000000; i++)
		{
			Outer outer = new Outer();
		}
	}
}
