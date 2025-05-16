package com.example.editcharacter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.editcharacter.data.AvatarPartType
import com.example.editcharacter.data.Item
import com.example.editcharacter.data.OnAvatarClickListener
import com.example.editcharacter.databinding.CharacterItemCardBinding

class ItemAdapter(var context: Context,var itemList: List<Item>,var listener : OnAvatarClickListener): RecyclerView.Adapter<ItemAdapter.CardViewHolder>() {


    inner class CardViewHolder(var view: CharacterItemCardBinding): RecyclerView.ViewHolder(view.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CharacterItemCardBinding.inflate(LayoutInflater.from(context),parent,false)
        return CardViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val itemCharacter = itemList.get(position)
        val v = holder.view

        v.imageView.setImageResource(context.resources.getIdentifier(itemCharacter.resim,"drawable",context.packageName))

        v.itemCard.setOnClickListener {
            listener.onAvatarItemClicked(itemCharacter)
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }



}