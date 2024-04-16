package com.store.storemanagement.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.store.storemanagement.R
import com.store.storemanagement.core.resource.InputOutLinedTextField
import com.store.storemanagement.core.resource.NonLazyGrid
import com.store.storemanagement.domain.model.CategoryPlant
import com.store.storemanagement.domain.model.Plant
import com.store.storemanagement.domain.model.TitleMostPopularPlant
import com.store.storemanagement.ui.components.home.BannerImageHome
import com.store.storemanagement.ui.components.home.ItemListMostPopularPlant
import com.store.storemanagement.ui.components.home.ItemListRecently
import com.store.storemanagement.ui.components.home.ListCartHome
import com.store.storemanagement.ui.components.home.ListSliderPopularNearby
import com.store.storemanagement.ui.components.home.listCategoryPlant
import com.store.storemanagement.ui.components.home.listTitleMostPopular

@Composable
fun HomeScreen() {
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
            Plant(
                "Emerald Fern Fronds (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic1.png",
                CategoryPlant("", ""),
                80,
                0
            ),
            Plant(
                "Scarlet Petal Paradise (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic2.png",
                CategoryPlant("", ""),
                99,
                0
            ),
            Plant(
                "Silver Leaf Serenity (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic3.png",
                CategoryPlant("", ""),
                49,
                0
            ),
            Plant(
                "Royal Bluebell Bliss (M)",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/product/product1/pic4.png",
                CategoryPlant("", ""),
                80,
                0
            )
        )
    }
    val selectedIndex = remember { mutableIntStateOf(0) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
//            .nestedScroll(scrollBehavior.nestedScrollConnection)
//            .padding(innerPadding)
    ) {
        item { InputOutLinedTextField() }
        item { Spacer(modifier = Modifier.padding(8.dp)) }
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Find Plant Category",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                LazyRow(contentPadding = PaddingValues(16.dp, 20.dp)) {
                    listCategoryPlant(categoryPlants)
                }
            }
        }
        item {
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
                listTitleMostPopular(
                    titleMostPopularPlants,
                    selectedIndex.intValue
                ) { selectedIndex.intValue = it }
            }
            NonLazyGrid(
                columns = 2,
                itemCount = mostPopularPlants.size,
                modifier = Modifier.padding(8.dp)
            ) {
                ItemListMostPopularPlant(mostPopularPlants[it])
            }
        }
        item { BannerImageHome() }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Recently Shortlisted By You",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    text = "See All",
                    style = MaterialTheme.typography.labelMedium
                )
            }
            LazyRow(contentPadding = PaddingValues(horizontal = 8.dp)) {
                items(mostPopularPlants) {
                    ItemListRecently(item = it)
                }
            }
        }
        item {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .background(MaterialTheme.colorScheme.onTertiary)
                    .padding(vertical = 20.dp, horizontal = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    Text(
                        text = "Items In Your Cart",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "View cart",
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
                ListCartHome(mostPopularPlants)
                ClickableText(text = AnnotatedString("Proceed to checkout (3)"),
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            MaterialTheme.colorScheme.primary,
                            RoundedCornerShape(16.dp)
                        )
                        .padding(vertical = 16.dp),
                    onClick = {})
            }
        }
        item {
            Text(
                text = "Popular Nearby",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Up to 60% off + up to \$107 cashback",
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = "See All",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(
                model = "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/map.png",
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(195.dp),
                contentScale = ContentScale.FillBounds
            )
            ListSliderPopularNearby(list = mostPopularPlants)
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Featured Now",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "See All",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            val listImageFeaturedOffer = listOf(
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/banner/ads/banner1.png",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/banner/ads/banner2.png",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/banner/ads/banner1.png",
                "https://plantzone.dexignzone.com/mobile/xhtml/assets/images/banner/ads/banner2.png"
            )
            LazyRow(contentPadding = PaddingValues(horizontal = 16.dp)) {
                items(listImageFeaturedOffer) {
                    AsyncImage(
                        modifier = Modifier
                            .size(250.dp, 120.dp)
                            .padding(end = 16.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        model = it, contentDescription = null
                    )
                }
            }
        }
    }
}