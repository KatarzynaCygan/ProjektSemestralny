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
public class TabeleUpdate implements ITabeleUpdate{
    
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

@Override
public boolean updateKtegoriaKategoria(String stary_k,String nowy_k)
{
   String pomocnicza;
    pomocnicza = "UPDATE KATRGORIE SET Kategoria ='"+nowy_k+"' WHERE KATEGORIE.Kategoria = '"+stary_k+"';";
    
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
public boolean updateProduktyProdukt(String stary_p,String nowy_p)
{
   String pomocnicza;
    pomocnicza = "UPDATE PRODUKTY SET Produkt ='"+nowy_p+"' WHERE PRODUKTY.Produkt = '"+stary_p+"';";
    
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
public boolean updateProduktyIlosc(String produkt,String ilosc)
{
   String pomocnicza;
    pomocnicza = "UPDATE PRODUKTY SET Ilosc ='"+ilosc+"' WHERE PRODUKTY.Produkt = '"+produkt+"';";
    
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
public boolean updateProduktyKat1(String produkt,String kat1)
{
   String pomocnicza;
    pomocnicza = "UPDATE PRODUKTY SET Kategoria1 ='"+kat1+"' WHERE PRODUKTY.Produkt = '"+produkt+"';";
    
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
public boolean updateProduktyKat2(String produkt,String kat2)
{
   String pomocnicza;
    pomocnicza = "UPDATE PRODUKTY SET Kategoria1 ='"+kat2+"' WHERE PRODUKTY.Produkt = '"+produkt+"';";
    
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
public boolean updateProduktyKat3(String produkt,String kat3)
{
   String pomocnicza;
    pomocnicza = "UPDATE PRODUKTY SET Kategoria1 ='"+kat3+"' WHERE PRODUKTY.Produkt = '"+produkt+"';";
    
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
public boolean updateProduktyKat4(String produkt,String kat4)
{
   String pomocnicza;
    pomocnicza = "UPDATE PRODUKTY SET Kategoria1 ='"+kat4+"' WHERE PRODUKTY.Produkt = '"+produkt+"';";
    
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
public boolean updateProduktyKat5(String produkt,String kat5)
{
   String pomocnicza;
    pomocnicza = "UPDATE PRODUKTY SET Kategoria1 ='"+kat5+"' WHERE PRODUKTY.Produkt = '"+produkt+"';";
    
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
public boolean updateProduktyKategoria(String produkt,String kat_stara, String kat_nowa)
{
   String pomocnicza1, pomocnicza2, pomocnicza3, pomocnicza4, pomocnicza5;
    pomocnicza1 = "UPDATE PRODUKTY SET Kategoria1 ='"+kat_nowa+"' WHERE PRODUKTY.Produkt = '"+produkt+"' AND Kategoria1= '"+kat_stara+"';";
    pomocnicza2 = "UPDATE PRODUKTY SET Kategoria2 ='"+kat_nowa+"' WHERE PRODUKTY.Produkt = '"+produkt+"' AND Kategoria2= '"+kat_stara+"';";
    pomocnicza3 = "UPDATE PRODUKTY SET Kategoria3 ='"+kat_nowa+"' WHERE PRODUKTY.Produkt = '"+produkt+"' AND Kategoria3= '"+kat_stara+"';";
    pomocnicza4 = "UPDATE PRODUKTY SET Kategoria4 ='"+kat_nowa+"' WHERE PRODUKTY.Produkt = '"+produkt+"' AND Kategoria4= '"+kat_stara+"';";
    pomocnicza5 = "UPDATE PRODUKTY SET Kategoria5 ='"+kat_nowa+"' WHERE PRODUKTY.Produkt = '"+produkt+"' AND Kategoria5= '"+kat_stara+"';";
    
    try {
            PreparedStatement prepStmt = conn.prepareStatement(pomocnicza1);
            prepStmt.execute();
            PreparedStatement prepStmt2 = conn.prepareStatement(pomocnicza2);
            prepStmt2.execute();
            PreparedStatement prepStmt3 = conn.prepareStatement(pomocnicza2);
            prepStmt3.execute();
            PreparedStatement prepStmt4 = conn.prepareStatement(pomocnicza2);
            prepStmt4.execute();
            PreparedStatement prepStmt5 = conn.prepareStatement(pomocnicza2);
            prepStmt5.execute();
        } catch (SQLException e) {
            System.err.println("Bląd przy sklepie");
            return false;
        }
        return true; 
        
    
}
@Override
public boolean updateSklepyAdres(String sklep,String adres)
{
   String pomocnicza;
    pomocnicza = "UPDATE SKLEPY SET Adres ='"+adres+"' WHERE SKLEPY.NazwaSklepu = '"+sklep+"';";
    
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
