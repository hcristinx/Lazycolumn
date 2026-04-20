package com.example.catalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.catalogo.navigation.AppNavigation
import com.example.catalogo.ui.theme.CatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // IA generated: Enable edge-to-edge support for a modern look
        enableEdgeToEdge()
        setContent {
            // IA generated: Main entry point for the Material 3 Catalog app using the project theme
            CatalogoTheme {
                AppNavigation()
            }
        }
    }
}
