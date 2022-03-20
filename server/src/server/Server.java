package cliente_servidor.old;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread{
	
	private static ServerSocket serverSocket;
	private static ArrayList<BufferedWriter> clientes;
	private Socket conexaoCliente;
	private InputStream inputStream;
	private InputStreamReader inputStreamReader;
	private BufferedReader bufferedReader;
	private String nome;
	
	public Server(Socket clienteConexao) {
		this.conexaoCliente = clienteConexao;
		try {
			inputStream = conexaoCliente.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			OutputStream outputStream = this.conexaoCliente.getOutputStream();
			Writer writer = new OutputStreamWriter(outputStream);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			clientes.add(bufferedWriter);
			String msg;
			msg = bufferedReader.readLine();
			String[] palavras = StringUtil.quebrarStringPorEspaco(msg);
			String cliente1 = palavras[0];
			String acao = palavras[1];
			String cliente2 = palavras[2];
			if(LeituraTxt.isExisteCliente(cliente2)&& LeituraTxt.isExisteCliente(cliente1)) {
				System.out.println("Conexão Aceita");
				while (true) {
					msg = bufferedReader.readLine();
					System.out.println(msg);
					//sendToAll(bufferedWriter, msg);
				}
			}else {
				System.out.println("Erro: cliente não cadastrado");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enviarAcao(BufferedWriter bwSaida, String msg) throws IOException {
		BufferedWriter bwS;

		for (BufferedWriter bw : clientes) {
			bwS = (BufferedWriter) bw;
			if (!(bwSaida == bwS)) {
				bw.write(nome + " -> " + msg + "\r\n");
				bw.flush();
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(8080);
        clientes = new ArrayList<BufferedWriter>();
        
        System.out.println("Servidor escutando na porta 8080");
        
        while (true) {
        	System.out.println("Aguardando conexão...");
			Socket con = serverSocket.accept();
			System.out.println("Cliente conectado...");
			Thread t = new Server(con);
			t.start();
        }
        
        
    }
}