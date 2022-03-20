package cliente_servidor.old;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LeituraTxt {

	public static boolean isExisteCliente(String nomeCliente) throws FileNotFoundException{
		Scanner in = new Scanner(new FileReader("clientes.txt"));
		while (in.hasNextLine()) {
		    String cliente = in.nextLine();
		    if(cliente.equals(nomeCliente))
		    return true;
		}
		return false;
	}

	public static void main(String[] args) {
		try {
			System.out.println(isExisteCliente("Yla"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
