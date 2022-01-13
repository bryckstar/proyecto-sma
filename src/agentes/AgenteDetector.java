/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import jade.core.*;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.core.behaviours.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Bryan
 */
public class AgenteDetector extends Agent {
    
    private String mensaje;
    
     public void setup(){
        addBehaviour (new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage aclMessage = receive();
                if (aclMessage != null){
                    mensaje = aclMessage.getContent();
                    System.out.println(getLocalName()+": se recibió el mensaje: " + mensaje);
                }
            }
        });
    }
    
}
