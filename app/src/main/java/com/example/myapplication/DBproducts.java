package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBproducts extends SQLiteOpenHelper {

    // Nombre de la base de datos y versión
    private static final String DATABASE_NAME = "DBproducts.db";
    private static final int DATABASE_VERSION = 1;

    // Nombre de la tabla
    private static final String TABLA_PRODUCTOS = "products";

    // Columnas de la tabla
    private static final String COLUMNA_ID = "id";
    private static final String COLUMNA_NOMBRE = "name";
    private static final String COLUMNA_PRECIO = "price";
    private static final String COLUMNA_IMAGEN = "image";




    public DBproducts(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la tabla de productos
        String crearTabla = "CREATE TABLE " + TABLA_PRODUCTOS + " (" +
                COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMNA_NOMBRE + " TEXT, " +
                COLUMNA_PRECIO + " REAL, " +
                COLUMNA_IMAGEN + " TEXT)";
        db.execSQL(crearTabla);

        // Insertar los 6 productos iniciales
        insertarProducto(db, "Nevera ", 950.000, "https://lh3.googleusercontent.com/gg/ACM6BItk8qlvTGXajL3NbqAVZl1ha3EyrNn485fH5iaKcx47RYSpgXAlKN5PuuRFfykIC4BO0zF47RRBQZADzqUfmBAKqfAp9NW6-Dovsr4DRyNP0aZITEIFIrah5H4bt1vblg2CxjfY9-qcE2AFKF_IZGTQCAVQBDGzdmxs1m8lUiJ9s1Jw7hE");
        insertarProducto(db, "base cama", 400.000, "https://lh3.googleusercontent.com/gg/ACM6BItju_Deh2BMG0Ab_IyDp4MR7GLSQ3wOTAnb0W-NRc379jDQSICK87BwKnz3LgSyhFuvYUPEkmtO5gLTstq-mvoTOIc0M94dpngQzvAnx5QsPIQB8CyrwKzJKWwCa8dmqQYUe_H4kg7frVtjgIu7KqSJKi4Acyqy-_7wpE8dfnqkjUvqf-I");
        insertarProducto(db, "Licuadora", 200.000, "https://lh3.googleusercontent.com/gg/ACM6BItT5IvbppEvVTRBvy8L_neleUCRLurZ65wWeeI8rAJZ4qQqZMuQ4wzT9LzgcLk5QilGXKiCgqTdgwZEuRvzOceXwwKvXPVavG6tzEDoy8aqrlzyqs9IVhfd5hkrh5a_l3bCTDtLZDuGy-DEsSXhXrBDlFLSo6v3EwV6ma3fbZjfF4x3_7k");
        insertarProducto(db, "Lavadora", 990.000, "https://lh3.googleusercontent.com/gg/ACM6BIvPcMBdFT0OQOKfo5EfeH7GpBKe28LMFleWB6Nk7KSeqb7c2AoekLsstye91v812KE8Kip7hqUxgmJrYN1DuXMfVaky5mfHBxk96P8E5s8kdszlcaWGe9lOH4t_ZkkU_5GvY44vGHi8twG1iMvI_yXTADC28MpEIRjQDBxokP97_T7QLJM");
        insertarProducto(db, "Televisor", 890.000, "https://lh3.googleusercontent.com/gg/ACM6BIvUHgI90l-vus5B_8cRiZRxaknki6fFKum_c5mJXPQTKClK3S3i_5OJ633qFkhLfgVmQ40Kf1eHK4vyL4oGXc1AZ4Mvc4d49gywyd92i5yFYYc4tQUjzSdmqnuYWXYIcySatcTxVxiPvwgASvBILByfv4sUcBcLAMW79G7bZ3R34aGMQwM");
        insertarProducto(db, "Silla rimax", 50.000, "https://lh3.googleusercontent.com/gg/ACM6BIu0zYksf9IDnP1v0S6G3LJdCHRY6NsCFc7kqpi5x69muB_4Q8UdL0cwR3Nxk5N1_iATOGDtz8cHDz6zfIhzYUyU05v33ZBbFl7vppsgDrnqVsRhdPGkFtICBj389LiVhY4Wbi_LHWJjO6h1v5FY6MWAvGY_v_qXZLEJ3tikvPf0RWz3P4re");
    }

    private void insertarProducto(SQLiteDatabase db, String name, double price, String image) {
        // Crear un objeto ContentValues para almacenar los valores a insertar
        ContentValues values = new ContentValues();
        values.put(COLUMNA_NOMBRE, name);
        values.put(COLUMNA_PRECIO, price);
        values.put(COLUMNA_IMAGEN, image);

        // Insertar el producto en la base de datos
        db.insert(TABLA_PRODUCTOS, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
