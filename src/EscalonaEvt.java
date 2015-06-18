
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class EscalonaEvt extends Evento {

    /**
     *
     * @param t
     * @param e
     */
    public EscalonaEvt(int t, Estruturas e) {
        this.t = t;
        this.estrutura = e;
        this.id = 3;
    }

    /**
     *
     */
    @Override
    public void run() {

        if (estrutura.getConfig().getEscalonador() == 1) {
            escalonaFifo();
        } else {
            JOptionPane.showMessageDialog(null, "Escalonador não suportado.\n\nAltere o parâmetro 'schet_type' em 'config.txt'.");
            estrutura.setErro(1);
        }

    }

    /**
     *
     *
     */
    private void escalonaFifo() {

        esvaziaFilaEscalonadorFifo();

        Processo p = proximoProcessoFifo();
        if (p != null) {

            ExecutaEvt e = new ExecutaEvt(t, p, estrutura);
            estrutura.addEvento(e);
        }

    }

    /**
     *
     * @return
     */
    public Processo proximoProcessoFifo() {

        if (estrutura.isFilaProntosEmpty() || (estrutura.isCpuBusy())) {
            return null;
        } //if(estrutura.filaProntosIsEmpty())return null;
        else {
            Processo r = estrutura.removeProximoPronto();

            return r;
        }
    }

     /**
     *
     *
     */
    private void esvaziaFilaEscalonadorFifo() {

        while (!estrutura.isFilaEscalonadorEmpty()) {

            estrutura.addFilaProntos(estrutura.removeProximoFilaEscalonador());

        }
    }

}
