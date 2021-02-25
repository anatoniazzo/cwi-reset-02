package dominio;

import exception.ValidaLocalizacaoEditora;
import exception.ValidaNomeEditora;

public class Editora {
    private String nome;
    private String localizacao;

    public Editora(String nome, String localizacao) {
        validarLocalizacao(localizacao);
        validarNome(nome);
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return localizacao;
    }

    public void setEndereco(String endereco) {
        this.localizacao = endereco;
    }

    private void validarNome(String nome) {
        if(nome.equals("DC COMICS")){
            throw new ValidaNomeEditora("Não é possível acessar essa editora!");
        }

    }
    private void validarLocalizacao(String localizacao){
        if(localizacao.equals("Porto Alegre")){
        throw new ValidaLocalizacaoEditora("Não é possível encontrar editora!");
        }
    }
}




