import kotlinx.coroutines.*
import kotlin.math.PI

fun main() {
    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 10.0)
    
    with(squareCabin){
            println("\nSquare Cabin\n============")
            println("Capacity: ${capacity}")
            println("Material: ${buildingMaterial}")
            println("Has room? ${hasRoom()}")
            println("Floor area: %.2f".format(floorArea()))
            getRoom()
    }
    
    with(roundHut){
            println("\nRound Cabin\n============")
            println("Capacity: ${capacity}")
            println("Material: ${buildingMaterial}")
            println("Has room? ${hasRoom()}")
            println("Floor Area? ${floorArea()}")
            getRoom()
    }
    
        with(roundTower){
            println("\nRound Tower\n============")
            println("Capacity: ${capacity}")
            println("Material: ${buildingMaterial}")
            println("Has room? ${hasRoom()}")
            println("Floor Area? ${floorArea()}")
            getRoom()
    }
}

class RoundTower(residents: Int,
                 radius: Double,
                 val floors: Int = 2): RoundHut(residents, radius){
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
    
    override fun floorArea(): Double{
        return PI * radius * radius * floors
    }
}

open class RoundHut(val residents: Int,val radius: Double): Dwelling(residents){
    override val buildingMaterial = "Straw"
    override val capacity = 4
    
    override fun floorArea(): Double{
        return PI * radius * radius
    }
}

class SquareCabin(residents: Int, val length: Double): Dwelling(residents){
    override val buildingMaterial = "Wood"
    override val capacity = 6
    
    override fun floorArea(): Double{
        return length * length
    }
    
}

abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int
    
    fun hasRoom():Boolean {
        return residents < capacity
    }
    
    fun getRoom() {
        if (residents < capacity) {
            residents++
            println("You got a room")
        } else {
            println("Sorry, at capacity and no rooms left.")
        }
    }
    
    abstract fun floorArea():Double
}