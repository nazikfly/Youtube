package com.geektech.ytube.data.remote

import android.provider.MediaStore
import com.geektech.ytube.data.remote.model.PlayList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    fun getPlayList(
        @Query("part") part:String,
        @Query("channelId") channelId:String,
        @Query("key")apiKey :String,

    ): Response<PlayList>

}