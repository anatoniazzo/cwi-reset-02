package entidade;

public class Casa extends Imovel{
    private Boolean patio;


    public Casa(Endereco endereco, Double valor, Boolean patio) {
        super(endereco, valor);
        this.patio = patio;
    }

    public Boolean getPatio() {
        return patio;
    }

    public void setPatio(Boolean patio) {
        this.patio = patio;
    }
    @Override
    public String apresentacao(){
        return "[CASA]\n"
                + "  Imóvel localizado no endereço: " + this.getEndereco()
                + " \n Valor: R$ " + this.getValor();

    }
}
