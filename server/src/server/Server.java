package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Servidor escutando na porta 8080");
        Socket cliente = serverSocket.accept();
        System.out.println("Cliente conectado " +  
            cliente.getInetAddress().getHostAddress()
        );
        Scanner s = new Scanner(cliente.getInputStream());
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }
        s.close();
        serverSocket.close();
        cliente.close();
    }
}