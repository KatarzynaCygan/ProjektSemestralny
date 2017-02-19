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
public class TabeleInserts implements ITabeleInserts{
    
public static final String DRIVER = "org.sqlite.JDBC";
public static final String DB_URL = "jdbc:sqlite:BazaDanych.db";
 
private Connection conn;
private Statement stat;

private String NazwaSklepu;
private String createNazwaSklepu;
private String ElastycznaNazwaSklepu;
private String SciezkaDodKatSklepu;
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
 
    }

private void setNazwaSklepu(String nazwa_sklepu)
{
    NazwaSklepu = nazwa_sklepu;
}
@Override
public String getNazwaSklepu()
{
    return NazwaSklepu;
}

private void createSciezkaNazwySklepu(String NazwaSklepu)
{
    createNazwaSklepu ="CREATE TABLE IF NOT EXISTS "+NazwaSklepu+" (Kategoria nvarchar(255) UNIQUE)" ;
}

@Override
public boolean createTabelaNazwaSklepu(String nazwa_sklepu)
{
    //this.setNazwaSklepu(nazwa_sklepu);
    //this.createSciezkaNazwySklepu(nazwa_sklepu);
    
    try {
            stat.execute("CREATE TABLE IF NOT EXISTS "+nazwa_sklepu+" (Kategoria nvarchar(255) UNIQUE)");
        } catch (SQLException e) {
            System.err.println("Bląd przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
}
@Override
public boolean insertSklep(String nazwa_sklepu)
{
    String Nazwasklepu;
    Nazwasklepu = nazwa_sklepu;
    
    this.createTabelaNazwaSklepu(Nazwasklepu);
    
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into SKLEPY values (?);");
            prepStmt.setString(1, nazwa_sklepu);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
  
}
@Override
public boolean insertSklep(String nazwa_sklepu,String adres)
{
    
    this.createTabelaNazwaSklepu(nazwa_sklepu);
    
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into SKLEPY values (?, ?);");
            prepStmt.setString(1, nazwa_sklepu);
            prepStmt.setString(2, adres);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
  
}
@Override
public boolean insertKategoriaNazwaSklepu(String NazwaSklepu, String kategoria)
{
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into "+NazwaSklepu+" values (?);");
            prepStmt.setString(1, kategoria);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
}
@Override
public boolean insertKategoria(String kategoria)
{
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into KATEGORIE values (?);");
            prepStmt.setString(1, kategoria);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
}
@Override
public boolean insertProdukt(String produkt)
{
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into PRODUKTY values (?);");
            prepStmt.setString(1, produkt);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
}
@Override
public boolean insertProdukt(String produkt,String ilosc)
{
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into PRODUKTY values (?,?);");
            prepStmt.setString(1, produkt);
            prepStmt.setString(2, ilosc);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
}
@Override
public boolean insertProdukt(String produkt,String ilosc,String kategoria1)
{
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into PRODUKTY values (?,?,?);");
            prepStmt.setString(1, produkt);
            prepStmt.setString(2, ilosc);
            prepStmt.setString(3, kategoria1);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
}
@Override
public boolean insertProdukt(String produkt,String ilosc,String kategoria1,String kategoria2)
{
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into PRODUKTY values (?,?,?,?);");
            prepStmt.setString(1, produkt);
            prepStmt.setString(2, ilosc);
            prepStmt.setString(3, kategoria1);
            prepStmt.setString(4, kategoria2);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
}
@Override
public boolean insertProdukt(String produkt,String ilosc,String kategoria1,String kategoria2, String kategoria3)
{
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into PRODUKTY values (?,?,?,?,?);");
            prepStmt.setString(1, produkt);
            prepStmt.setString(2, ilosc);
            prepStmt.setString(3, kategoria1);
            prepStmt.setString(4, kategoria2);
            prepStmt.setString(5, kategoria3);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
}
@Override
public boolean insertProdukt(String produkt,String ilosc,String kategoria1,String kategoria2, String kategoria3, String kategoria4)
{
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into PRODUKTY values (?,?,?,?,?,?);");
            prepStmt.setString(1, produkt);
            prepStmt.setString(2, ilosc);
            prepStmt.setString(3, kategoria1);
            prepStmt.setString(4, kategoria2);
            prepStmt.setString(5, kategoria3);
            prepStmt.setString(6, kategoria4);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
}
@Override
public boolean insertProdukt(String produkt,String ilosc,String kategoria1,String kategoria2, String kategoria3, String kategoria4, String kategoria5)
{
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into PRODUKTY values (?,?,?,?,?,?,?);");
            prepStmt.setString(1, produkt);
            prepStmt.setString(2, ilosc);
            prepStmt.setString(3, kategoria1);
            prepStmt.setString(4, kategoria2);
            prepStmt.setString(5, kategoria3);
            prepStmt.setString(6, kategoria4);
            prepStmt.setString(7, kategoria5);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
}
@Override
public void setElastycznaNazwaSklepu(String Nazwa)
{
    ElastycznaNazwaSklepu = Nazwa;
}
@Override
public String getElastycznaNazwaSklepu()
{
    return ElastycznaNazwaSklepu;
}
@Override
public void setSciezkaDodKatSklepu(String Nazwa)
{
    ElastycznaNazwaSklepu = Nazwa;
    SciezkaDodKatSklepu = "insert into "+ElastycznaNazwaSklepu+" values (?);";
}
@Override
public boolean insertNazwaSklepu(String kategoria)
{
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    SciezkaDodKatSklepu);
            prepStmt.setString(1, kategoria);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
}
@Override
public boolean insertNazwaSklepu(String NazwaSkl,String kategoria)
{
    this.setSciezkaDodKatSklepu(NazwaSkl);
    
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    SciezkaDodKatSklepu);
            prepStmt.setString(1, kategoria);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
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
