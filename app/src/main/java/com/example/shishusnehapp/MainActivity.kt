package com.example.shishusnehapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShishuSnehApp()
        }
    }
}

@Composable
fun ShishuSnehApp() {

    var currentScreen by remember { mutableStateOf("home") }

    when (currentScreen) {

        "home" -> HomeScreen(
            onAddChildClick = {
                currentScreen = "addChild"
            },
            onVaccinationClick = {
                currentScreen = "vaccination"
            },
            onHealthTipsClick = {
                currentScreen = "health"
            }
        )

        "addChild" -> AddChildScreen(
            onBackClick = {
                currentScreen = "home"
            }
        )

        "vaccination" -> VaccinationScreen(
            onBackClick = {
                currentScreen = "home"
            }
        )

        "health" -> HealthTipsScreen(
            onBackClick = {
                currentScreen = "home"
            }
        )
    }
}

@Composable
fun HomeScreen(
    onAddChildClick: () -> Unit,
    onVaccinationClick: () -> Unit,
    onHealthTipsClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "ShishuSnehApp",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Child Health & Vaccination Tracker"
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = onAddChildClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Child")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = onVaccinationClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Vaccination Schedule")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = onHealthTipsClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Health Tips")
        }
    }
}

@Composable
fun AddChildScreen(onBackClick: () -> Unit) {

    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Add Child Details",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("Child Name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = age,
            onValueChange = {
                age = it
            },
            label = {
                Text("Age")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                if (name.isNotEmpty() && age.isNotEmpty()) {

                    Toast.makeText(
                        context,
                        "Child Details Saved",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {

                    Toast.makeText(
                        context,
                        "Please enter all details",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Save")
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

@Composable
fun VaccinationScreen(onBackClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Vaccination Schedule",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("• Birth → BCG, OPV")
        Spacer(modifier = Modifier.height(10.dp))

        Text("• 6 Weeks → DPT, Hepatitis B")
        Spacer(modifier = Modifier.height(10.dp))

        Text("• 9 Months → Measles")

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedButton(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

@Composable
fun HealthTipsScreen(onBackClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Health Tips",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("• Give nutritious food")
        Spacer(modifier = Modifier.height(10.dp))

        Text("• Ensure proper sleep")
        Spacer(modifier = Modifier.height(10.dp))

        Text("• Maintain hygiene")
        Spacer(modifier = Modifier.height(10.dp))

        Text("• Follow vaccination schedule")

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedButton(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}