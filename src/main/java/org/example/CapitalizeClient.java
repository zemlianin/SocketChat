package org.example;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CapitalizeClient {
    private ExecutorService executor
            = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws Exception {
        try (var socket = new Socket("localhost", 59898)) {
            System.out.println("Enter lines of text then Ctrl+D or Ctrl+C to quit");
            System.out.println("Input your name");
            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            Future<Integer> future = new Notificator().notificate(in);
            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
            }
        }
    }

    public static class Notificator {

        private ExecutorService executor
                = Executors.newSingleThreadExecutor();

        public Future<Integer> notificate(Scanner in) {
            return executor.submit(() -> {
                while (true) {
                    System.out.println(in.nextLine());
                    Thread.sleep(100);
                }
            });
        }
    }

}
