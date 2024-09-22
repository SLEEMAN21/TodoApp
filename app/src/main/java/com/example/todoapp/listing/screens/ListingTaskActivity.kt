package com.example.todoapp.listing.screens

import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.todoapp.ui.common.ToolBar
import com.example.todoapp.base.BaseActivity
import com.example.todoapp.listing.data.TaskModel
import com.example.todoapp.listing.data.TaskRepo
import com.example.todoapp.listing.data.TaskStatus
import com.example.todoapp.addEdit.screens.AddTaskActivity
import org.koin.android.ext.android.inject
import org.koin.java.KoinJavaComponent.inject


class ListingTaskActivity : BaseActivity() {
    private val repo: TaskRepo by inject()


    @Composable
    override fun Content(modifier: Modifier) {
        val context = LocalContext.current
        var tasks by remember { mutableStateOf(repo.getTasks().toList()) } // State to hold tasks

        val addTaskLauncher =
            rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    // Refresh the tasks after returning from AddTaskActivity
                    tasks = repo.getTasks().toList()
                }
            }

        Scaffold(
            modifier = Modifier.fillMaxWidth(),
            topBar = { ToolBar("ToDoApp", true, onBackClick = { finish() }) }, // Common ToolBar
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        val intent = Intent(context, AddTaskActivity::class.java)
                        addTaskLauncher.launch(intent)
                    }, containerColor = Color(0xFF9395D3), shape = CircleShape
                ) {
                    Icon(
                        Icons.Default.Add, contentDescription = "Add Task", tint = Color.White
                    )
                }
            },
            floatingActionButtonPosition = FabPosition.End
        ) { innerPadding ->
            TodoListScreen(
                modifier = Modifier.padding(innerPadding),
                tasks = tasks // Pass the state variable to the TodoListScreen
            )
        }
    }


}
