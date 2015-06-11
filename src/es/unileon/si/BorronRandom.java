package es.unileon.si;

public class BorronRandom {
	
	private String codigo;
	private double probabilidad;
	
	public BorronRandom(String c, String p) {
		this.codigo = c;
		this.probabilidad = Double.valueOf(p);
	}

	public String borrar() {
		
		char[] caracteres = codigo.toCharArray();
		
		for(int i=0; i<caracteres.length; i++) {
			double aleat = Math.random();
			if(aleat < probabilidad)
				caracteres[i] = 'X';
		}
		
		return String.valueOf(caracteres);
	}

}
