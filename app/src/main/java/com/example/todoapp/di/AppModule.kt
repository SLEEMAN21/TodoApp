package com.todo.di

import com.example.todoapp.listing.data.TaskRepo
import com.example.todoapp.listing.screens.ListingTaskViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
val appModule = module {
    single<TaskRepo> { TaskRepo() }
    //factory {  }
    viewModel { ListingTaskViewModel(get()) }
}
