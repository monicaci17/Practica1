package com.example.practica1.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica1.R
import com.example.practica1.ui.theme.Practica1Theme
import com.example.practica1.viewmodel.MainViewModel


@Composable
fun CronoApp(mainViewModel: MainViewModel, modifier: Modifier = Modifier) {

    var changeColor by remember { mutableStateOf(false) }

    // ✅ Estado para la opción seleccionada (0 = ninguna, 1-4 = seleccionada)
    var selectedOption by remember { mutableStateOf(0) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("¿Cuál es tu color favorito?")
        // --- CUATRO RADIOBUTTON ---
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedOption == 1,
                onClick = { selectedOption = 1 }
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text("Verde")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedOption == 2,
                onClick = { selectedOption = 2 }
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text("Azul")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedOption == 3,
                onClick = { selectedOption = 3 }
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text("Rojo")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedOption == 4,
                onClick = { selectedOption = 4 }
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text("Amarillo")
        }

        Spacer(modifier = Modifier.height(16.dp)) // Separación antes del primer botón

        // --- BOTÓN CAMBIAR COLOR ---
        Button(
            onClick = { changeColor = !changeColor },
            colors = ButtonDefaults.buttonColors(
                when (selectedOption) {
                    1 -> Color.Green
                    2 -> Color.Blue
                    3 -> Color.Red
                    4 -> Color.Yellow
                    else -> Color.Gray // color por defecto si no hay opción seleccionada
                }
            )
        ) {
            Text(text = "Cambiar Color")
        }

        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "${mainViewModel.countTime1} [s]")
        Text(text = "${mainViewModel.countTime2} [s]")
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = mainViewModel.resultState)
        Spacer(modifier = Modifier.height(5.dp))

        // --- BOTONES DE CRONÓMETRO ---
        Button(onClick = { mainViewModel.fetchData() }) {
            Text(text = "Cronómetro 1")
        }
        Button(onClick = { mainViewModel.cancelarContadores() }) {
            Text(text = "Cancelar")
        }

        Spacer(modifier = Modifier.height(10.dp))

        // --- MOSTRAR OPCIÓN SELECCIONADA ---
        if (selectedOption != 0) {
            Text(text = "Opción seleccionada: $selectedOption")
        }
    }
}