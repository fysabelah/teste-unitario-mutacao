package br.com.verify.cpf;

import br.com.verify.cpf.functions.ValidateCpf;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Informe um CPF: ");

        String cpf = ler.next();

        System.out.println("Resultado: ");

        if (ValidateCpf.isCPF(cpf)) {
            System.out.println(ValidateCpf.imprimeCPF(cpf));
        } else {
            System.out.println("Erro!!! CPF inválido!!!");
        }
    }
}

