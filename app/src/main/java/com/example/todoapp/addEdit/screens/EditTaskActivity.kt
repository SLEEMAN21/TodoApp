package com.example.todoapp.addEdit.screens
import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todoapp.ui.common.ToolBar
import com.example.todoapp.base.BaseActivity
import com.example.todoapp.listing.data.TaskRepo


class EditTaskActivity : BaseActivity() {
    private val repo = TaskRepo()

    @Composable
    override fun Content(modifier: Modifier) {
        val taskTitle = intent.getStringExtra("taskTitle") ?: ""
        val taskSubTitle = intent.getStringExtra("taskSubTitle") ?: ""

        Scaffold(
            topBar = { ToolBar("Edit Task", true,onBackClick = { finish() }) },
            content = {
                EditTaskContent(
                    modifier = Modifier.padding(it),
                    initialTitle = taskTitle,
                    initialDetail = taskSubTitle,
                    onUpdate = { newTitle, newDetail ->
                        val resultIntent = Intent().apply {
                            putExtra("updatedTaskTitle", newTitle)
                            putExtra("updatedTaskSubTitle", newDetail)
                        }

                        setResult(RESULT_OK, resultIntent)
                        finish()
                    }
                )
            }
        )
    }
}