package org.example.tests;

import org.example.CapitalizeServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

public class CapitalizeServerTests {
    @BeforeAll
    static void setup(){
        System.out.println("======RUN TEST=======");
    }
    @Test
    void strToUp_EmptyString_When_EmptyString() {
        System.out.println("======TEST 1 EXECUTED=======");
        Assertions.assertEquals("", CapitalizeServer.strToUp(""));
    }

    @Test
    void strToUpTest_AAA_When_aaa() {
        System.out.println("======TEST 2 EXECUTED=======");
        Assertions.assertEquals("AAA", CapitalizeServer.strToUp("aaa"));
    }

    @Test
    void strToUpTest_AAA_When_AAA() {
        System.out.println("======TEST 3 EXECUTED=======");
        Assertions.assertEquals("AAA", CapitalizeServer.strToUp("AAA"));
    }

    @Test
    void strToUpTest_whiteSpace_When_whiteSpace() {
        System.out.println("======TEST 4 EXECUTED=======");
        Assertions.assertEquals(" ", CapitalizeServer.strToUp(" "));
    }

    // Данный тест обходиться нарочно для демонстрации работы @Disabled
    @Disabled
    @Test
    void strToUpTest_T_When_t() {
        System.out.println("======TEST 4 EXECUTED=======");
        Assertions.assertEquals(" ", CapitalizeServer.strToUp(" "));
    }
}
