package com.kyawlinnthant.nav.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kyawlinnthant.nav.features.auth.forgot.AlbumsScreen
import com.kyawlinnthant.nav.features.auth.login.LoginScreen
import com.kyawlinnthant.nav.features.auth.login.LoginViewModel
import com.kyawlinnthant.nav.features.home.band.BandScreen
import com.kyawlinnthant.nav.features.home.band.BandViewModel
import com.kyawlinnthant.nav.theme.ComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val vm: BandViewModel = viewModel()
            val players = vm.band.collectAsState()

            val loginVm : LoginViewModel = viewModel()
            val albumName = loginVm.albumName.collectAsState()
            val password = loginVm.password.collectAsState()
            val onErrorAlbum = loginVm.onErrorAlbum.collectAsState()
            val onErrorPassword = loginVm.onErrorPassword.collectAsState()

            ComposeNavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        paddingValues = innerPadding,
                        albumName = albumName.value,
                        password = password.value,
                        onErrorName = onErrorAlbum.value,
                        onErrorPassword = onErrorPassword.value,
                        onAction = loginVm::onAction
                    )
//                    AlbumsScreen(paddingValues = innerPadding)

//                    BandScreen(
//                        players = players.value?.players,
//                        paddingValues = innerPadding
//                    )
                }
            }
        }
    }
}
