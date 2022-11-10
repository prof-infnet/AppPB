package br.edu.infnet.apppb

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //val backgroundImage: ImageView = findViewById(R.id.SplashCircular)
        //val sideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        // backgroundImage.startAnimation(sideAnimation)

        Handler(
            Looper.getMainLooper())
            .postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000)
    }
}