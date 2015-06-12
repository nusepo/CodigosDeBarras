package es.unileon.si;

import javax.swing.JOptionPane;

public class ValidarCodigo {

	private String codigo;
	private int modulo = 10;

	public ValidarCodigo(String codigo) {
		boolean valido= true;
		if(codigo.length() != 13){
			JOptionPane.showMessageDialog(null, "No es un codigo valido por longitud");
			valido = false;
			
		}else{			
			for(int i=0; i<codigo.length(); i++) {
				if (!Character.isDigit(codigo.charAt(i))){
					JOptionPane.showMessageDialog(null, "No es un codigo valido por caracteres");
					valido=false;
					break;
				}
			}			
		}
		if(valido){
			this.codigo = codigo;
			comprobacion();
		}
	}

	private void comprobacion() {
		int impares = 0, pares = 0;
		
				
		for(int i=0; i<this.codigo.length(); i++) {
			if(i%2==0)
				impares = impares + Character.getNumericValue(codigo.charAt(i));
			else 
				pares = pares + Character.getNumericValue(codigo.charAt(i));
		}
		
		int suma = (impares + (3*pares))%modulo;
		
		if(suma == 0){
			JOptionPane.showMessageDialog(null, "El codigo es válido");
			
		}else{		
			JOptionPane.showMessageDialog(null, "El codigo es invalido. El digito de control no es correcto");
		}
		
	}

}
