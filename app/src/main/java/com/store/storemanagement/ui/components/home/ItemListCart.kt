package com.store.storemanagement.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.store.storemanagement.R
import com.store.storemanagement.domain.model.Plant
import kotlin.math.roundToInt

@Composable
fun ListCartHome(list: List<Plant>) {
    list.take(3).forEach {
        ItemListCart(it)
    }
}

@Composable
fun ItemListCart(item: Plant) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .padding(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background, RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.tree_example),
                contentDescription = null,
                modifier = Modifier.size(75.dp)
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(text = "Velvet Violet Vines (M)", style = MaterialTheme.typography.titleMedium)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "\$${item.price}",
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "\$${(item.price * 1.2).roundToInt()}",
                    style = TextStyle(
                        textDecoration = TextDecoration.LineThrough,
                        color = Color.Gray,
                        fontStyle = FontStyle.Italic
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.baseline_star_24),
                    contentDescription = null
                )
                Text(text = "(${item.review} Review)")
            }
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                    append("Quantity: ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("1")
                }
            })
        }
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            Image(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background, CircleShape)
                    .padding(8.dp)
                    .align(Alignment.CenterEnd),
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = null
            )
        }
    }
}