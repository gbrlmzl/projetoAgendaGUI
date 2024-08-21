package gravador;

import entidades.Contato;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {
    public static final String ARQUIVOS_CONTATOS = "contatos.dat";


    public void salvarContatos(Map<String, Contato> contatos){ //precisa avisar que lança IOExcpetion?
        try(ObjectOutput out = new ObjectOutputStream(new FileOutputStream(ARQUIVOS_CONTATOS))){
            out.writeObject(contatos);
        }catch(IOException e){
            System.out.println("Lá");
        }


    }
    public HashMap<String, Contato> recuperarContatos() throws IOException {  //precisa avisar que lança IOExcpetion?
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVOS_CONTATOS))){
        HashMap<String, Contato> contatos = (HashMap<String, Contato>)in.readObject();
        return contatos;

        }catch(IOException e){
            throw new IOException("Arquivo \"" + ARQUIVOS_CONTATOS + "\" não encontrado");
        }catch(ClassNotFoundException e){
            throw new IOException("Classe dos objetos gravados no \"" + ARQUIVOS_CONTATOS + "\" não existe");
        }
    }
}
