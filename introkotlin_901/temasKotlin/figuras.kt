package com.negabytes.introkotlin_901.temasKotlin

fun main() {
    var continuar = true

    while (continuar) {
        println("\nMenú de cálculo de áreas:")
        println("1 -> Círculo")
        println("2 -> Cuadrado")
        println("3 -> Triángulo")
        println("4 -> Pentágono")
        println("5 -> Salir")

        print("Elige una opción: ")
        val seleccion = readln().toIntOrNull()

        when (seleccion) {
            1 -> areaCirculo()
            2 -> areaCuadrado()
            3 -> areaTriangulo()
            4 -> areaPentagono()
            5 -> {
                println("Finalizando el programa...")
                continuar = false
            }
            else -> println("Opción inválida, intenta nuevamente.")
        }
    }
}

fun areaCirculo() {
    println("\nÁrea de un Círculo")
    print("Introduce el radio: ")
    val radio = readln().toDoubleOrNull()

    if (radio != null && radio > 0) {
        println("Resultado: ${"%.2f".format(3.1416 * radio * radio)}")
    } else {
        println("Error: Entrada no válida.")
    }
}

fun areaCuadrado() {
    println("\nÁrea de un Cuadrado")
    print("Introduce el lado: ")
    val lado = readln().toDoubleOrNull()

    if (lado != null && lado > 0) {
        println("Resultado: ${"%.2f".format(lado * lado)}")
    } else {
        println("Error: Entrada no válida.")
    }
}

fun areaTriangulo() {
    println("\nÁrea de un Triángulo")
    print("Introduce la base: ")
    val base = readln().toDoubleOrNull()
    print("Introduce la altura: ")
    val altura = readln().toDoubleOrNull()

    if (base != null && altura != null && base > 0 && altura > 0) {
        println("Resultado: ${"%.2f".format((base * altura) / 2)}")
    } else {
        println("Error: Entrada no válida.")
    }
}

fun areaPentagono() {
    println("\nÁrea de un Pentágono")
    print("Introduce la longitud del lado: ")
    val lado = readln().toDoubleOrNull()
    print("Introduce la apotema: ")
    val apotema = readln().toDoubleOrNull()

    if (lado != null && apotema != null && lado > 0 && apotema > 0) {
        println("Resultado: ${"%.2f".format((5 * lado * apotema) / 2)}")
    } else {
        println("Error: Entrada no válida.")
    }
}
