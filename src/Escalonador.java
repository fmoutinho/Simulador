/*

 /**
 *
 * @author gvpm
 */

public abstract class Escalonador {

    Estruturas estrutura;

    /**
     *
     * @param e estrutura a aplicar o escalonador
     */
    public Escalonador(Estruturas e) {

        this.estrutura = e;

    }

    /**
     *
     * @param t tempo da simulacao para escalonar
     */
    public void escalona(int t) {

        esvaziaFilaEscalonador();

        Processo p = proximoProcesso();

        if (p != null) {

            ExecutaEvt e = new ExecutaEvt(t, p, estrutura);
            estrutura.addEvento(e);
        }

    }

    /**
     *
     */
    public abstract void esvaziaFilaEscalonador();

    /**
     *
     * @return Proximo processo de acordo com a politica usada
     */
    public abstract Processo proximoProcesso();
}
