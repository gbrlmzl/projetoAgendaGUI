package testeGravador;
import entidades.Contato;
import exceptions.ContatoInexistenteException;
import gravador.GravadorDeDados;
import org.junit.jupiter.api.Test;
import sistema.Agenda;
import sistema.AgendaAyla;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class TesteGravador {
    @Test
    public void testeGravador() throws IOException {
        File arquivosContatos = new File(GravadorDeDados.ARQUIVOS_CONTATOS);
        if(arquivosContatos.exists()){
            arquivosContatos.delete();
        }
        File arquivo = new File(GravadorDeDados.ARQUIVOS_CONTATOS);
        assertFalse(arquivo.exists());
        HashMap<String,Contato> contatosMap = new HashMap<>();
        contatosMap.put("Debora", new Contato("Debora", 5, 10));
        GravadorDeDados.salvarContatos(contatosMap);
        assertTrue(arquivo.exists());
        arquivo.delete(); //o teste cria um arquivo de verdade? não exclui automaticamente?
    }

    @Test
    public void testaRecuperacao() throws IOException{
        File arquivoContatos = new File(GravadorDeDados.ARQUIVOS_CONTATOS);
        if(arquivoContatos.exists()) arquivoContatos.delete();

        File arquivo = new File(GravadorDeDados.ARQUIVOS_CONTATOS);
        assertFalse(arquivo.exists());
        HashMap<String, Contato> contatosMap = new HashMap<>();
        contatosMap.put("Josaca", new Contato("Josaca", 4, 7));
        GravadorDeDados.salvarContatos(contatosMap);
        assertTrue(arquivo.exists());
        HashMap<String, Contato> contatosRecuperados = GravadorDeDados.recuperarContatos();
        Contato c1 = contatosRecuperados.get("Josaca");
        assertEquals(4, c1.getDiaAniversario());
        assertEquals(7, c1.getMesAniversario());
        assertEquals("Josaca", c1.getNome());
        arquivo.delete();




    }



}
