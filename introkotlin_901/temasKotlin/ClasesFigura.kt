import kotlin.math.PI
import kotlin.math.tan

abstract class Figura(val nombre: String) {
    abstract fun calcularArea(): Double
    abstract fun solicitarDatos()
    fun mostrarArea() {
        println("El área del $nombre es: ${"%.2f".format(calcularArea())}")
    }
}

class Circulo : Figura("Círculo") {
    private var radio: Double = 0.0

    override fun solicitarDatos() {
        print("Introduce el radio del círculo: ")
        radio = readln().toDoubleOrNull() ?: 0.0
        while (radio <= 0) {
            println("Error: El radio debe ser un número positivo.")
            print("Introduce el radio del círculo: ")
            radio = readln().toDoubleOrNull() ?: 0.0
        }
    }

    override fun calcularArea(): Double {
        return PI * radio * radio
    }
}

class Cuadrado : Figura("Cuadrado") {
    private var lado: Double = 0.0

    override fun solicitarDatos() {
        print("Introduce el lado del cuadrado: ")
        lado = readln().toDoubleOrNull() ?: 0.0
        while (lado <= 0) {
            println("Error: El lado debe ser un número positivo.")
            print("Introduce el lado del cuadrado: ")
            lado = readln().toDoubleOrNull() ?: 0.0
        }
    }

    override fun calcularArea(): Double {
        return lado * lado
    }
}

class TrianguloRectangulo : Figura("Triángulo Rectángulo") {
    private var base: Double = 0.0
    private var altura: Double = 0.0

    override fun solicitarDatos() {
        print("Introduce la base del triángulo: ")
        base = readln().toDoubleOrNull() ?: 0.0
        while (base <= 0) {
            println("Error: La base debe ser un número positivo.")
            print("Introduce la base del triángulo: ")
            base = readln().toDoubleOrNull() ?: 0.0
        }

        print("Introduce la altura del triángulo: ")
        altura = readln().toDoubleOrNull() ?: 0.0
        while (altura <= 0) {
            println("Error: La altura debe ser un número positivo.")
            print("Introduce la altura del triángulo: ")
            altura = readln().toDoubleOrNull() ?: 0.0
        }
    }

    override fun calcularArea(): Double {
        return (base * altura) / 2
    }
}

class Pentagono : Figura("Pentágono") {
    private var lado: Double = 0.0
    private var apotema: Double = 0.0

    override fun solicitarDatos() {
        print("Introduce la longitud del lado del pentágono: ")
        lado = readln().toDoubleOrNull() ?: 0.0
        while (lado <= 0) {
            println("Error: El lado debe ser un número positivo.")
            print("Introduce la longitud del lado del pentágono: ")
            lado = readln().toDoubleOrNull() ?: 0.0
        }

        print("Introduce la apotema del pentágono (o escribe 0 para calcularla): ")
        apotema = readln().toDoubleOrNull() ?: 0.0

        if (apotema <= 0) {
            // Calcular apotema automáticamente si no se proporciona
            apotema = lado / (2 * tan(PI / 5))
            println("Apotema calculada: ${"%.2f".format(apotema)}")
        }
    }

    override fun calcularArea(): Double {
        return (5 * lado * apotema) / 2
    }
}

class CalculadoraAreas {
    private val figuras = mapOf(
        1 to Circulo(),
        2 to Cuadrado(),
        3 to TrianguloRectangulo(),
        4 to Pentagono()
    )

    fun mostrarMenu() {
        var continuar = true

        while (continuar) {
            println("\nMenú de cálculo de áreas:")
            println("1 -> Círculo")
            println("2 -> Cuadrado")
            println("3 -> Triángulo Rectángulo")
            println("4 -> Pentágono")
            println("5 -> Salir")

            print("Elige una opción: ")
            val seleccion = readln().toIntOrNull()

            when (seleccion) {
                in 1..4 -> {
                    val figura = figuras[seleccion]!!
                    figura.solicitarDatos()
                    figura.mostrarArea()
                }
                5 -> {
                    println("Finalizando el programa...")
                    continuar = false
                }
                else -> println("Opción inválida, intenta nuevamente.")
            }
        }
    }
}

fun main() {
    val calculadora = CalculadoraAreas()
    calculadora.mostrarMenu()
}