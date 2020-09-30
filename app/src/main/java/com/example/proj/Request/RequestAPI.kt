package com.example.proj.Request


import android.os.AsyncTask
import android.widget.TextView
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path



interface RequestAPI {



    abstract val moshi: Moshi
    val retrofit: Retrofit.Builder
        get() = Retrofit.Builder()
            .baseUrl("https://api.mydomain.com")
            .addConverterFactory(MoshiConverterFactory.create(moshi))

    @GET("https://github.com/trending")

    suspend fun getUserRepos(@Path("username") username: String): List<TextView>
}




//.baseUrl("https://github.com/trending")