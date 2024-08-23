package controller;

import entidades.Contato;
import sistema.Agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;


public class AgendaSearchController implements ActionListener {
    private Agenda agenda;
    private JFrame janelaPrincipal;
    private final ImageIcon pesqImg = new ImageIcon("./imgs/icons/search_person.png");

    public AgendaSearchController(Agenda agenda, JFrame janela){
        this.agenda = agenda;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int dia = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,pesqImg,"Dia do mês a pesquisar [1 - 31]",JOptionPane.QUESTION_MESSAGE));
        int mes = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,pesqImg,"Mês a pesquisar [1 - 12]",JOptionPane.QUESTION_MESSAGE));
        Collection<Contato> aniversariantes = agenda.pesquisaAniversariantes(dia, mes);
        if(!aniversariantes.isEmpty()){
            JOptionPane.showMessageDialog(janelaPrincipal, "Aniversariantes encontrados:","", JOptionPane.INFORMATION_MESSAGE);
            for(Contato c : aniversariantes){
                JOptionPane.showMessageDialog(janelaPrincipal, c,"", JOptionPane.INFORMATION_MESSAGE);

            }
        }else{
            JOptionPane.showMessageDialog(janelaPrincipal, "Não foi encontrado nenhum aniversariante nesta data","Erro", JOptionPane.ERROR_MESSAGE);

        }

    }
}
