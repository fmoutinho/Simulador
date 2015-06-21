
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class Carregador {

    private final Estruturas estrutura;

    /**
     *
     * @param estrutura
     */
    public Carregador(Estruturas estrutura) {
        this.estrutura = estrutura;
    }

    /**
     *
     * @throws IOException
     */
    public void run() throws IOException {

        int id, tempoChegada, tempoExec;

        FileReader f;
        try {
            f = new FileReader(estrutura.getConfig().getEntrada());

            BufferedReader b;
            b = new BufferedReader(f);
            boolean eof = false;

            while (!eof) {

                String line = b.readLine();

                if (line == null) {
                    eof = true;

                } else if (!line.isEmpty()) {
                    String[] sv = line.split(" ");

                    id = Integer.parseInt(sv[0]);
                    tempoChegada = Integer.parseInt(sv[1]);
                    tempoExec = Integer.parseInt(sv[2]);

                    Processo p = new Processo(id, tempoChegada, tempoExec);
                    ChegaEvt c = new ChegaEvt(p.getTempoChegada(), p, estrutura);
                    estrutura.addEvento(c);
                }

            }
            b.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo " + "'" + estrutura.getConfig().getEntrada() + "' não encontrado.\n\nVerifique o parâmetro 'input' em 'config.txt'.");
            estrutura.setErro(2);
        }

    }

}
