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
public class TabeleDelete implements ITabeleDelete{
    
public static final String DRIVER = "org.sqlite.JDBC";
public static final String DB_URL = "jdbc:sqlite:BazaDanych.db";
 
private Connection conn;
private Statement stat;

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

private boolean deleteTabelaNazwaSklepu(String NazwaSkl)
{
    this.setElastycznaNazwaSklepu(NazwaSkl);
    String usuwanie_tabeli = "Drop table "+ElastycznaNazwaSklepu+";";
    
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    usuwanie_tabeli);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
}
@Override
public boolean deleteSklep(String nazwa_sklepu)
{
    String pomocnicza;
    this.deleteTabelaNazwaSklepu(nazwa_sklepu);
    pomocnicza = "DELETE FROM SKLEPY WHERE SKLEPY.NazwaSklepu='"+nazwa_sklepu+"';";
    
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    pomocnicza);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
}
@Override
public boolean deleteKategoria(String kategoria)
{
    String pomocnicza;
    pomocnicza = "DELETE FROM KATEGORIE WHERE KATEGORIE.Kategoria='"+kategoria+"';";
    
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    pomocnicza);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
}
@Override
public boolean deleteKategoriaSklepu(String NazwaSklepu, String kategoria)
{
    String pomocnicza;
    pomocnicza = "DELETE FROM "+NazwaSklepu+" WHERE "+NazwaSklepu+".Kategoria='"+kategoria+"';";
    
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    pomocnicza);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true;
}
@Override
public boolean deleteProdukt(String produkt)
{
    String pomocnicza;
    pomocnicza = "DELETE FROM PRODUKTY WHERE PRODUKTY.Produkt='"+produkt+"';";
    
    try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    pomocnicza);
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
