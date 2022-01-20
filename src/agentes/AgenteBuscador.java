  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;
import objetos.RecursosAprendizaje;

/**
 *
 * @author Bryan
 */
public class AgenteBuscador extends Agent{
    
    RecursosAprendizaje ra = new RecursosAprendizaje();
    ArrayList<String> sinonimos = new ArrayList<>();
    ACLMessage aclMessage;
    boolean relevante = false;
    
    @Override
    public void setup(){
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                aclMessage = receive();
                if (aclMessage != null) {
                    String mensaje = aclMessage.getContent();
                    System.out.println(getLocalName() + ": acaba de recibir el sigueinte mensaje");
                    sinonimos = ra.buscarRA(mensaje);
                    System.out.println(getLocalName() + ": preparandose para buscar palabra clave");
                    if (sinonimos != null){
                        for (int i=0; i < sinonimos.size(); i++){
                            if(sinonimos.get(i).equals(mensaje)){
                                consulta(sinonimos.get(0));
                                relevante = true;
                                break;
                            }
                        }
                    }else{
                        consulta(mensaje);
                    }
                }
            }
        });
    }
    
    private void consulta(String mensaje){
        aclMessage = new ACLMessage(ACLMessage.INFORM);
        aclMessage.setContent(mensaje);
        aclMessage.addReceiver(new AID("Agente-RS", AID.ISLOCALNAME));
        send(aclMessage);
        System.out.println(getLocalName() +": preparandose para enviar palabra clave al Agente-RS");
        System.out.println("=======================================================");
    }
    
}
