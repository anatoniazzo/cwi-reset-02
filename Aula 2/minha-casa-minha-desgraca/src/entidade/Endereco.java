package entidade;

public class Endereco {
    private String logradouro;
    private String número;
    private String complemento;
    private String bairro;
    private String cidade;
    private UnidadeFederativa estado;

    public Endereco(String logradouro, String número, String complemento, String bairro, String cidade, UnidadeFederativa estado) {
        this.logradouro = logradouro;
        this.número = número;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNúmero() {
        return número;
    }

    public void setNúmero(String número) {
        this.número = número;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UnidadeFederativa getEstado() {
        return estado;
    }

    public void setEstado(UnidadeFederativa estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return " "
                + " Logradouro: '" + logradouro + '\''
                + ", Número:'" + número + '\''
                + ", Complemento: '" + complemento + '\''
                + ", Bairro: '" + bairro + '\''
                + ", Cidade: '" + cidade + '\''
                + ", Estado: " + estado;

    }
}
