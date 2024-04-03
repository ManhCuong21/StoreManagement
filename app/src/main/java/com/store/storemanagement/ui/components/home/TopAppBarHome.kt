package com.store.storemanagement.ui.components.home

import android.content.res.Configuration
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.store.storemanagement.R
import com.store.storemanagement.ui.theme.StoreManagementTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarHome(
    scrollBehavior: TopAppBarScrollBehavior,
    onClickDrawer: () -> Unit
) {
    TopAppBar(
        modifier = Modifier
            .padding(0.dp, 8.dp)
            .padding(0.dp),
        colors = TopAppBarDefaults.smallTopAppBarColors(MaterialTheme.colorScheme.background),
        title = {
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
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreviewTopAppBar() {
    StoreManagementTheme {
        TopAppBarHome(TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())) {}
    }
}