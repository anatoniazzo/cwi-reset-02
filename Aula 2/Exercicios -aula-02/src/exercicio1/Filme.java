package exercicio1;

import java.sql.SQLOutput;

public class Filme {

    private String nome;
    private String descrição;
    private double duracao;
    private int anoLancamento;
    private int avaliação;
    private  Diretor diretor;


    public Filme(String nome, String descrição, double duracao, int anoLancamento, int avaliação, Diretor diretor) {
        this.nome = nome;
        this.descrição = descrição;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliação = avaliação;
        this.diretor = diretor;
    }

    public void exibirFilme(){
        System.out.println("Nome do filme: " + this.nome);
        System.out.println("Duracao do filme: " + this.duracao);
        System.out.println("Descrição: " + this.descrição );
        System.out.println("Nome do diretor: " + this.diretor.getNomeDiretor());
    }

}
