package com.valid.jpgarcia.topartists.webservice;

import com.valid.jpgarcia.topartists.model.artist.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServiceClient {

    @GET("2.0")
    Call<Data> getArtist(@Query("method") String method, @Query("country") String country, @Query("api_key") String apiKey, @Query("format") String format);
}
