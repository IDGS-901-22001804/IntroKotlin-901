package com.negabytes.introkotlin_901.temasKotlin

fun main() {
    println("RESOLUCIÓN DE ECUACIÓN CUADRÁTICA POR FÓRMULA GENERAL")
    println("Forma general: ax² + bx + c = 0")
    println("Ingrese los coeficientes:")

    // Validar entrada de 'a'
    print("a = ")
    val a = readln().toDoubleOrNull() ?: run {
        println("Error: 'a' debe ser un número válido")
        return
    }

    if (a == 0.0) {
        println("Error: Si a=0 no es una ecuación cuadrática")
        return
    }

    // Validar entrada de 'b'
    print("b = ")
    val b = readln().toDoubleOrNull() ?: run {
        println("Error: 'b' debe ser un número válido")
        return
    }

    // Validar entrada de 'c'
    print("c = ")
    val c = readln().toDoubleOrNull() ?: run {
        println("Error: 'c' debe ser un número válido")
        return
    }

    // Calcular discriminante
    val discriminante = b * b - 4 * a * c
    println("\nProceso de solución:")
    println("1. Discriminante (Δ) = b² - 4ac = $b² - 4*$a*$c = $discriminante")

    when {
        discriminante > 0 -> {
            println("2. Como Δ > 0, existen dos soluciones reales diferentes")
            val x1 = (-b + Math.sqrt(discriminante)) / (2 * a)
            val x2 = (-b - Math.sqrt(discriminante)) / (2 * a)
            println("3. Aplicando fórmula general:")
            println("   x₁ = (-b + √Δ) / (2a) = (-$b + √$discriminante) / (2*$a) = ${"%.4f".format(x1)}")
            println("   x₂ = (-b - √Δ) / (2a) = (-$b - √$discriminante) / (2*$a) = ${"%.4f".format(x2)}")
            println("\nResultado final:")
            println("x₁ = ${"%.4f".format(x1)}")
            println("x₂ = ${"%.4f".format(x2)}")
        }
        discriminante == 0.0 -> {
            println("2. Como Δ = 0, existe una solución real única (raíz doble)")
            val x = -b / (2 * a)
            println("3. Aplicando fórmula general:")
            println("   x = -b / (2a) = -$b / (2*$a) = ${"%.4f".format(x)}")
            println("\nResultado final:")
            println("x = ${"%.4f".format(x)}")
        }
        else -> {
            println("2. Como Δ < 0, existen dos soluciones complejas conjugadas")
            val parteReal = -b / (2 * a)
            val parteImaginaria = Math.sqrt(-discriminante) / (2 * a)
            println("3. Aplicando fórmula general con números complejos:")
            println("   Parte real = -b/(2a) = -$b/(2*$a) = ${"%.4f".format(parteReal)}")
            println("   Parte imaginaria = √|Δ|/(2a) = √${-discriminante}/(2*$a) = ${"%.4f".format(parteImaginaria)}")
            println("\nResultado final:")
            println("x₁ = ${"%.4f".format(parteReal)} + ${"%.4f".format(parteImaginaria)}i")
            println("x₂ = ${"%.4f".format(parteReal)} - ${"%.4f".format(parteImaginaria)}i")
        }
    }
}