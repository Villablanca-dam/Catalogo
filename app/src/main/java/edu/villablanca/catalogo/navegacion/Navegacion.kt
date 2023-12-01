package edu.villablanca.catalogo.navegacion


import edu.villablanca.catalogo.componentes.DemoButton
import android.content.Context
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.villablanca.catalogo.componentes.DemoButton
import edu.villablanca.catalogo.componentes.DemoText
import edu.villablanca.catalogo.navegacion.*
import edu.villablanca.catalogo.pantallas.DetailScreen
import edu.villablanca.catalogo.pantallas.PantallaLista
import edu.villablanca.catalogo.pantallas.PantallaCodigoFuente


/**
 * Grafo de navegación
 */
@Composable
fun Navegacion(context: Context) {
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destino.PLista.ruta) {
        composable(Destino.PLista.ruta) { PantallaLista(navController) }
        composable("detail/{item}") { backStackEntry ->
            DetailScreen(
                backStackEntry.arguments?.getString("item") ?: "",
                navController = navController
            )
        }
        composable("info/{detailItem}") { backStackEntry ->
            PantallaCodigoFuente(
                context = context,
                navController = navController,
                detailItem = backStackEntry.arguments?.getString("detailItem") ?: ""
            )
        }

        // Pantallas de componentes
        composable(Destino.PCodigoFuente.ruta) { PantallaCodigoFuente(context,navController) }
        composable(Destino.PText.ruta) { DemoText() }
        composable(Destino.PButton.ruta) { DemoButton() }
    }
    Button(onClick = { navController.navigate("list") }) {
        Text(text = "<- Volver")
    }
    Button(onClick = { navController.navigate(Destino.PCodigoFuente.ruta ) }) {
        Text("Código fuente")
    }
}
