package es.unileon.si;

public class IntercambioDigitos {

	private String codigo;
	private int diferencia;
	
	public int getDiferencia() {
		return diferencia;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public IntercambioDigitos(String codigoBarras)
	{
		this.codigo= codigoBarras;
		this.diferencia=0;
	}
	
	/**
	 * Intercambia dos digitos consecutivos de manera aleatoria
	 * @param codigo
	 * @return codigo con los dos digitos intercambiados
	 */
	public void  intercambio()
	{
	
		int posicionIntercambio = (int) (Math.random() * (this.codigo.length()-1));
		char primero=this.codigo.charAt(posicionIntercambio);
		char segundo=this.codigo.charAt(posicionIntercambio+1);
		String codigoCambiado="";
		for(int i=0;i<this.codigo.length();i++)
		{
			if(i==posicionIntercambio)
			{
				codigoCambiado+=segundo;
			}
			else if(i==posicionIntercambio+1)
			{
				codigoCambiado+=primero;
			}
			else
			{
				codigoCambiado+=codigo.charAt(i);
			}
		}
		this.codigo=codigoCambiado;
		this.diferencia=Math.abs(Integer.parseInt(primero+"")-Integer.parseInt(segundo+""));
		
	}

}
