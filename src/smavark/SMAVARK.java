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

    public void main(String[] args){
        
        String[] argsAgentes = {"-gui", "AgenteDetector:agentes.AgenteDetector", "AgenteGestor:agentes.AgenteGestor"};
        jade.Boot.main(argsAgentes);
        
    }
    
}
