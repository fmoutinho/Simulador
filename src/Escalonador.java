/*

/**
 *
 * @author gvpm
 */
public abstract class Escalonador {
    
    int t;

    Estruturas estrutura;
    
    /**
     *
     * @param t
     * @param e
     */
    public Escalonador(int t, Estruturas e) {
        this.t = t;
        this.estrutura = e;
        
    }
    
    /**
     *
     */
    public void escalona(){
        
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
