
/**
 * Classe que modela o Processo
 *
 * @author gvpm
 */
public class Processo {

    private final int id;
    private final int tempoChegada;
    private final int tempoExec;
    private int tempoRestante;

    /**
     *
     * @param id
     * @param tempoChegada
     * @param tempoExec
     */
    public Processo(int id, int tempoChegada, int tempoExec) {
        this.id = id;
        this.tempoChegada = tempoChegada;
        this.tempoExec = tempoExec;
        this.tempoRestante = tempoExec;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public int getTempoChegada() {
        return tempoChegada;
    }

    /**
     *
     * @return
     */
    public int getTempoExec() {
        return tempoExec;
    }

    /**
     *
     * @return
     */
    public int getTempoRestante() {
        return tempoRestante;
    }

    /**
     *
     * @param tempoRestante
     */
    public void setTempoRestante(int tempoRestante) {
        this.tempoRestante = tempoRestante;
    }

}
