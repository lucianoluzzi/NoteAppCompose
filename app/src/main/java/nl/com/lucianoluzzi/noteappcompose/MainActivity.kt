package nl.com.lucianoluzzi.noteappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nl.com.lucianoluzzi.noteappcompose.ui.navigation.MainNavHost
import nl.com.lucianoluzzi.noteappcompose.ui.theme.NoteAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppComposeTheme {
                MainNavHost()
            }
        }
    }
}
