package com.kk.memechallengexml.data.service

import com.kk.memechallengexml.data.model.ResponseMemeDTO
import retrofit2.http.GET

interface ApiService {

    @GET("get_memes")
    suspend fun getMemes(): ResponseMemeDTO
}