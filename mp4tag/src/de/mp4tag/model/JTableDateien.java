package de.mp4tag.model;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableDateien {
	private JFrame f;
	
	public JTableDateien(JFrame f) {

	String[][] rowData = {
		    { "Japan", "245" }, { "USA", "240" }, { "Italien", "220" },
		    { "Spanien", "217" }, {"Türkei", "215"} ,{ "England", "214" },
		    { "Frankreich", "190" }, {"Griechenland", "185" },
		    { "Deutschland", "180" }, {"Portugal", "170" }
		    };

		    String[] columnNames =  {
		      "Land", "Durchschnittliche Fernsehdauer pro Tag in Minuten"
		    };


		    JTable table = new JTable( rowData, columnNames );
		    f.add( new JScrollPane( table ) );

		    f.pack();
		    f.setVisible( true );
	}	
}
