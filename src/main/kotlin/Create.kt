package exemples

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement

fun create(){
    val url = "jdbc:sqlite:identifier.sqlite"
    val con: Connection

    try {
        con = DriverManager.getConnection(url)

        val createTableSQL = "CREATE TABLE if not exists USUARIO " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Nombre varchar(15)," +
                "Usuari varchar(15)," +
                "Password varchar(10)," +
                "Telefono numeric," +
                "Email varchar(50) UNIQUE)"

        val preparedStatement: PreparedStatement = con.prepareStatement(createTableSQL)
        preparedStatement.executeUpdate()

        preparedStatement.close()
        con.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}