package com.example.todoapp.addEdit.screens
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todoapp.base.BaseActivity
import com.example.todoapp.listing.data.TaskModel
import com.example.todoapp.listing.data.TaskRepo
import com.example.todoapp.ui.common.ToolBar
import org.koin.android.ext.android.inject


class AddEditTaskActivity : BaseActivity() {
    private val repo: TaskRepo by inject()

    @Composable
    override fun Content() {
        val taskModel = intent.getParcelableExtra<TaskModel>(TASK_KEY)

        Scaffold(
            modifier = Modifier.fillMaxWidth(),
            topBar = {
                ToolBar(
                    if (taskModel == null) "ADD" else "EDIT",
                    true,
                    onBackClick = { finish() }
                )
            }
        ) { innerPadding ->
            AddEditTaskScreen(
                modifier = Modifier.padding(innerPadding),
                taskModel = taskModel,
                onAddClick = { task ->
                    if (taskModel == null) {
                        repo.addTask(task)
                    }
                    setResult(RESULT_OK)
                    finish()
                },
                onEditClick = { task ->
                    if (taskModel != null) {
                        repo.editTask(task.id, task)
                    }
                    setResult(RESULT_OK)
                    finish()
                }
            )
        }
    }

    companion object {
        const val TASK_KEY = "task_key"
    }
}


