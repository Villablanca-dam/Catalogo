package edu.villablanca.catalogo

/**
 *  Ejemplode app con un catalogo de componentes de compose
 */
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import edu.villablanca.catalogo.pantallas.PantallaPrincipal
import edu.villablanca.catalogo.ui.theme.CatalogoTheme

/*
    Lista de funciones composable de ejemplo
    Todas en el paquete edu.villablanca.catalogo.componentes

    El fichero y la función se llaman igual con prefijo "Demo".
    Ejemplo: Text -> DemoText.kt y funcion DemoText()
 */





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
                    PantallaPrincipal(this)
                }
            }
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


