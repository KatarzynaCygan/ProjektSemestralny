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
public interface ITabelePokaz {
    
    void Connection();
    List<Produkty> pokazProdukty();
    /*List<String> pokazProduktIlosc();
    List<String> pokazProduktKat1();
    List<String> pokazProduktKat2();
    List<String> pokazProduktKat3();
    List<String> pokazProduktKat4();
    List<String> pokazProduktKat5();*/
    List<String> pokazKategorie();
    List<Sklepy> pokazSklep();
    /*List<String> pokazSklepAdres();*/
    List<String> pokazNazwaSklepu(String NazwaSklepu);
    void closeConnection();
}
