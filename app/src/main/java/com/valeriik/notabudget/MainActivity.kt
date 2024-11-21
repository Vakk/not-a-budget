package com.valeriik.notabudget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.valeriik.home.ui.HomeScreen
import com.valeriik.navigation.NavigationConstants
import com.valeriik.notabudget.ui.theme.MyApplicationTheme
import com.valeriik.settings.ui.SettingsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme(dynamicColor = false) {
                val navController = rememberNavController()

                NavHost(navController = navController, NavigationConstants.Routes.HOME) {
                    composable(NavigationConstants.Routes.HOME) {
                        HomeScreen(navController)
                    }
                    composable(NavigationConstants.Routes.SETTINGS) {
                        SettingsScreen(navController)
                    }
                    composable(NavigationConstants.Routes.NOTEBOOK_DETAILS) {
                    }
                }
            }
        }
    }
}