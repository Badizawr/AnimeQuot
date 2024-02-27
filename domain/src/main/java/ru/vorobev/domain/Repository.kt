package ru.vorobev.domain

interface Repository {
    suspend fun loadQuot() : Pair<Boolean, String>
}