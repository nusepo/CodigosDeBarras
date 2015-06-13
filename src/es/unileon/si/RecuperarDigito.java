package es.unileon.si;

import javax.swing.JOptionPane;

public class RecuperarDigito {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   System.out.println(recuperarDigito("X901234123457"));
		 //Codigo de barras correcto: 5901234123457
		//   5 +0 +2 +4 + 2 +4  +7 = 24
		//   3 * (9 + 1 + 3 +1 +3 +5) = 3*(22)
	}
	
	public static String recuperarDigito(String cb){
		//Se introducirá en el TextBox correspondiente una cadena de 13 caracteres con una X.
		
		//Para evitar errores, hacemos que la X sea minúscula y la buscamos en el String
		cb = cb.toUpperCase();
		int pos = cb.indexOf("X");
		
		//Este será el String de salida del método.
		String cbString = cb;
		int cuentaX = 0;
		int[] arrayCb = new int[13];
		for(int i=0;i< cbString.length();i++)
		{
			if(cbString.charAt(i)=='X'){
				cuentaX ++;
				arrayCb[i]=0;
			}else{
				arrayCb[i]=Integer.parseInt(cbString.charAt(i)+"");
			}
				
		}
		
		if (cuentaX>=2){
			JOptionPane.showMessageDialog(null, "Hay dos o  más borrones. La capacidad correctora del programa es 1.");
			return cbString;
			
		}else if (cuentaX==0){
			JOptionPane.showMessageDialog(null, "El código no tiene borrones ");
			return cbString;
		}else{//Si hay 1 X
			//Sustituímos la X por un 0
			cb = cb.replace("X","0");
			
			//Parseamos el string para convertirlo a long.
			String result = "";
			long codigo= Long.parseLong(cb);

			//ALGORITMO del código de barras.
			int suma = 0;
			for (int i=0; i< arrayCb.length;i++){
				//a1+3a2 en este caso sera array[0]+3*array[1] etc.
				if (i==0 || i%2==0){
					suma += arrayCb[i];
				}else {
					suma += 3*arrayCb[i];
				}
			}
			
			//Creamos un long con el código de barras.
			if (suma%10 == 0) {
				JOptionPane.showMessageDialog(null, "El dígito borrado es un 0");
				cbString = cbString.replace("X",0+"");
			}else{
				if (pos%2==0){
					JOptionPane.showMessageDialog(null, "El dígito borrado es un "+(10 - (suma%10)));
					cbString = cbString.replace("X",(10 - (suma%10)+""));
				}else{
					//Los pares por lo de que pos empieza en 0..
					cbString = cbString.replace("X",(3*(suma%10))%10+"");
					JOptionPane.showMessageDialog(null, "El dígito borrado es un "+(3*(suma%10))%10);
				}
			}

			return cbString;
		}
	}
}
