import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JTextField jTextFieldFecha;
	private JTextField jTextFieldSucursal;
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
				jTextFieldFecha = new JTextField();
				getContentPane().add(jTextFieldFecha);
				jTextFieldFecha.setBounds(116, 62, 122, 23);
			}
			{
				jLabelIngreseFecha = new JLabel();
				getContentPane().add(jLabelIngreseFecha);
				jLabelIngreseFecha.setText("Día a liquidar:");
				jLabelIngreseFecha.setBounds(26, 63, 84, 20);
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
				jTextFieldSucursal.setBounds(116, 105, 122, 23);
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
				jButtonLiquidar.setBounds(276, 147, 84, 35);
				jButtonLiquidar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButtonLiquidar.actionPerformed, event="+evt);
						
						BusinessDelegate.getInstancia().liquidarComisionesMozos(diaLiquidado, jTextFieldSucursal.getText());
					}
				});
			}
			pack();
			this.setSize(400, 231);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
