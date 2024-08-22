package entidades;

import java.io.Serializable;
import java.util.Objects;

public class Contato implements Serializable {
    private String nome;
    private int diaAniversario;
    private int mesAniversario;

    public Contato(String nome, int dia, int mes){
        this.nome = nome;
        this.diaAniversario = dia;
        this.mesAniversario = mes;
    }

    public int getDiaAniversario() {
        return diaAniversario;
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    public int getMesAniversario() {
        return mesAniversario;
    }

    public void setMesAniversario(int mesAniversario) {
        this.mesAniversario = mesAniversario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return getDiaAniversario() == contato.getDiaAniversario() && getMesAniversario() == contato.getMesAniversario() && Objects.equals(nome, contato.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, getDiaAniversario(), getMesAniversario());
    }

    @Override
    public String toString(){
        return  "Nome: " + nome + "\n" +
                "Data de aniversário: " + getDiaAniversario() + "/" + getMesAniversario();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
