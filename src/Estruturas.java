
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author
 */
public class Estruturas {

    private final List<Evento> filaEventos;
    private final List<Processo> filaEscalonador;
    private final List<Processo> filaProntos;
    private Processo cpu;
    private final List<LogLine> log;
    private final Config config;
    private int erro;
    private Escalonador escalonador;

    /**
     *
     * @param c configuracao a ser utilizada na simulacao
     */
    public Estruturas(Config c) {

        this.filaEventos = new LinkedList<>();
        this.filaEscalonador = new LinkedList<>();
        this.filaProntos = new LinkedList<>();
        this.log = new LinkedList<>();
        this.cpu = null;
        this.config = c;
        this.erro = 0;

    }

    public List<LogLine> getLog() {
        return log;
    }

    /**
     *
     * @return
     */
    public int getErro() {
        return erro;
    }

    public List<Processo> getFilaProntos() {
        return filaProntos;
    }

    public void setEscalonador(Escalonador e) {
        this.escalonador = e;
    }

    public Escalonador getEscalonador() {
        return escalonador;
    }

    /**
     *
     * @param erro
     */
    public void setErro(int erro) {
        this.erro = erro;
    }

    /**
     *
     * @param e
     */
    public void addEvento(Evento e) {
        ListIterator li = filaEventos.listIterator();
        int cont = 0;

        if (e.getId() == 3) {

            while (li.hasNext()) {
                Evento ee = (Evento) li.next();
                if ((ee.getId() == 3) && (ee.getT() == e.getT())) {
                    cont = 1;
                }

            }
        }

        if (cont == 0) {
            filaEventos.add(e);
        }
        //if(cont==1)System.out.println("Ja tem");

        filaEventos.sort(e);
    }

    /**
     *
     * @return
     */
    public Evento removeProxEvento() {

        return filaEventos.remove(0);

    }

    /**
     *
     * @param p
     * @return
     */
    public Evento removeEventoTermina(Processo p) {
        ListIterator li = filaEventos.listIterator();
        Evento ee = null;
        while (li.hasNext()) {
            ee = (Evento) li.next();
            if ((ee.getId() == 1) && (ee.getP().equals(p))) {
                filaEventos.remove(ee);
                return ee;
            }

        }

        return ee;
    }

    /**
     *
     * @return
     */
    public boolean isFilaEventosEmpty() {
        return filaEventos.isEmpty();

    }

    /**
     *
     * @param p
     */
    public void addFilaEscalonador(Processo p) {

        filaEscalonador.add(p);
    }

    /**
     *
     * @return
     */
    public Processo removeProximoFilaEscalonador() {
        return filaEscalonador.remove(0);

    }

    /**
     *
     * @return
     */
    public boolean isFilaEscalonadorEmpty() {
        return filaEscalonador.isEmpty();

    }

    /**
     *
     * @param p
     */
    public void addFilaProntos(Processo p) {
        filaProntos.add(p);
    }

    /**
     *
     * @return
     */
    public Processo removeProximoPronto() {
        return filaProntos.remove(0);

    }

    /**
     *
     * @return
     */
    public Processo removeMenorTempoRestantePronto() {
        int tamanho = filaProntos.size();
        int min = 0;
        int minIndex = 0;
        for (int i = 0; i < tamanho; i++) {
            if (i == 0) {
                min = filaProntos.get(i).getTempoRestante();
                minIndex = 0;
            } else if (filaProntos.get(i).getTempoRestante() < min) {
                min = filaProntos.get(i).getTempoRestante();
                minIndex = i;

            }

        }

        return filaProntos.remove(minIndex);

    }

    /**
     *
     * @return
     */
    public boolean isFilaProntosEmpty() {
        return filaProntos.isEmpty();

    }

    /**
     *
     *
     */
    void addCpu(Processo p) {
        this.cpu = p;
    }

    /**
     *
     * @return
     */
    public Processo removeCPU() {
        Processo p = cpu;
        cpu = null;
        return p;
    }

    /**
     *
     * @return
     */
    public Processo cpuCheck() {
        Processo p = cpu;
        return p;
    }

    /**
     *
     * @return
     */
    public boolean isCpuBusy() {
        return cpu != null;
    }

    /**
     *
     * @return
     */
    public Config getConfig() {
        return config;
    }

    /**
     *
     * @return
     */
    public LogLine getLogAtual() {

        return log.get(log.size() - 1);

    }

    /**
     *
     * @param l
     */
    public void addLogLine(LogLine l) {
        log.add(l);

    }

}
