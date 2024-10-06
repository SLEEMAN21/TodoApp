package com.example.todoapp.base
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable


import com.example.todoapp.ui.theme.TODOAPPTheme

abstract class BaseActivity : ComponentActivity() {


    @Composable
    abstract fun Content()

    final  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TODOAPPTheme {
                Content()
            }
        }
    }
}

