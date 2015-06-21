/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gvpm
 */
public class EscalonadorSJF extends Escalonador {

    /**
     *
     * @param e
     */
    public EscalonadorSJF(Estruturas e) {
        super(e);
    }

    @Override
    public void esvaziaFilaEscalonador() {

        while (!estrutura.isFilaEscalonadorEmpty()) {

            estrutura.addFilaProntos(estrutura.removeProximoFilaEscalonador());

        }

    }

    @Override
    public Processo proximoProcesso() {
        if (estrutura.isFilaProntosEmpty() || (estrutura.isCpuBusy())) {
            return null;
        } else {

            Processo r = estrutura.removeMenorTempoRestantePronto();
            return r;
        }
    }

}
