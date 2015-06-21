
import java.util.Comparator;

/**
 *
 * @author
 */
public abstract class Evento implements Comparator {

    int t, id;

    Estruturas estrutura;

    public void run() {

    }

    /**
     *
     * @return
     */
    public int getT() {
        return t;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    public Processo getP() {
        return null;
    }

    /**
     *
     *
     */
    @Override
    public int compare(Object o1, Object o2) {
        Evento e1 = (Evento) o1;
        Evento e2 = (Evento) o2;

        int r = 0;

        if ((e1.getT() == e2.getT()) && (e1.getId() > e2.getId())) {
            r = 1;
        }
        if ((e1.getT() == e2.getT()) && (e1.getId() < e2.getId())) {
            r = -1;
        }
        if ((e1.getT() == e2.getT()) && (e1.getId() == e2.getId())) {
            r = 0;
        }
        if (e1.getT() > e2.getT()) {
            r = 1;
        }
        if (e1.getT() < e2.getT()) {
            r = -1;
        }

        return r;
    }

}
