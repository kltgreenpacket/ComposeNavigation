package com.kyawlinnthant.nav.features.home.band

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kyawlinnthant.nav.data.Player

@Composable
fun BandScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(),
    players: List<Player>?
) {
    players?.let { data ->
        LazyColumn(
            modifier = modifier.padding(paddingValues),
            state = rememberLazyListState()
        ) {
            items(
                data.size, key = { it }) { index ->
                val currentPlayer = data[index]
                ListItem(
                    headlineContent = {
                        Text(
                            currentPlayer.name,
                            style = MaterialTheme.typography.headlineLarge.copy(
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                    },
                    supportingContent = {
                        Column {
                            Text(
                                currentPlayer.dob,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    color = MaterialTheme.colorScheme.secondary
                                )
                            )
                            Text(currentPlayer.bio)
                        }
                    },
                    overlineContent = {
                        Text(currentPlayer.role)

                    }
                )
            }
        }
    } ?: run {
        Box(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("No Data!")
        }
    }
}