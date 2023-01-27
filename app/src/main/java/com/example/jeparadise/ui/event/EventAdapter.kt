package com.example.jeparadise.ui.event

import android.annotation.SuppressLint
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

class EventAdapter (private val eventSnapshotList: List<DocumentSnapshot>) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val eventImage = view.findViewById<ImageView>(R.id.event_img)
        val eventName = view.findViewById<TextView>(R.id.event_name)
        val eventLocation = view.findViewById<TextView>(R.id.event_location)
        val eventDistance = view.findViewById<TextView>(R.id.event_distance)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.list_event, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val document: DocumentSnapshot = eventSnapshotList[position]
        val data = document.toObject(MainModel::class.java)
        if (data != null) {
            Picasso.get().load(data.url).into(holder.eventImage)
            holder.eventName.text = data.name
            holder.eventLocation.text = data.location
            holder.eventDistance.text = data.distance.toString() + " km"
        }
    }

    override fun getItemCount(): Int {
        return eventSnapshotList.size
    }
}