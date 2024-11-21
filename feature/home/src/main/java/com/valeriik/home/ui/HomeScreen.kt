package com.valeriik.home.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.valeriik.budget.ui.TransactionsContent
import com.valeriik.dashboard.ui.DashboardContent
import com.valeriik.navigation.NavigationConstants
import com.valeriik.notes.ui.NotesContent


private enum class NavigationTab {
    Notes,
    Transactions,
    Dashboard
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
) {
    var navigationTab by remember { mutableStateOf(NavigationTab.Notes) }

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Budget Overview", style = MaterialTheme.typography.titleLarge)
                },
                actions = {
                    IconButton(onClick = { navController.navigate(NavigationConstants.settings()) }) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // Handle Add New Grocery item
                },
                modifier = Modifier.padding(16.dp),
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Item")
            }
        },
        bottomBar = {
            BottomAppBar(actions = {
                NavigationBarItem(
                    selected = navigationTab == NavigationTab.Notes,
                    onClick = { navigationTab = NavigationTab.Notes },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Notes"
                        )
                    })
                NavigationBarItem(
                    selected = navigationTab == NavigationTab.Transactions,
                    onClick = { navigationTab = NavigationTab.Transactions },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Transactions"
                        )
                    })
                NavigationBarItem(
                    selected = navigationTab == NavigationTab.Dashboard,
                    onClick = { navigationTab = NavigationTab.Dashboard },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Dashboard"
                        )
                    })
            })
        }
    ) {
        val modifier = remember { Modifier.padding(it).fillMaxSize() }
        when (navigationTab) {
            NavigationTab.Notes -> NotesContent(modifier = modifier, navController = navController)
            NavigationTab.Transactions -> TransactionsContent(modifier = modifier)
            NavigationTab.Dashboard -> DashboardContent(modifier = modifier)
        }
    }
}