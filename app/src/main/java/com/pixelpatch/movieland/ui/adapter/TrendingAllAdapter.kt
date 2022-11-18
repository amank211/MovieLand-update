package com.pixelpatch.movieland.ui.adapter

import android.annotation.SuppressLint
import android.app.ActionBar.LayoutParams
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.transition.Fade
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.pixelpatch.movieland.Constants
import com.pixelpatch.movieland.MediaType
import com.pixelpatch.movieland.R
import com.pixelpatch.movieland.datamodels.movie.MovieResponse
import com.pixelpatch.movieland.datamodels.person.PersonMoviesResponse
import com.pixelpatch.movieland.datamodels.tv.TVResponse
import com.pixelpatch.movieland.ui.PersonActivity
import com.pixelpatch.movieland.ui.Youtube
import com.pixelpatch.movieland.viewmodel.MovieViewModel
import com.squareup.picasso.Picasso
import com.squareup.picasso.Picasso.LoadedFrom


class TrendingAllAdapter(context: Context, data: List<DataModeAssign>, viewModel: MovieViewModel) :
    RecyclerView.Adapter<TrendingAllAdapter.TrendingAllViewHolder>() {

    var dataList = data
    var context = context
    var model = viewModel


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingAllViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.trending_all, parent, false)
        val params = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        params.marginStart = 15
        params.marginEnd = 15
        params.bottomMargin = 30
        view.layoutParams = params
        return TrendingAllViewHolder(view)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: TrendingAllViewHolder, position: Int) {

        var data = dataList[position]
        var text = ""
        data.getMediaTitle()?.let { text = (data.getMediaTitle()!!) }

        if(text.length > 15)
            holder.title.text = "${text.removeRange(15, text.length)}..."
        else
            holder.title.text = text

        // we are adding fade animation
        // between two imageviews.
        // we are adding fade animation
        // between two imageviews.
        val fade = Fade()

        // below 3 lines of code is to exclude
        // action bar,title bar and navigation
        // bar from animation.

        // below 3 lines of code is to exclude
        // action bar,title bar and navigation
        // bar from animation.
        fade.excludeTarget(android.R.id.statusBarBackground, true)
        fade.excludeTarget(android.R.id.navigationBarBackground, true)

        // we are adding fade animation
        // for enter transition.

        // we are adding fade animation
        // for enter transition.
        (context as Activity).window.enterTransition = fade

        // we are also setting fade
        // animation for exit transition.

        // we are also setting fade
        // animation for exit transition.
        (context as Activity).window.exitTransition = fade

        holder.poster.transitionName = data.getMediaId().toString()

        when(data.getType()){
            MediaType.MOVIE -> {
                holder.itemView.setOnClickListener {
                    var intent = Intent(context, Youtube::class.java)
                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        context as Activity, holder.poster, ViewCompat.getTransitionName(holder.poster)!!
                    )
                    intent.putExtra("id", data.getMediaId())
                    intent.putExtra("type", data.getType())
                    context.startActivity(intent, options.toBundle())
                }
            }
            MediaType.TV -> {
                    holder.itemView.setOnClickListener {
                        var intent = Intent(context, Youtube::class.java)
                        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            context as Activity, holder.poster, ViewCompat.getTransitionName(holder.poster)!!
                        )
                        intent.putExtra("id", data.getMediaId())
                        intent.putExtra("type", data.getType())
                        context.startActivity(intent, options.toBundle())
                    }
            }
            MediaType.PERSON -> {
                holder.itemView.setOnClickListener {
                    var intent = Intent(context, PersonActivity::class.java)
                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        context as Activity,
                        holder.poster,
                        ViewCompat.getTransitionName(holder.poster)!!
                    )
                    intent.putExtra("id", data.getMediaId())
                    intent.putExtra("type", data.getType())
                    context.startActivity(intent, options.toBundle())
                }
            }
            else -> {}
        }

        Picasso.with(holder.poster.context)
            .load(Constants.IMAGE_PREFIX + data.getPoster())
            .placeholder(R.drawable.placeholder)
            .into(holder.poster)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class TrendingAllViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poster: ImageView
        var title: TextView

        init {
            poster = itemView.findViewById(R.id.poster)
            title = itemView.findViewById(R.id.title)
        }
    }
}