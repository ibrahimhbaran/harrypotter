package com.play.harrypotter.data.services

import com.play.harrypotter.data.entites.Character
import retrofit2.Response
import retrofit2.http.GET

interface CharacterService {
   @GET("api/characters")
   suspend fun getCharacters() :Response<List<Character>>
}