package principal.vistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import principal.controladores.ControladorProvincia;
import principal.controladores.DatosDeTabla;
import principal.entidades.Ccaa;
import principal.entidades.Provincia;

import javax.swing.JLabel;

public class PanelPrincipal extends JPanel {
	public Object[][] getDatosEnTabla() {
		return datosEnTabla;
	}

	public void setDatosEnTabla(Object[][] datosEnTabla) {
		this.datosEnTabla = datosEnTabla;
	}


	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosEnTabla[] = DatosDeTabla.getTitulosColumnas();
	private static final long serialVersionUID = 1L;
	private JTable table;
	JScrollPane scrollPane = new JScrollPane();
	/**
	 * Create the panel.
	 */
	public PanelPrincipal() {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		
		splitPane.setLeftComponent(scrollPane);
		this.dtm = getDefaultTableModelNoEditable();
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		JLabel lblProvincias = new JLabel("Provincias");
		add(lblProvincias, BorderLayout.NORTH);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int indiceFilaSel = table.getSelectedRow();		
				Object value = datosEnTabla[indiceFilaSel][0];
				Provincia estselecc = ControladorProvincia.findById(Integer.valueOf(String.valueOf(value)));
				PanelGestionProvincias pgp=new PanelGestionProvincias(estselecc);
				JScrollPane scrollpane2 = new JScrollPane(pgp);
				splitPane.setRightComponent(scrollpane2);
				splitPane.setResizeWeight(0.25);
			}
		});

	}
	
	private DefaultTableModel getDefaultTableModelNoEditable () {
		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column != 1) {
					return false;
				}
				return true;
			}
		};
		return dtm;

}}
