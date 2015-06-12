package es.unileon.si;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class Interfaz  extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private JLabel lblPedirCodigo;
	private JTextField txtCodigoBarras;
	private JLabel lblCorrecto;
	private JLabel lblIncorrecto;
	private JPanel panelOpciones;
	JButton btnValidar;
	private JButton btnDigitoControl;
	private JButton btnDigitoBorrado;
	private JPanel panelErrores;
	private JButton btnDigitosConsecutivos;
	private JSeparator separator;
	private JLabel lblIntercambio;
	private JLabel lblDifieren;
	private JLabel lblBorron;
	private JTextField txtProbabilidad;
	private JLabel lblNewLabel;
	private JButton btnBorrarAleatorio;
	private JLabel lblDiferencia;

	public Interfaz() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz.class.getResource("/es/unileon/si/images/Barcode.png")));
		this.setTitle("Codigos de barras");
		this.setBounds(100, 100, 417, 393);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		lblPedirCodigo = new JLabel("Introduzca el código de barras:");
		lblPedirCodigo.setBounds(10, 11, 196, 35);
		this.getContentPane().add(lblPedirCodigo);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setBounds(190, 18, 159, 20);
		getContentPane().add(txtCodigoBarras);
		
		lblCorrecto = new JLabel("");
		lblCorrecto.setIcon(new ImageIcon(Interfaz.class.getResource("/es/unileon/si/images/ok.png")));
		lblCorrecto.setBounds(359, 11, 30, 29);
		//no se ve, se pasa a a true en caso que la validacion sea correcta
		lblCorrecto.setVisible(false);
		getContentPane().add(lblCorrecto);
		
		lblIncorrecto = new JLabel("");
		lblIncorrecto.setIcon(new ImageIcon(Interfaz.class.getResource("/es/unileon/si/images/fail.png")));
		lblIncorrecto.setBounds(359, 11, 30, 29);
		//no se ve, se pasa a true en caso que la validacion sea incorrecta
		lblIncorrecto.setVisible(false);
		getContentPane().add(lblIncorrecto);
		
		panelOpciones = new JPanel();
		panelOpciones.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOpciones.setLayout(null);
		panelOpciones.setBounds(8, 246, 381, 97);
		getContentPane().add(panelOpciones);
		
		btnValidar = new JButton("<html><center>Validar<br/>Codigo</center></html>");
		btnValidar.setBounds(10, 28, 115, 52);
		panelOpciones.add(btnValidar);
		
		btnDigitoControl = new JButton("<html><center>Calcular digito<br/> de control</center></html>");
		btnDigitoControl.setBounds(135, 28, 115, 52);
		panelOpciones.add(btnDigitoControl);
		
		btnDigitoBorrado = new JButton("<html><center>Recuperar<br/>digito borrado</center></html>");
		btnDigitoBorrado.setBounds(256, 28, 115, 52);
		panelOpciones.add(btnDigitoBorrado);
		
		panelErrores = new JPanel();
		panelErrores.setBorder(new TitledBorder(null, "Errores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelErrores.setBounds(10, 52, 379, 183);
		panelErrores.setLayout(null);
		getContentPane().add(panelErrores);
		
		btnDigitosConsecutivos = new JButton("Intercambiar");
		btnDigitosConsecutivos.setBounds(254, 142, 115, 30);
		panelErrores.add(btnDigitosConsecutivos);
		
		separator = new JSeparator();
		separator.setBounds(10, 106, 359, 9);
		panelErrores.add(separator);
		
		lblIntercambio = new JLabel("Intercambio de dos d\u00EDgitos consecutivos");
		lblIntercambio.setBounds(10, 106, 234, 50);
		panelErrores.add(lblIntercambio);
		
		lblDifieren = new JLabel("Difieren en:");
		lblDifieren.setBounds(10, 134, 200, 38);
		panelErrores.add(lblDifieren);
		
		lblBorron = new JLabel("Probabilidad borrar mas de un digito");
		lblBorron.setBounds(10, 24, 247, 20);
		panelErrores.add(lblBorron);
		
		txtProbabilidad = new JTextField();
		txtProbabilidad.setText("0.05");
		txtProbabilidad.setBounds(227, 24, 44, 20);
		panelErrores.add(txtProbabilidad);
		txtProbabilidad.setColumns(10);
		
		lblNewLabel = new JLabel("Borron aleatorio de digitos");
		lblNewLabel.setBounds(10, 50, 193, 50);
		panelErrores.add(lblNewLabel);
		
		btnBorrarAleatorio = new JButton("Borrar");
		btnBorrarAleatorio.setBounds(254, 64, 115, 30);
		panelErrores.add(btnBorrarAleatorio);
		
		lblDiferencia = new JLabel("");
		lblDiferencia.setBounds(84, 145, 25, 17);
		panelErrores.add(lblDiferencia);
		
		//escuchar evento boton  cambio digitos
		this.btnDigitosConsecutivos.addActionListener(this);
		
		//escuchar evento boton borron aleatorio
		this.btnBorrarAleatorio.addActionListener(this);
		
		//calcular digito de control
		this.btnDigitoControl.addActionListener(this);
		
		//escuchar evento boton validarcodigo
		this.btnValidar.addActionListener(this);
	
	}


	

	@Override
	public void actionPerformed(ActionEvent e) {
		//accion evento cambio digitos
		if(e.getSource()== this.btnDigitosConsecutivos)
		{
			IntercambioDigitos cambio=new IntercambioDigitos(this.txtCodigoBarras.getText());
			cambio.intercambio();
			this.txtCodigoBarras.setText(cambio.getCodigo());
			//mostramos la diferencia entre los digitos intercambiados para ver si fucnionara la validacion
			this.lblDiferencia.setText(cambio.getDiferencia()+"");	
		}
		else if(e.getSource()== this.btnBorrarAleatorio) {
			BorronRandom borron = new BorronRandom(txtCodigoBarras.getText(), txtProbabilidad.getText());
			txtCodigoBarras.setText(borron.borrar());
		}
		else if(e.getSource() == this.btnDigitoControl) {
			CalculoDigitoDeControl control = new CalculoDigitoDeControl(this.txtCodigoBarras.getText());
			txtCodigoBarras.setText(control.mostrar());
			JOptionPane.showMessageDialog(null, "El dígito de control para el código " + this.txtCodigoBarras.getText() + " es: " + control.getControl(), "DÍGITO DE CONTROL", JOptionPane.INFORMATION_MESSAGE);
		
		}else if(e.getSource() == this.btnValidar) {
			ValidarCodigo validar = new ValidarCodigo(this.txtCodigoBarras.getText());
		}
		//en el else if otro evento de otro boton
		
	}
}
