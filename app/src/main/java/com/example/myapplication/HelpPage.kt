package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.myapplication.R

class HelpPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.help_page)
        this.resizeContents()
    }

    fun resizeContents() {
        val displayMetrics = DisplayMetrics();
        windowManager.defaultDisplay.getMetrics(displayMetrics);
        val deviceWidth = displayMetrics.widthPixels;

        val helpPageTitle = findViewById<TextView>(R.id.helpPageTitle);
        helpPageTitle.layoutParams.width = deviceWidth - 100;

        val helpPageContent1 = findViewById<TextView>(R.id.helpPageContent1);
        helpPageContent1.layoutParams.width = deviceWidth - 100;

        val helpPageContent2 = findViewById<TextView>(R.id.helpPageContent2);
        helpPageContent2.layoutParams.width = deviceWidth - 100;

        val helpPageContent3 = findViewById<TextView>(R.id.helpPageContent3);
        helpPageContent3.layoutParams.width = deviceWidth - 100;
    }

    fun navigateMainMenu (view: View) {
        startActivity(Intent(this@HelpPage, MainActivity::class.java))
    }
}