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
public class TabeleSzukaj implements ITabeleSzukaj{
    
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
public List<String> szukajKategorie(String sz_kategoria) {
        List<String> SzKategoria = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT DISTINCT KATEGORIE.Kategoria FROM KATEGORIE WHERE KATEGORIE.Kategoria = '"+sz_kategoria+"'");
            String kategoria;
            while(result.next()) {
                kategoria = result.getString("Kategoria");
                SzKategoria.add(kategoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return SzKategoria;
    }
@Override
public List<Sklepy> szukajSklep(String sz_sklepy) {
        List<Sklepy> SzSklep = new LinkedList<Sklepy>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM SKLEPY WHERE SKLEPY.NazwaSklepu = '"+sz_sklepy+"'");
            String sklep;
            String adres;
            while(result.next()) {
                sklep = result.getString("NazwaSklepu");
                adres = result.getString("Adres");
                SzSklep.add( new Sklepy(sklep,adres));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return SzSklep;
    }
/*@Override
*public List<String> szukajSklepAdres(String sz_sklep) {
        List<String> SzSklepAdres = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT SKLEPY.Adres FROM SKLEPY WHERE SKLEPY.NazwaSklepu = '"+sz_sklep+"'");
            String adres;
            while(result.next()) {
                adres = result.getString("Adres");
                SzSklepAdres.add(adres);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return SzSklepAdres;
    }
@Override
public List<String> szukajSklepPoAdres(String sz_adres) {
        List<String> SzSklepPoAdres = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT SKLEPY.NazwaSklepu FROM SKLEPY WHERE SKLEPY.Adres = '"+sz_adres+"'");
            String sklep;
            while(result.next()) {
                sklep = result.getString("NazwaSklepu");
                SzSklepPoAdres.add(sklep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return SzSklepPoAdres;
    }*/
@Override
public List<Sklepy> szukajAdres(String sz_adres) {
        List<Sklepy> SzAdres = new LinkedList<Sklepy>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM SKLEPY WHERE SKLEPY.Adres = '"+sz_adres+"'");
            String adres;
            String sklep;
            while(result.next()) {
                sklep = result.getString("NazwaSklepu");
                adres = result.getString("Adres");
                SzAdres.add(new Sklepy(sklep,adres));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return SzAdres;
    }
@Override
public List<String> szukajNazwaSklepu(String NazwaSklepu,String sz_kategoria) {
    
    
        List<String> SzNazwaSklepu = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT DISTINCT "+NazwaSklepu+".Kategoria FROM "+NazwaSklepu+" WHERE "+NazwaSklepu+".Kategoria = '"+sz_kategoria+"'");
            String kategoria;
            while(result.next()) {
                kategoria = result.getString("Kategoria");
                SzNazwaSklepu.add(kategoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return SzNazwaSklepu;
    }
@Override
public List<Produkty> szukajProdukt(String sz_produkt) {
        List<Produkty> SzProdukt = new LinkedList<Produkty>();
        try {
            ResultSet result = stat.executeQuery("SELECT PRODUKTY.* FROM PRODUKTY WHERE PRODUKTY.Produkt = '"+sz_produkt+"'");
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
                SzProdukt.add(new Produkty(produkt,ilosc, kat1,kat2, kat3, kat4,kat5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return SzProdukt;
    }
@Override
public List<Produkty> szukajProduktIlosc(String sz_produkt) {
        List<Produkty> SzProduktIlosc = new LinkedList<Produkty>();
        try {
            ResultSet result = stat.executeQuery("SELECT PRODUKTY.* FROM PRODUKTY WHERE PRODUKTY.Produkt = '"+sz_produkt+"'");
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
                SzProduktIlosc.add(new Produkty(produkt,ilosc, kat1,kat2, kat3, kat4,kat5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return SzProduktIlosc;
    }
@Override
public List<String> szukajProduktKategorie(String sz_produkt) {
        List<String> SzProduktKategorie = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT PRODUKTY.Kategoria1, PRODUKTY.Kategoria2, PRODUKTY.Kategoria3, PRODUKTY.Kategoria4, PRODUKTY.Kategoria5 FROM PRODUKTY WHERE PRODUKTY.Produkt = '"+sz_produkt+"'");
            String Kategoria1;
            String Kategoria2;
            String Kategoria3;
            String Kategoria4;
            String Kategoria5;
            while(result.next()) {
                Kategoria1 = result.getString("Kategoria1");
                Kategoria2 = result.getString("Kategoria2");
                Kategoria3 = result.getString("Kategoria3");
                Kategoria4 = result.getString("Kategoria4");
                Kategoria5 = result.getString("Kategoria5");
                SzProduktKategorie.add(Kategoria1);
                SzProduktKategorie.add(Kategoria2);
                SzProduktKategorie.add(Kategoria3);
                SzProduktKategorie.add(Kategoria4);
                SzProduktKategorie.add(Kategoria5);        
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return SzProduktKategorie;
    }
@Override
public List<Produkty> szukajProduktyDlaKategorii(String sz_kategoria) {
        List<Produkty> SzProduktyDlaKategorii = new LinkedList<Produkty>();
        try {
            ResultSet result = stat.executeQuery("SELECT PRODUKTY.* FROM PRODUKTY WHERE PRODUKTY.Kategoria1='"+sz_kategoria+"' OR PRODUKTY.Kategoria2='"+sz_kategoria+"' OR PRODUKTY.Kategoria3='"+sz_kategoria+"' OR PRODUKTY.Kategoria4='"+sz_kategoria+"' OR PRODUKTY.Kategoria5= '"+sz_kategoria+"'");
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
                SzProduktyDlaKategorii.add(new Produkty(produkt,ilosc, kat1,kat2, kat3, kat4,kat5));       
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return SzProduktyDlaKategorii;
    }
/*@Override
public List<String> szukajIloscDlaKategorii(String sz_kategoria) {
        List<String> SzIloscDlaKategorii = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT PRODUKTY.Ilosc FROM PRODUKTY WHERE PRODUKTY.Kategoria1='"+sz_kategoria+"' OR PRODUKTY.Kategoria2='"+sz_kategoria+"' OR PRODUKTY.Kategoria3='"+sz_kategoria+"' OR PRODUKTY.Kategoria4='"+sz_kategoria+"' OR PRODUKTY.Kategoria5= '"+sz_kategoria+"'");
            String ilosc;
            while(result.next()) {
                ilosc = result.getString("Ilosc");
                SzIloscDlaKategorii.add(ilosc);       
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return SzIloscDlaKategorii;
    }*/
@Override
public List<Produkty> szukajProduktDlaSklepu(String sz_sklep) {
        List<Produkty> SzProduktDlaSklepu = new LinkedList<Produkty>();
        try {
            ResultSet result = stat.executeQuery("SELECT PRODUKTY.* FROM PRODUKTY LEFT JOIN "+sz_sklep+" WHERE "+sz_sklep+".Kategoria=PRODUKTY.Kategoria1 OR "+sz_sklep+".Kategoria=PRODUKTY.Kategoria2 OR "+sz_sklep+".Kategoria=PRODUKTY.Kategoria3 OR "+sz_sklep+".Kategoria=PRODUKTY.Kategoria4 OR "+sz_sklep+".Kategoria=PRODUKTY.Kategoria5");
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
                SzProduktDlaSklepu.add(new Produkty(produkt,ilosc, kat1,kat2, kat3, kat4,kat5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return SzProduktDlaSklepu;
    }
/*@Override
public List<String> szukajIlosctDlaSklepu(String sz_sklep) {
        List<String> SzIlosctDlaSklepu = new LinkedList<String>();
        try {
            ResultSet result = stat.executeQuery("SELECT PRODUKTY.Ilosc FROM PRODUKTY INNER JOIN "+sz_sklep+" WHERE "+sz_sklep+".Kategoria=PRODUKTY.Kategoria1 OR "+sz_sklep+".Kategoria=PRODUKTY.Kategoria2 OR "+sz_sklep+".Kategoria=PRODUKTY.Kategoria3 OR "+sz_sklep+".Kategoria=PRODUKTY.Kategoria4 OR "+sz_sklep+".Kategoria=PRODUKTY.Kategoria5");
            String ilosc;
            while(result.next()) {
                ilosc = result.getString("Ilosc");
                SzIlosctDlaSklepu.add(ilosc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return SzIlosctDlaSklepu;
    }*/
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
