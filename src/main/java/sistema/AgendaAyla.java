package sistema;

import entidades.Contato;
import exceptions.ContatoInexistenteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AgendaAyla implements Agenda{
    private Map<String, Contato> contatos = new HashMap<>();
    public AgendaAyla(){}
    public void salvarDados(){}
    public void recuperarDados(){}

    @Override
    public boolean cadastraContato(String nome, int dia, int mes) {
        if(contatos.containsKey(nome)){
           return false;
        }
        Contato novoContato = new Contato(nome, dia, mes);
        contatos.put(nome,novoContato);
        return true;
    }

    @Override
    public boolean removeContato(String nome) throws ContatoInexistenteException {
        if(contatos.containsKey(nome)){
            contatos.remove(nome);
            return true;
        }
        throw new ContatoInexistenteException("Contato inexistente!");
    }
    @Override
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes){
        Collection<Contato> listaAniversariantes = new ArrayList<>();
        for(Contato c : contatos.values()){
            if(c.getDiaAniversario() == dia && c.getMesAniversario() == mes){
                listaAniversariantes.add(c);
            }
        }
        return listaAniversariantes;
    };
}
