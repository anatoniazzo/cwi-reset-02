package br.com.banco.desgraca.exception;

public class ContaDigitalInvalidaException extends RuntimeException {
    public ContaDigitalInvalidaException(String mensagemDeErro) {
        super(mensagemDeErro);
    }

}
