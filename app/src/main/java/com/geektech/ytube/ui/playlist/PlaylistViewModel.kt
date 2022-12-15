package com.geektech.ytube.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.ytube.data.remote.model.PlayList
import com.geektech.ytube.repository.Repository

class PlaylistViewModel(private val repository: Repository): ViewModel() {

    fun getPlaylist(): LiveData<PlayList?> {

        return repository.getPlayList()
    }


}





