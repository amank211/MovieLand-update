package com.pixelpatch.movieland.ui.adapter

import ImageResult
import ImagesOfPersonResponse
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.pixelpatch.movieland.Constants
import com.pixelpatch.movieland.R
import com.squareup.picasso.Picasso
import java.util.*


internal class ImageViewPager(
    var context: Context,
    var images: List<ImageResult>
) :
    PagerAdapter() {
    // Layout Inflater
    var mLayoutInflater: LayoutInflater

    // Viewpager Constructor
    init {
        images = images
        mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        // return the number of images
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // inflating the item.xml
        val itemView: View = mLayoutInflater.inflate(R.layout.person_posters, container, false)

        // referencing the image view from the item.xml file
        val imageView = itemView.findViewById<View>(R.id.image) as ImageView

        var url = Constants.IMAGE_PREFIX + images[position].media.posterPath
        Log.d("URL", "url: $url")

        Picasso.with(imageView.context)
            .load(url)
            .placeholder(R.drawable.placeholder)
            .into(imageView)

        // Adding the View
        Objects.requireNonNull(container).addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}