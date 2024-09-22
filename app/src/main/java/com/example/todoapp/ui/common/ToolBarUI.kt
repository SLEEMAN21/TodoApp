package com.example.todoapp.ui.common
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.todoapp.ui.theme.TODOAPPTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBar(
    title:String,
    showBack:Boolean
    ,    onBackClick: (() -> Unit)? = null
) {
    val navigationIconWithBack: @Composable () -> Unit = {
        IconButton(onClick = { onBackClick?.invoke()}) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
        }
    }
    val navigationIconEmpty: @Composable () -> Unit = {}
    val navigationIcon: @Composable () -> Unit = if(showBack) navigationIconWithBack else navigationIconEmpty
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Text(
                text = title,
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth()
            )
        },

        navigationIcon = navigationIcon,
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(0xFF9395D3)
        )
    )
}
@Preview(showBackground = true)
@Composable
private fun ToolBarPreview() {

    TODOAPPTheme{
        ToolBar(title = "Todo App", showBack = true)
    }
}