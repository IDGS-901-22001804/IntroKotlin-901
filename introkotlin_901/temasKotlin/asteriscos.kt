package com.negabytes.introkotlin_901.temasKotlin

// Programa que dibuja una pirámide de asteriscos hasta que el usuario ingrese 0
fun main() {
    iniciarProgramaPiramide()
}

fun iniciarProgramaPiramide() {
    var inputUsuario: Int

    do {
        println("\n¿Cuántos niveles tendrá la pirámide? (0 para salir):")
        inputUsuario = obtenerEntradaNumerica()

        when {
            inputUsuario < 0 -> mostrarMensajeError()
            inputUsuario > 0 -> {
                println("\nPirámide de $inputUsuario nivel(s):")
                construirPiramide(inputUsuario)
            }
        }
    } while (inputUsuario != 0)

    println("\n¡Programa finalizado!")
}

fun obtenerEntradaNumerica(): Int {
    while (true) {
        try {
            return readln().toInt()
        } catch (e: NumberFormatException) {
            println("Error: Debes ingresar un número entero. Intenta nuevamente:")
        }
    }
}

fun construirPiramide(niveles: Int) {
    for (i in 1..niveles) {
        repeat(i) { print("*") }  // Ahora usando asteriscos como solicitaste
        println()
    }
}

fun mostrarMensajeError() {
    println("Error: El número debe ser positivo. Intenta con otro valor.")
}