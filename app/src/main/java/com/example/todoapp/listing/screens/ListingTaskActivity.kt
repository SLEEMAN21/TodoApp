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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.todoapp.addEdit.screens.AddEditTaskActivity
import com.example.todoapp.base.BaseActivity
import com.example.todoapp.ui.common.ToolBar
import com.example.todoapp.ui.utils.UiLogger
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListingTaskActivity : BaseActivity() {
    private val viewModel: ListingTaskViewModel by viewModel()

    @Composable
    override fun Content() {
        val context = LocalContext.current
        val tasks by viewModel.tasksStateFlow.collectAsState()
        LaunchedEffect(tasks) {
            UiLogger.log("ListingTask Updated with new tasks: ${tasks.size}")
        }
        val addTaskLauncher =
            rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                UiLogger.log("On Activity Result arrived with status: ${result.resultCode == RESULT_OK}")
                if (result.resultCode == RESULT_OK) {
                    viewModel.refreshTasks()
                }
            }

        Scaffold(modifier = Modifier.fillMaxWidth(),
            topBar = { ToolBar("TODO") },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        val intent = Intent(context, AddEditTaskActivity::class.java)
                        addTaskLauncher.launch(intent)
                    }, containerColor = Color(0xFF9395D3), shape = CircleShape
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add Task", tint = Color.White)
                }
            },
            floatingActionButtonPosition = FabPosition.End
        ) { innerPadding ->
            TodoListScreen(modifier = Modifier.padding(innerPadding),
                tasks = tasks,
                onDeleteTask = { taskModel ->
                    viewModel.deleteTask(taskModel)
                },
                onEditTask = { taskModel ->
                    val intent = Intent(context, AddEditTaskActivity::class.java)
                    intent.putExtra(AddEditTaskActivity.TASK_KEY, taskModel)
                    addTaskLauncher.launch(intent)
                },
                onCompletedTask = { taskModel ->
                    viewModel.completeTask(taskModel)
                })
        }
    }
}
