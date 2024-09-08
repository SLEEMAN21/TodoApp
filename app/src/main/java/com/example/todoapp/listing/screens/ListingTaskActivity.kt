package com.example.todoapp.listing.screens


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todoapp.base.BaseActivity
import com.example.todoapp.listing.data.TaskRepo

class ListingTaskActivity : BaseActivity() {
    private val repo = TaskRepo()

    @Composable
    override fun Content(modifier: Modifier) {
        TodoListScreen(
            modifier = modifier,
            tasks = repo.getTasks()
        )
    }


}
