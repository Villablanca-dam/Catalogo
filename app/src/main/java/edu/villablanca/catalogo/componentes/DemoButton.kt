package edu.villablanca.catalogo.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DemoButton(modifier: Modifier = Modifier){
    Column(
        modifier=modifier,
    ) {
        Text(text = "Demo button")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "normal")
        }
        Button(onClick = { /*TODO*/ }) {
            Text("Otro")
        }
    }
}