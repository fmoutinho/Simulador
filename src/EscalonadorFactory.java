
import javax.swing.JOptionPane;

/**
 * Classe delegada a criar as Politicas de Escalonamento
 *
 * @author gvpm
 */
public class EscalonadorFactory {

    Escalonador e;

    Estruturas estrutura;

    /**
     *
     * @param estrutura
     */
    public EscalonadorFactory(Estruturas estrutura) {
        this.estrutura = estrutura;
    }

    /**
     * Metodo instancia um politica de escalonamento a partir do valor do
     * parametro 'id'
     *
     * @param id id do escalonador na config
     * @return
     */
    public Escalonador getEscalonador(int id) {

        if (id == 1) {
            e = new EscalonadorFIFO(estrutura);
        } else if (id == 2) {
            e = new EscalonadorSJF(estrutura);

        } else {
            JOptionPane.showMessageDialog(null, "Escalonador não suportado.\n\nAltere o parâmetro 'schet_type' em 'config.txt'.");
            estrutura.setErro(1);
            return null;
        }

        return e;

    }
}
