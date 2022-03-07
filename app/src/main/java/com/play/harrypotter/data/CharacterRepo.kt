package com.play.harrypotter.data

import com.play.harrypotter.data.services.CharacterService
import javax.inject.Inject

class CharacterRepo @Inject constructor( private val characterService: CharacterService){

    suspend fun getCharacterList() = characterService.getCharacters()

}