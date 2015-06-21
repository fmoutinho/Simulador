
/**
 *
 * @author
 */
public class TerminaEvt extends Evento {

    private final Processo p;

    /**
     *
     * @param t
     * @param p
     * @param e
     */
    public TerminaEvt(int t, Processo p, Estruturas e) {
        this.t = t;
        this.p = p;
        this.estrutura = e;
        this.id = 1;
    }

    /**
     *
     */
    @Override
    public void run() {
        estrutura.removeCPU();

        EscalonaEvt e = new EscalonaEvt(t, estrutura);
        estrutura.addEvento(e);
        estrutura.getLogAtual().setTempoSaida(t);
        estrutura.getLogAtual().setTermino(1);

    }

    /**
     *
     * @return
     */
    @Override
    public Processo getP() {
        return p;
    }

}
