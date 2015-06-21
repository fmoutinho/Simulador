
import java.io.IOException;

/**
 *
 * @author
 */
public class Simulador {

    private Estruturas estrutura;

    public Simulador() {

    }

    /**
     *
     * @throws IOException
     */
    public void run() throws IOException {
        Config config = new Config();
        config.loadConfig();
        if (config.getErro() == 0) {
            this.estrutura = new Estruturas(config);

            Carregador c = new Carregador(estrutura);
            c.run();

            int idEscalonador = estrutura.getConfig().getIdEscalonador();
            //Cria Factory
            EscalonadorFactory factory = new EscalonadorFactory(estrutura);
            //Cria Escalonador pedido na config e coloca na estrurura.
            estrutura.setEscalonador(factory.getEscalonador(idEscalonador));

            BuscadorDeEventos b = new BuscadorDeEventos(estrutura);
            b.run();

            Saida saida = new Saida(estrutura);
            saida.printLog();

            if (estrutura.getConfig().getPlot() == 1) {
                saida.geraPlot();
            }

        }

    }

}
