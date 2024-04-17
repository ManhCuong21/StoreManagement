package com.store.storemanagement.ui.components.topappbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.store.storemanagement.R
import com.store.storemanagement.ui.navigations.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarMain(
    navController: NavController,
    scrollBehavior: TopAppBarScrollBehavior,
    onClickDrawer: () -> Unit
) {
    val navStackBackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry.value?.destination?.route
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            when (currentDestination) {
                Screens.Home.route -> TopAppBarHome(onClickDrawer)
                Screens.Favorite.route -> TopAppBarWishList()
                Screens.Cart.route -> TopAppBarHome(onClickDrawer)
                Screens.Category.route -> TopAppBarHome(onClickDrawer)
                Screens.Profile.route -> TopAppBarHome(onClickDrawer)
            }
        },
    )
}

@Composable
fun TopAppBarHome(onClickDrawer: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Text(
                buildAnnotatedString {
                    append("Find Your \nFavorite ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Plants")
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_cactus),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(0.dp, 6.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.img_profile),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clip(RoundedCornerShape(32))
                .clickable { onClickDrawer() }
        )
    }
}

@Composable
fun TopAppBarWishList() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Wishlist",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}