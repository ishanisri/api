package com.example.ishanisrivastava.got.network;

import com.example.ishanisrivastava.got.model.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {
    @GET("/charcters/:")
    Call<RetroPhoto> getCharacterDetails(
    @Query("name") String name);
}
