package exemples

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.*

fun insert(){
    val url = "jdbc:sqlite:identifier.sqlite"
    val con: Connection

    try {
        con = DriverManager.getConnection(url)

        println("Añade una nueva fila")
        println("Introduce el nombre:")
        val nombre = Scanner(System.`in`).nextLine()
        println("Introduce el usuario:")
        val user = Scanner(System.`in`).nextLine()
        println("Introduce la contraseña:")
        val pass = Scanner(System.`in`).nextLine()
        println("Introduce el teléfono:")
        val tlf = Scanner(System.`in`).nextInt()
        println("Introduce el email:")
        val email = Scanner(System.`in`).nextLine()

        val insertSQL = "INSERT OR REPLACE INTO USUARIO (Nombre, Usuari, Password, Telefono, Email) " +
                "VALUES (?, ?, ?, ?, ?)"

        val preparedStatement: PreparedStatement = con.prepareStatement(insertSQL)
        preparedStatement.setString(1, nombre)
        preparedStatement.setString(2, user)
        preparedStatement.setString(3, pass)
        preparedStatement.setInt(4, tlf)
        preparedStatement.setString(5, email)
        preparedStatement.executeUpdate()

        selectAll()

        preparedStatement.close()
        con.close()
    } catch (e: SQLException) {
        println("Aun no existe la tabla")
        showMenu()
    }
}