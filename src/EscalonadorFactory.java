
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Classe delegada a criar as Politicas de Escalonamento
 * @author gvpm
 */
public class EscalonadorFactory {

    Escalonador e;

    Estruturas estrutura;

    public EscalonadorFactory(Estruturas estrutura) {
        this.estrutura = estrutura;
    }
    /**
     * Metodo instancia um politica de escalonamento a partir do valor 
     * do parametro 'id'
     * @param id
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
