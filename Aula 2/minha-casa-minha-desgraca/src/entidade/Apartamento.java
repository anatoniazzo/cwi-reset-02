package entidade;

public class Apartamento extends Imovel {

    private Integer andar;

    public Apartamento(Endereco endereco, Double valor, Integer andar) {
        super(endereco, valor);
        this.andar = andar;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }


    @Override
    public String apresentacao(){
        return "[APARTAMENTO]\n"
                + "  Imóvel localizado no endereço: " + this.getEndereco()
                + " \n Valor: R$ " + this.getValor();

    }
}
