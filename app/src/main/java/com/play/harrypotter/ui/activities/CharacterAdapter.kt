package com.play.harrypotter.ui.activities

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.play.harrypotter.R
import com.play.harrypotter.data.entites.Character
import javax.inject.Inject

class CharacterAdapter @Inject constructor() :
    RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {

    private var dataList = mutableListOf<Character>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val characterNameTextView = view.findViewById<TextView>(R.id.character_name)
        private val characterInfoTextView = view.findViewById<TextView>(R.id.character_info)
        private val characterImageView = view.findViewById<ImageView>(R.id.character_image)

        @SuppressLint("SetTextI18n")
        fun bind(character: Character) {
            characterNameTextView.text = character.name
            characterInfoTextView.text = "Birth date: ${character.dateOfBirth} " +
                    "\nGender: ${character.gender}" +
                    "\nEye colour: ${character.eyeColour}" +
                    "\nActor: ${character.actor}" +
                    "\nIs Alive: ${character.alive}" +
                    "\nAncestry: ${character.ancestry}"

            Glide
                .with(itemView)
                .load(character.image)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .into(characterImageView)

        }
    }

    fun updateData(data: List<Character>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val character = dataList[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int = dataList.size
}