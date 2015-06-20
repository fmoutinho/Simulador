
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class EscalonaEvt extends Evento {

    /**
     *
     * @param t
     * @param e
     */
    int idEscalonador;
    Escalonador escalonador;
    
    public EscalonaEvt(int t, Estruturas e) {
        this.t = t;
        this.estrutura = e;
        this.id = 3;
        
    }

    /**
     *
     */
    @Override
    public void run() {            
       

             estrutura.getEscalonador().escalona(t);
      
    }

   

}
