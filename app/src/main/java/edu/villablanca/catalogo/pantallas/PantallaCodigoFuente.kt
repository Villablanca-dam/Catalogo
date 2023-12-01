package edu.villablanca.catalogo.pantallas

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.io.IOException

/**
 * Pantalla para mostar el código fuente de los ejemplos.
 * Para mejorar la lectura eliminamos los import
 *
 * @param navController
 * @param detailItem Código fuente
 */
@Composable
fun PantallaCodigoFuente(context: Context, navController: NavController, detailItem: String="") {
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
        Box(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(text = textToShow.split("\n") // Divide el texto en líneas
                .filterNot { line -> line.startsWith("import") } // Elimina las líneas que empiezan con "import"
                .joinToString("\n")
            )
        }

    }
}