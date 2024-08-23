package controller;

import sistema.Agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AgendaAddController implements ActionListener {
    private Agenda agenda;
    private JFrame janelaPrincipal;
    private final ImageIcon pesqImg = new ImageIcon("./imgs/icons/search_person.png");

    public AgendaAddController(Agenda agenda, JFrame janela){
        this.agenda = agenda;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String nome = JOptionPane.showInputDialog(janelaPrincipal, pesqImg, "Nome do aniversariante", JOptionPane.QUESTION_MESSAGE);
        int dia = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,pesqImg,"Dia do mês em que nasceu [1-31]",JOptionPane.QUESTION_MESSAGE));
        int mes = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,pesqImg,"Mês de nascimento [1-12]",3));
        //boolean cadastrou = agenda.cadastraContato(nome, dia, mes);
        if(agenda.cadastraContato(nome,dia,mes)){
            JOptionPane.showMessageDialog(janelaPrincipal,"Aniversariante cadastrado","Sucesso", JOptionPane.INFORMATION_MESSAGE);

        }else{
            JOptionPane.showMessageDialog(janelaPrincipal,"Erro ao cadastrar aniversariante","Erro", JOptionPane.ERROR_MESSAGE);

        }

    }
}
