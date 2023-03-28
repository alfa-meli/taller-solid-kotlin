package excercise5

interface Database {
    fun connect(): Error?
    fun query(query: String): Pair<List<String>, Error?>
}

class MySQLDatabase(
    private val host: String,
    private val port: Int,
    private val username: String,
    private val password: String,
    private val database: String
) : Database {
    override fun connect(): Error? {
        // implementación para conectar a MySQL
        return null
    }

    override fun query(query: String): Pair<List<String>, Error?> {
        // implementación para realizar una consulta a MySQL
        return Pair(emptyList(), null)
    }
}

fun main() {
    val db = MySQLDatabase(
        host = "localhost",
        port = 3306,
        username = "myuser",
        password = "mypassword",
        database = "mydatabase"
    )

    val err = db.connect()
    if (err != null) {
        print(err)
    }

    // realizar una consulta utilizando la implementación de MySQLDatabase
    val (result, queryErr) = db.query("SELECT * FROM mytable")
    if (queryErr != null) {
        print(queryErr)
    }

    println(result)
    // hacer algo con el resultado
}
