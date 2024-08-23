package gui;

import controller.AgendaAddController;
import controller.AgendaRemoveController;
import controller.AgendaSearchController;
import gravador.GravadorDeDados;
import sistema.Agenda;
import sistema.AgendaAyla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class AgendaGUI extends JFrame {
    JLabel linha1, linha2;
    public static final String[] opcoes = new String[]{"Sim", "Não"};
    ImageIcon menuImg = new ImageIcon("./imgs/bolochocolate.png");
    ImageIcon addImg = new ImageIcon("./imgs/icons/add_person.png");
    ImageIcon pesqImg = new ImageIcon("./imgs/icons/search_person.png");
    ImageIcon removeImg = new ImageIcon("./imgs/icons/remove_person.png");
    JButton botaoAdicionar, botaoPesquisar, botaoRemover;
    Agenda agenda = new AgendaAyla();
    public void salvarDados() throws IOException {
        agenda.salvarDados();
    }
    public void recuperarDados() throws IOException{
        agenda.recuperarDados();
    }
    public AgendaGUI(){
        setTitle("Agenda de aniversários");
        setSize(900, 700);
        setLocation(0, 0);
        setResizable(false);

        getContentPane().setBackground(Color.white);
        linha1 = new JLabel("Agenda de Aniversários", JLabel.CENTER);
        linha1.setForeground(Color.black);
        linha1.setFont(new Font("Serif", Font.BOLD,32));
        linha2 = new JLabel(menuImg, JLabel.CENTER);
        botaoAdicionar = new JButton("Adicionar", addImg);
        botaoAdicionar.addActionListener(new AgendaAddController(agenda, this));

        botaoPesquisar = new JButton("Pesquisar",pesqImg);
        botaoPesquisar.addActionListener(new AgendaSearchController(agenda, this));


        botaoRemover = new JButton("Remover",removeImg);
        botaoRemover.addActionListener(new AgendaRemoveController(agenda, this));

        botaoAdicionar.setBackground(Color.green);
        botaoPesquisar.setBackground(Color.lightGray);
        botaoRemover.setBackground(Color.red);




        getContentPane().setLayout(new GridLayout(3,2));
        getContentPane().add(linha1);
        getContentPane().add(botaoAdicionar);
        getContentPane().add(linha2);
        getContentPane().add(botaoPesquisar);
        getContentPane().add(new JLabel());
        getContentPane().add(botaoRemover);



    }
    public static void main(String[] Args){
        AgendaGUI janela = new AgendaGUI();
        if(GravadorDeDados.existemDadosSalvos()){
            try{
                janela.recuperarDados();}
            catch (IOException e2){
                System.out.println(e2.getMessage());
            }
        }
        janela.setVisible(true);
        WindowListener fechadorDeJanelaPrincipal = new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                int opc = JOptionPane.showOptionDialog(janela,"Deseja salvar os dados?", "Sair", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null, opcoes, null);
                if(opc == 0){
                    try{
                        janela.salvarDados();}
                    catch (IOException e3){
                        System.out.println(e3.getMessage());
                    }

                }
                System.exit(0);
            }
        };
        janela.addWindowListener(fechadorDeJanelaPrincipal);
        //janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
