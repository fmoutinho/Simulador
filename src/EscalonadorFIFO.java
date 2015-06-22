
/**
 * Classe que modela a politica de escalonamento FIFO
 * @author gvpm
 */
public class EscalonadorFIFO extends Escalonador {

    /**
     *
     * @param e
     */
    public EscalonadorFIFO(Estruturas e) {
        super(e);
    }

    @Override
    /**
     * Metodo esvazia a fila do escalonador colocando os processos na fila de 
     * 'Prontos'
     */
    public void esvaziaFilaEscalonador() {
        while (!estrutura.isFilaEscalonadorEmpty()) {

            estrutura.addFilaProntos(estrutura.removeProximoFilaEscalonador());

        }
    }

    @Override
    /**
     * Metodo checa se a fila de 'Prontos' esta vazia ou se o CPU esta ocupado
     * senao remove o proximo processo 'Pronto'
     */
    public Processo proximoProcesso() {
        if (estrutura.isFilaProntosEmpty() || (estrutura.isCpuBusy())) {
            return null;
        } //if(estrutura.filaProntosIsEmpty())return null;
        else {
            Processo r = estrutura.removeProximoPronto();

            return r;
        }
    }

}
