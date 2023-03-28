package solutions.exercise5

import java.util.logging.Level
import java.util.logging.Logger

fun main() {
    val db: Database = MySQLDatabase(
        host = "localhost",
        port = 3306,
        username = "myuser",
        password = "mypassword",
        database = "mydatabase"
    )

    val logger = Logger.getLogger(MyObject::class.java.name)
    val myObject = MyObject(database = db, logger = logger)

    val result = myObject.queryDatabase("SELECT * FROM mytable")

    println(result)
}

interface Database {
    fun connect(): Exception?
    fun query(query: String): Pair<List<String>?, Exception?>
}

class MySQLDatabase(
    private val host: String,
    private val port: Int,
    private val username: String,
    private val password: String,
    private val database: String
) : Database {
    override fun connect(): Exception? {
        // implementación para conectar a MySQL
        return null
    }

    override fun query(query: String): Pair<List<String>?, Exception?> {
        // implementación para realizar una consulta a MySQL
        return Pair(null, null)
    }
}

class MyObject(
    private val database: Database,
    private val logger: Logger
) {
    fun queryDatabase(query: String): List<String>? {
        val (result, exception) = database.query(query)
        if (exception != null) {
            logger.log(Level.SEVERE, "Error querying database", exception)
        }
        return result
    }
}
