package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;


public class CapitalizeServer {

    public static void main(String[] args) throws Exception {
        try (var listener = new ServerSocket(59898)) {
            System.out.println("The capitalization server is running...");
            var pool = Executors.newFixedThreadPool(20);
            while (true) {
                pool.execute(new Capitalizer(listener.accept()));
            }
        }
    }

    static public String strToUp(String s) {
        return s.toUpperCase();
    }
    private static class Capitalizer implements Runnable {
        static ConcurrentHashMap<String, Socket> users = new ConcurrentHashMap<>();
        static CopyOnWriteArrayList<PrintWriter> chats = new CopyOnWriteArrayList<>();
        private Socket socket;

        Capitalizer(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("Connected: " + socket);
            try {
                var in = new Scanner(socket.getInputStream());
                var out = new PrintWriter(socket.getOutputStream(), true);
                String name = "";
                boolean flag = false;
                while (in.hasNextLine()) {
                    if (flag) {
                        String msg = in.nextLine();
                        for (var stream : chats) {
                            stream.println(name + " : " + CapitalizeServer.strToUp(msg));
                        }
                    } else {
                        name = in.nextLine();
                        if (!users.containsKey(name)) {
                            users.put(name, socket);
                            chats.add(out);
                            flag = true;
                            out.println("success");
                        } else {
                            out.println("input other name");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Error:" + socket);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                }
                System.out.println("Closed: " + socket);
            }
        }
    }
}
