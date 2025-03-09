import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit

fun sumarNumeros() {
    try {
        print("Ingrese el primer número: ")
        val num1 = readLine()!!.toDouble()
        print("Ingrese el segundo número: ")
        val num2 = readLine()!!.toDouble()
        print("Ingrese el tercer número: ")
        val num3 = readLine()!!.toDouble()
        val suma = num1 + num2 + num3
        println("La suma de los números ingresados es: $suma")
    } catch (e: NumberFormatException) {
        println("Por favor, ingrese valores numéricos válidos.")
    }
}

fun ingresarNombre() {
    print("Ingrese su nombre completo: ")
    val nombre = readLine()!!
    println("Nombre registrado: $nombre")
}

fun calcularTiempoVida() {
    try {
        print("Ingrese su fecha de nacimiento (YYYY-MM-DD): ")
        val fechaNacimiento = LocalDate.parse(readLine()!!)
        val fechaActual = LocalDate.now()
        val periodo = Period.between(fechaNacimiento, fechaActual)
        val dias = ChronoUnit.DAYS.between(fechaNacimiento, fechaActual)
        val semanas = dias / 7
        val meses = periodo.years * 12 + periodo.months
        val horas = dias * 24
        val minutos = horas * 60
        val segundos = minutos * 60

        println("Has vivido aproximadamente:")
        println("$meses meses")
        println("$semanas semanas")
        println("$dias días")
        println("$horas horas")
        println("$minutos minutos")
        println("$segundos segundos")
    } catch (e: Exception) {
        println("Formato de fecha incorrecto. Intente nuevamente con YYYY-MM-DD.")
    }
}

fun salir() {
    println("Saliendo del programa...")
    System.exit(0)
}

fun menu() {
    while (true) {
        println("\nMenú de opciones:")
        println("1. Sumar tres números")
        println("2. Ingresar nombre completo")
        println("3. Calcular tiempo de vida")
        println("4. Salir")

        print("Seleccione una opción: ")
        when (readLine()) {
            "1" -> sumarNumeros()
            "2" -> ingresarNombre()
            "3" -> calcularTiempoVida()
            "4" -> salir()
            else -> println("Opción no válida, intente nuevamente.")
        }
    }
}

fun main() {
    menu()
}
