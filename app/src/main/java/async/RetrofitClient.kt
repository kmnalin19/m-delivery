package async

import io.reactivex.Observable
import com.app.delivery.mvp.models.Delivery
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface RetrofitClient {

    @GET("deliveries")
    fun requestDeliveryList(): Observable<ArrayList<Delivery>>

    companion object {

        fun createClient(): RetrofitClient {
            return createRetrofitClient("https://mock-api-mobile.dev.lalamove.com/")
        }

        fun createRetrofitClient(baseUrl: String): RetrofitClient {

            val client = OkHttpClient.Builder()
            client.connectTimeout(100, TimeUnit.SECONDS)
            client.readTimeout(30, TimeUnit.SECONDS)

            return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .client(client.build())
                .build().create(RetrofitClient::class.java)
        }
    }
}