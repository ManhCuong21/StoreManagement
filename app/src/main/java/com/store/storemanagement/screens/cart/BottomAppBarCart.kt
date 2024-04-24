package com.store.storemanagement.screens.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomAppBarCart(totalCount: Int, totalAmount: Int) {
    Column(
        Modifier
            .background(MaterialTheme.colorScheme.onTertiary)
            .padding(16.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Total Amount", style = MaterialTheme.typography.titleLarge)
            Text(
                text = "$$totalAmount",
                modifier = Modifier.align(Alignment.CenterEnd),
                style = MaterialTheme.typography.titleMedium
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { /*TODO*/ }) {
            Text(
                text = "Proceed To Buy ($totalCount Items)",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }
    }
}