package edu.villablanca.catalogo.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SliderNormal() {
    var sliderPosition by remember { mutableStateOf(0f) }

    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { newValue ->
                sliderPosition = newValue
            },
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Blue
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Value: $sliderPosition", modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun SliderValores() {
    var sliderPosition by remember { mutableStateOf(50f) }

    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { newValue ->
                sliderPosition = newValue
            },
            valueRange = 0f..100f,
            steps = 1,
            colors = SliderDefaults.colors(
                thumbColor = Color.Green,
                activeTrackColor = Color.Yellow
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Value: $sliderPosition", modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun SliderConTexto() {
    var sliderPosition by remember { mutableStateOf(0f) }

    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { newValue ->
                sliderPosition = newValue
            },
            valueRange = 0f..100f,
            steps = 1,
            colors = SliderDefaults.colors(
                thumbColor = Color.Magenta,
                activeTrackColor = Color.Cyan
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Value: $sliderPosition", modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun SliderVertical() {
    var sliderPosition by remember { mutableStateOf(0f) }

    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { newValue ->
                sliderPosition = newValue
            },
            valueRange = 0f..100f,
            steps = 1,
            colors = SliderDefaults.colors(
                thumbColor = Color.Gray,
                activeTrackColor = Color.Black
            ),
            modifier = Modifier.fillMaxHeight()
        )
        Text(text = "Value: $sliderPosition", modifier = Modifier.padding(8.dp))
    }
}


@Preview
@Composable
fun DemoSlider(){
//list composables
    Column(
        modifier = Modifier.padding(16.dp),

    ) {
        SliderNormal()
        SliderValores()
        SliderConTexto()
        SliderVertical()
    }
}