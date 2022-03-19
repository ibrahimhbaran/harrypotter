package com.play.harrypotter.contract

import com.play.harrypotter.data.entites.Character

interface MainContract {

    interface View{
        fun showProgress()
        fun hideProgress()
        fun showError(message: String)
        fun loadData(data: List<Character>)
    }

    interface Presenter{
        fun onCreate()
        fun onDestroy()
    }

}