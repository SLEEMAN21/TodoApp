package com.example.todoapp.listing.screens
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.listing.data.TaskModel
import com.example.todoapp.listing.data.TaskRepo
import com.example.todoapp.ui.utils.UiLogger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class ListingTaskViewModel(private val taskRepo: TaskRepo) : ViewModel() {
    private val _tasksStateFlow = MutableStateFlow<List<TaskModel>>(emptyList())
    val tasksStateFlow: StateFlow<List<TaskModel>> = _tasksStateFlow

    init {
        refreshTasks()
    }

    fun refreshTasks() {
        viewModelScope.launch {
            val tasks = taskRepo.getTasks()
            _tasksStateFlow.value = tasks.toList()
            UiLogger.log("Data Has been sent")
        }
    }

    fun deleteTask(taskModel: TaskModel) {
        taskRepo.deleteTask(taskModel)
        refreshTasks()
    }
    fun completeTask(taskModel: TaskModel) {
        taskRepo.completeTask(taskModel)
        refreshTasks()
    }

}