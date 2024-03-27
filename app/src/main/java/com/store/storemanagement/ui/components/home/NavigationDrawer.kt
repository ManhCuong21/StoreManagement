package com.store.storemanagement.ui.components.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.store.storemanagement.ui.navigations.Screens
import com.store.storemanagement.ui.theme.StoreManagementTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(
    name: String
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {

            }
        },
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(name, scrollBehavior, onClickDrawer = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                })
            },
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(state = rememberScrollState())
            ) {
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")
                Text(text = "Welcome")

            }
        }
    }
}

val navigationItems = listOf(
    NavigationItem(
        title = "Home",
        route = Screens.Home.route,
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
    ),
    NavigationItem(
        title = "Profile",
        route = Screens.Profile.route,
        selectedIcon = Icons.Filled.Person,
        unSelectedIcon = Icons.Outlined.Person,
    )
)

data class NavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val badgeCount: Int? = null
)

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NavigationDrawerPreview() {
    StoreManagementTheme {
        NavigationDrawer("Home")
    }
}