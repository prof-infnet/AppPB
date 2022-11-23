package br.edu.infnet.apppb

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.infnet.apppb.databinding.ActivityHomeBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeActivity : AppCompatActivity() {


    private lateinit var binding : ActivityHomeBinding
    private var anuncioInter: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Inicialização do Admob
        MobileAds.initialize(this) {}

       val adRequest = AdRequest.Builder().build()
       binding.adView.loadAd(adRequest)

        requestNewInterstitial()

        //requestReward()

        getData()
    }


    private fun requestNewInterstitial() {
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d("INTERSTTIAL", adError.message)
                    anuncioInter =null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d("INTERSTITIAL", "Ad was loaded.")
                    anuncioInter = interstitialAd
                    configureFullScreen()
                }


            }
        )
    }

    private fun configureFullScreen() {
        anuncioInter?.fullScreenContentCallback = createFullScreenCalback("INTERSTITIAL") {
            anuncioInter = null
        }
    }

    private fun createFullScreenCalback(TAG: String, funcao: () -> Unit ): FullScreenContentCallback
            = object : FullScreenContentCallback() {
        override fun onAdDismissedFullScreenContent() {
            Log.d(TAG, "Ad was dismissed.")
        }
            }


    private fun requestReward() {

    }

    fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://jsonplaceholder.typicode.com")
        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getPosts()
        callback.enqueue(object : Callback<List<Posts>> {
            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                response.body()?.forEach {


                    binding.idTexto.text = binding.idTexto.text.toString().plus(it.body)


                }
            }
        })
    }

    fun interClick(view: View) {
        if(anuncioInter != null){
            anuncioInter?.show(this)
        }
        else{
            Log.d("INTERSTITIAL", "The interstitial ad wasn't ready yet.")
        }
    }

    fun rewardClick(view: View) {}


}