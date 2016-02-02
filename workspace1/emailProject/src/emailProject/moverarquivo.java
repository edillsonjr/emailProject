/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailProject;

import java.io.File;

/**
 *
 * @author edilson.junior
 */
public class moverarquivo {
   
    void mover(String endereco)  {
        
        // arquivo a ser movido
        File arquivo = new File(endereco);
    
        // diretorio de destino
        File dir = new File("c:\\Users\\edilson.junior\\workspace\\emailProject");
    
        // move o arquivo para o novo diretorio
        boolean ok = arquivo.renameTo(new File(dir, arquivo.getName()));
        if(ok){
            System.out.println("Arquivo foi movido com sucesso");
        }
        else{
            System.out.println("Nao foi possivel mover o arquivo");
        }
    }
}

