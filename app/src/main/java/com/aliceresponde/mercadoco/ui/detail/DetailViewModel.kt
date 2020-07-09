package com.aliceresponde.mercadoco.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliceresponde.mercadoco.data.remote.NoInternetException
import com.aliceresponde.mercadoco.ui.model.UiItem
import com.aliceresponde.mercadoco.usecase.GetItemImagesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel @ViewModelInject constructor(
    private val itemImagesImages: GetItemImagesUseCase,
    private val itemDescription: GetItemDescriptionUseCase
) : ViewModel() {

    private val _description = MutableLiveData<String>("")
    val description: LiveData<String> get() = _description

    private val _images = MutableLiveData<List<String>>(listOf())
    val images: LiveData<List<String>> get() = _images

    private val _uiItem = MutableLiveData<UiItem>()
    val uiItem: LiveData<UiItem> get() = _uiItem

    fun setItem(item: UiItem){
        _uiItem.value = item
    }


    fun getItemDescription(id: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val description = itemDescription(id)
                    _description.postValue(description)
                } catch (e: NoInternetException) {
                    _description.postValue("")
                }
            }
        }
    }

    fun getItemImages(id: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val images = itemImagesImages(id)
                } catch (e: NoInternetException) {
                }
            }
        }
    }
}
