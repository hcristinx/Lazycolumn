package com.example.catalogo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.catalogo.screens.ComponentDetailScreen
import com.example.catalogo.screens.ComponentListScreen

// IA generated: Navigation configuration for the app
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {
        // Main list screen
        composable("list") {
            ComponentListScreen(navController = navController)
        }
        
        // Dynamic detail screen with argument
        composable(
            route = "detail/{componentId}",
            arguments = listOf(navArgument("componentId") { type = NavType.StringType })
        ) { backStackEntry ->
            val componentId = backStackEntry.arguments?.getString("componentId") ?: ""
            ComponentDetailScreen(navController = navController, componentId = componentId)
        }
    }
}
