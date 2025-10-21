package com.example.uts_mobcom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uts_mobcom.ui.theme.Uts_mobcomTheme

object Destinations {
    const val HOME = "home"
    const val ADD_CONTACT = "add_contact"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Uts_mobcomTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Destinations.HOME,
                    modifier = Modifier.fillMaxSize()
                ) {
                    composable(Destinations.HOME) {
                        HomeScreen(onNavigate = { route ->
                            navController.navigate(route)
                        })
                    }
                    composable(Destinations.ADD_CONTACT) {
                        SimpleOutlinedTextFieldScreen(
                            onBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Dashboard")

            Button(onClick = { onNavigate(Destinations.ADD_CONTACT) }) {
                Text("Tambah dan Edit Kontak")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Uts_mobcomTheme {
        HomeScreen {}
    }
}
