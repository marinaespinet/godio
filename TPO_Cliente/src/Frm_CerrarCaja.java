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
public class Frm_CerrarCaja extends javax.swing.JFrame {

	private static Frm_CerrarCaja instancia = null;
	private JLabel jLabelBilletesDe10;
	private JTextField jTextFieldSucursal;
	private JLabel jLabelSucursal;
	private JTextField jTextFieldMonedas;
	private JTextField jTextFieldBilletesDe100;
	private JTextField jTextFieldBilletesDe50;
	private JTextField jTextFieldBilletesDe20;
	private JLabel jLabelBilletesDe100;
	private JTextField jTextFieldBilletesDe10;
	private JTextField jTextFieldBilletesDe5;
	private JTextField jTextFieldBilletesDe2;
	private JLabel jLabelMonedas;
	private JLabel jLabelBilletesDe50;
	private JLabel jLabelBilletesDe20;
	private JLabel jLabelBilletesDe2;
	private JLabel jLabelBilletesDe5;
	private JLabel jLabelTitulo;
	private JButton jButtonCerrar;
	private JTextField jTextFieldNotificador;
	
	

	public static Frm_CerrarCaja getInstancia(){
		if(instancia == null){			
			instancia = new Frm_CerrarCaja();
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
				Frm_CerrarCaja inst = new Frm_CerrarCaja();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Frm_CerrarCaja() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Cerrar Caja");
			getContentPane().add(getJLabelBilletesDe2());
			getContentPane().add(getJLabelBilletesDe5());
			getContentPane().add(getJLabelBilletesDe10());
			getContentPane().add(getJLabelBilletesDe20());
			getContentPane().add(getJLabelBilletesDe50());
			getContentPane().add(getJLabelBilletesDe100());
			getContentPane().add(getJLabelMonedas());
			getContentPane().add(getJTextFieldBilletesDe2());
			getContentPane().add(getJTextFieldBilletesDe5());
			getContentPane().add(getJTextFieldBilletesDe10());
			getContentPane().add(getJTextFieldBilletesDe20());
			getContentPane().add(getJTextFieldBilletesDe50());
			getContentPane().add(getJTextFieldBilletesDe100());
			getContentPane().add(getJTextFieldMonedas());
			getContentPane().add(getJTextFieldNotificador());
			getContentPane().add(getJLabelTitulo());
			getContentPane().add(getJButtonCerrar());
			getContentPane().add(getJLabelSucursal());
			getContentPane().add(getJTextFieldSucursal());
			pack();
			this.setSize(780, 468);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	
	
	private JLabel getJLabelTitulo() {
		if(jLabelTitulo == null) {
			jLabelTitulo = new JLabel();
			jLabelTitulo.setText("Cerrar Caja");
			jLabelTitulo.setBounds(20, 12, 182, 20);
			jLabelTitulo.setFont(new java.awt.Font("Segoe UI",1,14));
		}
		return jLabelTitulo;
	}
	
	private JLabel getJLabelBilletesDe5() {
		if(jLabelBilletesDe5 == null) {
			jLabelBilletesDe5 = new JLabel();
			jLabelBilletesDe5.setText("Billetes de 5 pesos: ");
			jLabelBilletesDe5.setBounds(38, 101, 101, 16);
		}
		return jLabelBilletesDe5;
	}
	
	private JLabel getJLabelBilletesDe2() {
		if(jLabelBilletesDe2 == null) {
			jLabelBilletesDe2 = new JLabel();
			jLabelBilletesDe2.setText("Billetes de 2 pesos: ");
			jLabelBilletesDe2.setBounds(38, 74, 101, 16);
		}
		return jLabelBilletesDe2;
	}
	
	private JLabel getJLabelBilletesDe10() {
		if(jLabelBilletesDe10 == null) {
			jLabelBilletesDe10 = new JLabel();
			jLabelBilletesDe10.setText("Billetes de 10 pesos: ");
			jLabelBilletesDe10.setBounds(38, 129, 107, 16);
		}
		return jLabelBilletesDe10;
	}
	
	private JLabel getJLabelBilletesDe20() {
		if(jLabelBilletesDe20 == null) {
			jLabelBilletesDe20 = new JLabel();
			jLabelBilletesDe20.setText("Billetes de 20 pesos: ");
			jLabelBilletesDe20.setBounds(38, 157, 107, 16);
		}
		return jLabelBilletesDe20;
	}
	
	private JLabel getJLabelBilletesDe50() {
		if(jLabelBilletesDe50 == null) {
			jLabelBilletesDe50 = new JLabel();
			jLabelBilletesDe50.setText("Billetes de 50 pesos: ");
			jLabelBilletesDe50.setBounds(38, 185, 107, 16);
		}
		return jLabelBilletesDe50;
	}
	
	private JLabel getJLabelBilletesDe100() {
		if(jLabelBilletesDe100 == null) {
			jLabelBilletesDe100 = new JLabel();
			jLabelBilletesDe100.setText("Billetes de 100 pesos: ");
			jLabelBilletesDe100.setBounds(38, 213, 113, 16);
		}
		return jLabelBilletesDe100;
	}
	
	private JLabel getJLabelMonedas() {
		if(jLabelMonedas == null) {
			jLabelMonedas = new JLabel();
			jLabelMonedas.setText("Monedas: ");
			jLabelMonedas.setBounds(38, 241, 55, 16);
		}
		return jLabelMonedas;
	}
	
	private JTextField getJTextFieldBilletesDe2() {
		if(jTextFieldBilletesDe2 == null) {
			jTextFieldBilletesDe2 = new JTextField();
			jTextFieldBilletesDe2.setText("0");
			jTextFieldBilletesDe2.setBounds(169, 71, 69, 23);
		}
		return jTextFieldBilletesDe2;
	}
	
	private JTextField getJTextFieldBilletesDe5() {
		if(jTextFieldBilletesDe5 == null) {
			jTextFieldBilletesDe5 = new JTextField();
			jTextFieldBilletesDe5.setText("0");
			jTextFieldBilletesDe5.setBounds(169, 98, 69, 23);
		}
		return jTextFieldBilletesDe5;
	}
	
	private JTextField getJTextFieldBilletesDe10() {
		if(jTextFieldBilletesDe10 == null) {
			jTextFieldBilletesDe10 = new JTextField();
			jTextFieldBilletesDe10.setText("0");
			jTextFieldBilletesDe10.setBounds(169, 126, 69, 23);
		}
		return jTextFieldBilletesDe10;
	}
	
	private JTextField getJTextFieldBilletesDe20() {
		if(jTextFieldBilletesDe20 == null) {
			jTextFieldBilletesDe20 = new JTextField();
			jTextFieldBilletesDe20.setText("0");
			jTextFieldBilletesDe20.setBounds(169, 154, 69, 23);
		}
		return jTextFieldBilletesDe20;
	}
	
	private JTextField getJTextFieldBilletesDe50() {
		if(jTextFieldBilletesDe50 == null) {
			jTextFieldBilletesDe50 = new JTextField();
			jTextFieldBilletesDe50.setText("0");
			jTextFieldBilletesDe50.setBounds(169, 182, 69, 23);
		}
		return jTextFieldBilletesDe50;
	}
	
	private JTextField getJTextFieldBilletesDe100() {
		if(jTextFieldBilletesDe100 == null) {
			jTextFieldBilletesDe100 = new JTextField();
			jTextFieldBilletesDe100.setText("0");
			jTextFieldBilletesDe100.setBounds(169, 210, 69, 23);
		}
		return jTextFieldBilletesDe100;
	}
	
	private JTextField getJTextFieldMonedas() {
		if(jTextFieldMonedas == null) {
			jTextFieldMonedas = new JTextField();
			jTextFieldMonedas.setText("0");
			jTextFieldMonedas.setBounds(169, 238, 69, 23);
		}
		return jTextFieldMonedas;
	}
	
	private JTextField getJTextFieldNotificador() {
		if(jTextFieldNotificador == null) {
			jTextFieldNotificador = new JTextField();
			jTextFieldNotificador.setBounds(38, 361, 595, 41);
			jTextFieldNotificador.setEditable(false);
			jTextFieldNotificador.setText("");
		}
		return jTextFieldNotificador;
	}
	
	private JButton getJButtonCerrar() {
		if(jButtonCerrar == null) {
			jButtonCerrar = new JButton();
			jButtonCerrar.setText("Aceptar");
			jButtonCerrar.setBounds(645, 362, 88, 40);
			jButtonCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					System.out.println("jButtonCerrar.actionPerformed, event="+evt);
					try {
						Integer opCajaId = BusinessDelegate.getInstancia().crearOperacionCaja(2, Integer.parseInt(jTextFieldSucursal.getText()));
						
						if(jTextFieldBilletesDe2.getText() != "0"){
							
							DTO.Item_Operacion_Caja item = new DTO.Item_Operacion_Caja();
							item.setItem_operacion_operacion_id(opCajaId);
							item.setCantidad(Integer.parseInt(jTextFieldBilletesDe2.getText()));
							item.setMonto((float)2*Integer.parseInt(jTextFieldBilletesDe2.getText()));
							item.setTipo_comprobante(5);
							BusinessDelegate.getInstancia().agregarItemsCaja(item, opCajaId);
							
						}
						
						if(jTextFieldBilletesDe5.getText() != "0"){
							
							DTO.Item_Operacion_Caja item = new DTO.Item_Operacion_Caja();
							item.setItem_operacion_operacion_id(opCajaId);
							item.setCantidad(Integer.parseInt(jTextFieldBilletesDe5.getText()));
							item.setMonto((float)5*Integer.parseInt(jTextFieldBilletesDe5.getText()));
							item.setTipo_comprobante(6);
							BusinessDelegate.getInstancia().agregarItemsCaja(item, opCajaId);
							
						}
						
						if(jTextFieldBilletesDe10.getText() != "0"){
							
							DTO.Item_Operacion_Caja item = new DTO.Item_Operacion_Caja();
							item.setItem_operacion_operacion_id(opCajaId);
							item.setCantidad(Integer.parseInt(jTextFieldBilletesDe10.getText()));
							item.setMonto((float)10*Integer.parseInt(jTextFieldBilletesDe10.getText()));
							item.setTipo_comprobante(7);
							BusinessDelegate.getInstancia().agregarItemsCaja(item, opCajaId);
							
						}
						
						if(jTextFieldBilletesDe20.getText() != "0"){
							
							DTO.Item_Operacion_Caja item = new DTO.Item_Operacion_Caja();
							item.setItem_operacion_operacion_id(opCajaId);
							item.setCantidad(Integer.parseInt(jTextFieldBilletesDe20.getText()));
							item.setMonto((float)20*Integer.parseInt(jTextFieldBilletesDe20.getText()));
							item.setTipo_comprobante(8);
							BusinessDelegate.getInstancia().agregarItemsCaja(item, opCajaId);
							
						}
						
						if(jTextFieldBilletesDe50.getText() != "0"){
							
							DTO.Item_Operacion_Caja item = new DTO.Item_Operacion_Caja();
							item.setItem_operacion_operacion_id(opCajaId);
							item.setCantidad(Integer.parseInt(jTextFieldBilletesDe50.getText()));
							item.setMonto((float)50*Integer.parseInt(jTextFieldBilletesDe50.getText()));
							item.setTipo_comprobante(9);
							BusinessDelegate.getInstancia().agregarItemsCaja(item, opCajaId);
							
						}
		
						if(jTextFieldBilletesDe100.getText() != "0"){
							
							DTO.Item_Operacion_Caja item = new DTO.Item_Operacion_Caja();
							item.setItem_operacion_operacion_id(opCajaId);
							item.setCantidad(Integer.parseInt(jTextFieldBilletesDe100.getText()));
							item.setMonto((float)100*Integer.parseInt(jTextFieldBilletesDe100.getText()));
							item.setTipo_comprobante(10);
							BusinessDelegate.getInstancia().agregarItemsCaja(item, opCajaId);
							
						}
						
						if(jTextFieldMonedas.getText() != "0"){
							
							DTO.Item_Operacion_Caja item = new DTO.Item_Operacion_Caja();
							item.setItem_operacion_operacion_id(opCajaId);
							item.setCantidad(Integer.parseInt(jTextFieldMonedas.getText()));
							item.setMonto((float)1*Integer.parseInt(jTextFieldMonedas.getText()));
							item.setTipo_comprobante(4);
							BusinessDelegate.getInstancia().agregarItemsCaja(item, opCajaId);
							
						}
						
						mostrarMensaje("Se creo la operacion caja");
					} catch (NumberFormatException e) {
						mostrarMensaje(e.getMessage());
						e.printStackTrace();
					} catch (RemoteException e) {
						mostrarMensaje(e.getMessage());
					}
				}
			});
		}
		return jButtonCerrar;
	}

	public void mostrarMensaje(String string) {
		jTextFieldNotificador.setText(string);
		
	}
	
	private JLabel getJLabelSucursal() {
		if(jLabelSucursal == null) {
			jLabelSucursal = new JLabel();
			jLabelSucursal.setText("Sucursal: ");
			jLabelSucursal.setBounds(289, 15, 50, 16);
		}
		return jLabelSucursal;
	}
	
	private JTextField getJTextFieldSucursal() {
		if(jTextFieldSucursal == null) {
			jTextFieldSucursal = new JTextField();
			jTextFieldSucursal.setText("3");
			jTextFieldSucursal.setBounds(346, 12, 25, 23);
			jTextFieldSucursal.setEditable(false);
		}
		return jTextFieldSucursal;
	}

}
