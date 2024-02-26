package com.etsugo.explorejava.exception;

public class TryCatchFinaly
{
	static class AutoCloseableImpl implements AutoCloseable
	{
		private String name;
		
		public AutoCloseableImpl(String name)
		{
			super();
			this.name = name;
			System.out.println(name + "Create ressource");
		}

		@Override
		public void close() throws Exception
		{
			System.out.println(name + ": Close ressource");
			throw new Exception();
			
		}
	}
	
	public static void main(String[] args)
	{
		//if origin catched Exception is Uncheck, no need to catch/throws it
//		try
//		{
//			throw new NullPointerException();
//		}
//		catch(Exception e)
//		{
//			throw e;
//		}
		
		startTrying(false);
		
		startTrying(true);
	}

	private static void startTrying(boolean except)
	{
		try (AutoCloseableImpl r1 = new AutoCloseableImpl("r1"); AutoCloseableImpl r2 = new AutoCloseableImpl("r2"))
		{
			System.out.println("Trying stuff");
			
			if (except)
			{
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			System.out.println("Catching stuff");
		}
		finally
		{
			System.out.println("Doing finally stuff");
		}
	}
}
