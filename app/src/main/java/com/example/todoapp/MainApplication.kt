package com.example.todoapp

import android.app.Application
import com.todo.di.appModule
import com.example.todoapp.ui.utils.UiLogger
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApp : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MainApp)
            modules(appModule)
        }
        UiLogger.log("Main App has been started")
    }
}