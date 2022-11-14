package br.edu.infnet.apppb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var imageList: List<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.idViewPager)

        imageList = ArrayList<Int>()
        imageList = imageList + R.drawable.ale
        imageList = imageList + R.drawable.arg
        imageList = imageList + R.drawable.bratrans

        viewPagerAdapter = ViewPagerAdapter(this@MainActivity, imageList)

        viewPager.adapter = viewPagerAdapter




    }
}