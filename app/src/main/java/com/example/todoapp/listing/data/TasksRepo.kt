package com.example.todoapp.listing.data

import com.example.todoapp.ui.utils.UiLogger

/**
 * Repository class for task management
 */
class TaskRepo {
    private val tasks = mutableListOf<TaskModel>()

    private var currentId = 0
    fun addTask(taskModel: TaskModel) {
        val newTask = taskModel.copy(id = currentId++)
        tasks.add(newTask)
        UiLogger.log("New Task has been added: $taskModel")
        UiLogger.log("REPO tasks size: ${tasks.size}")
    }

    fun completeTask(taskModel: TaskModel) {
        val task = tasks.find { it.id == taskModel.id }
        task?.let {
            it.status = TaskStatus.Completed
            UiLogger.log("Task with Id:${it.id} has been marked as Completed: $taskModel")
        }
    }

    fun editTask(taskId: Int, updatedTask: TaskModel) {
        val index = tasks.indexOfFirst { it.id == taskId }
        tasks[index] = updatedTask.copy(id = taskId, status = TaskStatus.Pending)
        UiLogger.log("Task with index $index and Id:${tasks[index].id} has been edited: ${tasks[index]}")
    }


    fun getTasks(): List<TaskModel> {
        return tasks.filter { it.status == TaskStatus.New || it.status == TaskStatus.Pending }
    }

    fun deleteTask(taskModel: TaskModel) {
        val task = tasks.find { it.id == taskModel.id }
        task?.let {
            it.status = TaskStatus.Deleted
            UiLogger.log("Task with Id:${it.id} has been marked as Deleted : $taskModel")
        }
    }
}
