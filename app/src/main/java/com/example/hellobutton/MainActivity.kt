package com.example.hellobutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hellobutton.ui.theme.HelloButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloButtonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Button(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Button(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(false) }
    val name: String = "Nizar"


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state){
            Greeting(name)
        }
        ExtendedFloatingActionButton(
            onClick = { state = !state },
            icon = { Icon(Icons.Default.Refresh, contentDescription = "refresh") },
            text = { Text(text = "Click me!") }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloButtonTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Button(
                modifier = Modifier.padding(innerPadding)
            )
        }
}}