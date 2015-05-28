package es.unileon.si;

public class BorronRandom {

	public static void main(String[] args) {
		String codigoDeBarras = "8410240210404";
		
		int posicionBorron = (int) (Math.random() * codigoDeBarras.length());
		
		char[] caracteres = codigoDeBarras.toCharArray();
		caracteres[posicionBorron] = 'X';
		String codigoConBorron = String.valueOf(caracteres);
		
		System.out.println(codigoConBorron);
	}

}
