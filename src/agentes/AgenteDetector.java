/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import BL.BLRecursos_Aprendizaje;
import objetos.RecursosAprendizaje;
import jade.core.*;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.core.behaviours.*;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class AgenteDetector extends Agent {
    
    BLRecursos_Aprendizaje objRA  = new BLRecursos_Aprendizaje();
    ArrayList <RecursosAprendizaje> lista;
    private String mensaje;
    
    
    @Override
     public void setup(){
        addBehaviour (new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage aclMessage = receive();
                if (aclMessage != null){
                    mensaje = aclMessage.getContent();
                    System.out.println(getLocalName()+": se recibió el mensaje: " + mensaje);
                    try {
                        System.out.println(getLocalName() + ": preparación para consultar a la base de datos");
                        lista = objRA.consultarRA(mensaje);
                        System.out.println(getLocalName() + ": consulta completa");
                        aclMessage = new ACLMessage(ACLMessage.INFORM);
                        aclMessage.setContentObject((Serializable) lista);
                        aclMessage.addReceiver(new AID("Agente-Gestor",AID.ISLOCALNAME));
                        send(aclMessage);
                        System.out.println(getLocalName()+": enviando mensaje al agente gestor");
                        System.out.println("///////////////////////////////////////////////////////////\n");
                    } catch (SQLException ex) {
                        Logger.getLogger(AgenteDetector.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AgenteDetector.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(AgenteDetector.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
}
