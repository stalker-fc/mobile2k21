package ru.itmo.mobile2k21.third

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import com.google.gson.Gson
import okhttp3.*
import java.io.BufferedInputStream
import java.io.IOException


class CatsClient(
    val catImage: ImageView
) {
    data class RandomCat(
        val success: Boolean,
        val resourceId: Int
    )
    private val mainHandler: Handler = Handler(Looper.getMainLooper())
    private val client = OkHttpClient()
    private val gson = Gson()

    fun getRandomCat() {
        val request = Request.Builder()
            .url("http://10.0.2.2:8080/random")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("CatsClient", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")
                    val randomCat: RandomCat = gson.fromJson( response.body!!.string(), RandomCat::class.java)
                    getCatImage(randomCat.resourceId)
                }
            }
        })
    }

    fun getCatImage(catId: Int) {
        val url = "http://10.0.2.2:8080/resource/${catId}"
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("CatsClient", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")
                    val inputStream = response.body!!.byteStream()
                    Log.i("inputStream", "inputstream value = $inputStream")
                    val bufferedInputStream = BufferedInputStream(inputStream)
                    val bitmap = BitmapFactory.decodeStream(bufferedInputStream)
                    mainHandler.post {
                        catImage.setImageBitmap(bitmap)
                    }
                }
            }
        })
    }
    private fun setImage(bitmap: Bitmap) {
        catImage.setImageBitmap(bitmap)
    }
}