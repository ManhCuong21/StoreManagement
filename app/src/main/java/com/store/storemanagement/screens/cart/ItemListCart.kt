package com.store.storemanagement.screens.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.store.storemanagement.R
import com.store.storemanagement.domain.model.Plant
import kotlin.math.roundToInt

@Composable
fun ItemListCart(item: Plant, totalAmount: (String, Int) -> Unit) {
    var count by remember { mutableStateOf(1) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .background(MaterialTheme.colorScheme.onTertiary, RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.tree_example),
            contentDescription = null,
            modifier = Modifier.size(75.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(text = "Velvet Violet Vines (M)", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
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
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {
                    if (count > 1) {
                        count -= 1
                        totalAmount("Remove", item.price)
                    }
                }) {
                    Icon(
                        modifier = Modifier.clip(RoundedCornerShape(24.dp)),
                        painter = painterResource(id = R.drawable.ic_remove_24),
                        contentDescription = null
                    )
                }
                Text(text = "$count", style = MaterialTheme.typography.titleMedium)
                IconButton(onClick = {
                    count += 1
                    totalAmount("Add", item.price)
                }) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.Bottom)
        ) {
            IconButton(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.errorContainer, CircleShape)
                    .align(Alignment.BottomEnd),
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_delete_24),
                        contentDescription = null,
                        tint = Color(229, 79, 78)
                    )
                }, onClick = {}
            )
        }
    }
}