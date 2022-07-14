package nl.com.lucianoluzzi.noteappcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import nl.com.lucianoluzzi.noteappcompose.ui.screens.dashboard.DashboardScreen
import nl.com.lucianoluzzi.noteappcompose.ui.screens.details.DetailsScreen

@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.Dashboard.route,
    ) {
        composable(Destination.Dashboard.route) {
            DashboardScreen(
                onNoteClick = { noteId ->
                    navController.navigate(Destination.Details(noteId).route)
                }
            )
        }

        val detailsDestination = Destination.Details()
        composable(
            route = detailsDestination.route,
            arguments = listOf(navArgument(detailsDestination.noteKey) {
                type = NavType.StringType
            }),
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(detailsDestination.noteKey)?.let {
                DetailsScreen(
                    noteId = it,
                    onBackPressed = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}
