package com.geektech.ytube.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.ytube.BuildConfig
import com.geektech.ytube.core.network.RetrofitClient
import com.geektech.ytube.data.remote.model.PlayList
import com.geektech.ytube.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel: ViewModel() {

var repository = Repository()
    fun getPlaylist(): LiveData<PlayList?> {

        return repository.getPlayList()
    }


}





