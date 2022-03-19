package com.play.harrypotter.presenter

import com.play.harrypotter.contract.MainContract
import com.play.harrypotter.data.CharacterRepo
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private var view: MainContract.View?,
    private val characterRepo: CharacterRepo
) : MainContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    /**
     * will load character list onCreate method of MainActivity
     */
    override fun onCreate() {
        view?.showProgress()
        compositeDisposable.add(characterRepo.getCharacterList().subscribe({
            view?.hideProgress()
            view?.loadData(it)
        }, {
            view?.hideProgress()
            view?.showError(it.message.toString())
        }))
    }

    override fun onDestroy() {
        // this is  for preventing memory leak if user close the MainActivity before network  call
        view = null
        compositeDisposable.clear()
    }
}