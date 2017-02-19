
package kreator_zakupow;
/**
 *
 * @author Kasia
 */
import javafx.beans.property.*;
        
public class StringTrigger{
    
    private StringProperty tekst;
    
    public final void setStringTrigger(String tekst)
    {
        
        
        this.StringTekstProperty().set(tekst);
    }
    
    public final StringProperty StringTekstProperty()
    {
        if(tekst == null)
            tekst = new SimpleStringProperty("");
        
        return tekst;
    }
    
    public final String getStringTrigger()
    {
        if(tekst != null)
        return tekst.get();
        return "";
    }
    
}
