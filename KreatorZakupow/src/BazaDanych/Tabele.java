/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazaDanych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kasia
 */
public class Tabele implements ITabele{
    
public static final String DRIVER = "org.sqlite.JDBC";
public static final String DB_URL = "jdbc:sqlite:BazaDanych.db";
 
private Connection conn;
private Statement stat;

@Override
public void Connection() {
        try {
            Class.forName(Tabele.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
 
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polączenia");
            e.printStackTrace();
        }
 
        createTabele();
    }
@Override
public boolean createTabele()
{
    String createKategorie = "CREATE TABLE IF NOT EXISTS KATEGORIE (Kategoria nvarchar(255) UNIQUE)";
    String createSklepy = "CREATE TABLE IF NOT EXISTS SKLEPY (NazwaSklepu nvarchar(255) UNIQUE, Adres nvarchar(255) DEFAULT 'brak' )";
    String createProdukty = "CREATE TABLE IF NOT EXISTS PRODUKTY (Produkt nvarchar(255) UNIQUE, Ilosc nvarchar(255) DEFAULT 'brak danych' , Kategoria1 nvarchar(255) DEFAULT 'brak' , Kategoria2 nvarchar(255) DEFAULT 'brak' , Kategoria3 nvarchar(255) DEFAULT 'brak' , Kategoria4 nvarchar(255) DEFAULT 'brak' , Kategoria5 nvarchar(255) DEFAULT 'brak' )";
    
    try {
            stat.execute(createKategorie);
            stat.execute(createSklepy);
            stat.execute(createProdukty);
        } catch (SQLException e) {
            System.err.println("Bląd przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
}
@Override
public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }


}


