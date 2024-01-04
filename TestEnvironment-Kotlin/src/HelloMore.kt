import java.util.*

fun randomDay(): String {
    val week = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    return week[Random().nextInt(week.size)]
}

fun fishFood(day: String): String {
    return when (day) {
        "Mon" -> "flakes"
        "Tue" -> "pellets"
        "Wed" -> "redworms"
        "Thu" -> "granules"
        "Fri" -> "mosquitoes"
        "Sat" -> "lettuce"
        "Sun" -> "plankton"
        else -> "nothing"
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun main(args: Array<String>) {
    feedTheFish()
    swim(speed = "turtle-like")
}

fun swim(speed: String = "fast") {
    println("Swimming $speed")
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty:Int) = dirty > 30
fun isSunday(day: String) = day == "Sun"
