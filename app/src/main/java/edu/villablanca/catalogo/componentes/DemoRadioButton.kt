package edu.villablanca.catalogo.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun DemoRadioButton(){
    // Lista de tipos de estudio
    val studyTypes = listOf("FP Grado Superior", "FP Grado Medio", "Bachillerato", "Universidad")

    // Estado para almacenar la opción seleccionada
    var selectedStudyType by remember { mutableStateOf("") }

    // RadioGroup en Compose
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        studyTypes.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RadioButton(
                    selected = option == selectedStudyType,
                    onClick = { selectedStudyType = option },
                    colors = RadioButtonDefaults.colors(MaterialTheme.colorScheme.primary)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option, modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewBotones(){
    DemoRadioButton()
}