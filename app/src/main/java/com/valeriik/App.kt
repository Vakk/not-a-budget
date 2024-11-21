package com.valeriik

import android.app.Application
import com.valeriik.notes.data.NotebookRepository
import com.valeriik.notes.data.NotebookRepositoryImpl
import com.valeriik.notes.domain.GetNotebooksUseCase
import com.valeriik.notes.ui.NotebooksViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule(), notesModule())
            androidContext(this@App)
        }
    }


    private fun appModule(): Module = module {

    }

    private fun notesModule(): Module = module {
        single<NotebookRepository> {
            NotebookRepositoryImpl(context = Dispatchers.IO)
        }
        factory<GetNotebooksUseCase> {
            GetNotebooksUseCase(notebookRepository = get(),)
        }
        viewModel { NotebooksViewModel(getNotebooksUseCase = get()) }
    }
}