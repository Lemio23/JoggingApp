package com.example.myapplication

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)
        this.initApp();
    }

    var isLoggedIn = false;

    //TODO do przeniesienia do innego pliku łacznie z isLoggedIn
    fun initApp() {
        this.checkIfLoggedIn();
        this.resizeContents();
    }

    fun resizeContents() {

        val displayMetrics = DisplayMetrics();
        windowManager.defaultDisplay.getMetrics(displayMetrics);
        val deviceWidth = displayMetrics.widthPixels;

        //BIG BUTTONS
        val buttonNewRoute = findViewById<Button>(R.id.newRoute);
        buttonNewRoute.layoutParams.width = deviceWidth - 100;

        val buttonRouteHistory = findViewById<Button>(R.id.routeHistory);
        buttonRouteHistory.layoutParams.width = deviceWidth -100;

        val buttonFavoriteRoutes = findViewById<Button>(R.id.favoriteRoutes);
        buttonFavoriteRoutes.layoutParams.width = deviceWidth - 100;

        val buttonAchievements = findViewById<Button>(R.id.achievements);
        buttonAchievements.layoutParams.width = deviceWidth - 100;

        //SMALL BUTTONS
        val buttonHelp = findViewById<Button>(R.id.help);
        buttonHelp.layoutParams.width = deviceWidth/3;

        val buttonInfo = findViewById<Button>(R.id.projectInfo);
        buttonInfo.layoutParams.width = deviceWidth/3;

        val buttonLogIn = findViewById<Button>(R.id.logIn);
        buttonLogIn.layoutParams.width = deviceWidth/3;

        val buttonLogOut = findViewById<Button>(R.id.logOut);
        buttonLogOut.layoutParams.width = deviceWidth/3;

        if (isLoggedIn) {
            buttonLogIn.visibility = View.GONE;
        } else {
            buttonLogOut.visibility = View.GONE;
        }

        val menuTitle = findViewById<TextView>(R.id.menuTitle);
        menuTitle.layoutParams.width = deviceWidth * 6 / 10;

        val menuLogo = findViewById<ImageView>(R.id.menuLogo);
        menuLogo.layoutParams.width = deviceWidth * 2 / 10;
        menuLogo.layoutParams.height = menuLogo.layoutParams.width;
    }

    fun checkIfLoggedIn() {

        //TODO

    }

    fun navigateRouteHistory(view: View) {
        if (!isLoggedIn) {
            showNotLoggedInDialog();
        }
    }
    fun navigateFavoriteRoutes(view: View) {
        if (!isLoggedIn) {
            showNotLoggedInDialog()
        }
    }
    fun navigateAchievements(view: View) {
        if (!isLoggedIn) {
            showNotLoggedInDialog()
        }
    }
    fun navigateHelp(view: View) {
        startActivity(Intent(this@MainActivity, HelpPage::class.java))
    }
    fun navigateProjectInfo(view: View) {
        startActivity(Intent(this@MainActivity, ProjectInfo::class.java))
    }

    private fun showNotLoggedInDialog () {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Błąd")
        builder.setMessage("Funkcjonalność niedostępna dla niezalogowanych użytkowników.")
        builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        builder.show();
    }
}