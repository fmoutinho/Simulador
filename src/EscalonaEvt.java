
/**
 *
 * @author
 */
public class EscalonaEvt extends Evento {
    
    int idEscalonador;
    Escalonador escalonador;
    /**
     *
     * @param t tempo na simulacao
     * @param e estrutura da simulacao
     */
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
