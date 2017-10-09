package de.mp4tag.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import de.mp4tag.model.Tag;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.FlowLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class Hauptfenster<File> extends JFrame {

	private static final long serialVersionUID = -2246360012555585813L;
	private JPanel contentPane;
	private JTextField txtTxtstatuszeile;
	private JTextField txtPfad;
	
	private Tag tagDatenfelder;
	
//	private File fPfad;
	private JTable tableMp4Dateien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			Hauptfenster frame = new Hauptfenster();
			frame.setVisible(true);
	}

	
	/**
	 * Create the frame.
	 */
	public Hauptfenster() {
		setTitle("mp4Tag");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menubDatei = new JMenuBar();
		contentPane.add(menubDatei, BorderLayout.NORTH);
		
		JMenu menuDatei = new JMenu("Datei");
		menubDatei.add(menuDatei);
		
		JMenuItem menuItemOeffnen = new JMenuItem("\u00D6ffnen");
		menuDatei.add(menuItemOeffnen);
		
		JSeparator menuDateiSeparator = new JSeparator();
		menuDatei.add(menuDateiSeparator);
		
		JMenuItem menuItemSchliessen = new JMenuItem("Schliessen");
		menuDatei.add(menuItemSchliessen);
		
		JMenu menuUeber = new JMenu("?");
		menubDatei.add(menuUeber);
		
		JMenuItem menuItemVersion = new JMenuItem("Version");
		menuUeber.add(menuItemVersion);
		
		JMenuItem menuItemUeber = new JMenuItem("\u00DCber");
		menuUeber.add(menuItemUeber);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelKopfzeile = new JPanel();
		panel.add(panelKopfzeile, BorderLayout.NORTH);
		panelKopfzeile.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblPfad = new JLabel("Pfad");
		panelKopfzeile.add(lblPfad);
		
		JButton btnPfad = new JButton("Pfad");
		panelKopfzeile.add(btnPfad);
		
		txtPfad = new JTextField();
		txtPfad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("ActionListener wurde aufgerufen.");
			}
		});
		panelKopfzeile.add(txtPfad);
		txtPfad.setDropTarget(new DropTarget() {
			private static final long serialVersionUID = 2399766378118802599L;
			public synchronized void drop(DropTargetDropEvent evt) {
	            try {
	                evt.acceptDrop(DnDConstants.ACTION_COPY);
	                List<File> droppedFiles = (List<File>) evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
	                
	                System.out.println("Anzahl: " + droppedFiles.size());
	                System.out.println(droppedFiles.get(0).toString());
	                
	                String dropNamePfad = droppedFiles.get(0).toString();
	                
	                txtPfad.setText("");
	                txtPfad.setText(dropNamePfad);

	                for(int i=0; i<droppedFiles.size(); i++) {
		                System.out.println(droppedFiles.get(i).toString());
	                }
	                
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            } // Ende try - catch
		} // Ende sychronized void
		}		
				);
		
		txtPfad.setColumns(50);
		
		JButton btnUebergeordneterOrdner = new JButton("../");
		panelKopfzeile.add(btnUebergeordneterOrdner);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane);
		
		JPanel panel_1_mp4 = new JPanel();
		tabbedPane.addTab("mp4", null, panel_1_mp4, null);
		panel_1_mp4.setLayout(new BorderLayout(0, 0));
		
		JTree treeMp4Verzeichnisse = new JTree();
		panel_1_mp4.add(treeMp4Verzeichnisse, BorderLayout.WEST);
		
		/*
		 * =========================================================
		 * JTable befüllen
		 * =========================================================
		 */
	
		String[][] rowData = {
			    { "Japan", "245" }, { "USA", "240" }, { "Italien", "220" },
			    { "Spanien", "217" }, {"Türkei", "215"} ,{ "England", "214" },
			    { "Frankreich", "190" }, {"Griechenland", "185" },
			    { "Deutschland", "180" }, {"Portugal", "170" }
			    };

	    String[] columnNames =  {
			      "Land", "Durchschnittliche Fernsehdauer pro Tag in Minuten"
			    };

		tableMp4Dateien = new JTable(rowData, columnNames);

//		panel_1_mp4.add(tableMp4Dateien, BorderLayout.CENTER);
//		add( new JScrollPane(tableMp4Dateien));
		
		panel_1_mp4.add(new JScrollPane(tableMp4Dateien), BorderLayout.CENTER);
		
		
		
		JPanel panelMp4RechteLeiste = new JPanel();
		panelMp4RechteLeiste.setMaximumSize(new Dimension(100, 100));
		panelMp4RechteLeiste.setMinimumSize(new Dimension(100, 100));
		panel_1_mp4.add(panelMp4RechteLeiste, BorderLayout.EAST);
		panelMp4RechteLeiste.setLayout(new BoxLayout(panelMp4RechteLeiste, BoxLayout.Y_AXIS));
		
		JButton btnMakedir = new JButton("Verzeichnis erstellen");
		btnMakedir.setVerticalAlignment(SwingConstants.TOP);
		panelMp4RechteLeiste.add(btnMakedir);
		
		JButton btnMp4Verschieben = new JButton("mp4 verschieben");
		btnMp4Verschieben.setVerticalAlignment(SwingConstants.TOP);
		panelMp4RechteLeiste.add(btnMp4Verschieben);
		
		JButton btnErstellenVerschieben = new JButton("erstellen + verschieben");
		panelMp4RechteLeiste.add(btnErstellenVerschieben);
		
		/*
		 * ========================
		 * Panel 2: media/genre
		 * ========================
		 */
		
		
		JPanel panel_2_mediagenre = new JPanel();
		tabbedPane.addTab("media-genre", null, panel_2_mediagenre, null);
		
		tagDatenfelder = new Tag();
		tagDatenfelder.setTagSlugName(txtPfad.getName());
		
		
		
		txtTxtstatuszeile = new JTextField();
		txtTxtstatuszeile.setText("txtStatuszeile");
		contentPane.add(txtTxtstatuszeile, BorderLayout.SOUTH);
		txtTxtstatuszeile.setColumns(10);
	}
}
