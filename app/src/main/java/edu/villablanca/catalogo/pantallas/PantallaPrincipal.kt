package edu.villablanca.catalogo.pantallas

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.villablanca.catalogo.componentes.DemoButton
import edu.villablanca.catalogo.componentes.DemoCheckBox
import edu.villablanca.catalogo.componentes.DemoSwitch
import edu.villablanca.catalogo.componentes.DemoText
import edu.villablanca.catalogo.componentes.DemoSwitch
import edu.villablanca.catalogo.comun.AppBarViewModel
import edu.villablanca.catalogo.navegacion.Destino




 data class  DemoComponente(
    val ruta: String,
    val funcion: @Composable () -> Unit,
     val fuente: String

)

internal val losComponentes = listOf<DemoComponente>(
    DemoComponente("Texto", { DemoText() }, "DemoText.kt"),
    DemoComponente("Boton", { DemoButton()}, "DemoButton.kt"),
    DemoComponente("CheckBox", { DemoCheckBox()}, "DemoCheckBox.kt"),
    DemoComponente("Switch", { DemoSwitch() }, "DemoSwitch.kt"),
)
/**
 * Pantalla principal
 */

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PantallaPrincipal(context: Context, modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    val appBarViewModel: AppBarViewModel = viewModel()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MiTopAppBar(appBarViewModel = appBarViewModel, navController = navController) }
    ) { paddingValues ->
        NavHost(navController = navController,
            startDestination = Destino.PLista.ruta,
            modifier= Modifier.padding(paddingValues)
            ) {
            composable(Destino.PLista.ruta) { PantallaLista(losComponentes, navController = navController) }
            composable(Destino.PCodigoFuente.ruta)   {
              //  appBarViewModel.actualizarCodigoFuente("DemoText.kt")
                PantallaCodigoFuente(appBarViewModel,navController)}

            losComponentes.forEach { comp ->

                composable(comp.ruta) {
                    appBarViewModel.actualizarTitulo(comp.ruta)
                    appBarViewModel.actualizarCodigoFuente(comp.fuente)
                    comp.funcion.invoke() }
        }


        }
    } // de scaffikd
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiTopAppBar(appBarViewModel: AppBarViewModel, navController: NavController) {
    val titulo = appBarViewModel.titulo.collectAsState()

    TopAppBar(
        title = { Text(text = titulo.value ) },
        navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Atrás")
                }
        } , //
        actions ={
            IconButton(onClick = { navController.navigate(Destino.PCodigoFuente.ruta) }) {
                Icon(Icons.Filled.List , contentDescription = "Código")
            }
        }


    )
}