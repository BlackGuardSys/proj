package com.example.proj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import io.ktor.http.cio.*
import okhttp3.OkHttpClient
import java.io.IOException
import javax.security.auth.callback.Callback


class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val client = OkHttpClient()
        fun onCreate(savedInstanceState: Bundle?)
        { super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            run("https://github.com/trending")
        }
        fun run(url: String)
        {
            val request = Request .builder() .url(url) .build()
            client.newCall(request).enqueue(object : Callback {
                fun onFailure(call: Call, e: IOException) {}
                fun onResponse(call: Call, response: Response) = println(response.body()?.string())
            })
        }



    }

    private fun toastMeState(message: String) {
        Toast.makeText(this, "${lifecycle.currentState}, $message", Toast.LENGTH_LONG).show()
    }
    override fun onResume() {
        super.onResume()
        toastMeState("ON_RESUME")
    }
    override fun onPause() {
        super.onPause()
        toastMeState("ON_PAUSE")
    }
    override fun onStop() {
        super.onStop()
        toastMeState("ON_STOP")
    }

}

private fun Call.enqueue(responseCallback: Callback) {

}
