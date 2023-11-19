package edu.villablanca.catalogo

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.villablanca.catalogo.componentes.DemoButton
import edu.villablanca.catalogo.ui.theme.CatalogoTheme
import java.io.IOException

/*
    Lista de funciones composable de ejemplo
    Todas en el paquete edu.villablanca.catalogo.componentes

    El fichero y la función se llaman igual con prefijo "Demo".
    Ejemplo: Text -> DemoText.kt y funcion DemoText()
 */
internal  val uiComponentes = listOf("Text", "Button", "TextField")



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
                    VentanaPrincipal(this)
                }
            }
        }
    }
}

@Composable
fun PantallaLista(navController: NavController) {


    LazyColumn {
        items(uiComponentes){ item ->
            Text(text = item,
            modifier = Modifier.clickable {
                navController.navigate("detail/$item")
            })
        }


    }
}

@Composable
fun Item1(){
    Text(text = "Esto es ventana item 1")
}
@Composable
fun Item2(){
    Text(text = "Esto es ventana item 2")
}
@Composable
fun DetailScreen(item: String,navController: NavController) {


    Column {
        when(item){
            "Text" -> Item1()
            "Button" -> DemoButton()
            "TextField" -> Item2()
            else -> println("Error funcion no preparada")
        }

        Text(text = "Detalles de $item")
        Button(onClick = {  navController.navigate("list")}) {
            Text(text = "<- Volver")
        }
        Button(onClick = { navController.navigate("info/$item") }) {
            Text("Código fuente")
        }
    }
  
}


@Composable
fun CodigoFuente(context: Context, navController: NavController, detailItem: String) {
    var textToShow by remember { mutableStateOf("") }

    fun loadFileContent(context: Context, fileName: String): String {
        return try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            "Error al cargar el archivo : $fileName"
        }
    }

    textToShow = loadFileContent(context, "Demo${detailItem}.kt")

    Column {
        Button(onClick = { navController.popBackStack() }) {
            Text("Volver")
        }
        Box(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)) {
            Text(text = textToShow.split("\n") // Divide el texto en líneas
                .filterNot { line -> line.startsWith("import") } // Elimina las líneas que empiezan con "import"
                .joinToString("\n")
            )
        }

    }
}
@Composable
fun VentanaPrincipal(context: Context, modifier: Modifier = Modifier ) {

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
                    context = context,
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
       // VentanaPrincipal()
    }
}