/*
Desarrolla un programa con las siguientes clases:

- Clase Cafetera con atributos ubicacion (nombre de la sala o habitación dónde se encuentra), capacidad (la cantidad máxima de café que puede contener la cafetera) y cantidad (la cantidad actual de café
que hay en la cafetera).

Implementa, al menos, lo siguiente:

    * En la clase se debe establecer la capacidad máxima en 1000 (c.c.) y la cantidad actual en cero (cafetera vacía).
    * Constructor primario con la ubicacion.
    * Constructor secundario con la ubicación y la capacidad máxima de la cafetera. Inicializa la cantidad actual de café igual a la capacidad máxima.
    * Constructor secundario con la ubicacion, la capacidad máxima y la cantidad actual. Si la cantidad actual es mayor que la capacidad máxima de la cafetera, la ajustará al máximo.
    * llenar(): hace que la cantidad actual sea igual a la capacidad.
    * servirTaza(Taza): simula la acción de servir una taza con la capacidad que tenga la taza. Si la cafetera tiene café, llenará la taza y restará la cantidad servida en la cantidad de la cafetera. Si la cantidad actual de café “no alcanza” para llenar la taza, se sirve lo que quede. Actualizar la cantidad de la cafetera y aplicar el método adecuado de la taza.
    * vaciar(): pone la cantidad de café actual en cero.
    * agregarCafe(Int): añade a la cafetera la cantidad de café indicada. Por defecto añade 200 c.c. No se puede añadir más cantidad que su capacidad máxima, si ocurriera esta circunstancia, simplemente llenaríamos la cantidad de la cafetera a su capacidad máxima.
    * toString(): debe retornar por ejemplo "Cafetera(ubicación = Salón, capacidad = 1000 c.c., cantidad = 0 c.c.)"

- Clase Taza, que tendrá los atributos color, capacidad y cantidad.

Implementa, al menos, lo siguiente:

    * Un único constructor con el color (por defecto blanco) y la capacidad (por defecto 50 c.c.). La clase también contendrá un atributo con la cantidad que se establcerá a 0.
    * La propiedad cantidad debe modificarse para que si el valor que recibe es mayor que la capacidad de la taza, solo establezca el valor de dicha capacidad.
    * El método llenar() que establecerá la cantidad de la taza a su máxima capacidad.
    * El método "sobrecargado" llenar(Int) que establecerá la cantidad de la taza a la cantidad pasada como argumento al método.
    * Sobreescribir el método toString(), que debe retornar por ejemplo "Taza(color = BLANCO, capacidad = 50 c.c., cantidad = 30 c.c.)"

- Clase enumerada Color, que contendrá los colores disponibles: blanco, negro, gris, azul y verde.

En el programa principal se deben crear 3 cafeteras de capacidad 1000, 750 y 500 c.c. con 0, 750 y 200 c.c de cantidad respectivamente.
Para crear cada cafetera, debéis utilizar un constructor diferente.
También debéis generar una lista de 20 tazas con la capacidad de 50, 75 y 100 de manear aleatoria.
Implementar el resto de comentarios TODO de la función main().

NOTA:
la sobrecarga de métodos se refiere a la capacidad de definir varios métodos en una clase con el mismo nombre pero con diferentes parámetros.
Esto permite que una clase tenga varios métodos con la misma firma (nombre de método) pero con listas de parámetros diferentes.

La sobrecarga de métodos facilita la legibilidad del código y proporciona flexibilidad al programador al permitirle utilizar el mismo nombre de
método para realizar operaciones similares pero con diferentes conjuntos de datos.

*/

class Cafetera(private val ubicacion: String){

    var capacidadMax: Int = 1000

    init {
        require(this.capacidadMax in 0..1000){"Error - La capacidad debe estar entre 0-1000"}
    }

    var cantidad: Int = 0

    // Constructor 2
    constructor(ubicacion: String, capacidadMax: Int ) : this(ubicacion){

        this.capacidadMax = capacidadMax
        this.cantidad = capacidadMax
    }

    // Contructor 3
    constructor(ubicacion: String, capacidadMax: Int, cantidad: Int) : this(ubicacion, capacidadMax){
        this.cantidad = cantidad
        if (cantidad > this.capacidadMax) this.cantidad = capacidadMax
    }

    fun llenar(){
        this.cantidad = this.capacidadMax
    }



    fun servirTaza(taza: Taza){
        if (cantidad > 0){
            if (taza.capacidad < cantidad){
                taza.llenar(taza.capacidad)
                cantidad -= (taza.capacidad)
            }
            else{
                taza.llenar(cantidad)
                cantidad -= taza.cantidad
            }
        }
    }

