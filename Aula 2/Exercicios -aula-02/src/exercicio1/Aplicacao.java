package exercicio1;

public class Aplicacao {
    public static void main(String[] args) {

        Diretor diretor = new Diretor("Chistofer Nolan", 70, 20, Genero.MASCULINO);
        Ator ator = new Ator ("Leonardo Di Caprio", 35, 4, Genero.MASCULINO);

        Filme filmeVingadores = new Filme("vingadores", "legal",200.00, 1900,
                5, diretor);

        Filme filmeUmaLindaMulher= new Filme("Uma linda mulher","tri",150.00,1984,
                5, diretor );

        filmeVingadores.exibirFilme();
        filmeUmaLindaMulher.exibirFilme();

        diretor.imprimir();
        ator.imprimir();

    }
}

