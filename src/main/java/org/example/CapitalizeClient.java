package org.example;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CapitalizeClient {
    public final static String SERVERIP = "194.87.186.59";
    public final static String LOCALIP = "localhost";
    final private static int PORT = 59898;

    // Не бейте за эту дичь, я всего лишь хочу написать тесты)
    public static String SelectHost(String input) {
        if (input == "1") {
            return LOCALIP;
        } else {
            return SERVERIP;
        }
    }

    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        System.out.println("Select IP, input 1 for localhost-connect and input any other string for server-connect");
        String input = scanner.nextLine();
        String host = SelectHost(input);
        try (var socket = new Socket(host, PORT)) {
            System.out.println("Enter lines of text then Ctrl+D or Ctrl+C to quit");
            System.out.println("Input your name");
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
