package com.geektech.ytube.ui.playlist

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.geektech.ytube.base.BaseActivity
import com.geektech.ytube.core.utils.CheckInternetConnection
import com.geektech.ytube.core.utils.Constant
import com.geektech.ytube.data.remote.model.Item
import com.geektech.ytube.databinding.ActivityPlaylistsBinding
import com.geektech.ytube.repository.Repository
import com.geektech.ytube.ui.detail.DetailPlaylistActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistActivity : BaseActivity<ActivityPlaylistsBinding>(){

   private val viewModel: PlaylistViewModel by viewModel()

   private  var adapter:PlaylistsAdapter? = null

    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityPlaylistsBinding {
        return ActivityPlaylistsBinding.inflate(layoutInflater)
    }

    override fun initAdapter() {
          adapter = PlaylistsAdapter()
adapter?.onClick = {
    val intent = Intent(this, DetailPlaylistActivity::class.java)
    intent.putExtra(Constant.putId, it.id)
    startActivity(intent)}
        binding.recyclerview.adapter=adapter
    }

     fun initListener(id: Item) {

    }
    override fun setUI() {

    }

    override fun setupLiveData() {
        viewModel.getPlaylist().observe(this){ playlist->
            if(playlist !=null) {
                adapter?.setList(playlist.items as ArrayList<Item>)
                Toast.makeText(this, playlist.kind.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun checkInternet() {
        CheckInternetConnection((getSystemService(Context.CONNECTIVITY_SERVICE) as
                ConnectivityManager)).observe(this) {

            binding.includedInternet.rlParent.isVisible = !it
            binding.recyclerview.isVisible=it
            setupLiveData()
        }
    }
}


