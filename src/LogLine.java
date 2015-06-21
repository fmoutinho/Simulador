
/** Classe que modela o a linha do log com com as informacoes de saida
 *
 * @author
 */
public class LogLine {

    private final int tempoEntrada, id;
    private int tempoSaida, termino;

    /**
     *
     * @param tempoEntrada
     * @param id
     */
    public LogLine(int tempoEntrada, int id) {
        this.tempoEntrada = tempoEntrada;
        this.id = id;
    }

    /**
     *
     * @param tempoSaida
     */
    public void setTempoSaida(int tempoSaida) {
        this.tempoSaida = tempoSaida;
    }

    /**
     *
     * @param termino
     */
    public void setTermino(int termino) {
        this.termino = termino;
    }

    /**
     *
     * @return
     */
    public int getTempoEntrada() {
        return tempoEntrada;
    }

    /**
     *
     * @return
     */
    public int getTempoSaida() {
        return tempoSaida;
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
    public int getTermino() {
        return termino;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(tempoEntrada);
        sb.append(" ");
        sb.append(tempoSaida);
        sb.append(" ");
        sb.append(id);
        sb.append(" ");
        sb.append(termino);

        return sb.toString();
    }

}
