package exemples

import java.sql.*
import java.util.*

fun select() {
    val url = "jdbc:sqlite:identifier.sqlite"
    val con: Connection

    try {
        con = DriverManager.getConnection(url)
        val st = con.createStatement()

        println("Introduce los campos a filtrar separados por comas si quieres ver todo introduce *")
        val input = Scanner(System.`in`).nextLine()

        val sentenciaSQL: String
        if (input == "*") {
            sentenciaSQL = "SELECT * FROM USUARIO"
        } else {
            val items = input.split(",")
            val selectColumns = items.joinToString(", ") { it.trim() }
            sentenciaSQL = "SELECT $selectColumns FROM USUARIO"
        }

        val preparedStatement: PreparedStatement = con.prepareStatement(sentenciaSQL)
        val rs: ResultSet = preparedStatement.executeQuery()

        System.out.println("ID \tNombre \tUser \tPassword \tTelefono \tEmail \t")
        System.out.println("---------------------------------------------------------")
        var rowCount = 0
        while (rs.next()) {
            print("" + rs.getInt(1) + "\t")
            print("" + rs.getString(2) + "\t")
            print("" + rs.getString(3) + "\t")
            print("" + rs.getString(4) + "\t")
            print("" + rs.getInt(5) + "\t")
            println("" + rs.getString(6) + "\t")
            rowCount++
        }
        println("Número de registros: $rowCount")
        rs.close()
        preparedStatement.close()
        st.close()
        con.close()
    } catch (e: SQLException) {
        println("No existe aún la tabla")
        showMenu()
    }
}