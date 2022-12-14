package com.geektech.ytube.ui.playlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.geektech.ytube.data.remote.model.Item
import com.geektech.ytube.data.remote.model.PlayList
import com.geektech.ytube.databinding.ItemPlaylistsBinding


class PlaylistsAdapter : RecyclerView.Adapter<PlaylistsAdapter.PlaylistsViewHolder>() {

    private var playLists = ArrayList<Item>()
var onClick:((Item)-> Unit)?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistsViewHolder {
        return PlaylistsViewHolder(
            ItemPlaylistsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistsViewHolder, position: Int) {
holder.bind(playLists[position])    }

    override fun getItemCount(): Int {
        return playLists.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(playLists: ArrayList<Item>) {
        this.playLists = playLists
        notifyDataSetChanged()
    }

    inner class PlaylistsViewHolder(private val binding: ItemPlaylistsBinding ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.imagePlaylists.load(item.snippet.thumbnails.default.url)
            binding.title.text = item.snippet.title
            itemView.setOnClickListener {
                onClick?.invoke(item)
            }
        }
    }
}
