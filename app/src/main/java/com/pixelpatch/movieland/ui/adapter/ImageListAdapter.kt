package com.pixelpatch.movieland.ui.adapter

import android.annotation.SuppressLint
import android.app.ActionBar
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.pixelpatch.movieland.Constants
import com.pixelpatch.movieland.R
import com.pixelpatch.movieland.datamodels.movie.Backdrop
import com.pixelpatch.movieland.viewmodel.MovieViewModel
import com.squareup.picasso.Picasso

class ImageListAdapter(context: Context, data: List<Backdrop>, viewModel: MovieViewModel) :
    RecyclerView.Adapter<ImageListAdapter.ImageViewHolder>() {

    var dataList = data
    var context = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.photo_gallery, parent, false)
        val params = ActionBar.LayoutParams(
            ActionBar.LayoutParams.WRAP_CONTENT,
            ActionBar.LayoutParams.WRAP_CONTENT
        )
        params.marginStart = 15
        params.marginEnd = 15
        params.bottomMargin = 10
        view.layoutParams = params
        return ImageViewHolder(view)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        var data = dataList[position]
        var imageLink = Constants.IMAGE_PREFIX + data.filePath

        Picasso.with(holder.poster.context)
            .load(imageLink)
            .placeholder(R.drawable.placeholder)
            .into(holder.poster)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poster: ImageView
        init {
            poster = itemView.findViewById(R.id.poster)
        }
    }
}