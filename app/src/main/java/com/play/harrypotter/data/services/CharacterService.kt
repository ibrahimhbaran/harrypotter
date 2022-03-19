package com.play.harrypotter.data.services

import com.play.harrypotter.data.entites.Character
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface CharacterService {
   @GET("api/characters")
  fun getCharacters() :Single<List<Character>>
}