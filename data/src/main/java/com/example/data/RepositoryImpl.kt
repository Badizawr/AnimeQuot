package com.example.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.vorobev.domain.AnimeRepository
import java.lang.Exception

class RepositoryImpl (
    private val service: AnimeQuoteService
): AnimeRepository {

    constructor() :this(
        Retrofit.Builder().baseUrl("https://animechan.xyz/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(AnimeQuoteService::class.java)
    )
    override suspend fun loadQuot(): Pair<Boolean, String> {
       return try {
           val quote = service.animeQuote().quote
           Pair(true, quote)
        } catch (e:Exception) {
            Pair(false, e.message ?: "error")
        }
    }
}