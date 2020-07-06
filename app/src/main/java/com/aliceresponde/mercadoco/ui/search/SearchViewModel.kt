package com.aliceresponde.mercadoco.ui.search

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliceresponde.mercadoco.domain.SearchUseCase
import com.aliceresponde.mercadoco.remote.NoInternetException
import com.aliceresponde.mercadoco.ui.model.UiItem
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel(private val useCase: SearchUseCase) : ViewModel() {
    private val _loadingVisibility = MutableLiveData<Int>(GONE)
    val loadingVisibility: LiveData<Int> get() = _loadingVisibility

    private val _recyclerVisibility = MutableLiveData<Int>(GONE)
    val recyclerVisibility: LiveData<Int> get() = _recyclerVisibility

    private val _noDataVisibility = MutableLiveData<Int>(GONE)
    val noDataVisibility: LiveData<Int> get() = _noDataVisibility

    private val _noInternetVisibility = MutableLiveData<Int>(GONE)
    val noInternetVisibility: LiveData<Int> get() = _noInternetVisibility

    private val _isInputEmpty = MutableLiveData<Boolean>(false)
    val isInputEmpty: LiveData<Boolean> get() = _isInputEmpty


    private val _items = MutableLiveData<List<UiItem>>()
    val items: LiveData<List<UiItem>> get() = _items

    fun searchItems(input: String) {
        if (input.isEmpty()) {
            _isInputEmpty.value = true
            return
        }

        viewModelScope.launch {
            withContext(IO) {
                try {
                    hideViews()
                    _loadingVisibility.postValue(VISIBLE)
                    val data = useCase.searchItem(input)
                    _items.postValue(data)
                    updateVisibility(data)
                } catch (e: NoInternetException) {
                    hideViews()
                    _noInternetVisibility.postValue(VISIBLE)
                }
            }
        }
    }

    private fun hideViews() {
        _loadingVisibility.postValue(GONE)
        _recyclerVisibility.postValue(GONE)
        _noDataVisibility.postValue(GONE)
        _noInternetVisibility.postValue(GONE)
    }

    private fun updateVisibility(data: List<UiItem>) {
        _loadingVisibility.postValue(GONE)
        _recyclerVisibility.postValue(if (data.isEmpty()) GONE else VISIBLE)
        _noDataVisibility.postValue(if (data.isEmpty()) VISIBLE else GONE)
    }
}
