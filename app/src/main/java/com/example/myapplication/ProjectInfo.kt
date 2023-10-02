package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.myapplication.R

class ProjectInfo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.project_info)
        this.resizeContents()
    }

    fun resizeContents() {
        val displayMetrics = DisplayMetrics();
        windowManager.defaultDisplay.getMetrics(displayMetrics);
        val deviceWidth = displayMetrics.widthPixels;
    }

    fun navigateMainMenu (view: View) {
        startActivity(Intent(this@ProjectInfo, MainActivity::class.java))
    }
}