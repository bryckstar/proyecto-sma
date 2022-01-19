/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import gui.GUI_principal;
import objetos.RecursosAprendizaje;
import jade.core.*;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.core.behaviours.*;
import jade.lang.acl.UnreadableException;
import java.util.ArrayList;

/**
 *
 * @author Bryan
 */
public class AgenteGestor extends Agent {

    GUI_principal gui;
    String txtBusqueda;
    RecursosAprendizaje ra = new RecursosAprendizaje();

    public void setup() {
        gui = new GUI_principal(this);
        addBehaviour(new CyclicBehaviour() {
            public void action() {
                ACLMessage aclMessage = receive();
                if (aclMessage != null) {
                    try {
                        ArrayList<RecursosAprendizaje> lista
                                = (ArrayList<RecursosAprendizaje>) aclMessage.getContentObject();
                        if (lista.size() > 0) {
                            System.out.println(getLocalName() + ": recibió datos del Aagente Detector \n\n");
                            /*gui.establecerLista(Lista)*/
                        } else {
                            System.out.println(getLocalName() + ": no recibió los datos del Agente Detector \n\n");
                            String msm = ra.sinResultados("Sin Resultados.txt").replace("%s", txtBusqueda);
                            /*gui.sinResultados*/
                        }

                    } catch (UnreadableException e) {
                        e.getMessage();
                    }
                }
            }
        });
    }
}
