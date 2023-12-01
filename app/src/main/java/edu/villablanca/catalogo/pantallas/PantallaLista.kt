package edu.villablanca.catalogo.pantallas


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import edu.villablanca.catalogo.componentes.DemoButton
import edu.villablanca.catalogo.navegacion.Destino


internal  val uiComponentes = listOf(
    "Text",
    "Button",
    "TextField")

internal val listaRutas = listOf<Destino>(
    Destino.PText,
    Destino.PButton
)


/**
 *
 * Pantalla con la lista de componentes
 * @param  navController
 */
@Composable
fun PantallaLista(navController: NavController) {


    LazyColumn(
        modifier = Modifier.fillMaxWidth(0.8f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // item { Text(text = "Estoy en la PantallaLista") }
        /*  items(uiComponentes) { item ->
            Button(
                modifier = Modifier.fillMaxWidth(0.8f),
                onClick = {  navController.navigate("detail/$item") }
            ) {
                Text(text = item,


                )
            }
        }*/
        items(listaRutas) { destino ->
            Button(
                modifier = Modifier.fillMaxWidth(0.8f),
                onClick = { navController.navigate(destino.ruta) }
            ) {
                Text(
                    text = destino.ruta,
                )

            }

        }
    }
}