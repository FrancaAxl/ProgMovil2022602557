package com.example.holatoats

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { UIPrincipal() }
    }
}

@Composable
fun UIPrincipal() {
    var nombre by rememberSaveable { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("area del mensaje") }

fun mensaje(){
    mensaje ="hola $nombre"
}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        //verticalArrangement = Arrangement.Center,
        //horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "¿Como te llamas?", style = MaterialTheme.typography.bodyLarge)

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Introduce tu nombre") },
            modifier = Modifier
                .padding(vertical = 8.dp)
        )

        Button(
            onClick = { mensaje() },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Saludar!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Previsualizacion() {
    UIPrincipal()
}
