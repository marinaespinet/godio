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
import javax.swing.JTextArea;
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
public class Frm_ControlarStockEnDeposito extends javax.swing.JFrame {

	private static Frm_ControlarStockEnDeposito instancia = null;
	
	public static Frm_ControlarStockEnDeposito getInstancia(){
		if(instancia == null){			
			instancia = new Frm_ControlarStockEnDeposito();
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
	private JTextField jTextFieldDepoId;
	private JLabel jLabelIdDepo;
	private JTextArea jTextAreaResultados;
	private JLabel jLabelMes;
	private JButton jButtonLiquidar;
	private JLabel jLabelSucursal;
	private JLabel jLabelTitulo;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Frm_ControlarStockEnDeposito inst = new Frm_ControlarStockEnDeposito();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Frm_ControlarStockEnDeposito() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Controlar stock en deposito");
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Controlar Stock en deposito");
				jLabelTitulo.setBounds(26, 12, 295, 31);
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
				jButtonLiquidar.setText("Listar Productos");
				jButtonLiquidar.setBounds(522, 140, 145, 34);
				jButtonLiquidar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButtonLiquidar.actionPerformed, event="+evt);

						try {
							List <DTO.Stock> elStock = BusinessDelegate.getInstancia().getStockPorDeposito(1);
							for(DTO.Stock unStock : elStock){
								jTextAreaResultados.append("En la sucursal 1 hay " + 
															unStock.getCantidad() + " " + unStock.getNombreProducto() + " que vence el dia " 
															+ unStock.getFecha_vencimiento_producto_dt() + "\n");
								
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
				jTextAreaResultados = new JTextArea();
				getContentPane().add(jTextAreaResultados);
				jTextAreaResultados.setBounds(26, 180, 644, 228);
				jTextAreaResultados.setEditable(false);
			}
			{
				jLabelIdDepo = new JLabel();
				getContentPane().add(jLabelIdDepo);
				jLabelIdDepo.setText("Deposito ID: ");
				jLabelIdDepo.setBounds(26, 65, 67, 16);
			}
			{
				jTextFieldDepoId = new JTextField();
				getContentPane().add(jTextFieldDepoId);
				jTextFieldDepoId.setBounds(116, 62, 41, 23);
			}
			pack();
			this.setSize(707, 465);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
