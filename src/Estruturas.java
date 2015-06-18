
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class Estruturas {

    private final List<Evento> filaEventos;
    private final List<Processo> filaEscalonador;
    private final List<Processo> filaProntos;
    private Processo cpu;
    private final List<LogLine> log;
    private final Config config;
    private int erro;

    /**
     *
     * @param c
     */
    public Estruturas(Config c) {

        this.filaEventos = new LinkedList<>();
        this.filaEscalonador = new LinkedList<>();
        this.filaProntos = new LinkedList<>();
        this.log = new LinkedList<>();
        this.cpu = null;
        this.config = c;
        this.erro = 0;

    }

    /**
     *
     * @return
     */
    public int getErro() {
        return erro;
    }

    /**
     *
     * @param erro
     */
    public void setErro(int erro) {
        this.erro = erro;
    }

    /**
     *
     * @param e
     */
    public void addEvento(Evento e) {
        ListIterator li = filaEventos.listIterator();
        int cont = 0;

        if (e.getId() == 3) {

            while (li.hasNext()) {
                Evento ee = (Evento) li.next();
                if ((ee.getId() == 3) && (ee.getT() == e.getT())) {
                    cont = 1;
                }

            }
        }

        if (cont == 0) {
            filaEventos.add(e);
        }
        //if(cont==1)System.out.println("Ja tem");

        filaEventos.sort(e);
    }

    /**
     *
     * @return
     */
    public Evento removeProxEvento() {

        return filaEventos.remove(0);

    }

    /**
     *
     * @param p
     * @return
     */
    public Evento removeEventoTermina(Processo p) {
        ListIterator li = filaEventos.listIterator();
        Evento ee = null;
        while (li.hasNext()) {
            ee = (Evento) li.next();
            if ((ee.getId() == 1) && (ee.getP().equals(p))) {
                filaEventos.remove(ee);
                return ee;
            }

        }

        return ee;
    }

    /**
     *
     * @return
     */
    public boolean isFilaEventosEmpty() {
        return filaEventos.isEmpty();

    }

    /**
     *
     * @param p
     */
    public void addFilaEscalonador(Processo p) {

        filaEscalonador.add(p);
    }

    /**
     *
     * @return
     */
    public Processo removeProximoFilaEscalonador() {
        return filaEscalonador.remove(0);

    }

    /**
     *
     * @return
     */
    public boolean isFilaEscalonadorEmpty() {
        return filaEscalonador.isEmpty();

    }

    /**
     *
     * @param p
     */
    public void addFilaProntos(Processo p) {
        filaProntos.add(p);
    }

    /**
     *
     * @return
     */
    public Processo removeProximoPronto() {
        return filaProntos.remove(0);

    }

    /**
     *
     * @return
     */
    public boolean isFilaProntosEmpty() {
        return filaProntos.isEmpty();

    }
    
    /**
     *
     * 
     */
    void addCpu(Processo p) {
        this.cpu = p;
    }

    /**
     *
     * @return
     */
    public Processo removeCPU() {
        Processo p = cpu;
        cpu = null;
        return p;
    }

    /**
     *
     * @return
     */
    public Processo cpuCheck() {
        Processo p = cpu;
        return p;
    }

    /**
     *
     * @return
     */
    public boolean isCpuBusy() {
        return cpu != null;
    }

    /**
     *
     * @return
     */
    public Config getConfig() {
        return config;
    }

    /**
     *
     * @return
     */
    public LogLine getLogAtual() {

        return log.get(log.size() - 1);

    }

    /**
     *
     * @param l
     */
    public void addLogLine(LogLine l) {
        log.add(l);

    }

    /**
     *
     */
    public void printLog() {

        FileWriter arq = null;
        PrintWriter gravarArq;
        try {
            arq = new FileWriter(config.getSaida());

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o arquivo de saída.");
            setErro(3);

        }
        gravarArq = new PrintWriter(arq);
        while (!log.isEmpty()) {

            gravarArq.println(log.get(0).toString());
            gravarArq.flush();

            log.remove(0);

        }
        gravarArq.close();

    }

    /**
     *
     */
    public void geraPlot() {
        File file = new File("plot.sh");

        try {
            Runtime.getRuntime().exec("chmod +x" + file.getAbsolutePath());

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o Plot.\n\nVerifique se o gnuplot está instalado.\nVerifique se os arquivos 'plot.gnu' e 'plot.sh' estão na pasta.");
            setErro(4);

        }
        try {
            Runtime.getRuntime().exec(file.getAbsolutePath());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o Plot.\n\nVerifique se o gnuplot está instalado.\nVerifique se os arquivos 'plot.gnu' e 'plot.sh' estão na pasta.");
            setErro(4);
        }

    }

}
