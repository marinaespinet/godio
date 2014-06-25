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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
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
public class MenuPrincipal extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JMenu jMenu1;
	private JMenuItem jMenuItemCerrarCaja;
	private JMenuItem jMenuItemControlarMovStock;
	private JMenuItem jMenuItemLiquidarComisionesMozos;
	private JMenuItem jMenuItemCerrarMesa;
	private JMenuItem jMenuItemAgregarPlatos;
	private JMenuItem jMenuItemAbrirMesa;
	private JMenuItem jMenuItemSalirDelSistema;
	private JMenu jMenuSalir;
	private JMenuItem jMenuItemControlarStockEnDepo;
	private JMenuItem jMenuItemAbrirCaja;
	private JMenuBar jMenuBar;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MenuPrincipal inst = new MenuPrincipal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MenuPrincipal() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Sistema Restaurante");
			{
				jMenuBar = new JMenuBar();
				setJMenuBar(jMenuBar);
				{
					jMenu1 = new JMenu();
					jMenuBar.add(jMenu1);
					jMenu1.setText("Restaurante");
					{
						jMenuItemAbrirCaja = new JMenuItem();
						jMenu1.add(jMenuItemAbrirCaja);
						jMenuItemAbrirCaja.setText("Abrir Caja");
						jMenuItemAbrirCaja.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.out.println("jMenuItemAbrirCaja.actionPerformed, event="+evt);
								Frm_AbrirCaja elFormulario = Frm_AbrirCaja.getInstancia();
								elFormulario.setVisible(true);
							}
						});
					}
					{
						jMenuItemCerrarCaja = new JMenuItem();
						jMenu1.add(jMenuItemCerrarCaja);
						jMenuItemCerrarCaja.setText("Cerrar Caja");
						jMenuItemCerrarCaja.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.out.println("jMenuItemCerrarCaja.actionPerformed, event="+evt);
								Frm_CerrarCaja elFormulario = Frm_CerrarCaja.getInstancia();
								elFormulario.setVisible(true);
							}
						});
					}
					{
						jMenuItemControlarMovStock = new JMenuItem();
						jMenu1.add(jMenuItemControlarMovStock);
						jMenuItemControlarMovStock.setText("Controlar movimientos de stock");
						jMenuItemControlarMovStock.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.out.println("jMenuItemControlarMovStock.actionPerformed, event="+evt);
								Frm_ControlarMovimientosDeStock elFormulario = Frm_ControlarMovimientosDeStock.getInstancia();
								elFormulario.setVisible(true);
							}
						});
					}
					{
						jMenuItemControlarStockEnDepo = new JMenuItem();
						jMenu1.add(jMenuItemControlarStockEnDepo);
						jMenuItemControlarStockEnDepo.setText("Controlar stock en depósito");
						jMenuItemControlarStockEnDepo.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.out.println("jMenuItemControlarStockEnDepo.actionPerformed, event="+evt);
								Frm_ControlarStockEnDeposito elFormulario = Frm_ControlarStockEnDeposito.getInstancia();
								elFormulario.setVisible(true);
							}
						});
					}
					{
						jMenuItemLiquidarComisionesMozos = new JMenuItem();
						jMenu1.add(jMenuItemLiquidarComisionesMozos);
						jMenuItemLiquidarComisionesMozos.setText("Liquidar comisiones Mozos");
						jMenuItemLiquidarComisionesMozos.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.out.println("jMenuItemLiquidarComisionesMozos.actionPerformed, event="+evt);
								Frm_LiquidarComisionesMozos elFormulario = Frm_LiquidarComisionesMozos.getInstancia();
								elFormulario.setVisible(true);
							}
						});
					}
					{
						jMenuItemAbrirMesa = new JMenuItem();
						jMenu1.add(jMenuItemAbrirMesa);
						jMenuItemAbrirMesa.setText("Abrir mesa");
						jMenuItemAbrirMesa.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.out.println("jMenuItemAbrirMesa.actionPerformed, event="+evt);
								Frm_AbrirMesa elFormulario = Frm_AbrirMesa.getInstancia();
								elFormulario.setVisible(true);
							}
						});
					}
					{
						jMenuItemAgregarPlatos = new JMenuItem();
						jMenu1.add(jMenuItemAgregarPlatos);
						jMenuItemAgregarPlatos.setText("Agregar Platos a Pedido");
						jMenuItemAgregarPlatos.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.out.println("jMenuItemAgregarPlatos.actionPerformed, event="+evt);
								Frm_AgregarPlato elFormulario = Frm_AgregarPlato.getInstancia();
								elFormulario.agregameLasMesas(1);
								elFormulario.setVisible(true);
							}
						});
					}
					{
						jMenuItemCerrarMesa = new JMenuItem();
						jMenu1.add(jMenuItemCerrarMesa);
						jMenuItemCerrarMesa.setText("Cerrar Mesa");
						jMenuItemCerrarMesa.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.out.println("jMenuItemCerrarMesa.actionPerformed, event="+evt);
								Frm_CerrarMesa elFormulario = Frm_CerrarMesa.getInstancia();
								elFormulario.setVisible(true);
							}
						});
					}
				}
				{
					jMenuSalir = new JMenu();
					jMenuBar.add(jMenuSalir);
					jMenuSalir.setText("Salir");
					{
						jMenuItemSalirDelSistema = new JMenuItem();
						jMenuSalir.add(jMenuItemSalirDelSistema);
						jMenuItemSalirDelSistema.setText("Salir del sistema");
						jMenuItemSalirDelSistema.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.out.println("jMenuItemSalirDelSistema.actionPerformed, event="+evt);
								System.exit(0);
							}
						});
					}
				}
			}
			pack();
			this.setSize(488, 298);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
