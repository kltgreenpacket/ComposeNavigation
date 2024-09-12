package com.kyawlinnthant.nav.features.auth.login

import androidx.lifecycle.ViewModel
import com.kyawlinnthant.nav.util.Albums
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {

    val albumName: StateFlow<String>
        field = MutableStateFlow("")
    val password: StateFlow<String>
        field = MutableStateFlow("")
    val onErrorAlbum: StateFlow<Boolean>
        field = MutableStateFlow(false)
    val onErrorPassword: StateFlow<Boolean>
        field = MutableStateFlow(false)

    fun onAction(action: LoginAction) {
        when (action) {
            LoginAction.OnLoginClick -> {
                onLogin()
            }

            is LoginAction.OnUpdateAlbumName -> {
                updateName(action.name)
            }

            is LoginAction.OnUpdatePassword -> {
                updatePassword(action.password)
            }

            LoginAction.OnAlbumList -> {

            }
        }
    }

    private fun updateName(name: String) {
        onErrorAlbum.value = false
        albumName.value = name
    }

    private fun updatePassword(password: String) {
        onErrorPassword.value = false
        this.password.value = password
    }

    private fun onLogin(
        name: String = albumName.value,
        password: String = this.password.value
    ) {
        val validAlbum = Albums.validateAlbum(name = name)
        val validPassword = Albums.validatePassword(password = password)
        if (!validAlbum) {
            onErrorAlbum.value = true
        }
        if (!validPassword) {
            onErrorPassword.value = true
        }
        if (validAlbum && validPassword) {
            print("Valid")
        }
    }
}