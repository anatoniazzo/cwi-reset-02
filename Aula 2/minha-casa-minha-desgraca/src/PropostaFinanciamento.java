import entidade.Beneficiario;
import entidade.Imovel;
import entidade.UnidadeFederativa;

public class PropostaFinanciamento {
    private Beneficiario beneficiario;
    private Imovel imovel;
    private Integer mesesParaPagamento;

    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovel, Integer mesesParaPagamento) {
        this.beneficiario = beneficiario;
        this.imovel = imovel;
        this.mesesParaPagamento = mesesParaPagamento;
    }

    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     * <p>
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     * for equivalente a pelo menos 50% do valor do imóvel.
     * <p>
     * Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     * o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */


    public void validarProposta() {
        Double proposta = beneficiario.getSalario() * this.mesesParaPagamento;
        Double porcentagemValorImovel;

        if(UnidadeFederativa.SP.equals(imovel.getEndereco().getEstado())){
            porcentagemValorImovel = 0.65 * imovel.getValor();

        } else if(UnidadeFederativa.RJ.equals(imovel.getEndereco().getEstado())){
             porcentagemValorImovel = 0.60 * imovel.getValor();
        } else {
             porcentagemValorImovel = 0.5 * imovel.getValor();
        }

        if (proposta >= porcentagemValorImovel) {
            imprimirPropostaAprovada();
        } else {
            imprimirPropostaNegada();
        }
    }

    private void imprimirPropostaAprovada() {
        imprimirDadosProposta();
        System.out.println("Parabéns !! Sua proposta de financiamento foi aceita!! ");
    }

    private void imprimirPropostaNegada() {
        imprimirDadosProposta();
        System.out.println("Infelizmente sua proposta de financiamento não foi aceita");

    }

    private void imprimirDadosProposta() {
        System.out.println("Beneficiário : " + this.beneficiario.getNome());
        System.out.println(("Imóvel (endereço): " + this.imovel.getEndereco().toString()));
        System.out.println("Imóvel (valor): " + this.imovel.getValor());
        System.out.println("Prazo de pagamento: " + this.mesesParaPagamento);

    }
}

