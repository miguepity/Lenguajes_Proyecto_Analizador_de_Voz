/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_asuna_miguel_ardon_11311056;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;

/**
 *
 * @author Miguel A. Ardon E
 */
public class Tiempo extends Thread {

    public int hora = 00, min = 00, seg = 00, ds = 00;//unidades de medida
    public boolean vive = false;
    JLabel label;
    Asuna asuna;

    public Tiempo() {
    }

    public Tiempo(JLabel label, Asuna asuna) {
        this.label = label;
        this.asuna = asuna;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
    
    

    public void run() {
        vive = false;

        try {
            if (asuna.Llamada.isVisible() || asuna.VideoLlamada.isVisible()) {
                vive = false;
                for (int i = 0; i < 10000000; i++) {
                    label.setText("Dialing...");
                }
                vive = true;
            }
            while (vive) {//ciclo infinito
                if (ds == 99) {//si los decisegundos son iguales a 99
                    ds = 00;//decisegundo vuelve a empezar en cero
                    seg++;//y aumenta un segundo
                }
                if (seg == 59) {//si los segundos son iguales a 59
                    seg = 00;//segundo vuelve a empezar en cero
                    min++;//y aumenta un minuto
                }
                if (min == 59) {//si los minutos son iguales a 59
                    min = 00;//minuto vuelve a empezar en cero
                    hora++;//y aumenta una hora
                }

                ds++;//aumentan las decimas de segundo

                label.setText(hora + ":" + min + ":" + seg);//se muestra en el jlabel
                if (asuna.Llamada.isVisible() == false && asuna.VideoLlamada.isVisible() == false) {
                    hora = 0;
                    min = 0;
                    seg = 0;
                    ds = 0;
                    label.setText("Dialing...");
                    sleep(10000);
                }
                sleep(10);//que duerma una decima de segundo

            }
        } catch (Exception ie) {
            System.out.println(ie.getMessage());
        }
    }
}
