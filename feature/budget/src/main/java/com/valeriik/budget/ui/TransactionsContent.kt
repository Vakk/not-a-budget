package com.valeriik.budget.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TransactionsContent(
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxSize()) {
        Text(text = "Transactions")
    }
}