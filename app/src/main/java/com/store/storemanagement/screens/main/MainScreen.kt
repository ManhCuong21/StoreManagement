package com.store.storemanagement.screens.main

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.store.storemanagement.ui.components.home.NavigationDrawer
import com.store.storemanagement.ui.theme.StoreManagementTheme

@Composable
fun MainScreen(name: String) {
    NavigationDrawer(name)
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MainScreenPreview() {
    StoreManagementTheme {
        MainScreen("Home")
    }
}