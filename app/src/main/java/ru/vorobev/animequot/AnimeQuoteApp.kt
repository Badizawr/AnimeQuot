package ru.vorobev.animequot

import android.app.Application
import com.example.data.RepositoryImpl
import com.example.presentation.MainViewModel
import com.example.presentation.ProvideViewModel
import ru.vorobev.domain.AnimeRepository

class AnimeQuoteApp : Application(), ProvideViewModel {

    private lateinit var viewModel: MainViewModel
    override fun onCreate() {
        super.onCreate()
        val repository : AnimeRepository = RepositoryImpl()
        viewModel = MainViewModel(repository = repository)
    }

    override fun viewModel(): MainViewModel {
        return viewModel
    }
}