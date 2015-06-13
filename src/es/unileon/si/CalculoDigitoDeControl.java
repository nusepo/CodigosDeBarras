package es.unileon.si;

import javax.swing.JOptionPane;

public class CalculoDigitoDeControl {
	
	private String codigo;
	private String codigoConControl;
	private int digitoDeControl;
	private int mod = 10;
	
	public int getControl() {
		return digitoDeControl;
	}
	
	public CalculoDigitoDeControl(String c) {
		this.codigo = c;
	}

	public String mostrar() {
		char[] caracteres = codigo.toCharArray();
		int suma = 0, impares = 0, pares = 0;
		
		boolean valido= true;
		if(codigo.length() != 12){
			JOptionPane.showMessageDialog(null, "No es un código válido por longitud");
			valido = false;			
		}else{			
			for(int i=0; i<codigo.length(); i++) {
				if (!Character.isDigit(codigo.charAt(i))){
					JOptionPane.showMessageDialog(null, "No es un código válido por caracteres");
					valido=false;
					break;
				}
			}			
		}
		if(valido){
			for(int i=1; i<=caracteres.length; i++) {
				if(i%2==1)
					impares += Character.getNumericValue(caracteres[i-1]);
				else if(i%2==0)
					pares += Character.getNumericValue(caracteres[i-1]);
			}
			suma = (impares + (3*pares))%mod;	
			digitoDeControl = (10-suma)%mod;
			codigoConControl = codigo + digitoDeControl;
			
			JOptionPane.showMessageDialog(null, "El dígito de control para el código " + codigo + " es: " + digitoDeControl, "DÍGITO DE CONTROL", JOptionPane.INFORMATION_MESSAGE);
			return String.valueOf(codigoConControl);
		}
		
			return codigo;
		
	}

}//848000065235
 //978316148410