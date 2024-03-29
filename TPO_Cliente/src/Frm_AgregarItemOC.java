import java.awt.Component;
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
public class Frm_AgregarItemOC extends javax.swing.JFrame {

	private static Frm_AgregarItemOC instancia = null;
	private JLabel jLabelProv;
	private JTextField jTextFieldProv;
	private JLabel jLabelIdProd;
	private JTextField jTextFieldProd;
	private JLabel jLabelCantidad;
	private JTextField jTextFieldCantidad;	
	private JLabel jLabelPrecio;
	private JTextField jTextFieldPrecio;


	private JButton jButton;
	private JTextField jTextFieldOC;
	private JLabel jLabelOC;
	private JLabel jLabelTitulo;
	private JTextField jTextFieldNotificador;
	
	

	public static Frm_AgregarItemOC getInstancia(){
		if(instancia == null){			
			instancia = new Frm_AgregarItemOC();
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
				Frm_AgregarItemOC inst = new Frm_AgregarItemOC();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Frm_AgregarItemOC() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Agregar item a OC");
			getContentPane().add(getJTextFieldNotificador());
			getContentPane().add(getJLabelTitulo());
			getContentPane().add(getJLabelOC());
			getContentPane().add(getJTextFieldOC());
			getContentPane().add(getJButton());
			getContentPane().add(getJLabelPrecio());
			getContentPane().add(getJTextFieldPrecio());
			getContentPane().add(getJLabelIdProd());
			getContentPane().add(getJTextFieldProd());
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
			jLabelTitulo.setText("Agregar item a OC");
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
	
	private JLabel getJLabelOC() {
		if(jLabelOC == null) {
			jLabelOC = new JLabel();
			jLabelOC.setText("Compra: ");
			jLabelOC.setBounds(40, 45, 100, 22);
		}
		return jLabelOC;
	}
	
	private JTextField getJTextFieldOC() {
		if(jTextFieldOC == null) {
			jTextFieldOC = new JTextField();
			jTextFieldOC.setText("");
			jTextFieldOC.setBounds (150, 45, 100, 22);
			jTextFieldOC.setEditable(true);
		}
		return jTextFieldOC;
	}
	
	private Integer getjTextFieldOC() {
		if(jTextFieldOC == null) {
			jTextFieldOC = new JTextField();
			jTextFieldOC.setText("");
			jTextFieldOC.setBounds (150, 45, 100, 22);
			jTextFieldOC.setEditable(true);
		}
		return Integer.parseInt(jTextFieldOC.getText().toString());
	}
	
	private JButton getJButton() {
		if(jButton == null) {
			jButton = new JButton();
			jButton.setText("Agregar item");
			jButton.setBounds(473, 118, 108, 41);
			jButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					System.out.println("jButton.actionPerformed, event="+evt);
					try {
						Integer prod = getjTextFieldProd();
						Integer cant = getJTextFieldCantidad();
						Double precio = getjTextFieldPrecio();
						DTO.Item_Compra item =new DTO.Item_Compra(prod, cant, precio);
						BusinessDelegate.getInstancia().agregarItemOC(item, getjTextFieldOC());
						jTextFieldNotificador.setText("Se agrego el item a la compra");
					} catch (RemoteException e) {
						jTextFieldNotificador.setText(e.getMessage());
					}
				}
			});
		}
		return jButton;
	}
	
	private JLabel getJLabelPrecio() {
		if(jLabelPrecio == null) {
			jLabelPrecio = new JLabel();
			jLabelPrecio.setText("Precio");
			jLabelPrecio.setBounds(280, 75, 100, 22);
		}
		return jLabelPrecio;
	}
	
	private JTextField getJTextFieldPrecio() {
		if(jTextFieldPrecio == null) {
			jTextFieldPrecio = new JTextField();
			jTextFieldPrecio.setText("");
			jTextFieldPrecio.setBounds(390,75,100,22);
			jTextFieldPrecio.setEditable(true);
		}
		return jTextFieldPrecio;
	}
	
	private Double getjTextFieldPrecio() {
		if(jTextFieldPrecio == null) {
			jTextFieldPrecio = new JTextField();
			jTextFieldPrecio.setText("");
			jTextFieldPrecio.setBounds(390,75,100,22);
			jTextFieldPrecio.setEditable(true);
		}
		return Double.parseDouble(jTextFieldPrecio.getText());
	}
		
	private JLabel getJLabelIdProd() {
		if(jLabelIdProd == null) {
			jLabelIdProd = new JLabel();
			jLabelIdProd.setText("Producto: ");
			jLabelIdProd.setBounds(40, 75, 100, 22);
		}
		return jLabelIdProd;
	}
	
	private JTextField getJTextFieldProd() {
	//Integer getJTextFieldProd(){
			if(jTextFieldProd == null) {
				jTextFieldProd = new JTextField();
				jTextFieldProd.setText("1");
				jTextFieldProd.setBounds (150, 75, 100, 22);
				jTextFieldProd.setEditable(true);
			}
			return jTextFieldProd;
		}
	private Integer getjTextFieldProd() {
				if(jTextFieldProd == null) {
					jTextFieldProd = new JTextField();
					jTextFieldProd.setText("1");
					jTextFieldProd.setBounds (150, 75, 100, 22);
					jTextFieldProd.setEditable(true);
				}
				return Integer.parseInt(jTextFieldProd.getText().toString());
			}
	

	public JLabel getjLabelCantidad() {
		if(jLabelCantidad == null) {
			jLabelCantidad = new JLabel();
			jLabelCantidad.setText("Cantidad: ");
			jLabelCantidad.setBounds(280, 45, 100, 22);
		}
		return jLabelCantidad;
	}

	public void setjLabelCantidad(JLabel jLabelCantidad) {
		this.jLabelCantidad = jLabelCantidad;
	}

	public JTextField getjTextFieldCantidad() {
		if(jTextFieldCantidad == null) {
			jTextFieldCantidad = new JTextField();
			jTextFieldCantidad.setBounds (390, 45, 100, 22);
		}
		return jTextFieldCantidad;
	}

	private Integer getJTextFieldCantidad() {
		if(jTextFieldCantidad == null) {
			jTextFieldCantidad = new JTextField();
			jTextFieldCantidad.setBounds (390, 45, 100, 22);
		}
		return Integer.parseInt(jTextFieldCantidad.getText());
	}

	public void setjTextFieldCantidad(JTextField jTextFieldCantidad) {
		this.jTextFieldCantidad = jTextFieldCantidad;
	}
	

}
