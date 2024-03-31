package com.store.storemanagement.screens.main

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.store.storemanagement.ui.components.home.NavigationDrawerBody
import com.store.storemanagement.ui.components.home.NavigationDrawerHeader
import com.store.storemanagement.ui.components.home.TopAppBar
import com.store.storemanagement.ui.theme.StoreManagementTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(name: String) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerHeader()
                NavigationDrawerBody(onItemClick = {

                })
            }
        },
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            containerColor = MaterialTheme.colorScheme.primaryContainer,
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
                    .padding(8.dp, 0.dp)
                    .padding(innerPadding)
                    .verticalScroll(state = rememberScrollState())
            ) {
                InputTextField()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField() {
    // we are creating a variable for
    // getting a value of our text field.
    val inputvalue = remember { mutableStateOf(TextFieldValue("")) }
    Column(
        // we are using column to align our
        // imageview to center of the screen.
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),

        // below line is used for specifying
        // vertical arrangement.
        verticalArrangement = Arrangement.Center,

        // below line is used for specifying
        // horizontal arrangement.
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            value = inputvalue.value,
            onValueChange = { inputvalue.value = it },
            label = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = ""
                )
            },
            shape = CircleShape,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.background,
                focusedIndicatorColor = Color.Transparent, //hide the indicator
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = { Text(text = "Search...") })
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MainScreenPreview() {
    StoreManagementTheme {
        MainScreen("Home")
    }
}