package com.example.submissionexpert1.presentation.ui.nav

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.submissionexpert1.presentation.navigation.navigateSingleTop

@Composable
fun BottomBar(
  isActive : (String) -> Boolean,
  navController : NavHostController,
) {
  NavigationBar {
    BottomBarItem().bottomBarItems().forEachIndexed { index, navigationItem ->
      NavigationBarItem(
        selected = isActive(navigationItem.route),
        label = {
          Text(navigationItem.label)
        },
        icon = {
          Icon(
            navigationItem.icon,
            contentDescription = navigationItem.label
          )
        },
        onClick = {
          navController.navigateSingleTop(navigationItem.route)
        }
      )
    }

  }
}