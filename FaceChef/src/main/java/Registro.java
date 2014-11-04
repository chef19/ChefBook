
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.swing.JOptionPane;
import javax.validation.constraints.NotNull;

@Named (value="Registro")
@RequestScoped
public class Registro {
    @NotNull
    private String b;
    @NotNull
    private String c;
    @NotNull
    private String d;
    
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
    
    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
    
    public void mensaje (){
        ArrayList list = new ArrayList();
        list.add(this.b);
        list.add(this.c);
        list.add(this.d);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(b+" "+c+" "+d));
    }
    
}
