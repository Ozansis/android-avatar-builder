package com.example.editcharacter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.editcharacter.adapter.ItemAdapter
import com.example.editcharacter.data.AvatarPartType
import com.example.editcharacter.data.Item
import com.example.editcharacter.data.OnAvatarClickListener
import com.example.editcharacter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnAvatarClickListener {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        binding.rv.layoutManager= StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        val itemListesi = ArrayList<Item>()

        val i1 = Item("armor1", AvatarPartType.BODY)
        val i2 = Item("armor2", AvatarPartType.BODY)
        val i3 = Item("kadin1", AvatarPartType.HEAD)
        val i4 = Item("erkek1", AvatarPartType.HEAD)
        val i5 = Item("erkek2", AvatarPartType.HEAD)
        val i6 = Item("kadin", AvatarPartType.HEAD)
        val i7 = Item("silah1", AvatarPartType.WEAPON)
        val i8 = Item("silah2", AvatarPartType.WEAPON)
        val i9 = Item("silah3", AvatarPartType.WEAPON)
        val i10 = Item("erkek3", AvatarPartType.HEAD)


        itemListesi.add(i1)
        itemListesi.add(i2)
        itemListesi.add(i3)
        itemListesi.add(i4)
        itemListesi.add(i5)
        itemListesi.add(i6)
        itemListesi.add(i7)
        itemListesi.add(i8)
        itemListesi.add(i9)
        itemListesi.add(i10)

        val adapterx = ItemAdapter(this,itemListesi,this)
        binding.rv.adapter = adapterx




        setContentView(binding.root)








    }

    override fun onAvatarItemClicked(item : Item){
        val drawableid = resources.getIdentifier(item.resim,"drawable",packageName)

        when(item.bodyType){
            AvatarPartType.BODY -> binding.imgOutfit.setImageResource(drawableid)
            AvatarPartType.HEAD -> binding.imgFace.setImageResource(drawableid)
            AvatarPartType.WEAPON -> binding.imgsword.setImageResource(drawableid)


        }



    }



}