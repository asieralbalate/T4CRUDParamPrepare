package exemples

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException

fun deleteAll(){
    val url = "jdbc:sqlite:identifier.sqlite"
    val con: Connection

    try {
        con = DriverManager.getConnection(url)

        val deleteSQL = "DELETE FROM USUARIO"

        val preparedStatement: PreparedStatement = con.prepareStatement(deleteSQL)
        preparedStatement.executeUpdate()

        preparedStatement.close()
        con.close()
    } catch (e: SQLException) {
        println("Aun no existe la tabla")
        showMenu()
    }
}