@file:Suppress("DEPRECATION")

package com.kyawlinnthant.nav.features.auth.forgot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kyawlinnthant.nav.util.Albums

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbumsScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(),
    albums: List<String> = Albums.albums
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("SOAD Albums")
                },
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) {
        LazyColumn(
            modifier = modifier
                .padding(it),
            state = rememberLazyListState(),
            contentPadding = PaddingValues(horizontal = 32.dp)
        ) {
            items(
                albums.size, key = { it }) { index ->
                val album = "${index + 1}. ${albums[index]}"
                ListItem(
                    headlineContent = {
                        Text(
                            album,
                            style = MaterialTheme.typography.labelLarge.copy(
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                )
            }
        }
    }


}