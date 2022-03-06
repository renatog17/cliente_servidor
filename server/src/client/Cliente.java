package client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) 
                    throws UnknownHostException, IOException {
        Socket socket = new Socket("0.tcp.ngrok.io", 17426);
        System.out.println("Conectado ao servidor");
        Scanner mensagem = new Scanner(System.in);
        PrintStream saida = new PrintStream(socket.getOutputStream());
        System.out.println("Digite uma mensagem:");
        while (mensagem.hasNextLine()) {
            saida.println(mensagem.nextLine());
        }
        saida.close();
        mensagem.close();
        socket.close();
    }
}