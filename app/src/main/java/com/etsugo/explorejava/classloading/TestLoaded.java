package com.etsugo.cgtraining.classloading;

public class TestLoaded {
	
    public static void main(String[] args) throws Exception {
    	
    	//add JVM args : --add-opens java.base/java.lang=ALL-UNNAMED to access findLoadedClass
         java.lang.reflect.Method m = ClassLoader.class.getDeclaredMethod("findLoadedClass", new Class[] { String.class });
         m.setAccessible(true);
         
         ClassLoader cl = ClassLoader.getSystemClassLoader();
         
         Object test1 = m.invoke(cl, "com.etsugo.cgtraining.classloading.ClassToTest");
         System.out.println("ClassToTest class object : " + test1);//not loaded
         System.out.println("ClassToParent class object : " + m.invoke(cl, "com.etsugo.cgtraining.classloading.ClassToTestParent"));
         
         Class<?> clazz = cl.loadClass("com.etsugo.cgtraining.classloading.ClassToTest");
//         Class.forName("com.etsugo.cgtraining.classloading.ClassToTest", false, ClassLoader.getSystemClassLoader());// Load the class
         System.out.println("Class for name : " + clazz);
         
         
         Object test2 = m.invoke(cl, "com.etsugo.cgtraining.classloading.ClassToTest");
         System.out.println("ClassToTest class object : " + test2);//loaded but not initialize yet
         System.out.println("ClassToParent class object : " + m.invoke(cl, "com.etsugo.cgtraining.classloading.ClassToTestParent"));
         
         ClassToTest.reportInitialization();//initializing
         
    }
}
