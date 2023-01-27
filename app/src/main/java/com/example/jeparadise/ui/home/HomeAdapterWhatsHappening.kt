package com.example.jeparadise.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jeparadise.R
import com.example.jeparadise.model.MainModel
import com.google.firebase.firestore.DocumentSnapshot
import com.squareup.picasso.Picasso

class HomeAdapterWhatsHappening(private val whatsHappeningSnapshotList: List<DocumentSnapshot>) : RecyclerView.Adapter<HomeAdapterWhatsHappening.ViewHolder>() {

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val happeningImage = view.findViewById<ImageView>(R.id.happening_img)
        val happeningName = view.findViewById<TextView>(R.id.happening_name)
        val happeningLocation = view.findViewById<TextView>(R.id.happening_location)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.list_whats_happening, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val document: DocumentSnapshot = whatsHappeningSnapshotList[position]
        val data = document.toObject(MainModel::class.java)
        if (data != null) {
            Picasso.get().load(data.url).into(holder.happeningImage)
            holder.happeningName.text = data.name
            holder.happeningLocation.text = data.location
        }
    }

    override fun getItemCount(): Int {
        return whatsHappeningSnapshotList.size
    }
}