package com.example.todoapp.listing.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class TaskModel(
    val id: Int,
    val title: String,
    val subTitle: String,
    var status: TaskStatus = TaskStatus.New
) : Parcelable

enum class TaskStatus {
    New, Deleted,Completed,Pending
}