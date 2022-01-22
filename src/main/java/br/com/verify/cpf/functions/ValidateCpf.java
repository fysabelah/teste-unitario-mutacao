package br.com.verify.cpf.functions;

import java.util.InputMismatchException;

public class ValidateCpf {

    public static String imprimeCPF(String cpf) {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }

    public static boolean isCPF(String cpf) {
        if (verifySameDigit(cpf) || cpf.length() != 11)
            return false;

        try {
            char dig10 = calculateFirstCheckDigit(cpf);
            char dig11 = calculateSecondCheckDigit(cpf);

            return dig10 == cpf.charAt(9) && dig11 == cpf.charAt(10);
        } catch (InputMismatchException error) {
            return false;
        }
    }

    private static char calculateSecondCheckDigit(String cpf) {
        int sm = 0;
        int peso = 11;

        int num;
        for (int i = 0; i < 10; i++) {
            num = cpf.charAt(i) - 48;
            sm += num * peso;
            peso -= 1;
        }

        int r = 11 - (sm % 11);

        if (r == 10 || r == 11)
            return '0';

        return (char) (r + 48);
    }

    private static char calculateFirstCheckDigit(String cpf) {
        int sm = 0;
        int peso = 10;

        int num;
        for (int i = 0; i < 9; i++) {
            num = cpf.charAt(i) - 48;
            sm += num * peso;
            peso -= 1;
        }

        int r = 11 - (sm % 11);

        if (r == 10 || r == 11) {
            return '0';
        }

        return (char) (r + 48);
    }

    private static boolean verifySameDigit(String cpf) {
        return cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") ||
                cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") ||
                cpf.equals("99999999999");
    }
}
