package com.google.mcommerce.sample.android.chapter09.notification;

import android.content.Intent;
import android.util.Log;

/*
 * Uses IntentService as the base class
 * to make this work on a separate thread.
 */
public class Test30SecBCRService 
extends ALongRunningNonStickyBroadcastService
{
	public static String tag = "Test30SecBCRService";
	
	//Required by IntentService
	public Test30SecBCRService() {
		super("com.ai.android.service.Test30SecBCRService");
	}
	/*
	 * Perform long running operations in this method.
	 * This is executed in a separate thread. 
	 */
	@Override
	protected void handleBroadcastIntent(Intent broadcastIntent) 
	{
		Utils.logThreadSignature(tag);
		Log.d(tag,"Sleeping for 30 secs");
		Utils.sleepForInSecs(30);
		String message = 
			broadcastIntent.getStringExtra("message");
		Log.d(tag,"Job completed");
		Log.d(tag,message);
	}
}
