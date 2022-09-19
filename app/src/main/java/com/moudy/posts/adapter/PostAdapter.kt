package com.moudy.posts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.moudy.posts.data.PostItem
import com.moudy.posts.databinding.LiPost2Binding
import com.moudy.posts.databinding.LiPostBinding

// DiffUtils
class PostAdapter : ListAdapter<PostItem, PostAdapter.ViewHolder>(diffCallback) {

    // DiffUtil
    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<PostItem>() {
            override fun areItemsTheSame(oldItem: PostItem, newItem: PostItem): Boolean {
                return oldItem === newItem // check if the items are the same. use the id if your model has one.
            }

            override fun areContentsTheSame(oldItem: PostItem, newItem: PostItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LiPost2Binding.inflate(LayoutInflater.from(parent.context), parent, false)

        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    inner class ViewHolder(private val binding: LiPost2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener{
                onClickListener.onClick(getItem(adapterPosition))
            }
        }

        fun bind() {
            // bind the view
            binding.title.text = getItem(adapterPosition).title
            binding.body.text = getItem(adapterPosition).bodyString
            binding.userid.text = getItem(adapterPosition).userId.toString()

        }
    }


    ///////////////////////////////////////////////////////////////
    private lateinit var onClickListener: OnClickListener

    interface OnClickListener {
        fun onClick(post:PostItem)
    }

    fun setOnCLickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }
}
