package solutions.exercise4

interface Database {
    fun conectar()
    fun desconectar()
    fun insertar()
    fun eliminar()
    fun actualizar()
    fun consultar()
}

class MiBaseDeDatos : Database {
    override fun conectar() {
        // lógica de conexión a la base de datos
    }

    override fun desconectar() {
        // lógica de desconexión de la base de datos
    }

    override fun insertar() {
        // lógica de inserción en la base de datos
    }

    override fun eliminar() {
        // lógica de eliminación en la base de datos
    }

    override fun actualizar() {
        // lógica de actualización en la base de datos
    }

    override fun consultar() {
        // lógica de consulta en la base de datos
    }
}

class Cliente {
    fun utilizarBaseDeDatos(db: Database) {
        // lógica de uso de la base de datos
        db.conectar()
        db.insertar()
        db.consultar()
        db.desconectar()
    }
}

class MiTabla : Database {
    override fun conectar() {
        // no implementado
    }

    override fun desconectar() {
        // no implementado
    }

    override fun insertar() {
        // lógica de inserción en la tabla
    }

    override fun eliminar() {
        // no implementado
    }

    override fun actualizar() {
        // no implementado
    }

    override fun consultar() {
        // lógica de consulta en la tabla
    }
}

fun main() {
    val db = MiBaseDeDatos()
    val tabla = MiTabla()

    val cliente = Cliente()
    cliente.utilizarBaseDeDatos(db)
    cliente.utilizarBaseDeDatos(tabla)
}
