package listmulticolumn;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a row composed of cells
 * @author Felipe Santa-Cruz
 * @version 0.1
 * @since 0.1
 *
 */
public class Row
{
	ArrayList<Cell> cells;
	String separator = " ";

	/**
	 * Creates an empty row.
	 */
	public Row()
	{
		cells = new ArrayList<Cell>();
	}
	
	/**
	 * Creates a row with specified cells.
	 * @param cells The cells that make up the row.
	 */
	public Row(Cell[] cells)
	{
		setCells(cells);
	}
	
	/**
	 * Creates a row with the specified separator and an empty ArrayList.
	 * @param separator The separator that used to differentiate row cells.
	 */
	public Row(String separator)
	{
		cells = new ArrayList<Cell>();
		this.separator = separator;
	}
	
	/**
	 * Creates a row with specified cells and separator.
	 * @param cells The cells that make up the row.
	 * @param separator The separator that used to differentiate row cells.
	 */
	public Row(Cell[] cells, String separator)
	{
		setCells(cells);
		this.separator = separator;
	}

	/**
	 * @return the cells
	 */
	public Cell[] getCells()
	{
		return (Cell[]) cells.toArray();
	}

	/**
	 * @param cells Set the cells with the specified ArrayList of Cells.
	 */
	public void setCells(Cell[] cells)
	{
		this.cells = new ArrayList<Cell>();
		addAll(cells);
	}
	
	/**
	 * @return The separator that used to differentiate row cells.
	 */
	public String getSeparator()
	{
		return separator;
	}

	/**
	 * @param separator The separator that will be used to differentiate row
	 * cells.
	 */
	public void setSeparator(String separator)
	{
		this.separator = separator;
	}
	
	/**
	 * Add a new cell to the row
	 * @param cell The element of which a row is composed, assimilated to
	 * the columns of a table.
	 * @return <b>true</b> if this collection changed as a result of the call.
	 */
	public boolean add(Cell cell)
	{
		boolean r = cells.add(cell);
		return r;
	}
	
	/**
	 * Extend the existing row with the specified collection of cells.
	 * @param cells A collection of cells.
	 * @return <b>true</b> if this collection changed as a result of the call.
	 */
	public void addAll(Cell[] cells)
	{
		for (int i = 0; i < cells.length; i++)
		{
			this.cells.add(cells[i]);
		}
	}
	
	/**
	 * Format a row with the size and data of each cell
	 * @return A String formatted as a row.
	 */
	public String getView()
	{
		String row = "";
		Iterator<Cell> i = cells.iterator();
		while (i.hasNext())
		{
			Cell cell = i.next();
			if (i.hasNext()) row += cell.getView() + separator;				
			else row += cell.getView();
		}
		return row;
	}
	
	/**
	 * @param i The index of the cell in the row, starting with 1.
	 * @return The cell in the position <b>i</b>, starting with 1.
	 * @throws IndexOutOfBoundsException if i is out of range.
	 */
	public Cell getCell(int i) throws IndexOutOfBoundsException
	{
		return cells.get(i - 1);
	}
	
	/**
	 * Returns the first cell in the row that match with the specified column name.
	 * If there is no match, an empty cell is returned.
	 * @param columnName The name of the column to which the cell belongs.
	 * @return the Cell with the specified column name if it exists.
	 */
	public Cell getCell(String columnName)
	{
		Cell matchCell = new Cell();
		for (Cell cell : cells)
		{
			if (cell.getColumnName() == columnName)
			{
				matchCell = cell;
				break;
			}
		}
		return matchCell;
	}
}
