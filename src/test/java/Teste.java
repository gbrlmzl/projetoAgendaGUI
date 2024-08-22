import entidades.Contato;
import exceptions.ContatoInexistenteException;
import org.junit.jupiter.api.Test;
import sistema.AgendaAyla;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Teste {
    @Test
    public void testaAgenda(){
        AgendaAyla sistema = new AgendaAyla();
        //Teste do método cadastraContato()
        assertTrue(sistema.cadastraContato("José", 19, 3), "O retorno do método deveria ser verdadeiro!");
        assertFalse(sistema.cadastraContato("José", 19, 3), "O retorno do método deveria ser falso!");


        ArrayList<Contato> aniversariantes = new ArrayList<>(sistema.pesquisaAniversariantes(19,3));
        //Teste do método pesquisaAniversariantes()
        assertEquals(1,aniversariantes.size(),"Deveria ter exatamente 1 aniversariante nessa lista");
        assertTrue(aniversariantes.get(0).getDiaAniversario() == 19 && aniversariantes.get(0).getMesAniversario() == 3,"Incoerência nos dados do aniversariante!");

        ArrayList<Contato> aniversariantes2 = new ArrayList<>(sistema.pesquisaAniversariantes(1,1));
        assertEquals(0,aniversariantes2.size(),"Essa lista deveria estar vazia!");


        //Teste do método removeContato()
        assertThrows(ContatoInexistenteException.class, ()-> sistema.removeContato("Gabriel"),"Deveria lançar exceção!");

        try{ //o assertTrue deve estar dentro ou fora do bloco try-catch?
            assertTrue(sistema.removeContato("José"));
        }catch(ContatoInexistenteException e){
            fail("Não deveria lançar exceção!");
        }
        assertThrows(ContatoInexistenteException.class, ()-> sistema.removeContato("José"), "Deveria lançar exceção!");







    }
}
