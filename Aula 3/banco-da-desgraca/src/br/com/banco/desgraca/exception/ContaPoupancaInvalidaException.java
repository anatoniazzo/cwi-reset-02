package br.com.banco.desgraca.exception;

public class ContaPoupancaInvalidaException extends RuntimeException {
    public ContaPoupancaInvalidaException(String mensagemDeErro) {
        super(mensagemDeErro);
    }

}
