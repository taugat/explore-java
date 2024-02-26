package com.etsugo.cgtraining.classloading;

import java.lang.instrument.Instrumentation;

public class ListLoadedClassesAgent
{
	private static Instrumentation instrumentation;
	
	public static void premain(String agentArgs, Instrumentation instrumentation)
	{
        ListLoadedClassesAgent.instrumentation = instrumentation;
    }
}
