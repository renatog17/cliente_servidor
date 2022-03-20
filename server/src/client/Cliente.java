package cliente_servidor.old;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cliente {
	
	private Socket socket;
	private OutputStream ou;
	private Writer ouw;
	private BufferedWriter bfw;
	
    public void conectar() 
                    throws UnknownHostException, IOException {
        socket = new Socket("127.0.0.1", 8080);
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
    
    public void escutar() throws IOException {

		InputStream in = socket.getInputStream();
		InputStreamReader inr = new InputStreamReader(in);
		BufferedReader bfr = new BufferedReader(inr);
		String msg = "";

		while (!"Sair".equalsIgnoreCase(msg)) {
			
		}

			
	}
    public static void main(String[] args) throws UnknownHostException, IOException {
		Cliente cliente = new Cliente();
		cliente.conectar();
	}
}