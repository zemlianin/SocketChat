package org.example.tests;

import org.example.CapitalizeClient;
import org.example.CapitalizeServer;
import org.junit.jupiter.api.*;

public class CapitalizeClientTests {
    @Test
    void SelectHost_SERVERIP_When_WhiteSpace() {
        System.out.println("======TEST 1 EXECUTED=======");
        Assertions.assertEquals(CapitalizeClient.SERVERIP, CapitalizeClient.SelectHost(" "));
    }

    @Test
    void SelectHost_SERVERIP_When_AabbBb() {
        System.out.println("======TEST 2 EXECUTED=======");
        Assertions.assertEquals(CapitalizeClient.SERVERIP, CapitalizeClient.SelectHost("AabbBb"));
    }

    @Test
    void SelectHost_SERVERIP_When_EmptyString() {
        System.out.println("======TEST 3 EXECUTED=======");
        Assertions.assertEquals(CapitalizeClient.SERVERIP, CapitalizeClient.SelectHost(""));
    }

    @Test
    void SelectHost_LOCALIP_When_1() {
        System.out.println("======TEST 4 EXECUTED=======");
        Assertions.assertEquals(CapitalizeClient.LOCALIP, CapitalizeClient.SelectHost("1"));
    }

    // Данный тест обходиться нарочно для демонстрации работы @Disabled
    @Disabled
    @Test
    void SelectHost_SERVERIP_When_2() {
        System.out.println("======TEST 5 EXECUTED=======");
        Assertions.assertEquals(CapitalizeClient.SERVERIP, CapitalizeServer.strToUp("2"));
    }
}
