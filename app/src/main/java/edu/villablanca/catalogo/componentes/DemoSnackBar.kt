package edu.villablanca.catalogo.componentes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
fun DemoSnackBar(){
    val estado = remember { SnackbarHostState() }
    var texto by remember { mutableStateOf("") }

    val listaNombres = arrayOf("Miguel","Antonio ","Mario")
    val estado2 = remember { mutableStateOf(listaNombres[0]) }
    val expansion = remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    Scaffold (modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(
                hostState = estado
            )
        }){
        Column (horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp, 0.dp))
        {

            menu(listaNombres,estado2,expansion)

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                scope.launch {
                    estado.showSnackbar(
                        message = "Hola ${estado2.value}!"
                    )
                }
            }) {
                Text(text = "Saluda")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun menu(
    listaNombres: Array<String>,
    estado: MutableState<String>,
    expansion: MutableState<Boolean>
) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(32.dp)){
        ExposedDropdownMenuBox(expanded = expansion.value,
            onExpandedChange = {expansion.value = !expansion.value}) {

            TextField(value = estado.value,
                label = { Text(text = "Elije el nombre") },
                onValueChange = {},
                readOnly = true,
                singleLine = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expansion.value)},
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor())

            ExposedDropdownMenu(expanded = expansion.value,
                onDismissRequest = { expansion.value = false }) {
                listaNombres.forEach {
                    DropdownMenuItem(text = { Text(text = it) },
                        onClick = { estado.value = it
                            expansion.value = false})
                }
            }


        }
    }

}