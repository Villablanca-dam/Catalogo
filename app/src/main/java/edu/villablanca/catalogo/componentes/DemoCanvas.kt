package edu.villablanca.catalogo.componentes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.villablanca.catalogo.R


@Composable
@Preview
fun DemoCanvas(){
    val kotlinImagen = ImageBitmap.imageResource(id = R.drawable.kotlin)
    var rotation by remember { mutableFloatStateOf(0f) }


    Column(Modifier.fillMaxSize(),
        ) {
        Canvas(modifier = Modifier.fillMaxWidth().height(500.dp), onDraw = {
            drawCircle(Color(color = 0x7F26AB2A), radius = 1000f, center)
            rotate(rotation) {
                drawImage(
                    kotlinImagen,
                    topLeft = Offset(size.width / 4f, size.height / 2.5f),
                )
            }
        })
        Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly,){
            Button(onClick = { rotation += 10 }) {
                Text(text = "+10")
            }
            Button(onClick = { rotation -= 10 }) {
                Text(text = "-10")
            }
        }


    }
}