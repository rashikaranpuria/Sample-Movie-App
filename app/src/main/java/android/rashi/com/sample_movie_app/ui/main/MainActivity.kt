package android.rashi.com.sample_movie_app.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.rashi.com.sample_movie_app.R
import android.rashi.com.sample_movie_app.ui.base.BaseActivity

class MainActivity : BaseActivity(), IMainActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
