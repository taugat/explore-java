package com.etsugo.explorejava.memory.stackimpl;

import java.util.EmptyStackException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Stack
{
	
	public static void main(String[] args) throws InterruptedException
	{
		Thread.sleep(20_000);
		
		Stack stack = new Stack(20);
		
		Thread.sleep(5_000);
		
		Stream.generate(Object::new).limit(10000000).forEach(stack::push);
		Thread.sleep(5_000);
		IntStream.range(0, 10000000).forEach(i -> stack.pop());
		
		
		System.out.println(getUsedMemory());
		System.gc();
		System.out.println(getUsedMemory());
		Thread.sleep(1_000_000);
	}
	
	public static long getMaxMemory() {
	    return Runtime.getRuntime().maxMemory();
	}

	public static long getUsedMemory() {
	    return getMaxMemory() - getFreeMemory();
	}

	public static long getTotalMemory() {
	    return Runtime.getRuntime().totalMemory();
	}

	public static long getFreeMemory() {
	    return Runtime.getRuntime().freeMemory();
	}

// keep these two fields as they are
	private Object[] elements;
	private int size = 0;

	public Stack(int initialCapacity)
	{
		elements = new Object[initialCapacity];
	}

	public void push(Object object)
	{
		ensureCapacity();
		elements[size++] = object;
	}

	public Object pop()
	{
		if(size == 0)
		{
			throw new EmptyStackException();
		}

		Object result = elements[--size];
		
//		performReduce();
//		elements[size] = null;

		return result;
	}

//	private void performReduce()
//	{
//		if (elements.length == size/2)
//		{
//			Object[] old = elements;
//			elements = new Object[size];
//			System.arraycopy(old, 0, elements, 0, size);
//		}
//	}

	private void ensureCapacity()
	{
		if(elements.length == size)
		{
			Object[] old = elements;
			elements = new Object[2 * size + 1];
			System.arraycopy(old, 0, elements, 0, size);
		}
	}
}
