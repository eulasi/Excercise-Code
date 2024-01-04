//TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.


// create a Student data class with the following arguments
data class Student(val fullName: String, var id: Int, var grade: Double )

// Create a list with the following values. This list is called student
val students = listOf<Student>(
    Student("John", 223, 140.0),
    Student("Mark", 548, 120.0),
    Student("Natali", 342, 150.0),
    Student("Sara", 718, 130.0),
)
// return the student from the student list and if not found, the program should return NPE
fun getStudentById(id: Int):Student {
    //  use the find method inside the function and if any student ID matches the ID entered by the user, you should return that student. If not, you should display an error as a Null pointer exception by using the null assertion operator
    return students.find { it.id == id }!!
}

// create a function with one string argument and return a nullable Student.
fun searchInStudents(name:String):Student?{
    // search in the students list for name by using a find function and if the name matches with any of the stored student names, the find will return that student instance
    return students.find { it.fullName.lowercase() == name.lowercase()}
}


// take a user input from the standard input stream which is the terminal.Use the readln()function which reads a line from the terminal and returns it as a String.
fun main() {
println("Please, Enter the ID of the Student")
    val id: Int = readln().toInt()
    println(getStudentById(id))
    println("Please, Enter the student's name")
    val name = readln()
    println(searchInStudents(name)?:"The student is not found")
}