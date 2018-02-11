package com.zcl.mainapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yuxue.imageloadutils.likeCache.ImageLoader
import com.zcl.mainapp.plugs.Main2Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()

        testImageLoad()
    }

    private fun testImageLoad() {

        var imageLoad1 = ImageLoader()
        imageLoad1.displayImage("http://www.juqu8.cn/uploadfiles/20170719/2017071915070468.jpg", iv_main1)


        var imageLoad2 = com.yuxue.imageloadutils.diskCache.ImageLoader()
        imageLoad2.displayImage("http://www.juqu8.cn/uploadfiles/20170719/2017071915070468.jpg", iv_main2)

        var imageLoad3 = com.yuxue.imageloadutils.ImageLoader()
        imageLoad3.displayImage("http://www.juqu8.cn/uploadfiles/20170719/2017071915070468.jpg", iv_main3)

        var imageLoad4 = com.yuxue.imageloadutils.ImageCache.ImageLoader()
        imageLoad4.displayImage("http://www.juqu8.cn/uploadfiles/20170719/2017071915070468.jpg", iv_main4)



        iv_main4.setOnClickListener { v -> startActivity(Intent(this, Main2Activity::class.java)) }

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
