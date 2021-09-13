package models

import java.sql.{Connection, DriverManager}

object members extends App {
  def stu:List[Array[String]] = {

    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/scala"
    val username = "root"
    val password = ""

    var memvalus:List[Array[String]] = List.empty
    var connection:Connection = null

    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
      // create the statement, and run the select query
      val statement = connection.createStatement()

      // get students data from the database
      val resultSet = statement.executeQuery("SELECT * FROM students")

      while ( resultSet.next() ) {

        val id = resultSet.getInt("Id")
        val fname = resultSet.getString("FName")
        val lname = resultSet.getString("LName")
        val index = resultSet.getString("IndexNo")
        val email = resultSet.getString("Email")

        // create the array with member details
        val row: Array[String] = Array(id.toString, fname, lname, index, email)
        // create list with arrays
        memvalus :+= row

      }
    } catch {
      case e => e.printStackTrace
    }

    connection.close()
    //return list
    memvalus
  }
}
