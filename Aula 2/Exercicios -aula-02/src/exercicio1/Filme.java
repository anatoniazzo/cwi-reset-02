package exercicio1;

public class Filme {

    private String nome;
    private String descrição;
    private double duracao;
    private int anoLancamento;
    private int avaliacao;
    private Diretor diretor;


    public Filme(String nome, String descrição, double duracao, int anoLancamento, int avaliacao, Diretor diretor) {
        defineAvaliacao(avaliacao);
        validaNomeEDefineAvaliacao(nome);
        this.nome = nome;
        this.descrição = descrição;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void exibirFilme() {
        System.out.println("Nome do filme: " + this.nome);
        System.out.println("Duracao do filme: " + this.duracao);
        System.out.println("Descrição: " + this.descrição);
        System.out.println("Nome do diretor: " + this.diretor.getNome());
    }

    private void defineAvaliacao(Integer avaliacao) {
        if (avaliacao < 1 || avaliacao > 5) {
            this.avaliacao = 3;
        } else {
            this.avaliacao = avaliacao;
        }
    }
        private void validaNomeEDefineAvaliacao (String nome){
            if ("Batman vs Superman".equals(nome)) {
                this.avaliacao = 1;
            } else if ("Interestelar".equals(nome)) {
                this.avaliacao = 5;
            }
        }

}
