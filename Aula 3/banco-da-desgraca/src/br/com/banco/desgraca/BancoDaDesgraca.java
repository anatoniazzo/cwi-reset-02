package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;
import jdk.swing.interop.SwingInterOpUtils;

import java.time.LocalDate;
import java.util.ArrayList;

public class BancoDaDesgraca {
    public static void main(String[] args) {

      System.out.println("-------TESTES REGRAS DE NEGÓCIO CONTA DIGITAL ------------------------");
        /*
         * Regra 1(Conta Digital):Não possui nenhum tipo de taxa, todas as operações são gratuitas.
         *
         */
        // Consulta saldo
        ContaDigital contaDigitalRegra1 = new ContaDigital(2345, InstituicaoBancaria.NUBANK, 200.0, new ArrayList<>());
        if (contaDigitalRegra1.consultarSaldo() == 200.0) {
            System.out.println("Funcionou o consultar saldo  (Conta Digital");
        } else {
            System.out.println("Não funcionou o consultar saldo  (Conta Digital)");
        }
        System.out.println("------------------------------------------------------");
        //Depositar
        contaDigitalRegra1.depositar(100.0);
        if (contaDigitalRegra1.consultarSaldo() == 300.0) {
            System.out.println("Saldo: " + contaDigitalRegra1.consultarSaldo());
        } else {
            System.out.println(" Não deu certo a operação depositar (Conta Digital).");
        }
          System.out.println("------------------------------------------------------");
       // Transferir
        ContaBancaria contaDestino = new ContaCorrente(2676, InstituicaoBancaria.BRADESCO, 200.0, new ArrayList<>());
        contaDigitalRegra1.transferir(150.0, contaDestino);
        if (contaDigitalRegra1.consultarSaldo() == 50.0) {
            System.out.println("Saldo " + contaDigitalRegra1.consultarSaldo());
        } else {
            System.out.println("Não deu certo a operação de transferir (Conta Digital.");
        }
        System.out.println("-------------------------------------------------------");
        /*
         *Fim Regra 1 (Conta Digital)
         */

        /*
         * Regra 2(Conta Digital):Os saques só são permitidos se o valor solicitado for de pelo menos R$ 10,00.
         */
          //Sacar
        ContaDigital contaDigitalRegra2 = new ContaDigital(2445, InstituicaoBancaria.NUBANK, 400.0, new ArrayList<>());
        contaDigitalRegra2.sacar(100.0);
        //contaDigitalRegra2.sacar(5.0);
        if (contaDigitalRegra2.consultarSaldo() == 300.0) {
            System.out.println("Saldo " + contaDigitalRegra2.consultarSaldo());
        } else {
            System.out.println("Não deu certo a operação de transferir (Conta Digital.");
        }
        System.out.println("------------------------------------------------------");

        /*
         *Fim Regra 2 (Conta Digital)
         */

        System.out.println("-------TESTES REGRAS DE NEGÓCIO CONTA CORRENTE------------------------");
        /*
         * Regra 1(Conta Corrente):É livre de taxas.
         *
         */
        // Consultar Saldo
        ContaCorrente contaCorrenteRegra1 = new ContaCorrente(2345, InstituicaoBancaria.BRADESCO, 500.0, new ArrayList<>());
        if (contaCorrenteRegra1.consultarSaldo() == 500.0) {
            System.out.println(" Saldo inicial: " + contaCorrenteRegra1.consultarSaldo());
        } else {
            System.out.println("Não funcionou o consultar saldo (Conta Corrente");
        }
        System.out.println("-------------------------------------------------------------------");
        // Depositar
        contaCorrenteRegra1.depositar(200.0);
        if (contaCorrenteRegra1.consultarSaldo() == 700.0) {
            System.out.println("Saldo: " + contaCorrenteRegra1.consultarSaldo());
        } else {
            System.out.println(" Não deu certo a operação depositar (Conta Corrente)");
        }
        /*
         *Fim Regra 1 (Conta Corrente)
         */
        System.out.println("---------------------------------------------------------------------");

        /*
         * Regra 2(Conta Corrente):Transferências para outras instituições bancárias
         *(neste caso, a taxa é de 1% do valor a ser transferido).
         */
        // Transferências
        ContaCorrente contaCorrenteRegra2 = new ContaCorrente(2434, InstituicaoBancaria.BRADESCO, 500.0, new ArrayList());
        ContaBancaria contaDestinoBancoDiferente = new ContaCorrente(2676, InstituicaoBancaria.CAIXA, 200.0, new ArrayList<>());
        contaCorrenteRegra2.transferir(100.0, contaDestinoBancoDiferente);
        System.out.println("BANCO DIFERENTE");
        if (contaCorrenteRegra2.consultarSaldo() == 399.0) {
            System.out.println("Saldo: " + contaCorrenteRegra2.consultarSaldo());
        } else {
            System.out.println(" Não deu certo a operação de transferência (Conta Corrente)");
        }
        System.out.println("BANCO IGUAL");
        ContaBancaria contaDestinoBancoIgual = new ContaCorrente(2676, InstituicaoBancaria.BRADESCO, 200.0, new ArrayList<>());
        contaCorrenteRegra2.transferir(100.0, contaDestinoBancoIgual);
        if (contaCorrenteRegra2.consultarSaldo() == 299.0) {
            System.out.println(" Saldo: " + contaCorrenteRegra2.consultarSaldo());
        } else {
            System.out.println(" Não deu certo a operação de transferência (Conta Corrente)");
        }
        /*
         *Fim Regra 2 (Conta Corrente)
         */
        System.out.println("--------------------------------------------------------");

        /*
         * Regra 3 (Conta Corrente):O saque só pode ser feito para valores divisíveis por 5
         *(ou seja, notas de R$ 5,00, R$ 10,00, R$ 20,00, R$ 50,00, R$ 100,00 e R$ 200,00);
         */
        // Sacar
        ContaCorrente contaCorrenteRegra3 = new ContaCorrente(2434, InstituicaoBancaria.BRADESCO, 500.0, new ArrayList());
        contaCorrenteRegra3.sacar(100.0);
        if (contaCorrenteRegra3.consultarSaldo() == 400.0) {
            System.out.println("Saldo: " + contaCorrenteRegra3.consultarSaldo());
        } else {
            System.out.println(" Não deu certo a operação sacar (Conta Corrente)");
        }
        /*
         *Fim Regra 3 (Conta Corrente)
         */
        System.out.println("--------------------------------------------------------");

        System.out.println("-------TESTES REGRAS DE NEGÓCIO CONTA POUPANCA------------------------");

        /*
         * Regra 1 (Conta Poupança): Possui taxa de 2% para saques,
         * sendo que o valor mínimo para solicitação de saque é de R$ 50,00.
         */
        // Sacar
        ContaPoupanca contaPoupancaRegra1 = new ContaPoupanca(2544, InstituicaoBancaria.CAIXA, 550.0, new ArrayList());
        contaPoupancaRegra1.sacar(100.0);
        if (contaPoupancaRegra1.consultarSaldo() == 448.0) {
            System.out.println("Saldo: " + contaPoupancaRegra1.consultarSaldo());
        } else {
            System.out.println(" Não deu certo a operação sacar (Conta Corrente)");
        }
        System.out.println("-----------------------------------------------------------------------");
        /*
         *Fim Regra 1 (Conta Poupança)
         */

        /*
         * Regra 2 (Conta Poupança): Taxa de 0,5% para transferências para mesma instituição bancária
         */
        ContaPoupanca contaPoupancaRegra2 = new ContaPoupanca(2455, InstituicaoBancaria.BRADESCO, 600.0, new ArrayList());
        ContaBancaria contaDestinoMesmaInstituicao = new ContaCorrente(2676, InstituicaoBancaria.BRADESCO, 200.0, new ArrayList<>());
        contaPoupancaRegra2.transferir(100.0, contaDestinoMesmaInstituicao);
        System.out.println("BANCO IGUAL");
        if (contaPoupancaRegra2.consultarSaldo() == 499.5) {
            System.out.println("Saldo: " + contaPoupancaRegra2.consultarSaldo());
        } else {
            System.out.println(" Não deu certo a operação de transferência (Conta Corrente)");
        }

        System.out.println("BANCO DIFERENTE");
        contaPoupancaRegra2 = new ContaPoupanca(2455, InstituicaoBancaria.BRADESCO, 600.0, new ArrayList());
        ContaBancaria contaDestinoInstituicaoDiferente = new ContaCorrente(2676, InstituicaoBancaria.CAIXA, 600.0, new ArrayList<>());
        contaPoupancaRegra2.transferir(100.0, contaDestinoInstituicaoDiferente);
        if (contaPoupancaRegra2.consultarSaldo() == 499.0) {
            System.out.println(" Saldo: " + contaPoupancaRegra2.consultarSaldo());
        } else {
            System.out.println(" Não deu certo a operação de transferência (Conta Corrente)");
        }
        /*
         *Fim Regra 2 (Conta Poupança)
         */

        System.out.println("---------------TESTES REGRAS SOBRE INSTITUIÇÕES BANCÁRIAS----------------------------");
        /*
         * Regra 1 (REGRAS SOBRE INSTITUIÇÕES BANCÁRIAS- Conta Digital): Somente Itaú e Nubank permitem contas digitais
         */
        try {
            ContaDigital contaDigitalInstituicoesPermitem = new ContaDigital(2345, InstituicaoBancaria.CAIXA, 200.0, new ArrayList<>());
        } catch (Exception e) {
            System.out.println("Somente Itaú e Nubank permitem contas digitais;");
        }
        /*
         *Fim Regra 1 (REGRAS SOBRE INSTITUIÇÕES BANCÁRIAS- Conta Digital)
         */
        /*
         * Regra 2 (REGRAS SOBRE INSTITUIÇÕES BANCÁRIAS- Conta PoupançaDigital): Somente Nubank não permite conta poupança.
         */

        try {
            ContaPoupanca contaPoupancaInstituicoesNaopermitem = new ContaPoupanca(2345, InstituicaoBancaria.NUBANK, 200.0, new ArrayList());
        } catch (Exception e) {
            System.out.println("Somente Nubank não permite conta poupança");
        }
        System.out.println("---------------TESTES EXTRATO CONTA CORRENTE----------------------------");
        // Exibir extrato
        ContaCorrente contaCorrente = new ContaCorrente(2345, InstituicaoBancaria.BRADESCO, 200.0, new ArrayList<>());
        contaCorrente.depositar(100.0);
        contaCorrente.sacar(100.0);

        contaCorrente.exibirExtrato(LocalDate.of(2020, 8, 26), null);
        contaCorrente.exibirExtrato(null, LocalDate.of(2020, 8, 26));
        contaCorrente.exibirExtrato(null, null);

        System.out.println("---------------TESTES EXTRATO CONTA DIGITAL----------------------------");
        ContaDigital contaDigital = new ContaDigital(2345, InstituicaoBancaria.NUBANK, 500.0, new ArrayList<>());
        contaDigital.depositar(230.0);
        contaDigital.sacar(130.0);

        contaDigital.exibirExtrato(LocalDate.of(2020, 9, 5), null);
        contaDigital.exibirExtrato(null, LocalDate.of(2020, 9, 5));
        contaDigital.exibirExtrato(null, null);


        System.out.println("---------------TESTES EXTRATO CONTA POUPANCA----------------------------");
        ContaPoupanca contaPoupanca = new ContaPoupanca(2345, InstituicaoBancaria.CAIXA, 600.0, new ArrayList<>());
        contaPoupanca.depositar(300.0);
        contaPoupanca.sacar(200.0);

        contaPoupanca.exibirExtrato(LocalDate.of(2020, 9, 15), null);
        contaPoupanca.exibirExtrato(null, LocalDate.of(2020, 9, 15));
        contaPoupanca.exibirExtrato(null, null);
    }
}















