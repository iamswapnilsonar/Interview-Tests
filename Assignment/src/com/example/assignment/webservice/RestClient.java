package com.example.assignment.webservice;

import retrofit.RestAdapter;

/**
 * @author Swapnil Sonar
 */
public class RestClient {
	
	public static final String BASE_URL = "http://192.168.10.104/";
	
	private RestInterface restInterface;

	public RestClient() {

		RestAdapter restAdapter = new RestAdapter.Builder()
				.setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(BASE_URL)
				.build();
		restInterface = restAdapter.create(RestInterface.class);
	}

	public RestInterface getRestInterface() {
		return restInterface;
	}
}
