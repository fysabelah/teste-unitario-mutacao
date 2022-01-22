package br.com.verify.cpf;

import br.com.verify.cpf.functions.ValidateCpf;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateCpfTest {

    @Test
    public void testImprimeCPF() {
        Assert.assertEquals("496.613.940-67", ValidateCpf.imprimeCPF("49661394067"));
    }

    @Test
    public void testIsCPF() {
        assertTrue(ValidateCpf.isCPF("49661394067"));
    }

    @Test
    public void testIs2CPF() {
        assertTrue(ValidateCpf.isCPF("91062611080"));
    }

    @Test
    public void testIsNotCPF() {
        assertFalse(ValidateCpf.isCPF("49662292067"));
    }

    @Test
    public void testSmallerSize() {
        assertFalse(ValidateCpf.isCPF("12132322"));
    }

    @Test
    public void testBiggerSize() {
        assertFalse(ValidateCpf.isCPF("121345678908"));
    }

    @Test
    public void isTheSameCPF() {
        assertFalse(ValidateCpf.isCPF("11111111111"));
    }
}