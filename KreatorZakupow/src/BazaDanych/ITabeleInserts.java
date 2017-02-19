/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BazaDanych;

/**
 *
 * @author Kasia
 */
public interface ITabeleInserts {
    
    void Connection();
    String getNazwaSklepu();
    boolean createTabelaNazwaSklepu(String nazwa_sklepu);
    boolean insertSklep(String nazwa_sklepu);
    boolean insertSklep(String nazwa_sklepu,String adres);
    boolean insertKategoriaNazwaSklepu(String NazwaSklepu, String kategoria);
    boolean insertKategoria(String kategoria);
    boolean insertProdukt(String produkt);
    boolean insertProdukt(String produkt,String ilosc);
    boolean insertProdukt(String produkt,String ilosc,String kategoria1);
    boolean insertProdukt(String produkt,String ilosc,String kategoria1,String kategoria2);
    boolean insertProdukt(String produkt,String ilosc,String kategoria1,String kategoria2, String kategoria3);
    boolean insertProdukt(String produkt,String ilosc,String kategoria1,String kategoria2, String kategoria3, String kategoria4);
    boolean insertProdukt(String produkt,String ilosc,String kategoria1,String kategoria2, String kategoria3, String kategoria4, String kategoria5);
    public void setElastycznaNazwaSklepu(String Nazwa);
    public String getElastycznaNazwaSklepu();
    void setSciezkaDodKatSklepu(String Nazwa);
    boolean insertNazwaSklepu(String kategoria);
    boolean insertNazwaSklepu(String NazwaSkl,String kategoria);
    void closeConnection();
    
}
