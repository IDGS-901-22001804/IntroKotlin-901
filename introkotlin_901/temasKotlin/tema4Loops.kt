package com.negabytes.introkotlin_901.temasKotlin

//For
fun main() {
    // Bucle for con un rango del 1 al 5
    for (number in 1..5) {
        print("$number ")
    }
    println()

    val nombres = listOf("Xime", "Menix", "Llanetronix", "Jejeje")

    // Bucle for para recorrer la lista de nombres
    for (nombre in nombres) {
        println(nombre)
    }

    // While y do-while
    var x = 0
    while (x < 5) {
        println(x)
        x++
    }

    do {
        println(x)
        x++
    } while (x < 10) // Corrección para evitar que se imprima solo una vez
}
