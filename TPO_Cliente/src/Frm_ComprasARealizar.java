import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

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
public class Frm_ComprasARealizar extends javax.swing.JFrame {

	private static Frm_ComprasARealizar instancia = null;
	
	public static Frm_ComprasARealizar getInstancia(){
		if(instancia == null){			
			instancia = new Frm_ComprasARealizar();
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

	private JTextField jTextFieldSucursal;
	//private JTextField jTextFieldDepoId;
	//private JLabel jLabelIdDepo;
	private JTextField jTextFieldResultados;
	private JLabel jLabelMes;
	private JButton jButtonCompras;
	private JLabel jLabelSucursal;
	private JLabel jLabelTitulo;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Frm_ComprasARealizar inst = new Frm_ComprasARealizar();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Frm_ComprasARealizar() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Listado de compras a realizar");
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Listado de compras a realizar");
				jLabelTitulo.setBounds(26, 12, 295, 31);
				jLabelTitulo.setFont(new java.awt.Font("Segoe UI",1,14));
			}
			{
				jTextFieldSucursal = new JTextField();
				getContentPane().add(jTextFieldSucursal);
				jTextFieldSucursal.setText("Administracion Central");
				jTextFieldSucursal.setBounds(116, 105, 28, 23);
				jTextFieldSucursal.setEditable(false);
			}
			{
				jLabelSucursal = new JLabel();
				getContentPane().add(jLabelSucursal);
				jLabelSucursal.setText("Sucursal:");
				jLabelSucursal.setBounds(26, 108, 72, 17);
			}
			{
				jButtonCompras = new JButton();
				getContentPane().add(jButtonCompras);
				jButtonCompras.setText("Listar compras pendientes");
				jButtonCompras.setBounds(522, 140, 145, 34);
				jButtonCompras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButtonCompras.actionPerformed, event="+evt);

						try {
							List <DTO.Insumo> listadoCompras = BusinessDelegate.getInstancia().getComprasARealizar();
							for(DTO.Insumo unaCompra : listadoCompras){
								jTextFieldResultados.setText(unaCompra.getName());
							}
							
							
						} catch (NumberFormatException | RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
			{
				jLabelMes = new JLabel();
				getContentPane().add(jLabelMes);
				jLabelMes.setBounds(116, 65, 28, 16);
			}
			{
				jTextFieldResultados = new JTextField();
				getContentPane().add(jTextFieldResultados);
				jTextFieldResultados.setBounds(26, 180, 644, 228);
				jTextFieldResultados.setEditable(false);
				jTextFieldResultados.setVisible(true);
			}

			pack();
			this.setSize(707, 465);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
