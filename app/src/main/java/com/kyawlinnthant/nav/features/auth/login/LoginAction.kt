package com.kyawlinnthant.nav.features.auth.login

sealed interface LoginAction {
    data class OnUpdateAlbumName(val name: String) : LoginAction
    data class OnUpdatePassword(val password: String) : LoginAction
    data object OnLoginClick : LoginAction
    data object OnAlbumList : LoginAction
}