/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import gui.GUI_principal;
import objetos.RecursosAprendizaje;
import jade.core.*;
import jade.lang.acl.ACLMessage;
import jade.core.behaviours.*;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.UnreadableException;
import java.util.ArrayList;

/**
 *
 * @author Bryan
 */
public class AgenteDetector extends GuiAgent {

    GUI_principal gui;
    String txtBusqueda;
    ACLMessage aclMessage;
    RecursosAprendizaje ra = new RecursosAprendizaje();

    @Override
    public void setup() {
        gui = new GUI_principal(this);
        gui.setVisible(true);
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage aclMessage = receive();
                if (aclMessage != null) {
                    try {
                        ArrayList<RecursosAprendizaje> lista
                                = (ArrayList<RecursosAprendizaje>) aclMessage.getContentObject();
                        if (lista.size() > 0) {
                            System.out.println(getLocalName() + ": recibió datos del Agente Gestor \n\n");
                            gui.establecerLista(lista);
                        } else {
                            System.out.println(getLocalName() + ": no recibió los datos del Agente Gestor \n\n");
                            String msm = ra.sinResultados("Sin Resultados.txt").replace("%s", txtBusqueda);
                            gui.sinResultados();
                        }

                    } catch (UnreadableException e) {
                        e.getMessage();
                    }
                }
            }
        });
    }
    
    @Override
    protected void onGuiEvent(GuiEvent ge){
        int tipoElemento = ge.getType();
        if (tipoElemento == 1){
            addBehaviour(new OneShotBehaviour(){
                @Override
                public void action(){
                    txtBusqueda = (String) ge.getParameter(0);
                    System.out.println(getLocalName()+": obtuvo el siguiente mensaje: "+txtBusqueda);
                    aclMessage = new ACLMessage(ACLMessage.INFORM);
                    aclMessage.setContent(txtBusqueda.toLowerCase());
                    aclMessage.addReceiver(new AID("Agente-Gestor",AID.ISLOCALNAME));
                    send(aclMessage);
                    System.out.println(getLocalName()+": listo para enviar mensaje al Agente-Gestor");
                    System.out.println("///////////////////////////////////////////////////////////\n");
                }
            });
        }
    }
}
