package mx.edu.itm.link.finalproyect_ofplants.models

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.jvm.Throws

class LocalDBManager (context: Context?,
                      name: String?,
                      factory: SQLiteDatabase.CursorFactory?,
                      version: Int):SQLiteOpenHelper(context, name, factory, version){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.let {
            var sql = """
               CREATE TABLE usuario(
                    id INTEGER PRIMARY KEY,
                    correo TEXT,
                    contrasena TEXT,
                    nombre TEXT,
                    telefono TEXT
               ) 
            """
            it.execSQL(sql)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?,
                           p1: Int, p2: Int) {}

    @Throws
    fun removeUsuario() {
        val db = writableDatabase

        var sql = "DELETE FROM usuario"

        db.execSQL(sql)

        db.close()
    }

    @Throws
    fun setUsuario(usuario: Usuario) {
        val db = writableDatabase

        var sql = "DELETE FROM usuario"

        db.execSQL(sql)

        sql = "INSERT INTO usuario VALUES(${usuario.id},'${usuario.correo}','${usuario.password}','${usuario.nombre}', '${usuario.telefono}')"

        db.execSQL(sql)

        db.close()
    }

    @Throws
    fun getUsuario() : Usuario? {
        val db = readableDatabase

        var sql = "SELECT * FROM usuario"

        val cursor = db.rawQuery(sql, null)

        var resultados: Usuario? = null
        if(cursor.moveToNext()) {
            resultados = Usuario(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3)
            )

        }
        db.close()

        return resultados
    }

    @Throws
    fun altaUsuario(usuario: Usuario){
        val db = writableDatabase
        val sql =
            "INSERT INTO usuario (id,correo,contrasena,nombre, telefono)" +
                    " VALUES ('${usuario.id}', '${usuario.correo}', '${usuario.password}','${usuario.nombre}', '${usuario.telefono}')"
        db.execSQL(sql)
        db.close()
    }

    @Throws
    fun consultaUsuarios(): ArrayList<Usuario> {
        val db = readableDatabase

        val sql =
            "SELECT id,correo,contrasena,nombre,telefono FROM usuario"

        val cursor = db.rawQuery(sql, null)

        val resultados = ArrayList<Usuario>()
        while (cursor.moveToNext()) {
            val usuario = Usuario(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4)
            )

            resultados.add(usuario)
        }
        db.close()

        return resultados
    }
}