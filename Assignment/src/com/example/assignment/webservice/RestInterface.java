package com.example.assignment.webservice;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Swapnil Sonar
 */
public interface RestInterface {

    @GET("/imageData.php")
    void getInfo(Callback<Response> cb);

}
