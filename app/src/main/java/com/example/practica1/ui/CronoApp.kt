package com.example.practica1.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun CronoApp(mainViewModel: MainViewModel, modifier: Modifier = Modifier){

    var changeColor by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {changeColor = !changeColor},
            colors = ButtonDefaults.buttonColors(
                if(changeColor) Color.Blue else Color.Red
            )
        ) {
            Text(text = "Cambiar Color")
        }
        Spacer(modifier = modifier.height(5.dp))
        Text(text = "${mainViewModel.countTime1} [s]")
        Text(text = "${mainViewModel.countTime2} [s]")
        Spacer(modifier = modifier.height(5.dp))
        Text(text = mainViewModel.resultState)
        Spacer(modifier = modifier.height(5.dp))
        Button(onClick = {mainViewModel.fetchData()}) {
            Text(text = "Cronómetro 1")
        }
        Button(onClick = {mainViewModel.cancelarContadores()}) {
            Text(text = "Cronómetro 1")
        }
    }
}