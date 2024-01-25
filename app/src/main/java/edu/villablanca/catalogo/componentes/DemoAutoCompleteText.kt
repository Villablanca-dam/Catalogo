package edu.villablanca.catalogo.componentes

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

/**
 * En Jetpack Compose, el equivalente de AutoCompleteTextView de las vistas tradicionales de Android se puede crear utilizando una combinación de
 * TextField (o OutlinedTextField) para la entrada de texto y DropdownMenu para mostrar las sugerencias. Esta combinación te permite construir una
 * funcionalidad similar a la de AutoCompleteTextView.
 *
 *  cómo podrías implementarlo:
 *
 * TextField/OutlinedTextField: Para la entrada de texto. Aquí es donde el usuario escribirá su entrada.
 *
 * DropdownMenu: Para mostrar una lista de opciones o sugerencias que cambian basándose en la entrada del usuario.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun DemoAutoCompleteText(){

}