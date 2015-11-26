package com.example.assignment.commans;

import android.app.Application;

import com.example.assignment.webservice.RestClient;

public class AssignApplication extends Application {

	private static RestClient restClient;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		restClient = new RestClient();	
	}

	public static RestClient getRestClient() {
		if (null == restClient) {
			restClient = new RestClient();
		}
		return restClient;
	}
	
	@Override
	public void onTerminate() {
		super.onTerminate();
	}
}
