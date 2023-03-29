package solutions.exercise4

interface Insertable {
    fun Insertar()
}

interface Consultable {
    fun Consultar()
}

interface Database {
    fun Conectar()
    fun Desconectar()
}

class MiBaseDeDatos : Database {
    override fun Conectar() {
        // lógica de conexión a la base de datos
    }

    override fun Desconectar() {
        // lógica de desconexión de la base de datos
    }
}

class Cliente {
    fun Insertar(db: Insertable) {
        db.Insertar()
    }

    fun Consultar(db: Consultable) {
        db.Consultar()
    }
}

class MiTabla : Insertable, Consultable {
    override fun Insertar() {
        // lógica de inserción en la tabla
    }

    override fun Consultar() {
        // lógica de consulta en la tabla
    }
}

fun main() {
    val tabla = MiTabla()

    val cliente = Cliente()
    cliente.Insertar(tabla)
    cliente.Consultar(tabla)
}
