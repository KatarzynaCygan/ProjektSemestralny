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
public interface ITabeleUpdate {
    
    void Connection();
    void setElastycznaNazwaSklepu(String Nazwa);
    String getElastycznaNazwaSklepu();
    boolean updateKtegoriaKategoria(String stary_k,String nowy_k);
    boolean updateProduktyProdukt(String stary_p,String nowy_p);
    boolean updateProduktyIlosc(String produkt,String ilosc);
    boolean updateProduktyKat1(String produkt,String kat1);
    boolean updateProduktyKat2(String produkt,String kat2);
    boolean updateProduktyKat3(String produkt,String kat3);
    boolean updateProduktyKat4(String produkt,String kat4);
    boolean updateProduktyKat5(String produkt,String kat5);
    boolean updateProduktyKategoria(String produkt,String kat_stara, String kat_nowa);
    boolean updateSklepyAdres(String sklep,String adres);
    void closeConnection();
    
}
