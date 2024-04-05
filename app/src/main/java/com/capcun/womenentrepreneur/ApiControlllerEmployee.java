package com.capcun.womenentrepreneur;

import com.capcun.womenentrepreneur.fetchPosts.fetchAllPosts;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiControlllerEmployee {

    // give url of your api folder
    static final String url = "https://brickzoneprop.com/WomenEM/APIS/";

    private static ApiControlllerEmployee clientObject;

    // Create object of retrofit
    private static Retrofit retrofit;

    ApiControlllerEmployee()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiControlllerEmployee getInstance()
    {
        if(clientObject == null)
            clientObject = new ApiControlllerEmployee();
        return clientObject;
    }


    public FetchAdIDApi fetchAdIDApi() {return retrofit.create(FetchAdIDApi.class);}
    public fetchAllPosts fetchingPost() {return retrofit.create(fetchAllPosts.class);}

}
