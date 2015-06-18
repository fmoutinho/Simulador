

/**
 *
 * @author 
 */
public class ExecutaEvt extends Evento {

    private final Processo p;

    /**
     *
     * @param t
     * @param p
     * @param e
     */
    public ExecutaEvt(int t, Processo p, Estruturas e) {
        this.t = t;
        this.p = p;
        this.estrutura = e;
        this.id = 4;
    }

    /**
     *
     */
    @Override
    public void run() {

        Processo p2 = estrutura.cpuCheck();
        if (p2 != null) {

            Evento e2 = estrutura.removeEventoTermina(p2);
            int tRestante = e2.getT() - t;
            p2.setTempoRestante(tRestante);
            estrutura.addFilaEscalonador(p2);
            estrutura.getLogAtual().setTempoSaida(t);
            estrutura.getLogAtual().setTermino(0);

        }

        estrutura.addCpu(p);
        LogLine l = new LogLine(t, p.getId());
        estrutura.addLogLine(l);
        int tExec;
        if (p.getTempoRestante() == -1) {
            tExec = p.getTempoExec();
        } else {
            tExec = p.getTempoRestante();
        }

        TerminaEvt te = new TerminaEvt(t + tExec, p, estrutura);
        estrutura.addEvento(te);

    }

}
