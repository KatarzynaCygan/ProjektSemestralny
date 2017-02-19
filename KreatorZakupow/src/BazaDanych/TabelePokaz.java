/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package BazaDanych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import ModeleTabel.Kategorie;
import ModeleTabel.NazwaSklepu;
import ModeleTabel.Produkty;
import ModeleTabel.Sklepy;
/**
 *
 * @author Kasia
 */
public class TabelePokaz implements ITabelePokaz{
    
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
 
    }
@Override
public List<Produkty> pokazProdukty() {
        List<Produkty> pProdukty = new LinkedList<Produkty>();
        try {
            ResultSet result = stat.executeQuery("SELECT PRODUKTY.* FROM PRODUKTY");
            String produkt;
            String ilosc;
            String kat1;
            String kat2;
            String kat3;
            String kat4;
            String kat5;
            while(result.next()) {
                produkt = result.getString("Produkt");
                ilosc = result.getString("Ilosc");
                kat1 = result.getString("Kategoria1");
                kat2 = result.getString("Kategoria2");
                kat3 = result.getString("Kategoria3");
                kat4 = result.getString("Kategoria4");
                kat5 = result.getString("Kategoria5");
                pProdukty.add(new Produkty(produkt,ilosc, kat1,kat2, kat3, kat4,kat5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pProdukty;
    }
/*@Override
public List<String> pokazProduktIlosc() {
        List<String> pProduktIlosc = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT PRODUKTY.Ilosc FROM PRODUKTY");
            String ilosc;
            while(result.next()) {
                ilosc = result.getString("Ilosc");
                pProduktIlosc.add(ilosc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pProduktIlosc;
    }
@Override
public List<String> pokazProduktKat1() {
        List<String> pProduktKat1 = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT PRODUKTY.Kategoria1 FROM PRODUKTY");
            String kategoria;
            while(result.next()) {
                kategoria = result.getString("Kategoria1");
                pProduktKat1.add(kategoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pProduktKat1;
    }
@Override
public List<String> pokazProduktKat2() {
        List<String> pProduktKat2 = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT PRODUKTY.Kategoria2 FROM PRODUKTY");
            String kategoria;
            while(result.next()) {
                kategoria = result.getString("Kategoria2");
                pProduktKat2.add(kategoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pProduktKat2;
    }
@Override
public List<String> pokazProduktKat3() {
        List<String> pProduktKat3 = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT PRODUKTY.Kategoria3 FROM PRODUKTY");
            String kategoria;
            while(result.next()) {
                kategoria = result.getString("Kategoria3");
                pProduktKat3.add(kategoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pProduktKat3;
    }
@Override
public List<String> pokazProduktKat4() {
        List<String> pProduktKat4 = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT PRODUKTY.Kategoria4 FROM PRODUKTY");
            String kategoria;
            while(result.next()) {
                kategoria = result.getString("Kategoria4");
                pProduktKat4.add(kategoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pProduktKat4;
    }
@Override
public List<String> pokazProduktKat5() {
        List<String> pProduktKat5 = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT PRODUKTY.Kategoria5 FROM PRODUKTY");
            String kategoria;
            while(result.next()) {
                kategoria = result.getString("Kategoria5");
                pProduktKat5.add(kategoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pProduktKat5;
    }*/
@Override
public List<String> pokazKategorie() {
        List<String> pKategorie = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT KATEGORIE.Kategoria FROM KATEGORIE");
            String kategoria;
            while(result.next()) {
                kategoria = result.getString("Kategoria");
                pKategorie.add(kategoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pKategorie;
    }
@Override
public List<Sklepy> pokazSklep() {
        List<Sklepy> pSklep = new LinkedList<Sklepy>();
        try {
            ResultSet result = stat.executeQuery("SELECT SKLEPY.* FROM SKLEPY");
            String sklep;
            String adres;
            while(result.next()) {
                sklep = result.getString("NazwaSklepu");
                adres = result.getString("Adres");
                pSklep.add(new Sklepy(sklep,adres));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pSklep;
    }
/*@Override
public List<String> pokazSklepAdres() {
        List<String> pSklepAdres = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT SKLEPY.Adres FROM SKLEPY");
            String adres;
            while(result.next()) {
                adres = result.getString("Adres");
                pSklepAdres.add(adres);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pSklepAdres;
    }*/
@Override
public List<String> pokazNazwaSklepu(String NazwaSklepu) {
        List<String> pNazwaSklepu = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM "+NazwaSklepu+"");
            String kategoria;
            while(result.next()) {
                kategoria = result.getString("Kategoria");
                pNazwaSklepu.add(kategoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pNazwaSklepu;
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
