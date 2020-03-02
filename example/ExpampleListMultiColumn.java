import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import listmulticolumn.Cell;
import listmulticolumn.CenterAlign;
import listmulticolumn.ContentAlign;
import listmulticolumn.LeftAlign;
import listmulticolumn.ListBody;
import listmulticolumn.ListColumns;
import listmulticolumn.ListHead;
import listmulticolumn.Row;

public class ExpampleListMultiColumn extends Frame implements WindowListener, ItemListener
{
	private static final long serialVersionUID = 1L;
	ListBody listBody = new ListBody(5, false);
	ListHead listHead = new ListHead();
	ListColumns lmc;
	final int cellSize1 = 9;
	final int cellSize2 = 11;
	final int cellSize3 = 8;
	final int cellSize4 = 0;
	ContentAlign alignHead = new CenterAlign();
	ContentAlign align = new LeftAlign();
	Cell[][] cells = {
			{
				new Cell(cellSize1, "Java", "Language", align),
				new Cell(cellSize2, "Spring", "Framework", align),
				new Cell(cellSize3, "4.3", "Version", align),
				new Cell(cellSize4, 
						"Spring’s flexible libraries are trusted by developers all "
						+ "over the world.", 
						"Description")
			},
			{
				new Cell(cellSize1, "Python", "Language", align),
				new Cell(cellSize2, "Django", "Framework", align),
				new Cell(cellSize3, "2.2.5", "Version", align),
				new Cell(cellSize4, 
						"Django is a high-level Python Web framework that encourages"
						+ " rapid development and clean, pragmatic design.", 
						"Description")
			},
			{
				new Cell(cellSize1, "Ruby", "Language", align),
				new Cell(cellSize2, "Rails", "Framework", align),
				new Cell(cellSize3, "5.0", "Version", align),
				new Cell(cellSize4, 
						"A web-application framework that includes everything needed "
						+ "to create database-backed web applications according to "
						+ "the Model-View-Controller", 
						"Description")
			}
	};
	
	Panel pnlForm = new Panel();
	Label lblLanguaje = new Label("Language");
	Label lblFramewor = new Label("Framework");
	Label lblVersion = new Label("Version");
	Label lblDescription = new Label("Description");
	TextField txtLanguage = new TextField(cellSize2);
	TextField txtFramework = new TextField(cellSize2);
	TextField txtVersion = new TextField(cellSize2);
	TextArea txaDescription = new TextArea(9, 15);
	
	public ExpampleListMultiColumn()
	{
		setSize(500, 300);
		// setResizable(false);
		setLayout(new GridLayout(1,2));
		setTitle("Example");
		setLocationRelativeTo(null);
		
		for (Cell[] cellsRow : cells)
		{
			Row row = new Row(cellsRow);
			listBody.add(row);
		}
		Row headRow = new Row();
		Cell head1 = new Cell(cellSize1, "Language");
		// head1.setAlign(alignHead);
		headRow.add(head1);
		Cell head2 = new Cell(cellSize2, "Framework");
		// head2.setAlign(alignHead);
		headRow.add(head2);
		Cell head3 = new Cell(cellSize3, "Version");
		// head3.setAlign(alignHead);
		headRow.add(head3);
		listHead.setHeadRow(headRow);
		lmc = new ListColumns(listHead, listBody);
		add(lmc);
		
		pnlForm.add(lblLanguaje);
		pnlForm.add(txtLanguage);
		pnlForm.add(lblFramewor);
		pnlForm.add(txtFramework);
		pnlForm.add(lblVersion);
		pnlForm.add(txtVersion);
		pnlForm.add(lblDescription);
		pnlForm.add(txaDescription);
		add(pnlForm);
		
		addWindowListener(this);
		listBody.addItemListener(this);
		
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new ExpampleListMultiColumn();
	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e)
	{
		txtLanguage.setText(listBody.getSelectedRow().getCell("Language").getData());
		txtFramework.setText(listBody.getSelectedRow().getCell("Framework").getData());
		txtVersion.setText(listBody.getSelectedRow().getCell("Version").getData());
		txaDescription.setText(listBody.getSelectedRow().getCell("Description").getData());
	}

}
