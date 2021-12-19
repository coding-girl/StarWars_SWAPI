package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.entities.Character
import com.example.rickandmorty.data.entities.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {
    @GET("people")
    suspend fun getAllCharacters() : Response<CharacterList>

    @GET("people")
    suspend fun getCharacter(@Query("page") id: Int): Response<Character>
}