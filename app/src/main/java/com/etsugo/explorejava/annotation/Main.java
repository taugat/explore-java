package com.etsugo.cgtraining.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.function.Consumer;

public class Main
{
	public static void main(String[] args) throws ClassNotFoundException
	{
		Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("com.etsugo.cgtraining.annotation.AClassToAnnotate");
		
		Arrays.stream(clazz.getDeclaredMethods())
//		.mapMulti(Main::getParameterAnnotation)
		.mapMulti(Main::getParameters)
		.filter(Main::isMyAnnotated)
		.forEach(System.out::println);
		
	}
	
	public static void getParameters(Method m, Consumer<Parameter> consumer)
	{
		Arrays.stream(m.getParameters()).forEach(consumer::accept);
	}
	
	public static void getParameterAnnotation(Method m, Consumer<Annotation> consumer)
	{
		Arrays.stream(m.getParameterAnnotations()).forEach(anns -> Arrays.stream(anns).forEach(consumer));
	}

	private static boolean isMyAnnotated(Parameter parameter1)
	{
		return parameter1.isAnnotationPresent(MyAnnotation.class);
	}
}
