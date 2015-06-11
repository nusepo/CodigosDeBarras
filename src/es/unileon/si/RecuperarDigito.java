package es.unileon.si;

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
		cb = cb.toLowerCase();
		int pos = cb.indexOf("x".toLowerCase());
		
		//Sustituímos la X por un 0
		cb = cb.replace("x","0");
		
		//Parseamos el string para convertirlo a long.
		String result = "";
		long codigo= Long.parseLong(cb);
		
		//Creamos un array donde vamos a meter todos los números para poder trabajar con ellos más cómodamente.
		Long[] arrayCb = new Long[13];

		for (int i=0; i<arrayCb.length;i++){
			arrayCb[i]=codigo%10;
			codigo /= 10;
		}

		//Ahora hacemos el cálculo de todos los digitos.
		int suma = 0;
		for (int i=0; i< arrayCb.length;i++){
			//a1+3a2 en este caso sera array[0]+3*array[1] etc.
			if (i==0 || i%2==0){
				suma += arrayCb[i];
			}else {
				suma += 3*arrayCb[i];
			}
		}
		
		
		if (suma%10 == 0) {
			result = "El código de barras es correcto";
		}else{
			if (pos%2==0){
				result = "El dígito borrado es : "+(10 - (suma%10)); 
			}else{
				//Los pares por lo de que pos empieza en 0..
				result = "El dígito borrado esta en la pos"+pos+" : "+(3*(suma%10))%10;
			}
		}

		return result;
	}
}
