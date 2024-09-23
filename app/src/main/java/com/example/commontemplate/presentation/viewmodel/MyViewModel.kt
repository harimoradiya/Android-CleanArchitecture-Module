package com.example.commontemplate.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.commontemplate.data.local.MyEntity
import com.example.commontemplate.data.repository.MyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MyViewModel(private val repository: MyRepository) : ViewModel() {
    val saveImages : Flow<List<MyEntity>> = repository.getSavedImage()

    private val _isLoading= MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun fetchAndSaveImages(){
        viewModelScope.launch {
            try {
                _isLoading.value =false
                val imageUrl  = repository.fetchRandomImage()
                Log.d("MyViewModel", "fetchAndSaveImages: $imageUrl")
                repository.saveImage(imageUrl)
            }
            catch (e:Exception){
                Log.d("MyViewModel", "fetchAndSaveImages: ${e.message}")
            }
            finally {
                _isLoading.value= true
            }
        }
    }
}