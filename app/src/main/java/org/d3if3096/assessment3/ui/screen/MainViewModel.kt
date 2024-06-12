package org.d3if3096.assessment3.ui.screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.d3if3096.assessment3.model.Product
import org.d3if3096.assessment3.network.ApiStatus
import org.d3if3096.assessment3.network.ProductApi


class MainViewModel : ViewModel() {

    var data = mutableStateOf(emptyList<Product>())
        private set

    var status = MutableStateFlow(ApiStatus.LOADING)
        private set
    init {
        retrieveData()
    }

    fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.value = ApiStatus.LOADING
            try {
                data.value = ProductApi.service.getProduct()
                status.value = ApiStatus.SUCCESS

            } catch (e: Exception) {
                Log.d("MainViewModel", "Failed: ${e.message}")
                status.value = ApiStatus.FAILED
            }
        }
    }
}