package exemples

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException
import java.util.*

fun delete(){
    val url = "jdbc:sqlite:identifier.sqlite"
    val con : Connection

    try {
        con = DriverManager.getConnection(url)

        println("Borra una fila segun su id")
        println("Introduce el id:")
        val idMenu = Scanner(System.`in`).nextLine()

        val deleteSQL = "DELETE FROM USUARIO WHERE ID = ?"

        val preparedStatement: PreparedStatement = con.prepareStatement(deleteSQL)
        preparedStatement.setString(1, idMenu)
        preparedStatement.executeUpdate()

        selectAll()
        preparedStatement.close()
        con.close()
    } catch (e: SQLException) {
        println("Aun no existe la tabla")
        showMenu()
    }
}