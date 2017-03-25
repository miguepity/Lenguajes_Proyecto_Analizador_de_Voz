/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReconocimientoVoz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Locale;
import javax.speech.Central;
import javax.speech.EngineModeDesc;
import javax.speech.recognition.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import proyecto_asuna_miguel_ardon_11311056.Asuna;

/**
 *
 * @author Miguel A. Ardon E
 */
/**
 * Esta es la clase principal, la clase que se encarga de comprar los fonemas y
 * compararlos con el carchivo ("c:/SimpleGrammarES2.txt"), donde se establecen
 * las palabras que se utilizaran en el fonema.....
 *
 * @version 1.0.0.0 Educativa
 * @author Carlos Mario Montaño Lopera
 */
public class ReconocimientoVoz extends ResultAdapter implements Runnable {

    /**
     * Permite manipular desde esta clase, y ejecutar las acciones segun el
     * comando de voz
     */
    Asuna asuna;
    JDialog donde;
    //boolean inicio = asuna.inicio;

    /**
     * Reconoce el comado de voz del Usuario
     */
    Recognizer reconocedorVoz;

    /**
     * Palabra que el usuario a pronunciado
     */
    public String palabra;

    public ReconocimientoVoz(Asuna asuna) {
        this.asuna = asuna;
    }

    /**
     * Captura el fonema(palabra), y la compara con un conjunto de palabras y
     * ejecuta una accion establecida.
     *
     * Importante: yo e utilizado <code>if</code>, por que mi version del jdk no
     * permite la la utilizacion de <code>switch</code> con String
     *
     * @param re
     */
    @Override
    public void resultAccepted(ResultEvent re) {
        try {
            Result res = (Result) (re.getSource());
            ResultToken tokens[] = res.getBestTokens();

            String frase[] = new String[1];
            frase[0] = "";

            for (int i = 0; i < tokens.length; i++) {
                palabra = tokens[i].getSpokenText();
                frase[0] += palabra + " ";

                if (palabra.equals("uno") && asuna.Principal.isVisible()) {
                    asuna.txt_accion.setText("1.(Buscar) Contacto");
                } else if (palabra.equals("dos") && asuna.Principal.isVisible()) {
                    asuna.txt_accion.setText("2.(Llamar) Contacto");
                } else if (palabra.equals("tres") && asuna.Principal.isVisible()) {
                    asuna.txt_accion.setText("3.(Editar) Numero de Contacto");
                } else if (palabra.equals("cuatro") && (asuna.Llamada.isVisible() || asuna.VideoLlamada.isVisible())) {
                    JOptionPane.showMessageDialog(asuna.window, "Mute");
                } else if (palabra.equals("cinco") && asuna.Principal.isVisible()) {
                    asuna.txt_accion.setText("5.(Video) Llamada");
                } else if (palabra.equals("seis") && asuna.Principal.isVisible()) {
                    asuna.txt_accion.setText("6.(Enviar) Mensaje");
                } else if (palabra.equals("siete")) {
                    if (asuna.Llamada.isVisible()) {
                        asuna.Llamada.setVisible(false);
                        asuna.Principal.setVisible(true);
                    } else {
                        asuna.window.setVisible(false);
                        asuna.VideoLlamada.setVisible(false);
                        asuna.Principal.setVisible(true);
                    }
                } else if (palabra.equals("ocho") && asuna.Principal.isVisible()) {
                    String ruta = "bitacora.txt";
                    File archivo = new File(ruta);
                    BufferedWriter bw;
                    if (archivo.exists()) {
                        bw = new BufferedWriter(new FileWriter(archivo));
                        bw.write(asuna.bitacora);
                    } else {
                        bw = new BufferedWriter(new FileWriter(archivo));
                        bw.write(asuna.bitacora);
                    }
                    bw.close();
                    System.exit(0);
                } else if (palabra.equals("miguel")) {
                    asuna.txt_user.setText(palabra);
                } else if (palabra.equals("mangel")) {
                    asuna.txt_user.setText(palabra);
                } else if (palabra.equals("elmejor")) {
                    asuna.txt_pass.setText(palabra);
                } else if (palabra.equals("angel")) {
                    asuna.txt_pass.setText(palabra);
                } else if (palabra.equals("walther")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }
                } else if (palabra.equals("johana")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }
                } else if (palabra.equals("enriquez")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("david")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("ambar")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("klaudia")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("rodolfo")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("juan")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("martha")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("mario")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("manuel")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("martin")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("andres")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("juana")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("daniela")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("ana")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("carlos")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("boniek")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("francisco")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("sergio")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("paulina")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("fernanda")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("victor")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("luis")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("claro")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("tigo")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("policia")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("operadora")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("lucia")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("ramon")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("jack")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("clarisa")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("daniel")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("emanuel")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("cistina")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("memo")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("roberto")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("geña")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("adriana")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("oscar")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("mariela")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("jessica")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("jaime")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("vilma")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("ardon")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("joan")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("shealsy")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("estela")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                } else if (palabra.equals("gloria")) {
                    if (asuna.llamar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_llamar.setText(palabra);
                            }
                        }
                    } else if (asuna.video.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_quien_video.setText(palabra);
                            }
                        }
                    } else if (asuna.editar.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(j).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_editar_nombre.setText(palabra);
                                asuna.id = asuna.u.getContactos().get(j).getId();
                            }
                        }
                    } else if (asuna.Mensaje.isVisible()) {
                        for (int j = 0; j < asuna.u.getContactos().size(); j++) {
                            if (asuna.u.getContactos().get(i).getNombre().equalsIgnoreCase(palabra)) {
                                asuna.txt_mensaje_nombre.setText(palabra);
                            }
                        }
                    }

                }

                //se escribe todo lo que esta en el documento de lenguaje
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public String getProgram() {
        return palabra;
    }

    /**
     * Carga el archivo ("gramatica.txt") y para poder empezar un proceso de
     * comparacion gramatical y hacer los procesesos de reconocimiento
     *
     * Importante: Se debe establecer un archivo ("c:/SimpleGrammarES2.txt"),
     * con un conjunto de expresiones gramaticales(Palabras) para poder generar
     * un proceso correcto de reconocimiento
     */
    public void reconocerVoz() {
        try {
            reconocedorVoz = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
            reconocedorVoz.allocate();

            FileReader gramatica = new FileReader("SimpleGrammarES2.txt");

            RuleGrammar reglaGramatica = reconocedorVoz.loadJSGF(gramatica);
            reglaGramatica.setEnabled(true);

            reconocedorVoz.addResultListener(new ReconocimientoVoz(asuna));
            reconocedorVoz.commitChanges();
            reconocedorVoz.requestFocus();
        } catch (Exception e) {
            System.out.println("Error en " + e.toString());
        }
    }

    @Override
    public void run() {
        this.reconocerVoz();
    }
}
