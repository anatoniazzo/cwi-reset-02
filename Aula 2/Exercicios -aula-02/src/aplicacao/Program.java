package aplicacao;

import exercicio1.Diretor;
import exercicio1.Filme;

public class Program {
    public static void main(String[] args) {

        Diretor diretor = new Diretor("Chistofer Nolan", 70, 20 );

        Filme filmeVingadores = new Filme("vingadores", "legal",200.00, 1900,
                5, diretor);

        Filme filmeUmaLindaMulher= new Filme("Uma linda mulher","tri",150.00,1984,
                5, diretor  );

        filmeVingadores.exibirFilme();
        filmeUmaLindaMulher.exibirFilme();

    }
}
