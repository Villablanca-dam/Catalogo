package edu.villablanca.catalogo.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import edu.villablanca.catalogo.Item1
import edu.villablanca.catalogo.Item2
import edu.villablanca.catalogo.componentes.DemoButton

/**
 * Pantalla con todas las variantes del compoente
 * @param item Cadena indicando la pantalla a la que navegar
 */
@Composable
fun DetailScreen(item: String,navController: NavController) {

    val modifier = Modifier.fillMaxWidth(0.8f)
    Column {

        when (item) {
            "Text" -> Item1()
            "Button" -> DemoButton()
            "TextField" -> Item2()
            else -> println("Error funcion no preparada")
        }

        Text(text = "Detalles de $item")
        Button(onClick = { navController.navigate("list") }) {
            Text(text = "<- Volver")
        }
        Button(onClick = { navController.navigate("info/$item") }) {
            Text("Código fuente")
        }
    }

}