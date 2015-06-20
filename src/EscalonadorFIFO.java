/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gvpm
 */
public class EscalonadorFIFO extends Escalonador {

    /**
     *
     * @param t
     * @param e
     */
    public EscalonadorFIFO(int t, Estruturas e) {
        super(t, e);
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
        } //if(estrutura.filaProntosIsEmpty())return null;
        else {
            Processo r = estrutura.removeProximoPronto();

            return r;
        }
    }
    
}
