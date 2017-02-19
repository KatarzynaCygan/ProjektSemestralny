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
public interface ITabeleDelete {
    
    void Connection();
    void setElastycznaNazwaSklepu(String Nazwa);
    String getElastycznaNazwaSklepu();
    boolean deleteSklep(String nazwa_sklepu);
    boolean deleteKategoria(String kategoria);
    boolean deleteProdukt(String produkt);
    boolean deleteKategoriaSklepu(String NazwaSklepu, String kategoria);
    void closeConnection();
    
    
}
