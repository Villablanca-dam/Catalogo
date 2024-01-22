package edu.villablanca.catalogo.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DemoMenus(){
    var expandido by remember { mutableStateOf(false) }
    val opciones = listOf("op1", "Op2", "Op3", "Op4")
    var textoSelecionado by remember { mutableStateOf("") }
    var tamanioTexto by remember { mutableStateOf(Size.Zero) }

    val icono = if (expandido)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = textoSelecionado,
            onValueChange = { textoSelecionado = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    tamanioTexto = coordinates.size.toSize()
                },
            label = { Text("Opciones") },
            trailingIcon = {
                Icon(icono, "contentDescription",
                    Modifier.clickable { expandido = !expandido })
            }
        )
        DropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { tamanioTexto.width.toDp() })
        ) {
            opciones.forEach { label ->
                DropdownMenuItem(
                    text = {
                        Text(text = label)
                } ,onClick = {
                        textoSelecionado = label
                    expandido = false
                })
            }
        }
    }
}
