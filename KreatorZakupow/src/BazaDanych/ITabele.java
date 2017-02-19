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
public interface ITabele {
    
    void Connection();
    boolean createTabele();
    void closeConnection();
    
}
