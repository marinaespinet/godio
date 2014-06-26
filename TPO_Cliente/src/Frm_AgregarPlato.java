import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class Frm_AgregarPlato extends javax.swing.JFrame {

	private static Frm_AgregarPlato instancia = null;
	private JLabel jLabelMozo;
	private JLabel jLabelIdPlato;
	private JTextField jTextFieldNroPlato;
	private JLabel jLabelCantidad;
	private JTextField jTextFieldCantidad;
	private JComboBox<Integer> jComboBoxMesa;
	private JLabel jLabelMesa;
	private JTextField jTextFieldNroMozo;
	private JButton jButton;
	private JTextField jTextFieldSucursal;
	private JLabel jLabelSucursal;
	private JLabel jLabelTitulo;
	private JTextField jTextFieldNotificador;
	
	

	public static Frm_AgregarPlato getInstancia(){
		if(instancia == null){			
			instancia = new Frm_AgregarPlato();
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
				Frm_AgregarPlato inst = new Frm_AgregarPlato();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Frm_AgregarPlato() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Agregar Plato");
			getContentPane().add(getJTextFieldNotificador());
			getContentPane().add(getJLabelTitulo());
			getContentPane().add(getJLabelSucursal());
			getContentPane().add(getJTextFieldSucursal());
			getContentPane().add(getJButton());
			getContentPane().add(getJLabelMozo());
			getContentPane().add(getJTextFieldNroMozo());
			getContentPane().add(getJLabelMesa());
			getContentPane().add(getJComboBoxMesa());
			getContentPane().add(getJLabelIdPlato());
			getContentPane().add(getJTextFieldNroPlato());
			getContentPane().add(getjLabelCantidad());
			getContentPane().add(getjTextFieldCantidad());
			pack();
			this.setSize(621, 229);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	
	
	private JLabel getJLabelTitulo() {
		if(jLabelTitulo == null) {
			jLabelTitulo = new JLabel();
			jLabelTitulo.setText("Agregar Plato a Pedido");
			jLabelTitulo.setBounds(20, 12, 182, 20);
			jLabelTitulo.setFont(new java.awt.Font("Segoe UI",1,14));
		}
		return jLabelTitulo;
	}

	private JTextField getJTextFieldNotificador() {
		if(jTextFieldNotificador == null) {
			jTextFieldNotificador = new JTextField();
			jTextFieldNotificador.setBounds(20, 118, 435, 41);
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
			jButton.setText("Agregar plato");
			jButton.setBounds(473, 118, 108, 41);
			jButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					System.out.println("jButton.actionPerformed, event="+evt);
					try {
						BusinessDelegate.getInstancia().agregarPlato(Integer.parseInt(jTextFieldNroPlato.getText()), Integer.parseInt(getjTextFieldCantidad().getText()), Integer.parseInt(getJTextFieldSucursal().getText()), Integer.parseInt(jComboBoxMesa.getSelectedItem().toString()));
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
	
	private JLabel getJLabelMesa() {
		if(jLabelMesa == null) {
			jLabelMesa = new JLabel();
			jLabelMesa.setText("Mesa: ");
			jLabelMesa.setBounds(20, 61, 34, 16);
		}
		return jLabelMesa;
	}
	
	@SuppressWarnings("unchecked")
	private JComboBox getJComboBoxMesa() {
		if(jComboBoxMesa == null) {
			ComboBoxModel jComboBoxMesaModel = 
					new DefaultComboBoxModel(
							new String[] { });
			jComboBoxMesa = new JComboBox();
			jComboBoxMesa.setModel(jComboBoxMesaModel);
			jComboBoxMesa.setBounds(66, 58, 70, 23);
			agregameLasMesas(Integer.parseInt(jTextFieldNroMozo.getText()));
		
		}
		return jComboBoxMesa;
	}
	
	private JLabel getJLabelIdPlato() {
		if(jLabelIdPlato == null) {
			jLabelIdPlato = new JLabel();
			jLabelIdPlato.setText("Nro. Plato a agregar: ");
			jLabelIdPlato.setBounds(187, 61, 120, 16);
		}
		return jLabelIdPlato;
	}
	
	private JTextField getJTextFieldNroPlato() {
		if(jTextFieldNroPlato == null) {
			jTextFieldNroPlato = new JTextField();
			jTextFieldNroPlato.setBounds(307, 58, 84, 23);
		}
		return jTextFieldNroPlato;
	}

	public JLabel getjLabelCantidad() {
		if(jLabelCantidad == null) {
			jLabelCantidad = new JLabel();
			jLabelCantidad.setText("Cantidad: ");
			jLabelCantidad.setBounds(187, 90, 120, 16);
		}
		return jLabelCantidad;
	}

	public void setjLabelCantidad(JLabel jLabelCantidad) {
		this.jLabelCantidad = jLabelCantidad;
	}

	public JTextField getjTextFieldCantidad() {
		if(jTextFieldCantidad == null) {
			jTextFieldCantidad = new JTextField();
			jTextFieldCantidad.setBounds(307, 90, 84, 23);
		}
		return jTextFieldCantidad;
	}

	public void setjTextFieldCantidad(JTextField jTextFieldCantidad) {
		this.jTextFieldCantidad = jTextFieldCantidad;
	}
	
	public void agregameLasMesas(Integer mozoId){
				try {
					List<Integer> lasMesasConPedidosDelMozo = BusinessDelegate.getInstancia().getMesasConPedidosAbiertosPorMozo(Integer.parseInt(jTextFieldNroMozo.getText()));
					for(Integer unId : lasMesasConPedidosDelMozo)
						jComboBoxMesa.addItem(unId);
				} catch (RemoteException e) {
					jTextFieldNotificador.setText(e.getMessage());
				}
	}

}
