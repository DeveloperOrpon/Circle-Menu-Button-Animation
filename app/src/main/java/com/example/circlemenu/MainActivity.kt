package com.example.circlemenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.akki.circlemenu.OnCircleMenuItemClicked
import com.ramotion.circlemenu.CircleMenuView
import kotlinx.android.synthetic.main.activity_main.*
const val TAG="MainActivity"
class MainActivity : AppCompatActivity(), OnCircleMenuItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //com.akki.circlemenu.CircleMenu
        CircleMenu.setOnMenuItemClickListener(this)
        //com.ramotion.circlemenu.CircleMenuView
        val menu = findViewById<CircleMenuView>(R.id.circle_menuid)
        menu.eventListener = object : CircleMenuView.EventListener() {
            override fun onMenuOpenAnimationStart(view : CircleMenuView) {
                Log.i(TAG, "onMenuOpenAnimationStart");
            }
        }

    }

    override fun onMenuItemClicked(id: Int) {
        when (id) {
            R.drawable.ic_baseline_home_24 -> showToast("Home Button clicked")
            R.drawable.ic_baseline_place_24 -> showToast("Place Button clicked")
            R.drawable.ic_baseline_settings_24 -> showToast("Setting Button clicked")
            R.drawable.ic_baseline_search_24 -> showToast("search Button clicked")
            R.drawable.ic_baseline_notifications_24 -> showToast("Notifications Button clicked")
        }
    }

    private fun showToast(s: String) {
        Toast.makeText(this,"$s",Toast.LENGTH_SHORT).show()
    }
}