package com.play.harrypotter.di

import com.play.harrypotter.contract.MainContract
import com.play.harrypotter.presenter.MainPresenter
import com.play.harrypotter.ui.activities.MainActivity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class MainModule {

    @Binds
    abstract fun bindMainView(activity: MainActivity): MainContract.View

    @Binds
    abstract fun bindMainPresenter(mainPresenter: MainPresenter): MainContract.Presenter
}