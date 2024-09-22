package com.example.todoapp.addEdit.screens
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todoapp.ui.common.ToolBar
import com.example.todoapp.base.BaseActivity
import com.example.todoapp.listing.data.TaskModel
import com.example.todoapp.listing.data.TaskRepo
import org.koin.android.ext.android.inject


class AddTaskActivity : BaseActivity() {
    private val repo: TaskRepo by inject()

    @Composable
    override fun Content(modifier: Modifier) {

        Scaffold(
            modifier = Modifier.fillMaxWidth(),
            topBar = { ToolBar("Add", true,onBackClick = { finish() }) }
        ) { innerPadding ->

            AddTaskScreen( modifier = Modifier.padding(innerPadding), onAddClick ={ taskModel ->
                repo.addTask(taskModel)
                setResult(RESULT_OK)
                finish()
            })


        }
    }
}