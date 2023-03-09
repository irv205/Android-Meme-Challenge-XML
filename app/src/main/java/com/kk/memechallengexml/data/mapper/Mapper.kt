package com.kk.memechallengexml.data.mapper

import com.kk.memechallengexml.domain.model.Meme

fun toDomianModel(
    name: String,
    url: String): Meme = Meme(name, url)