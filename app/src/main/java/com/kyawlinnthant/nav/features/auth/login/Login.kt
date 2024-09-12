package com.kyawlinnthant.nav.features.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(),
    albumName: String,
    password: String,
    onErrorName: Boolean,
    onErrorPassword: Boolean,
    onAction: (LoginAction) -> Unit
) {

    Box(
        modifier = modifier
            .padding(paddingValues)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = modifier.imePadding(),
            state = rememberLazyListState(),
            contentPadding = PaddingValues(32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                OutlinedTextField(
                    modifier = modifier
                        .fillMaxWidth(),
                    value = albumName,
                    onValueChange = {
                        onAction(LoginAction.OnUpdateAlbumName(it))
                    },
                    label = {
                        Text("SOAD album with the release year")
                    },
                    isError = onErrorName,
                    supportingText = {
                        if (onErrorName == true) {
                            Text("Wrong Album name and Released Year!")
                        }else null
                    }

                )
            }
            item {
                OutlinedTextField(
                    modifier = modifier
                        .fillMaxWidth(),
                    value = password,
                    onValueChange = {
                        onAction(LoginAction.OnUpdatePassword(it))
                    },
                    label = {
                        Text("Type password as SOAD")
                    },
                    isError = onErrorPassword,
                    supportingText = {
                        if (onErrorPassword == true) {
                            Text("Wrong Password!")
                        }else null
                    }
                )
            }
            item {
                Spacer(modifier = modifier.navigationBarsPadding())
            }
            item {
                Button(
                    modifier = modifier
                        .fillMaxWidth(),
                    onClick = {
                        onAction(LoginAction.OnLoginClick)
                    }
                ) {
                    Text("Login")
                }
            }
            item {
                OutlinedButton (
                    modifier = modifier
                        .fillMaxWidth(),
                    onClick = {
                        onAction(LoginAction.OnAlbumList)
                    }
                ) {
                    Text("View Album List?")
                }
            }
        }
    }

}
