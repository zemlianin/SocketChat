package org.example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CapitalizeClient {
    public static void main(String[] args) throws Exception {
        try (var socket = new Socket("localhost", 59898)) {
            System.out.println("Enter lines of text then Ctrl+D or Ctrl+C to quit");
            System.out.println("Input your name");
            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            while (scanner.hasNextLine()) {
                 out.println(scanner.nextLine());
                 System.out.println(in.nextLine());
            }
        }
    }
}
