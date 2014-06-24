import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
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

import Exceptions.RestaurantException;
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
public class Frm_AbrirMesa extends javax.swing.JFrame {

	private static Frm_AbrirMesa instancia = null;
	private JLabel jLabelMozo;
	private JTextField jTextFieldCantComensales;
	private JLabel jLabelCantComensales;
	private JTextField jTextFieldNroMozo;
	private JButton jButton;
	private JTextField jTextFieldSucursal;
	private JLabel jLabelSucursal;
	private JLabel jLabelTitulo;
	private JTextField jTextFieldNotificador;
	
	

	public static Frm_AbrirMesa getInstancia(){
		if(instancia == null){			
			instancia = new Frm_AbrirMesa();
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

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Frm_AbrirMesa inst = new Frm_AbrirMesa();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Frm_AbrirMesa() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Abrir Mesa");
			getContentPane().add(getJTextFieldNotificador());
			getContentPane().add(getJLabelTitulo());
			getContentPane().add(getJLabelSucursal());
			getContentPane().add(getJTextFieldSucursal());
			getContentPane().add(getJButton());
			getContentPane().add(getJLabelMozo());
			getContentPane().add(getJTextFieldNroMozo());
			getContentPane().add(getJLabelCantComensales());
			getContentPane().add(getJTextFieldCantComensales());
			pack();
			this.setSize(661, 205);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	
	
	private JLabel getJLabelTitulo() {
		if(jLabelTitulo == null) {
			jLabelTitulo = new JLabel();
			jLabelTitulo.setText("Abrir Mesa");
			jLabelTitulo.setBounds(20, 12, 182, 20);
			jLabelTitulo.setFont(new java.awt.Font("Segoe UI",1,14));
		}
		return jLabelTitulo;
	}

	private JTextField getJTextFieldNotificador() {
		if(jTextFieldNotificador == null) {
			jTextFieldNotificador = new JTextField();
			jTextFieldNotificador.setBounds(20, 104, 435, 41);
			jTextFieldNotificador.setEditable(false);
			jTextFieldNotificador.setText("");
		}
		return jTextFieldNotificador;
	}
	

	public void mostrarMensaje(String string) {
		jTextFieldNotificador.setText(string);
		
	}
	
	private JLabel getJLabelSucursal() {
		if(jLabelSucursal == null) {
			jLabelSucursal = new JLabel();
			jLabelSucursal.setText("Sucursal: ");
			jLabelSucursal.setBounds(473, 15, 50, 16);
		}
		return jLabelSucursal;
	}
	
	private JTextField getJTextFieldSucursal() {
		if(jTextFieldSucursal == null) {
			jTextFieldSucursal = new JTextField();
			jTextFieldSucursal.setText("3");
			jTextFieldSucursal.setBounds(556, 12, 25, 23);
			jTextFieldSucursal.setEditable(false);
		}
		return jTextFieldSucursal;
	}
	
	private JButton getJButton() {
		if(jButton == null) {
			jButton = new JButton();
			jButton.setText("Abrir mesa");
			jButton.setBounds(473, 104, 108, 41);
			jButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					System.out.println("jButton.actionPerformed, event="+evt);
					try {
						Integer mesaId = BusinessDelegate.getInstancia().abrirMesa(Integer.parseInt(jTextFieldNroMozo.getText()), Integer.parseInt(jTextFieldCantComensales.getText()));
						jTextFieldNotificador.setText("Acomode a los comensales en la mesa " + mesaId.toString());
					} catch (RemoteException e) {
						jTextFieldNotificador.setText(e.getMessage());
					}
				}
			});
		}
		return jButton;
	}
	
	private JLabel getJLabelMozo() {
		if(jLabelMozo == null) {
			jLabelMozo = new JLabel();
			jLabelMozo.setText("Mozo");
			jLabelMozo.setBounds(473, 50, 30, 16);
		}
		return jLabelMozo;
	}
	
	private JTextField getJTextFieldNroMozo() {
		if(jTextFieldNroMozo == null) {
			jTextFieldNroMozo = new JTextField();
			jTextFieldNroMozo.setText("1");
			jTextFieldNroMozo.setBounds(556, 47, 25, 23);
			jTextFieldNroMozo.setEditable(false);
		}
		return jTextFieldNroMozo;
	}
	
	private JLabel getJLabelCantComensales() {
		if(jLabelCantComensales == null) {
			jLabelCantComensales = new JLabel();
			jLabelCantComensales.setText("Cantidad de comensales: ");
			jLabelCantComensales.setBounds(112, 50, 146, 16);
		}
		return jLabelCantComensales;
	}
	
	private JTextField getJTextFieldCantComensales() {
		if(jTextFieldCantComensales == null) {
			jTextFieldCantComensales = new JTextField();
			jTextFieldCantComensales.setBounds(270, 47, 146, 23);
		}
		return jTextFieldCantComensales;
	}

}
