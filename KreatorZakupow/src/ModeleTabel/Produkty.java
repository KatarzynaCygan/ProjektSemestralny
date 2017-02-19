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
public class Produkty implements IProdukty{
    
    private String produkt;
    private String ilosc;
    private String kategoria1;
    private String kategoria2;
    private String kategoria3;
    private String kategoria4;
    private String kategoria5;
    
    @Override
    public String getProdukt()
    {
        return produkt;
    }
    
    @Override
    public void setProdukt(String produkt)
    {
        this.produkt = produkt;
    }
    
    @Override
    public String getIlosc()
    {
        return ilosc;
    }
    
    @Override
    public void setIlosc(String ilosc)
    {
        this.ilosc = ilosc;
    }
    
    @Override
    public String getKategoria1()
    {
        return kategoria1;
    }
    
    @Override
    public void setKategoria1(String kategoria1)
    {
        this.kategoria1 = kategoria1;
    }
    
    @Override
    public String getKategoria2()
    {
        return kategoria2;
    }
    
    @Override
    public void setKategoria2(String kategoria2)
    {
        this.kategoria2 = kategoria2;
    }
    
    @Override
    public String getKategoria3()
    {
        return kategoria3;
    }
    
    @Override
    public void setKategoria3(String kategoria3)
    {
        this.kategoria3 = kategoria3;
    }
    
    @Override
    public String getKategoria4()
    {
        return kategoria4;
    }
    
    @Override
    public void setKategoria4(String kategoria4)
    {
        this.kategoria4 = kategoria4;
    }
    
    @Override
    public String getKategoria5()
    {
        return kategoria5;
    }
    
    @Override
    public void setKategoria5(String kategoria5)
    {
        this.kategoria5 = kategoria5;
    }
    
    public Produkty(){}
    
    public Produkty(String produkt, String ilosc, String kategoria1, 
                    String kategoria2, String kategoria3, String kategoria4,
                    String kategoria5)
    {
        this.produkt = produkt;
        this.ilosc = ilosc;
        this.kategoria1 = kategoria1;
        this.kategoria2 = kategoria2;
        this.kategoria3 = kategoria3;
        this.kategoria4 = kategoria4;
        this.kategoria5 = kategoria5;
    }
    
    @Override
    public String toString()
    {
        return produkt+", ilość: "+ilosc+", kategorie: "+kategoria1+" "+kategoria2+" "+kategoria3+" "+kategoria4+" "+kategoria5 ;
    }
    
}
