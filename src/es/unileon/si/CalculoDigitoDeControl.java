package es.unileon.si;

public class CalculoDigitoDeControl {
	
	private String codigo;
	private String codigoConControl;
	private int digitoDeControl;
	
	public int getControl() {
		return digitoDeControl;
	}
	
	public CalculoDigitoDeControl(String c) {
		this.codigo = c;
	}

	public String mostrar() {
		char[] caracteres = codigo.toCharArray();
		int suma = 0, impares = 0, pares = 0;
		
		//PONER ERROR SI ES MAYOR O MENOR QUE 12
				
		for(int i=1; i<=caracteres.length; i++) {
			if(i%2==1)
				impares += Character.getNumericValue(caracteres[i-1]);
			else if(i%2==0)
				pares += Character.getNumericValue(caracteres[i-1]);
		}
		suma = (impares + (3*pares))%10;	
		digitoDeControl = 10-suma;
		codigoConControl = codigo + digitoDeControl;
		
		return String.valueOf(codigoConControl);
	}

}//848000065235