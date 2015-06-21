
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class BuscadorDeEventos {

    private final Estruturas estrutura;

    /**
     *
     * @param estrutura
     */
    public BuscadorDeEventos(Estruturas estrutura) {
        this.estrutura = estrutura;
    }

    /**
     *
     */
    public void run() {

        while (!estrutura.isFilaEventosEmpty()) {
            Evento ev = estrutura.removeProxEvento();
            ev.run();
        }
        if (estrutura.getErro() == 0 && estrutura.getConfig().getErro() == 0) {
            JOptionPane.showMessageDialog(null, "Simulação Finalizada\nArquivo 'output.txt' criado.");
        }

    }

}
