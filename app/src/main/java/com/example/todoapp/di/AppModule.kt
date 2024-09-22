package com.example.todoapp.di

import com.example.todoapp.listing.data.TaskRepo
import org.koin.dsl.module


val appModule = module {
        single<TaskRepo> { TaskRepo() }
    }
