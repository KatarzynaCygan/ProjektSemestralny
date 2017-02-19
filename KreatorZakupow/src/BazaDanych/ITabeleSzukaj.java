/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazaDanych;

import java.util.List;
import ModeleTabel.Kategorie;
import ModeleTabel.NazwaSklepu;
import ModeleTabel.Produkty;
import ModeleTabel.Sklepy;

/**
 *
 * @author Kasia
 */
public interface ITabeleSzukaj {
    
    void Connection();
    List<String> szukajKategorie(String sz_kategoria);
    List<Sklepy> szukajSklep(String sz_sklep);
    List<Sklepy> szukajAdres(String sz_adres);
    List<String> szukajNazwaSklepu(String NazwaSklepu,String sz_kategoria);
    List<Produkty> szukajProdukt(String sz_produkt);
    List<Produkty> szukajProduktIlosc(String sz_produkt);
    List<String> szukajProduktKategorie(String sz_produkt);
    List<Produkty> szukajProduktyDlaKategorii(String sz_kategoria);
    /*List<String> szukajIloscDlaKategorii(String sz_kategoria);*/
    List<Produkty> szukajProduktDlaSklepu(String sz_sklep);
   /* List<String> szukajIlosctDlaSklepu(String sz_sklep);*/
    public void closeConnection();
    
}
