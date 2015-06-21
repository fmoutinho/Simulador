/*

 /**
 *
 * @author gvpm
 */

public abstract class Escalonador {

    Estruturas estrutura;

    /**
     *
     * @param e
     */
    public Escalonador(Estruturas e) {

        this.estrutura = e;

    }

    /**
     *
     * @param t
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
     * @return
     */
    public abstract Processo proximoProcesso();
}
