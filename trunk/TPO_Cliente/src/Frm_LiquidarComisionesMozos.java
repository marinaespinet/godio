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
public class Frm_LiquidarComisionesMozos extends javax.swing.JFrame {

	private static Frm_LiquidarComisionesMozos instancia = null;
	
	public static Frm_LiquidarComisionesMozos getInstancia(){
		if(instancia == null){			
			instancia = new Frm_LiquidarComisionesMozos();
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

	private JTextField jTextFieldDia;
	private JTextField jTextFieldSucursal;
	private JLabel jLabelYear;
	private JTextField jTextFieldYear;
	private JTextField jTextFieldNotificacion;
	private JTextField jTextFieldMes;
	private JLabel jLabelMes;
	private JButton jButtonLiquidar;
	private JLabel jLabelSucursal;
	private JLabel jLabelTitulo;
	private JLabel jLabelIngreseFecha;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Frm_LiquidarComisionesMozos inst = new Frm_LiquidarComisionesMozos();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Frm_LiquidarComisionesMozos() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Liquidar comisiones Mozos");
			{
				jTextFieldDia = new JTextField();
				getContentPane().add(jTextFieldDia);
				jTextFieldDia.setBounds(52, 62, 46, 23);
			}
			{
				jLabelIngreseFecha = new JLabel();
				getContentPane().add(jLabelIngreseFecha);
				jLabelIngreseFecha.setText("Día: ");
				jLabelIngreseFecha.setBounds(22, 63, 30, 20);
			}
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Liquidar comisiones Mozos");
				jLabelTitulo.setBounds(26, 12, 200, 31);
				jLabelTitulo.setFont(new java.awt.Font("Segoe UI",1,14));
			}
			{
				jTextFieldSucursal = new JTextField();
				getContentPane().add(jTextFieldSucursal);
				jTextFieldSucursal.setText("1");
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
				jButtonLiquidar = new JButton();
				getContentPane().add(jButtonLiquidar);
				jButtonLiquidar.setText("Liquidar");
				jButtonLiquidar.setBounds(217, 147, 84, 35);
				jButtonLiquidar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButtonLiquidar.actionPerformed, event="+evt);
						Calendar unaFecha = Calendar.getInstance();
						unaFecha.set(Calendar.YEAR,Integer.parseInt(jTextFieldYear.getText()));
						unaFecha.set(Calendar.MONTH,Integer.parseInt(jTextFieldMes.getText())-1);
						unaFecha.set(Calendar.DAY_OF_MONTH,Integer.parseInt(jTextFieldDia.getText()));
						Date laFecha = new java.sql.Date(unaFecha.getTimeInMillis());
						try {
							BusinessDelegate.getInstancia().liquidarComisionesMozos(laFecha, Integer.parseInt(jTextFieldSucursal.getText()));
							jTextFieldNotificacion.enable();
							jTextFieldNotificacion.setText("Mozos liquidados correctamente");
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
				jLabelMes.setText("Mes: ");
				jLabelMes.setBounds(116, 65, 28, 16);
			}
			{
				jTextFieldMes = new JTextField();
				getContentPane().add(jTextFieldMes);
				jTextFieldMes.setBounds(151, 62, 47, 23);
			}
			{
				jLabelYear = new JLabel();
				getContentPane().add(jLabelYear);
				jLabelYear.setText("Año: ");
				jLabelYear.setBounds(210, 65, 28, 16);
			}
			{
				jTextFieldYear = new JTextField();
				getContentPane().add(jTextFieldYear);
				jTextFieldYear.setBounds(243, 62, 58, 23);
			}
			{
				jTextFieldNotificacion = new JTextField();
				getContentPane().add(jTextFieldNotificacion);
				jTextFieldNotificacion.setBounds(26, 158, 176, 23);
				jTextFieldNotificacion.setEditable(false);
				jTextFieldNotificacion.setEnabled(false);
				jTextFieldNotificacion.setBorder(BorderFactory.createCompoundBorder(
						null, 
						null));
			}
			pack();
			this.setSize(345, 231);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
