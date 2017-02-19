/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeleTabel;

/**
 *
 * @author Kasia
 */
public class Sklepy implements ISklepy{
    
    private String nazwa_sklepu;
    private String adres;
    
    @Override
    public String getNazwaSklepu()
    {
        return nazwa_sklepu;
    }
    
    @Override
    public void setNazwaSklepu(String nazwa_sklepu)
    {
        this.nazwa_sklepu = nazwa_sklepu;
    }
    
    @Override
    public String getAdres()
    {
        return adres;
    }
    
    @Override
    public void setAdres(String adres)
    {
        this.adres = adres;
    }
    
    public Sklepy(){}
    
    public Sklepy(String nazwa_sklepu, String adres)
    {
        this.nazwa_sklepu = nazwa_sklepu;
        this.adres = adres;
    }
    
    @Override
    public String toString()
    {
        return nazwa_sklepu+", adres: "+adres;    
    }
    
}
