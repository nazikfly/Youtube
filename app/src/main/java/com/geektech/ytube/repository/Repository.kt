package com.geektech.ytube.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.viewbinding.BuildConfig
import com.geektech.ytube.data.remote.ApiService
import com.geektech.ytube.data.remote.model.PlayList
import kotlinx.coroutines.Dispatchers

class Repository ( private val apiService : ApiService) {

    fun getPlayList():LiveData<PlayList?> {
        return  liveData(Dispatchers.IO){
            val response= apiService.getPlayList(
            "snippet,contentDetails",
            "UCluBATXIP9doWvougjUVUGQ",  BuildConfig.API_KEY)

               if (response.isSuccessful) {
                   emit(response.body())
               }
        }
    }
}

