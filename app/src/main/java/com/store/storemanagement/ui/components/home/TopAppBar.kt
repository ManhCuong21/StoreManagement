package com.store.storemanagement.ui.components.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.store.storemanagement.ui.theme.StoreManagementTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    name: String,
    scrollBehavior: TopAppBarScrollBehavior,
    onClickDrawer: () -> Unit
) {
    CenterAlignedTopAppBar(
        modifier = Modifier.padding(8.dp,0.dp),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
        ),
        title = {
            Text(name, style = MaterialTheme.typography.titleLarge)
        },
        navigationIcon = {
            IconButton(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
                    .background(MaterialTheme.colorScheme.background),
                onClick = { onClickDrawer() }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description",
                )
            }
        },
        actions = {
            IconButton(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
                    .background(MaterialTheme.colorScheme.background),
                onClick = { onClickDrawer() }) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Localized description",
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreviewTopAppBar() {
    StoreManagementTheme {
        TopAppBar("Home", TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())) {}
    }
}