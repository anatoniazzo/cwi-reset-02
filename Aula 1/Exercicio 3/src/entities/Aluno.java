package entities;

public class Aluno {
    private String nome;
    private double notaFinal;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String verificarStatus() {
        if (this.notaFinal >= 7.0) {
            return "APROVADO";
        } else {
            return "REPROVADO";
        }
    }
}
