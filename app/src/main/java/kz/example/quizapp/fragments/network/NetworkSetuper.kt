package kz.example.quizapp.fragments.network

import com.jaredsburrows.retrofit2.adapter.synchronous.SynchronousCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Arslan Tsoy <t.me/arslantsoy> on 6/2/21
 */

object NetworkSetuper {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://quizapi.io/")
        .client(
            OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(SynchronousCallAdapterFactory.create())
        .build()

    val questionApi: QuestionsApi = retrofit.create(QuestionsApi::class.java)


}