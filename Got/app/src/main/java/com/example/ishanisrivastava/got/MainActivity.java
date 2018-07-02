package com.example.ishanisrivastava.got;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ishanisrivastava.got.model.RetroPhoto;
import com.example.ishanisrivastava.got.network.GetDataService;
import com.example.ishanisrivastava.got.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetDataService apiService =
                RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<RetroPhoto> call = apiService.getCharacterDetails("ygritte");
        call.enqueue(new Callback<RetroPhoto>() {
            @Override
            public void onResponse(Call<RetroPhoto>call, Response<RetroPhoto> response) {
                String tracks = response.body().getName();

                Log.d("hi", "Number of tracks received: " + tracks);
            }

            @Override
            public void onFailure(Call<RetroPhoto>call, Throwable t) {
                // Log error here since request failed
                Log.e("hi", t.toString());
            }
        });


    }
}
