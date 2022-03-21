package com.play.harrypotter.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.play.harrypotter.R
import com.play.harrypotter.contract.MainContract
import com.play.harrypotter.data.entites.Character
import com.play.harrypotter.presenter.MainPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var characterAdapter: CharacterAdapter

    private lateinit var characterRecyclerView: RecyclerView


    private lateinit var loadingProgressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        loadingProgressBar = findViewById(R.id.loadingProgressBar)
        characterRecyclerView = findViewById(R.id.characterRCV)

        characterRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = characterAdapter
        }

        presenter.onCreate()
    }

    override fun showProgress() {
        loadingProgressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        loadingProgressBar.visibility = View.INVISIBLE
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun loadData(data: List<Character>) {
        characterAdapter.updateData(data)
    }

}