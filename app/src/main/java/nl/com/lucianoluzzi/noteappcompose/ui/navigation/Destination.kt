package nl.com.lucianoluzzi.noteappcompose.ui.navigation

sealed class Destination(val route: String) {
    object Dashboard : Destination("dashboard")
    data class Details(val noteKey: String = "note") : Destination("details/{$noteKey}")
}
