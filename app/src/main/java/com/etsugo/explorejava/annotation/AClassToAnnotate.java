package com.etsugo.cgtraining.annotation;

public class AClassToAnnotate
{
	private String stringField;

	public String getStringField(int temp)
	{
		return stringField;
	}

	public void setStringField(@MyAnnotation(1) String stringField)
	{
		this.stringField = stringField;
	}
}
