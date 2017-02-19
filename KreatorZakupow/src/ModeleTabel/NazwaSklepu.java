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
public class NazwaSklepu implements INazwaSklepu{
    
   private String kategoria;
    

    @Override
    public String getKategoria()
    {
        return kategoria;
    }
    
    @Override
    public void setKategoria(String kategoria)
    {
        this.kategoria = kategoria;
    }
    
    public NazwaSklepu(){}
    
    public NazwaSklepu(String kategoria)
    {
        this.kategoria = kategoria;
    }
    
    @Override
    public String toString()
    {
        return kategoria;
    }
    
    
    
}
