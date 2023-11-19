package edu.villablanca.catalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
//import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.villablanca.catalogo.ui.theme.CatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VentanaPrincipal()
                }
            }
        }
    }
}

@Composable
fun PantallaLista(navController: NavController) {
    val lista = listOf("Elemento 1", "Elemento 2", "Elemento 3")

    LazyColumn {
        // Add a single item
        item {
            Text(text = "First item")
        }
        items(lista){item ->
            Text(text = item,
            modifier = Modifier.clickable {
                navController.navigate("detail/$item")
            })

        }
        // Add 5 items
        items(5) { index ->
            Text(text = "Item: $index")
        }

        // Add another single item
        item {
            Text(text = "Last item")
        }
    }
}

@Composable
fun DetailScreen(item: String,navController: NavController) {
    Column {
        Text(text = "Detalles de $item")
        Button(onClick = {  navController.navigate("list")}) {
            Text(text = "<- Inicio")
        }
        Button(onClick = { navController.navigate("info/$item") }) {
            Text("Código fuente")
        }
    }
  
}
@Composable
fun CodigoFuente(navController: NavController, detailItem: String) {
    Column {
        Text(text = "Información adicional para $detailItem")
        Button(onClick = { navController.popBackStack() }) {
            Text("Volver a Detalles")
        }
    }
}
@Composable
fun VentanaPrincipal(modifier: Modifier = Modifier ) {

    val navController = rememberNavController()

    Column {
        Text(
            text = "Componentes Jetpack",
            modifier = modifier
        )


        NavHost(navController = navController, startDestination = "list") {
            composable("list") { PantallaLista(navController) }
            composable("detail/{item}") { backStackEntry ->
                DetailScreen(backStackEntry.arguments?.getString("item") ?: "",
                    navController = navController)
            }
            composable("info/{detailItem}") { backStackEntry ->
                CodigoFuente(
                    navController = navController,
                    detailItem = backStackEntry.arguments?.getString("detailItem") ?: ""
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CatalogoTheme {
        VentanaPrincipal()
    }
}