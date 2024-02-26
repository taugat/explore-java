package com.etsugo.cgtraining.classloading;

class Super2 {
    static { System.out.println("static Super2 "); }
}
class Child2 extends Super2 {
	public static int staticVal = 1;
    static { System.out.println("static Child2 "); }
}

class Super {
    static { System.out.println("static Super "); }
    int nonStaticVal1 = InitializationOrder.set(1, "non static Super");
}
class One {
    static { System.out.println("static One "); }
    public static int val = 1;
}
class Two extends Super {
    static { System.out.println("static Two "); }
    
    int nonStaticVal1 = InitializationOrder.set(1, "non static Two");
}

interface SuperInterface {
	int siConst = 0;
	int si = InitializationOrder.set(1, "superInterface");
}

interface Interface extends SuperInterface {
	int i1 = InitializationOrder.set(2, "interface i1");
	int i2 = InitializationOrder.set(3, "interface i2");
}

interface ChildInterface extends Interface {
	int ci = InitializationOrder.set(4, "childInterface");
}

public class InitializationOrder
{
	public static void main(String[] args) {
		
		One o = null;//static one is not run
//		System.out.println(o);
//		System.out.println(One.val);
		
		// Call static member of class
		System.out.println(Child2.staticVal);//run static Super2 then static Child
		
		// Call non-static of a class :
		Two t = new Two();//run static Super then static Two then non-static Super then non-static Two
		
		System.out.println("--Interface--");
		
		//Call static member with a constant value on an interface
		System.out.println(SuperInterface.siConst);// constant do not cause SuperInterface to be initialize
		
		//Call static member of a non-constant value
		/*
		 * ChildInterface.i1 is a reference to a field actually declared in interface Interface
		 * that is not a constant variable;
		 * this causes initialization of the fields of interface Interface,
		 * but not those of its superinterface SuperInterface, nor those of interface ChildInterface
		 */
		System.out.println(ChildInterface.i1);
		
	}

	public static int set(int i, String string)
	{
		System.out.println(string);
		return i;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
}
