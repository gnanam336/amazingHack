package com.topcoder.listener;

public class ShareDriveListener
{
	public static void main(String[] args)
	{
		try
		{
			new FileListener().listen();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}