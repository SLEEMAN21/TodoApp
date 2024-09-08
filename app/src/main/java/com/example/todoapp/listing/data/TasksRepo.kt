package com.example.todoapp.listing.data

/**
 * It's an operation class for task management
 */
class TaskRepo {
    private val tasks = mutableListOf<TaskModel>()

    fun addTask(taskModel: TaskModel) {
        tasks.add(taskModel)
    }

    fun updateStatus(taskModel: TaskModel, changeTo: TaskStatus) {
        taskModel.status = changeTo
    }

    fun getTasks(): List<TaskModel> {
        return tasks
    }
}