package nl.com.lucianoluzzi.noteappcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import nl.com.lucianoluzzi.noteappcompose.ui.screens.dashboard.DashboardScreen
import nl.com.lucianoluzzi.noteappcompose.ui.screens.details.DetailsScreen
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.Dashboard.route,
    ) {
        composable(Destination.Dashboard.route) {
            DashboardScreen(
                viewModel = getViewModel(),
                onNoteClick = { noteId ->
                    navController.navigate(Destination.Details(noteId).route)
                }
            )
        }

        val detailsDestination = Destination.Details()
        composable(
            route = detailsDestination.route,
            arguments = listOf(navArgument(detailsDestination.noteKey.toString()) {
                type = NavType.LongType
            }),
        ) { backStackEntry ->
            backStackEntry.arguments?.getLong(detailsDestination.noteKey.toString())?.let {
                DetailsScreen(
                    viewModel = getViewModel(
                        parameters = { parametersOf(it) }
                    ),
                    onBackPressed = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}
