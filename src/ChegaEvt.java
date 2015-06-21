
/**
 *
 * @author
 */
public class ChegaEvt extends Evento {

    Processo p;

    /**
     *
     * @param t
     * @param p
     * @param e
     */
    public ChegaEvt(int t, Processo p, Estruturas e) {
        this.t = t;
        this.p = p;
        this.estrutura = e;
        this.id = 2;
    }

    /**
     *
     */
    @Override
    public void run() {
        estrutura.addFilaEscalonador(p);
        EscalonaEvt e = new EscalonaEvt(t, estrutura);
        estrutura.addEvento(e);

    }

}
