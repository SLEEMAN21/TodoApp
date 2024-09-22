package com.example.todoapp.base
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todoapp.ui.common.ToolBar

import com.example.todoapp.ui.theme.TODOAPPTheme

abstract class BaseActivity : ComponentActivity() {


    @Composable
    abstract fun Content(modifier: Modifier)

    final  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TODOAPPTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { ToolBar("TODOAPP", true, onBackClick = { finish() }) }
                ) { innerPadding ->
                    Content(Modifier.padding(innerPadding)) // Calls the child class's content
                }
            }
        }
    }
}

