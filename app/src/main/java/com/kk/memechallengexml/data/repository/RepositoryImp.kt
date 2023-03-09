package com.kk.memechallengexml.data.repository

import com.kk.memechallengexml.core.util.ResponseHandler
import com.kk.memechallengexml.data.mapper.toDomianModel
import com.kk.memechallengexml.data.service.ApiService
import com.kk.memechallengexml.domain.model.Meme
import com.kk.memechallengexml.domain.repository.IRepository
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val service: ApiService): IRepository {

    override suspend fun getMemes(): ResponseHandler<List<Meme>> {
        return try {
            ResponseHandler.Success(service.getMemes().data.memes.map {
                toDomianModel(
                    it.name,
                    it.url
                )
            })
        } catch (e: Exception){
            ResponseHandler.Error(message = e.message.toString())
        }
    }
}