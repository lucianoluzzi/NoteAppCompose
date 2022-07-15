package nl.com.lucianoluzzi.noteappcompose.di

import nl.com.lucianoluzzi.noteappcompose.ui.screens.dashboard.DashboardViewModel
import nl.com.lucianoluzzi.noteappcompose.ui.screens.details.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        DashboardViewModel()
    }

    viewModel { parameters ->
        DetailsViewModel(noteId = parameters.get())
    }
}