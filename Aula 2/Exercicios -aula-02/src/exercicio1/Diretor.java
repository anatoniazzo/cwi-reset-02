package exercicio1;

public class Diretor {
    private String nomeDiretor;
    private int idade;
    private int quantidadeFilmes;

    public Diretor(String nomeDiretor, int idade, int quantidadeFilmes) {
        this.nomeDiretor = nomeDiretor;
        this.idade = idade;
        this.quantidadeFilmes = quantidadeFilmes;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }
}