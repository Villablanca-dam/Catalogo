package edu.villablanca.catalogo.pantallas

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.villablanca.catalogo.navegacion.Navegacion

/**
 * Pantalla principal
 */

@Composable
fun PantallaPrincipal(context: Context, modifier: Modifier = Modifier) {


    Column (
        modifier=Modifier.fillMaxWidth()
    ){
        Navegacion(context)

        Text(
            text = "Componentes Jetpack",
            modifier = modifier.fillMaxWidth().padding(horizontal= 5.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )




    }

}