    /**
     * Establece la cantidad de la cafetera a 0
     */
    fun vaciar(){
        this.cantidad = 0
    }

    /**
     * Agrega la cantidad de cafe si es posible
     */
    fun agregarCafe(cantCafe: Int){
        if (this.cantidad <= (capacidadMax-cantCafe)){
            this.cantidad += cantCafe
        }
        else{
            this.cantidad = capacidadMax
        }

    }


    override fun toString(): String {
        return "Cafetera(ubicación = ${this.ubicacion}, capacidad = ${this.capacidadMax}, cantidad = ${this.cantidad})"
    }


}



class Taza(private var color: String = "Blanco", var capacidad: Int = 50){

    var cantidad: Int = 0
        set(value) {
            if (cantidad > this.capacidad) field = this.capacidad
            field = value
        }



    fun llenar(){
        cantidad = this.capacidad
    }

    fun llenar(cant:Int){
        cantidad = cant
    }


    override fun toString(): String{
        return "Taza(color = ${this.color}, capacidad = ${this.capacidad}, cantidad = ${this.cantidad}.)"
    }

}


// Clase enumerada Color, que contendrá los colores disponibles: blanco, negro, gris, azul y verde.

enum class Color(){
    BLANCO, NEGRO, GRIS, AZUL, VERDE
}




/**
 * En el programa principal se deben crear 3 cafeteras de capacidad 1000, 750 y 500 c.c. con 0, 750 y 200 c.c de cantidad respectivamente.
 * Para crear cada cafetera, debéis utilizar un constructor diferente.
 * También debéis generar una lista de 20 tazas con la capacidad de 50, 75 y 100 de manear aleatoria.
 * Implementar el resto de comentarios TODO de la función main().
 */

fun main() {

    //TODO: Crear 3 cafeteras en la Sala, Cocina y Oficina
    val cafetera1 = Cafetera("Sala", 1000)
    val cafetera2 = Cafetera("Cocina", 750, 750)
    val cafetera3 = Cafetera("Oficina", 500, 200)

    //TODO: Crear una lista de 20 tazas con capacidades aleatorias


    val tazas = listOf(
        Taza("azul", 75),
        Taza("verde", 25),
        Taza("blanco", 50),
        Taza("negro", 75),
        Taza("gris", 25),
        Taza("azul", 50),
        Taza("verde", 75),
        Taza("blanco", 25),
        Taza("negro", 50),
        Taza("gris", 75),
        Taza("azul", 25),
        Taza("verde", 75),
        Taza("blanco", 50),
        Taza("negro", 25),
        Taza("gris", 75),
        Taza("azul", 50),
        Taza("verde", 25),
        Taza("blanco", 75),
        Taza("negro", 50),
        Taza("gris", 25),
        Taza("azul", 25),
    )


    println("**********************************************")
    //TODO: Mostrar por pantalla el contenido de las 3 cafeteras y las tazas.

    println(cafetera1.toString())
    println(cafetera2.toString())
    println(cafetera3.toString())

    for (taza in tazas){
        println(taza.toString())
    }

    println("**********************************************")
    println("Llenar la cafetera1 de café...")
    println("Vaciar la cafetera2...")
    println("Agregar café a la cafetera2 a la mitad de su capacidad...")
    println("Agregar 400 c.c. de café a la cafereta3...")

    //TODO: Llenar la cafetera1 de café.
    cafetera1.llenar()

    //TODO: Vaciar la cafetera2.
    cafetera2.vaciar()

    //TODO: Agregar café a la cafetera2 a la mitad de su capacidad.
    cafetera2.agregarCafe((cafetera2.capacidadMax / 2))

    //TODO: Agregar 400 c.c. de café a la cafereta3
    cafetera3.agregarCafe(400)

    println("**********************************************")
    //TODO: Mostrar por pantalla el contenido de las 3 cafeteras
    println(cafetera1.toString())
    println(cafetera2.toString())
    println(cafetera3.toString())

    println("**********************************************")
    println("Servir café en las tazas...")

    //TODO: Servir café en las tazas... siempre que haya café en la cafetera y en el orden cafetera1, cafetera2 y cafetera3.
    for (taza in tazas){
        if (cafetera1.cantidad > 0) cafetera1.servirTaza(taza)
        else if (cafetera2.cantidad > 0) cafetera2.servirTaza(taza)
        else if (cafetera3.cantidad > 0) cafetera3.servirTaza(taza)

    }

    println("**********************************************")
    println("**********************************************")
    println("**********************************************")

    //TODO: Mostrar por pantalla el contenido de las 3 cafeteras y las tazas.

    println(cafetera1.toString())
    println(cafetera2.toString())
    println(cafetera3.toString())

    for (taza in tazas){
        println(taza.toString())
    }



}