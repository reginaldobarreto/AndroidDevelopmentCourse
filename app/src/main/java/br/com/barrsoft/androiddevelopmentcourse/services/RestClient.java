package br.com.barrsoft.androiddevelopmentcourse.services;

import android.util.Log;
import br.com.barrsoft.androiddevelopmentcourse.interfaces.APIService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static final String BASE_URL = "https://api.spacexdata.com/v2/";
    private static final String TAG = RestClient.class.getName();

    public static APIService getService(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.i(TAG,"getService()");
        return retrofit.create(APIService.class);
    }
}
