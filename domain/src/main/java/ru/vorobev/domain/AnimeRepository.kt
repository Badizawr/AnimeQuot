package ru.vorobev.domain

interface AnimeRepository {
    suspend fun loadQuot() : Pair<Boolean, String>
}