package com.kk.memechallengexml.domain.repository

import com.kk.memechallengexml.core.util.ResponseHandler
import com.kk.memechallengexml.domain.model.Meme

interface IRepository {
    suspend fun getMemes(): ResponseHandler<List<Meme>>
}