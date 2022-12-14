package com.geektech.ytube.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.geektech.ytube.BuildConfig
import com.geektech.ytube.core.network.RetrofitClient
import com.geektech.ytube.data.remote.model.PlayList
import kotlinx.coroutines.Dispatchers

class Repository {

    private val apiService = RetrofitClient.create()

    fun getPlayList():LiveData<PlayList?> {
        return  liveData(Dispatchers.IO){
            val response= apiService.getPlayList(
            "snippet,contentDetails",
            "UCluBATXIP9doWvougjUVUGQ", BuildConfig.API_KEY)

               if (response.isSuccessful) {
                   emit(response.body())
               }
        }

    }
}

