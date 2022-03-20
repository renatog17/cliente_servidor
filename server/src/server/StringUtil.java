package cliente_servidor.old;

public class StringUtil {

	public static String[] quebrarStringPorEspaco(String txt) {
		String[] palavras = new String[3];
		int s = 0;
		int posEspaco = 0;
		for (int i = 0; i < txt.length(); i++) {
			if(txt.substring(i, i+1).equals(" ")) {
				palavras[s] = txt.substring(posEspaco,i);
				s++;
				posEspaco = i+1;
			}
		}
		palavras[s++] = txt.substring(posEspaco,txt.length());
		return palavras;
	}
	
	public static void main(String[] args) {
		String teste = "serv1 con serv2";
		String[] palavras = quebrarStringPorEspaco(teste);
		for (int i = 0; i < palavras.length; i++) {
			System.out.println(palavras[i]);
		}
	
	}
}
