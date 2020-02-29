import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import listmulticolumn.Cell;
import listmulticolumn.ContentAlign;
import listmulticolumn.LeftAlign;
import listmulticolumn.ListMultiColumn;
import listmulticolumn.Row;

public class ExpampleListMultiColumn extends Frame implements WindowListener, ItemListener
{
	private static final long serialVersionUID = 1L;
	final int cellSize1 = 9;
	final int cellSize2 = 11;
	final int cellSize3 = 8;
	final int cellSize4 = 0;
	// ContentAlign align = new CenterAlign();
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
	ListMultiColumn lmc = new ListMultiColumn(5, false);
	
	public ExpampleListMultiColumn()
	{
		setSize(300, 200);
		setTitle("Example");
		setLocationRelativeTo(null);
		
		for (Cell[] cellsRow : cells)
		{
			Row row = new Row(cellsRow);
			lmc.add(row);
		}
		
		add(lmc);
		
		addWindowListener(this);
		lmc.addItemListener(this);
		
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
		// System.out.println(lmc.getFontMetrics(lmc.getFont()));
		// System.out.println(lmc.getSelectedItem());
		System.out.println(lmc.getSelectedRow().getView());
		System.out.println(lmc.getSelectedRow().getCell("Description").getData());
	}

}
