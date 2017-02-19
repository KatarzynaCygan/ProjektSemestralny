/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kreator_zakupow;

import static com.sun.javafx.binding.ContentBinding.bind;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import kreator_zakupow.StringTrigger;
import BazaDanych.*;
import ModeleTabel.*;
import java.util.LinkedList;
import java.util.List;
import javafx.collections.ListChangeListener;
import javafx.scene.control.FocusModel;

/**
 * FXML Controller class
 *
 * @author Kasia
 */
public class WidokController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ChoiceBox wyborPKS;
    @FXML
    private Button btnDodaj;
    @FXML
    private Button btnUsun;
    @FXML
    private Button btnEdytuj;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label label8;
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private TextField text3;
    @FXML
    private TextField text4;
    @FXML
    private TextField text5;
    @FXML
    private TextField text6;
    @FXML
    private TextField text7;
    @FXML
    private TextField text8;
    @FXML
    private ChoiceBox wyborKS;
    @FXML
    private ComboBox wyborK;
    @FXML
    private ComboBox wyborNS;
    @FXML
    private Button btnSortuj;
    @FXML
    private ChoiceBox wyborPKSKS;
    @FXML
    private ComboBox wyborNSK;
    @FXML
    private Button btnWyswietl;
    @FXML
    private ChoiceBox wyborPKSA;
    @FXML
    private TextField txtSzukana;
    @FXML
    private Button btnWyszukaj;
    @FXML
    private ListView listaView;
    
    ITabele tabele;
    ITabelePokaz tPokaz;
    
    StringTrigger kolumna1;
    
    ObservableList<String> wPKS = FXCollections.observableArrayList("Produkt","Kategoria", "Sklep", "Edytuj dane", "Edytuj kategorie");
    ObservableList<String> wPKSKS = FXCollections.observableArrayList("Produkty","Kategorie", "Sklepy", "Nazwa Sklepu(ustaw poniżej)");
    ObservableList<String> wPKSA = FXCollections.observableArrayList("Produkt","Kategoria", "Sklep", "Adres");
    ObservableList<String> wKS = FXCollections.observableArrayList("Kategoria", "Sklep");
    ObservableList<Produkty> PRODUKTY;
    ObservableList<String> KATEGORIE;
    ObservableList<Sklepy> SKLEPY;
    ObservableList<String> NAZWASKLEPU;
    ObservableList<Produkty> szukajPRODUKTY;
    ObservableList<String> szukajKATEGORIE;
    ObservableList<Sklepy> szukajSKLEPY;
    ObservableList<Sklepy> szukajADRES;
    ObservableList<Produkty> pokazKategoria;
    ObservableList<Produkty> pokazSklepy;
    List<String> k ;
    List<Produkty> p;
    List<Sklepy> s;
    List<String> n;
    
    List<String> kszukaj = new LinkedList<String>() ;
    List<Produkty> pszukaj = new LinkedList<Produkty>() ;
    List<Sklepy> sszukaj = new LinkedList<Sklepy>() ;
    List<Sklepy> aszukaj = new LinkedList<Sklepy>() ;
    List<Produkty> kpokaz = new LinkedList<Produkty>();
    List<Produkty> nspokaz = new LinkedList<Produkty>();
    
    int IndeksWPKS = 0;
    int IndeksWPKSKS = 0;
    int IndekswyborNSK = 0;
    int IndeksPKSA = 0;
    int IndeksKS = 0;
    int IndekswyborK = 0;
    int IndekswyborNS = 0;
    
    boolean CzyNazwaSklepu = false;
    boolean CzyNSK = false;
    boolean CzyPKSA = false;
    
    String NazwaSklepu = "";
    String KategoriaPKSA = "";
    String KategoriaK = ""; 
    String NazwaSklepuS = "";
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tabele = new Tabele();
        tabele.Connection();
        tabele.closeConnection();
        tPokaz = new TabelePokaz();
        tPokaz.Connection();
        p = tPokaz.pokazProdukty();
        PRODUKTY = FXCollections.observableList(p);
        k = tPokaz.pokazKategorie();
        KATEGORIE = FXCollections.observableList(k); 
        s = tPokaz.pokazSklep();
        SKLEPY = FXCollections.observableList(s);
        pokazKategoria = FXCollections.observableList(kpokaz);
        pokazSklepy = FXCollections.observableList(nspokaz);
        tPokaz.closeConnection();
        ITabeleSzukaj iszukaj = new TabeleSzukaj();
        iszukaj.Connection();
        szukajPRODUKTY = FXCollections.observableList(pszukaj);
        szukajKATEGORIE = FXCollections.observableList(kszukaj);
        szukajSKLEPY = FXCollections.observableList(sszukaj);
        szukajADRES = FXCollections.observableList(aszukaj);
        iszukaj.closeConnection();
        
        SKLEPY.addListener(new ListChangeListener(){
            @Override
            public void onChanged(ListChangeListener.Change c) {
                tPokaz.Connection();
                s.clear();
                s = tPokaz.pokazSklep();
                SKLEPY = FXCollections.observableList(s);
                tPokaz.closeConnection();
            }
        });
        KATEGORIE.addListener(new ListChangeListener(){
            @Override
            public void onChanged(ListChangeListener.Change c) {
                tPokaz.Connection();
                k.clear();
                k = tPokaz.pokazKategorie();
                KATEGORIE = FXCollections.observableList(k);
                tPokaz.closeConnection();
            }
        });
               



        
        wyborPKS.setItems(wPKS);
        wyborPKSKS.setItems(wPKSKS);
        wyborNSK.setItems(SKLEPY);
        wyborPKSA.setItems(wPKSA);
        wyborKS.setItems(wKS);
        wyborK.setItems(KATEGORIE);
        wyborNS.setItems(SKLEPY);
        
        
        
        wyborPKS.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int number = -1;
                number = (int) newValue;
                IndeksWPKS = number;
                switch(number)
                {
                    case 0:
                        label1.setText("Produkt");
                        label2.setText("Ilość");
                        label3.setText("Kategoria 1");
                        text3.setPromptText("");
                        label4.setText("Kategoria 2");
                        label5.setText("Kategoria 3");
                        label6.setText("Kategoria 4");
                        label7.setText("Kategoria 5");
                        label8.setText("");
                        
                    break;
                    
                    case 1:
                        label1.setText("Kategoria");
                        label2.setText("");
                        label3.setText("");
                        text3.setPromptText("");
                        label4.setText("");
                        label5.setText("");
                        label6.setText("");
                        label7.setText("");
                        label8.setText("");
                        text4.setPromptText("");
                        text5.setPromptText("");
                        text6.setPromptText("");
                        text7.setPromptText("");
                        text8.setPromptText("");
                        
                    break;
                    
                    case 2:
                        label1.setText("Sklep");
                        label2.setText("Adres");
                        label3.setText("Kategoria");
                        text3.setPromptText("");
                        label4.setText("");
                        label5.setText("");
                        label6.setText("");
                        label7.setText("");
                        label8.setText("");
                        text4.setPromptText("");
                        text5.setPromptText("");
                        text6.setPromptText("");
                        text7.setPromptText("");
                        text8.setPromptText("");
                        
                        break;
                        
                    case 3:
                        label1.setText("Stara nazwa produktu");
                        label2.setText("Nowa nazwa produktu");
                        label3.setText("Dla poroduktu poniżej");
                        text3.setPromptText("aktualna lub nowa nazwa");
                        label4.setText("Ustal ilość");
                        label5.setText("Ustal starą kategorię");
                        label6.setText("Ustal nową kategorię");
                        label7.setText("Dla sklepu poniżej");
                        label8.setText("Ustaw adres");
                        text4.setPromptText("");
                        text5.setPromptText("");
                        text6.setPromptText("");
                        text7.setPromptText("");
                        text8.setPromptText("");
                        break;
                        
                    case 4:
                        label1.setText("W Kategoriach: stara kategoria");
                        label2.setText("Nowa kategoria");
                        label3.setText("Kategoria dla produku: produkt");
                        text3.setPromptText("");
                        label4.setText("Kategoria 1");
                        text4.setPromptText("dodaj/zmień kategorię");
                        label5.setText("Kategoria 2");
                        text5.setPromptText("dodaj/zmień kategorię");
                        label6.setText("Kategoria 3");
                        text6.setPromptText("dodaj/zmień kategorię");
                        label7.setText("Kategoria 4");
                        text7.setPromptText("dodaj/zmień kategorię");
                        label8.setText("Kategoria 5");
                        text8.setPromptText("dodaj/zmień kategorię");
                        break;

                    default:
                        break;
                }
            }
            });
        
        wyborPKSKS.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int number = -1;
                number = (int) newValue;
                IndeksWPKSKS = number;
                switch(IndeksWPKSKS)
                {
                    case 0:
                       listaView.setItems(PRODUKTY);
                       CzyNazwaSklepu = false;
                        break;
                    case 1:
                        listaView.setItems(KATEGORIE);
                        CzyNazwaSklepu = false;
                        break;
                    case 2:
                        listaView.setItems(SKLEPY);
                        CzyNazwaSklepu = false;
                        break;
                    case 3:
                        CzyNazwaSklepu = true;
                        break;
                    default:
                        break;
                }
            }
        });
        
        wyborPKSA.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int number = -1;
                number = (int) newValue;
                IndeksPKSA = number;
                CzyPKSA = true;
                
            }
        });
     
     wyborKS.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int number = -1;
                number = (int) newValue;
                IndeksKS = number;
                
            }
        });
        
        
        
    }
    
    
    public void combowyborNSK(ActionEvent event){
    wyborNSK.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            
            int number = -1;
            number = (int) newValue;
            IndekswyborNSK = number;
            
            ISklepy sklep = new Sklepy();
            
            
            CzyNSK = true;
            
            if(CzyNazwaSklepu)
            {
                sklep = SKLEPY.get(IndekswyborNSK);
                NazwaSklepu = sklep.getNazwaSklepu();
   
            }
        }
    });    
    }
    
    public void combowyborK(ActionEvent event)
    {
        wyborK.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            
            int number = -1;
            number = (int) newValue;
            IndekswyborK = number;
            

            KategoriaK = KATEGORIE.get(IndekswyborK);
            
   
            
        }
    });    
    }
    
    public void combowyborNS(ActionEvent event)
    {
        wyborNSK.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            
            int number = -1;
            number = (int) newValue;
            IndekswyborNS = number;
            
            ISklepy sklep = new Sklepy();
            
            
            
            
            
                sklep = SKLEPY.get(IndekswyborNS);
                NazwaSklepuS = sklep.getNazwaSklepu();
   
            
        }
    });  
    }
    
    public void buttonDodaj(ActionEvent event)
    {
        ITabeleInserts tDodaj;
        tDodaj = new TabeleInserts();
        tDodaj.Connection();
        
        switch(IndeksWPKS)
        {
            case 0:
               String produkt;
               String ilosc;
               String kat1;
               String kat2;
               String kat3;
               String kat4;
               String kat5;
               produkt = text1.getText();
               ilosc = text2.getText();
               kat1 = text3.getText();
               kat2 = text4.getText();
               kat3 = text5.getText();
               kat4 = text6.getText();
               kat5 = text7.getText();
               
               if(produkt!=null && produkt!="")
               {tDodaj.insertProdukt(produkt, ilosc, kat1, kat2, kat3, kat4, kat5);}
               
               tPokaz.Connection();
               p.clear();
               p = tPokaz.pokazProdukty();
               PRODUKTY = FXCollections.observableList(p);
                
               tPokaz.closeConnection();
               break;
            case 1:
                String kategoria;
                kategoria = text1.getText();
                
                if(kategoria!=null && kategoria!="")
                {tDodaj.insertKategoria(kategoria);}
                
                tPokaz.Connection();
                k.clear();
                wyborK.setItems(KATEGORIE);
                k = tPokaz.pokazKategorie();
                KATEGORIE = FXCollections.observableList(k); 
       
                tPokaz.closeConnection();
                wyborK.setItems(KATEGORIE);
                break;
            case 2:
                String sklep;
                String adres;
                String kategoriasklepu;
                sklep = text1.getText();
                adres = text2.getText();
                kategoriasklepu = text3.getText();
                
                if(sklep!=null && sklep!="")
                {
                    tDodaj.insertSklep(sklep, adres);
                    tDodaj.createTabelaNazwaSklepu(sklep);
                }
                if(sklep!=null && sklep!="")
                {
                    tDodaj.insertKategoriaNazwaSklepu(sklep, kategoriasklepu);
                }
                
                tPokaz.Connection();
                s.removeAll(s);
                wyborNSK.setItems(SKLEPY);
                wyborNS.setItems(SKLEPY);
                 s = tPokaz.pokazSklep();
                SKLEPY = FXCollections.observableList(s);
                tPokaz.closeConnection();
                wyborNSK.setItems(SKLEPY);
                wyborNS.setItems(SKLEPY);
                break;
            default:
                   break; 
            
        }
        tDodaj.closeConnection();
    }
    public void buttonUsun(ActionEvent event)
    {
        ITabeleDelete tUsun;
        tUsun = new TabeleDelete();
        tUsun.Connection();
        
        switch(IndeksWPKS)
        {
            case 0:
               String produkt;
               produkt = text1.getText();
               
               if(produkt!=null && produkt!="")
               tUsun.deleteProdukt(produkt);
               tPokaz.Connection();
               p.clear();
                p = tPokaz.pokazProdukty();
                PRODUKTY = FXCollections.observableList(p);
                tPokaz.closeConnection();
               break;
            case 1:
                String kategoria;
                kategoria = text1.getText();
                
                if(kategoria!=null && kategoria!="")
                    tUsun.deleteKategoria(kategoria);
                
                tPokaz.Connection();
                k.clear();
                wyborK.setItems(KATEGORIE);
                k = tPokaz.pokazKategorie();
                KATEGORIE = FXCollections.observableList(k); 
                tPokaz.closeConnection();
                wyborK.setItems(KATEGORIE);
               break;
            case 2:
                String sklep;
                String skategoria;
                sklep = text1.getText();
                skategoria = text3.getText();
                
                if(sklep!=null && sklep!="")
                tUsun.deleteSklep(sklep);
                
                if(sklep!=null && sklep!="" && skategoria!=null && skategoria!="")
                    tUsun.deleteKategoriaSklepu(sklep, skategoria);
                
                tPokaz.Connection();
                s.removeAll(s);
                wyborNSK.setItems(SKLEPY);
                wyborNS.setItems(SKLEPY);
                s = tPokaz.pokazSklep();
                SKLEPY = FXCollections.observableList(s);
                tPokaz.closeConnection();
                wyborNSK.setItems(SKLEPY);
                wyborNS.setItems(SKLEPY);
                break;
            default:
                break;
        }
        tUsun.closeConnection();
    }
    public void buttonEdytuj(ActionEvent event)
    {
        ITabeleUpdate tEdytuj;
        tEdytuj = new TabeleUpdate();
        tEdytuj.Connection();
        
        switch(IndeksWPKS)
        {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                String sprodukt;
                String nprodukt;
                String produkt;
                String skategoria;
                String nkategoria;
                String ilosc;
                String sklep;
                String adres;
                sprodukt = text1.getText();
                nprodukt = text2.getText();
                produkt = text3.getText();
                ilosc = text4.getText();
                skategoria = text5.getText();
                nkategoria = text6.getText();
                sklep = text7.getText();
                adres = text8.getText();
                
                if(sprodukt!=null && nprodukt!=null)
                {
                    if(sprodukt!="" && nprodukt!="")
                        tEdytuj.updateProduktyProdukt(sprodukt, nprodukt);
                    
                }
                
                if(produkt!=null && ilosc!=null)
                {
                    if(produkt!="" && ilosc!="")
                        tEdytuj.updateProduktyIlosc(produkt, ilosc);
                    
                }
                if(produkt!=null && skategoria!=null && nkategoria!=null)
                {
                    if(produkt!="" && skategoria!="" && nkategoria!="")
                        tEdytuj.updateProduktyKategoria(produkt, skategoria, nkategoria);
                    
                }
                if(sklep!=null && adres!=null)
                {
                    if(sklep!="" && adres!="")
                        tEdytuj.updateSklepyAdres(sklep, adres);  
                }
                
                tPokaz.Connection();
                p.clear();
                p = tPokaz.pokazProdukty();
                PRODUKTY = FXCollections.observableList(p);
                k.clear();
                wyborK.setItems(KATEGORIE);
                k = tPokaz.pokazKategorie();
                KATEGORIE = FXCollections.observableList(k); 
                s.removeAll(s);
                wyborNSK.setItems(SKLEPY);
                wyborNS.setItems(SKLEPY);
                s = tPokaz.pokazSklep();
                SKLEPY = FXCollections.observableList(s);
                tPokaz.closeConnection();
                wyborNSK.setItems(SKLEPY);
                wyborNS.setItems(SKLEPY);
                wyborK.setItems(KATEGORIE);
                break;
            case 4:
                String Skategoria;
                String Nkategoria;
                String Produkt;
                String kat1;
                String kat2;
                String kat3;
                String kat4;
                String kat5;
                Skategoria = text1.getText();
                Nkategoria = text2.getText();
                Produkt = text3.getText();
                kat1 = text4.getText();
                kat2 = text5.getText();
                kat3 = text6.getText();
                kat4 = text7.getText();
                kat5 = text8.getText();
                
                if(Skategoria!=null)
                {
                        tEdytuj.updateKtegoriaKategoria(Skategoria, Nkategoria);
                    
                }
                
                if(Produkt!=null)
                {
                        tEdytuj.updateProduktyKat1(Produkt, kat1);
                    
                }
                
                if(Produkt!=null)
                {
                        tEdytuj.updateProduktyKat2(Produkt, kat2);
                    
                }
                
                if(Produkt!=null)
                {
                        tEdytuj.updateProduktyKat3(Produkt, kat3);
                    
                }
                
                if(Produkt!=null)
                {
                        tEdytuj.updateProduktyKat4(Produkt, kat4);
                    
                }
                
                if(Produkt!=null)
                {
                        tEdytuj.updateProduktyKat5(Produkt, kat5);
                    
                }
                tPokaz.Connection();
                p.clear();
                p = tPokaz.pokazProdukty();
                PRODUKTY = FXCollections.observableList(p);
                k.clear();
                wyborK.setItems(KATEGORIE);
                k = tPokaz.pokazKategorie();
                KATEGORIE = FXCollections.observableList(k); 
                tPokaz.closeConnection();
                wyborK.setItems(KATEGORIE);
                break;
            default:
                break;
        }
        tEdytuj.closeConnection();
    }
    
    
    public void buttonSortuj(ActionEvent event)
    {
        ITabeleSzukaj tabProd = new TabeleSzukaj();
        
        switch(IndeksKS)
                {
                    case 0:
                       tabProd.Connection();
                        kpokaz = tabProd.szukajProduktyDlaKategorii(KategoriaK);
                        tabProd.closeConnection();
                        pokazKategoria = FXCollections.observableList(kpokaz);
                        //NAZWASKLEPU = FXCollections.observableArrayList("kogut", "małpa");
                        listaView.setItems(pokazKategoria);

                        break;
                    case 1:
                        tabProd.Connection();
                        nspokaz = tabProd.szukajProduktDlaSklepu(NazwaSklepuS);
                        tabProd.closeConnection();
                        pokazSklepy = FXCollections.observableList(nspokaz);
                        //NAZWASKLEPU = FXCollections.observableArrayList("kogut", "małpa");
                        listaView.setItems(pokazSklepy);

                        break;

                    default:
                        break;
                }
             tabProd.Connection();
                
             
    }
    public void buttonWyswietl(ActionEvent event)
    {
        /*if(CzyNazwaSklepu && CzyNSK)
        {*/
            ITabelePokaz tabP = new TabelePokaz();
             tabP.Connection();
                n = tabP.pokazNazwaSklepu(NazwaSklepu);
                tabP.closeConnection();
                NAZWASKLEPU = FXCollections.observableList(n);
                //NAZWASKLEPU = FXCollections.observableArrayList("kogut", "małpa");
                listaView.setItems(NAZWASKLEPU);
   // }
    }
    public void buttonWyszukaj(ActionEvent event){
    
        ITabeleSzukaj szukaj = new TabeleSzukaj();
        
        
            switch(IndeksPKSA)
                {
                    case 0:
                        String produkt;
                        produkt = txtSzukana.getText();
                        
                      szukaj.Connection();
                      pszukaj.clear();
                      pszukaj = szukaj.szukajProdukt(produkt);
                      szukajPRODUKTY = FXCollections.observableList(pszukaj);
                      szukaj.closeConnection();
                      listaView.setItems(szukajPRODUKTY);
                        break;
                    case 1:
                        String kategoria;
                        kategoria = txtSzukana.getText();
                        
                      szukaj.Connection();
                      kszukaj.clear();
                      kszukaj = szukaj.szukajKategorie(kategoria);
                        szukajKATEGORIE = FXCollections.observableList(kszukaj);
                      szukaj.closeConnection();
                      listaView.setItems(szukajKATEGORIE);
                        break;
                    case 2:
                        String sklep;
                        sklep = txtSzukana.getText();
                        
                      szukaj.Connection();
                      sszukaj.clear();
                      sszukaj = szukaj.szukajSklep(sklep);
                        szukajSKLEPY = FXCollections.observableList(sszukaj);
                      szukaj.closeConnection();
                      listaView.setItems(szukajSKLEPY);
                        break;
                    case 3:
                        String adres;
                        adres = txtSzukana.getText();
                        szukaj.Connection();
                      aszukaj.clear();
                      aszukaj = szukaj.szukajAdres(adres);
                        szukajADRES = FXCollections.observableList(aszukaj);
                      szukaj.closeConnection();
                      listaView.setItems(szukajADRES);
                        break;
                    default:
                        break;
                }
        
    }



    
}
