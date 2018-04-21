package com.jsantini.testandroidsantander.data.source.service;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jsantini.testandroidsantander.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jsantini on 21/04/18.
 */

public class SantanderApi {

    private static SantanderApi.SantanderApiContract santanderApiContract;

    public static SantanderApi.SantanderApiContract getApi(final Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = chain.request().newBuilder();
                requestBuilder.header("Content-Type", "application/json");
                requestBuilder.header("Accept", "application/json");
                requestBuilder.method(original.method(), original.body());
                Response response = chain.proceed(requestBuilder.build());

                return response;
            }
        });

        OkHttpClient okClient = builder.build();

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        Retrofit client = new Retrofit.Builder()
                .baseUrl(BuildConfig.SANTANDER_URL)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        santanderApiContract = client.create(SantanderApiContract.class);
        return santanderApiContract;
    }

    public interface SantanderApiContract {

    }
}
