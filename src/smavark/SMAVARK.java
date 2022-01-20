/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smavark;


/**
 *
 * @author Bryan
 */
public class SMAVARK{

    public static void main(String[] args){
        
        String[] argsAgentes = {"-gui","Agente-Gestor:agentes.AgenteGestor; Agente-Detector:agentes.AgenteDetector" };
        jade.Boot.main(argsAgentes);
        
    }
    
}
