package com.example.practica1.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    var resultState by mutableStateOf("")
        private set
    var countTime1 by mutableIntStateOf(0)
        private set

    var countTime2 by mutableIntStateOf(0)
        private set

    var terminaContador = false
    private var job1: Job? = null
    private var job2: Job? = null
    fun fetchData(){

        val job1 = viewModelScope.launch{
            for (i in 1..10){
                countTime1 = i
                delay(1000)
            }
        }

        val job2 = viewModelScope.launch {

            job1.join() // espera a que termine el primer contador

            for (j in 0..10){
                countTime2 = j
                delay(1000)
            }
        }

        viewModelScope.launch{
            delay(5000)
            resultState = "Respuesta obtenida de la Web"
        }
    }

    fun cancelarContadores(){

        viewModelScope.coroutineContext.cancelChildren()

    }

    /* Proceso Síncrono
    fun bloqueoApp(){
        Thread.sleep(5000)
        resultState = "Respuesta obtenida de la Web"
    }
*/

}