package controller;

import sistema.Agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaRemoveController implements ActionListener {
    private Agenda agenda;
    private JFrame janelaPrincipal;
    private final ImageIcon removeImg = new ImageIcon("./imgs/icons/remove_person.png");
    public AgendaRemoveController(Agenda agenda, JFrame janela){
        this.agenda = agenda;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String nome = JOptionPane.showInputDialog(janelaPrincipal, removeImg,"Nome do aniversariante a remover", JOptionPane.QUESTION_MESSAGE);
        try{
            agenda.removeContato(nome);
            JOptionPane.showMessageDialog(janelaPrincipal,"Aniversariante removido com sucesso","",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e2){
            JOptionPane.showMessageDialog(janelaPrincipal, "Falha ao remover: Aniversariante não encontrado", "Erro",JOptionPane.ERROR_MESSAGE);

        }

    }
}
