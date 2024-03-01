package com.example.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.vorobev.domain.AnimeRepository

class MainViewModel(
    private val repository : AnimeRepository
) : ViewModel(){
    private val innerLiveData = MutableLiveData<String>()
    val liveData: LiveData<String>
        get() = innerLiveData
    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    fun load() {
        viewModelScope.launch {
           val quote =  repository.loadQuot().second
            innerLiveData.value = quote
        }
    }

}