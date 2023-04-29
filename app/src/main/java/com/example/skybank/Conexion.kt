package com.example.skybank

import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.Driver
import java.sql.DriverManager
import java.sql.SQLException

class Conexion{
    private val ip="192.168.1.24:"
    private val db="SkyBank"
    private val username="sa"
    private val password="19021902"

    fun dbCon(): Connection?{
        val policy= StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn: Connection?=null
        val conString:String
        try{
            Class.forName("net.sourceforge. jdst.jbdc.Driver").newInstance()
            conString="jbdc:jtds:sqlserver://$ip;databaseName=$db;user=$username;password=$password"
            conn= DriverManager.getConnection(conString)
        }catch (ex: SQLException){
            Log.e("Error: ", ex.message!!)
        }catch (ex1: ClassNotFoundException){
            Log.e("Error: ",ex1.message!!)
        }catch (ex2:Exception){
            Log.e("Error: ",ex2.message!!)
        }
        return conn
    }
}