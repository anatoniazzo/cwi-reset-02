package br.com.banco.desgraca.exception;

public class SaqueInvalidoException extends RuntimeException {
    public SaqueInvalidoException(String mensagemDeErro) {
        super(mensagemDeErro);
    }

}
