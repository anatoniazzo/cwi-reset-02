package entidade;

public abstract class Imovel {
    private Endereco endereco;
    private Double valor;

    public Imovel(Endereco endereco, Double valor) {
        this.endereco = endereco;
        this.valor = valor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String apresentacao(){
        return
                 "Imóvel localizado no endereço: " + this.endereco
                + " Valor: R$ " + this.valor;

    }
}
