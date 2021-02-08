import entities.Aluno;

import java.util.Locale;
import java.util.Scanner;


public class Aplicacao {


    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Aluno aluno = new Aluno();
        System.out.print("Insira o nome do aluno: ");
        aluno.setNome(sc.next());
        System.out.print("Insira a nota do aluno: ");
        aluno.setNotaFinal(sc.nextDouble());


        System.out.println(aluno.getNome());
        System.out.println(aluno.getNotaFinal());
        System.out.println(aluno.verificarStatus());





    }
}
