package com.example.vk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.vk.data.applist.AppListApi
import com.example.vk.ui.applist.AppListScreen
import com.example.vk.ui.theme.VKTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKTheme {
                AppListScreen(apps = AppListApi().getApps())
            }
        }
    }
}
