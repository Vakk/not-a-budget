package com.valeriik.dashboard.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DashboardContent(
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxSize()) {
        Text(text = "Dashboard")
    }
}

