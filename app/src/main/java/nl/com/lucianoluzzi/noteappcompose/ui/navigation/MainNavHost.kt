package nl.com.lucianoluzzi.noteappcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import nl.com.lucianoluzzi.noteappcompose.ui.screens.dashboard.DashboardScreen

@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.Dashboard.route,
    ) {
        composable(Destination.Dashboard.route) {
            DashboardScreen()
        }
    }
}
