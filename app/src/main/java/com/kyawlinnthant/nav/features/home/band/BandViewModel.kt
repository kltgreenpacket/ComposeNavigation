package com.kyawlinnthant.nav.features.home.band

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyawlinnthant.nav.data.Band
import com.kyawlinnthant.nav.data.Store
import com.kyawlinnthant.nav.data.StoreSingleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BandViewModel(private val repo: Store = StoreSingleton.getRepo()) : ViewModel() {

    val band: StateFlow<Band?>
        field = MutableStateFlow(null)

    init {
        getBand()
    }

    private fun getBand() {
        viewModelScope.launch {
            repo.getBand().collectLatest {
                band.value = it
            }
        }
    }
}