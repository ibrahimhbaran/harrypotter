package com.play.harrypotter.data

import com.play.harrypotter.data.entites.Character
import com.play.harrypotter.data.services.CharacterService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CharacterRepo @Inject constructor(private val characterService: CharacterService) {

    fun getCharacterList(): Single<List<Character>> = characterService
        .getCharacters()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}