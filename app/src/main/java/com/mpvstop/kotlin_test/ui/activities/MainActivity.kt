package com.mpvstop.kotlin_test.ui.activities

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.mpvstop.kotlin_test.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : DaggerAppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.navigation_host_fragment)
        val appBarConfig: AppBarConfiguration =
            AppBarConfiguration.Builder( /*topLevelDestinationIds=*/
                R.id.user_fragment
            )
                .build()

        NavigationUI.setupWithNavController(
            main_toolbar, navController, appBarConfig
        )
        setSupportActionBar(main_toolbar)
        setupActionBarWithNavController(this, navController)
    }


}