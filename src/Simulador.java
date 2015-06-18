
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

            BuscadorDeEventos b = new BuscadorDeEventos(estrutura);
            b.run();

            estrutura.printLog();

            if (estrutura.getConfig().getPlot() == 1) {
                estrutura.geraPlot();
            }
        }

    }

}
