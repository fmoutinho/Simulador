
/** Classe que modela a linha do log com com as informacoes de saida
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
     *  Define o tempo de saida de uma linha do log
     * @param tempoSaida
     */
    public void setTempoSaida(int tempoSaida) {
        this.tempoSaida = tempoSaida;
    }

    /**
     *  Seta 1 se o processo tiver terminado naquele momento
     * @param termino 1 para termino 0 para nao termino
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
     * Converte as informacoes da linha do log para string
     * @return String de uma linha do log
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
