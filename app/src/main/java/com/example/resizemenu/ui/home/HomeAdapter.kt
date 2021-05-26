package com.example.resizemenu.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.resizemenu.R
import com.example.resizemenu.utils.getValueAnimator

var animationPlaybackSpeed: Double = 0.8
private val listItemExpandDuration: Long get() = (300L / animationPlaybackSpeed).toLong()
class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var expandView: View
    private lateinit var arrow: ImageView

    init {
        arrow = itemView.findViewById<ImageView>(R.id.arrow)
        expandView = itemView.findViewById<View>(R.id.expand_view)

        arrow.setOnClickListener {
            expandView.visibility = if (expandView.visibility == View.GONE) {
                //arrow.rotation = 90.0f
                    arrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
                View.VISIBLE
            } else {
                arrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24)
               // arrow.rotation = 0.0f
                View.GONE
            }

        }
    }

//    private fun setExpandProgress(holder: ListViewHolder, progress: Float) {
//        if (expandedHeight > 0 && originalHeight > 0) {
//            holder.cardContainer.layoutParams.height =
//                (originalHeight + (expandedHeight - originalHeight) * progress).toInt()
//        }
//        holder.cardContainer.layoutParams.width =
//            (originalWidth + (expandedWidth - originalWidth) * progress).toInt()
//
//        holder.cardContainer.setBackgroundColor(blendColors(originalBg, expandedBg, progress))
//        holder.cardContainer.requestLayout()
//
//        holder.chevron.rotation = 90 * progress
//    }
//
//    private fun animate(position: Int, expand: Boolean, animate: Boolean){
//        if (animate) {
//            val animator = getValueAnimator(
//                expand, listItemExpandDuration, AccelerateDecelerateInterpolator()
//            ) { progress -> setExpandProgress(holder, progress) }
//
//            if (expand) animator.doOnStart { holder.expandView.isVisible = true }
//            else animator.doOnEnd { holder.expandView.isVisible = false }
//
//            animator.start()
//        } else {
//
//            // show expandView only if we have expandedHeight (onViewAttached)
//            holder.expandView.isVisible = expand && expandedHeight >= 0
//            setExpandProgress(holder, if (expand) 1f else 0f)
//        }
//    }

}

class HomeAdapter : RecyclerView.Adapter<HomeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        return HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product_info, parent, false),
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 10
}