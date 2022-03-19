package com.play.harrypotter.presenter

import com.play.harrypotter.TestSchedulerRule
import com.play.harrypotter.contract.MainContract
import com.play.harrypotter.data.CharacterRepo
import com.play.harrypotter.data.entites.Character
import com.play.harrypotter.data.entites.Wand
import io.reactivex.rxjava3.core.Single

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MainPresenterTest {

    @Rule
    @JvmField
    val testRule = TestSchedulerRule()

    @Mock
    lateinit var mockCharacterRepo: CharacterRepo

    @Mock
    lateinit var mockView: MainContract.View

    lateinit var mainPresenter: MainPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        mainPresenter = MainPresenter(mockView, mockCharacterRepo)
    }

    @Test
    fun `when onCreate method we call characters from repository it should retrieve characters`() {
        val sampleData = createSampleCharacterList()
        Mockito.`when`(mockCharacterRepo.getCharacterList())
            .thenReturn(Single.just(sampleData))

        mainPresenter.onCreate()

        verify(mockCharacterRepo).getCharacterList()
        verify(mockView).loadData(sampleData)

    }

    private fun createSampleCharacterList(): List<Character> {
        val characterOfHarry = Character(
            "harry",
            listOf("mike", "jack"),
            "notsure",
            "male",
            "common",
            "1902",
            340,
            true,
            "no",
            "blue",
            "brown",
            Wand("wood", "core", 5),
            "pat",
            false,
            false,
            "joe", listOf("bim", "bam"), true, "no image"
        )
        val characterHermione = Character(
            "Hermione",
            listOf("mike", "jack"),
            "notsure",
            "female",
            "common",
            "1902",
            340,
            true,
            "no",
            "blue",
            "brown",
            Wand("wood", "core", 5),
            "pat",
            false,
            false,
            "joe", listOf("bim", "bam"), true, "no image"
        )
        return listOf(characterOfHarry, characterHermione)
    }

}