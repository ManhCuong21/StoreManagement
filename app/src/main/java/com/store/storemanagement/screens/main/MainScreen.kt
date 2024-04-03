package com.store.storemanagement.screens.main

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.store.storemanagement.R
import com.store.storemanagement.core.resource.InputOutLinedTextField
import com.store.storemanagement.domain.model.CategoryPlant
import com.store.storemanagement.domain.model.MostPopularPlant
import com.store.storemanagement.domain.model.TitleMostPopularPlant
import com.store.storemanagement.ui.components.home.ItemListCategoryPlant
import com.store.storemanagement.ui.components.home.ItemListMostPopularPlant
import com.store.storemanagement.ui.components.home.ItemListTitleMostPopular
import com.store.storemanagement.ui.components.home.NavigationDrawerBody
import com.store.storemanagement.ui.components.home.NavigationDrawerHeader
import com.store.storemanagement.ui.components.home.TopAppBarHome
import com.store.storemanagement.ui.theme.StoreManagementTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val categoryPlants = remember {
        listOf(
            CategoryPlant(
                "Indoor Plants",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/category/pic1.png"
            ),
            CategoryPlant(
                "House Plant",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/category/pic2.png"
            ),
            CategoryPlant(
                "Tropical",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/category/pic3.png"
            )
        )
    }
    val titleMostPopularPlants = remember {
        listOf(
            TitleMostPopularPlant("Trees"),
            TitleMostPopularPlant("Shrubs"),
            TitleMostPopularPlant("Herbs"),
            TitleMostPopularPlant("Vines"),
            TitleMostPopularPlant("Ferns"),
            TitleMostPopularPlant("Trees"),
            TitleMostPopularPlant("Shrubs"),
            TitleMostPopularPlant("Herbs"),
            TitleMostPopularPlant("Vines"),
            TitleMostPopularPlant("Ferns")
        )
    }
    val mostPopularPlants = remember {
        listOf(
            MostPopularPlant(
                "Emerald Fern Fronds (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic1.png",
                CategoryPlant("", ""),
                80
            ),
            MostPopularPlant(
                "Scarlet Petal Paradise (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic2.png",
                CategoryPlant("", ""),
                99
            ),
            MostPopularPlant(
                "Silver Leaf Serenity (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic3.png",
                CategoryPlant("", ""),
                49
            ),
            MostPopularPlant(
                "Royal Bluebell Bliss (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic4.png",
                CategoryPlant("", ""),
                80
            )
        )
    }
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
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                TopAppBarHome(scrollBehavior, onClickDrawer = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                })
            },
        ) { innerPadding ->
            val selectedIndex = remember { mutableIntStateOf(0) }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .nestedScroll(scrollBehavior.nestedScrollConnection)
                    .padding(innerPadding)
            ) {
                InputOutLinedTextField()
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = "Find Plant Category",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                LazyRow(contentPadding = PaddingValues(16.dp, 20.dp)) {
                    items(
                        items = categoryPlants,
                        itemContent = { ItemListCategoryPlant(item = it) })
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Most Popular Products",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
                LazyRow(contentPadding = PaddingValues(16.dp, 20.dp)) {
                    itemsIndexed(titleMostPopularPlants) { index, list ->
                        ItemListTitleMostPopular(list,
                            selected = selectedIndex.intValue == index,
                            clickAction = { selectedIndex.intValue = index })
                    }
                }
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    verticalItemSpacing = 4.dp,
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    userScrollEnabled = false
                ) {
                    items(mostPopularPlants) { item ->
                        ItemListMostPopularPlant(item)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MainScreenPreview() {
    StoreManagementTheme {
        MainScreen()
    }
}