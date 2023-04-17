package com.kk.memechallengexml.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kk.memechallengexml.core.util.ResponseHandler
import com.kk.memechallengexml.domain.model.Meme
import com.kk.memechallengexml.domain.repository.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository : IRepository) : ViewModel() {

    private val _memelist = MutableLiveData<List<Meme>>()
    val memeList : LiveData<List<Meme>> get() = _memelist

    private val _error = MutableLiveData<String>()
    val error : LiveData<String> get() = _error

    init {
        getMemes()
    }

    fun getMemes(){

        viewModelScope.launch(Dispatchers.IO) {
            when(val response = repository.getMemes()){
                is ResponseHandler.Error -> {
                    _error.postValue(response.message)
                    Log.e("Error-----", response.message)
                }
                is ResponseHandler.Success -> {
                    response.data.let {
                        _memelist.postValue(it)
                    }
                }
            }
        }
    }
}