package edu.villablanca.catalogo.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/**
 *   DemoBasicTextField
 */
//@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun DemoBasicTextField(){
    var text by remember { mutableStateOf("") }
   // TextField(value = text, onValueChange = {text = it})
    Column (){
        BasicTextField(
            modifier = Modifier.background(Color.White)
            , value = text, onValueChange = {text = it}) {
            Text(text = "valor: " + text, color = Color.Black)
        }
    }

}