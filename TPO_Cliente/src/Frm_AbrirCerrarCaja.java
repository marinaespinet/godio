import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import Interfaces.BusinessDelegate;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Frm_AbrirCerrarCaja extends javax.swing.JFrame {

	private static Frm_AbrirCerrarCaja instancia = null;
	private JLabel jLabelTitulo;
	private JButton jButtonCerrar;
	private JTextField jTextFieldNotificador;

	public static Frm_AbrirCerrarCaja getInstancia(){
		if(instancia == null){			
			instancia = new Frm_AbrirCerrarCaja();
		} 
		return instancia;
	}
	
	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JTextField jTextFieldNotificacion;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Frm_AbrirCerrarCaja inst = new Frm_AbrirCerrarCaja();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Frm_AbrirCerrarCaja() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Liquidar comisiones Mozos");
			{
				jTextFieldNotificacion = new JTextField();
				getContentPane().add(jTextFieldNotificacion);
				getContentPane().add(getJTextFieldNotificador());
				getContentPane().add(getJButtonCerrar());
				getContentPane().add(getJLabelTitulo());
				jTextFieldNotificacion.setBounds(26, 158, 176, 23);
				jTextFieldNotificacion.setEditable(false);
				jTextFieldNotificacion.setEnabled(false);
				jTextFieldNotificacion.setBorder(BorderFactory.createCompoundBorder(
						null, 
						null));
			}
			pack();
			this.setSize(654, 468);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JTextField getJTextFieldNotificador() {
		if(jTextFieldNotificador == null) {
			jTextFieldNotificador = new JTextField();
			jTextFieldNotificador.setBounds(38, 361, 474, 41);
			jTextFieldNotificador.setEditable(false);
			jTextFieldNotificador.setText("");
		}
		return jTextFieldNotificador;
	}
	
	private JButton getJButtonCerrar() {
		if(jButtonCerrar == null) {
			jButtonCerrar = new JButton();
			jButtonCerrar.setText("Aceptar");
			jButtonCerrar.setBounds(524, 362, 88, 40);
			jButtonCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					System.out.println("jButtonCerrar.actionPerformed, event="+evt);
					setVisible(false);
				}
			});
		}
		return jButtonCerrar;
	}

	public void mostrarMensaje(String string) {
		jTextFieldNotificador.setText(string);
		
	}
	
	private JLabel getJLabelTitulo() {
		if(jLabelTitulo == null) {
			jLabelTitulo = new JLabel();
			jLabelTitulo.setText("Abrir Caja");
			jLabelTitulo.setBounds(20, 12, 182, 20);
			jLabelTitulo.setFont(new java.awt.Font("Segoe UI",1,14));
		}
		return jLabelTitulo;
	}

}
