package listmulticolumn;

import java.awt.Font;
import java.awt.List;
import java.util.ArrayList;

/**
 * Represents a the body of a list with different columns.
 * 
 * @author Felipe Santa-Cruz
 *
 */
public class ListBody extends List
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Row> listedRows;

	public ListBody()
	{
		super();
		setFont();
		listedRows = new ArrayList<Row>();
	}

	public ListBody(int rows)
	{
		super(rows);
		setFont();
		listedRows = new ArrayList<Row>();
	}

	public ListBody(int rows, boolean multipleMode)
	{
		super(rows, multipleMode);
		setFont();
		listedRows = new ArrayList<Row>();
	}

	private void setFont()
	{
		super.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
	}
	
	/**
	 * @return the row elements that compose the list.
	 */
	public Row[] getListedRows()
	{
		return (Row[]) listedRows.toArray();
	}
	
	@Override
	public void removeAll()
	{
		super.removeAll();
		listedRows.clear();
	}
	
	
	/**
	 * Adds the specified item to the end of scrolling list. It creates a Row with only
	 * one cell. The size of cell will be the leng of the arg0
	 * @param arg0 The text that will be added as row to the list.
	 */
	@Override
	public void add(String arg0)
	{
		Cell cell = new Cell(arg0.length(), arg0);
		Row row = new Row();
		row.add(cell);
		this.add(row);
	}
	
	/**
	 * Adds the specified item to the the scrolling list at the position indicated by
	 * the index. The index is zero-based. If the value of the index is less than
	 * zero,or if the value of the index is greater than or equal to the number of
	 * items in the list, then the item is added to the end of the list.
	 * 
	 * @param arg0 The row you want to add.
	 * @param index the position at which to add the item.
	 */
	@Override
	public void add(String arg0, int index)
	{
		Cell cell = new Cell(arg0.length(), arg0);
		Row row = new Row();
		row.add(cell);
		this.add(row, index);
	}
	

	/**
	 * Adds the specified item to the end of scrolling list.
	 * @param row The row you want to add.
	 */
	public void add(Row row)
	{
		super.add(row.getView());
		listedRows.add(row);
	}

	/**
	 * Adds the specified item to the the scrolling list at the position indicated by
	 * the index. The index is zero-based. If the value of the index is less than
	 * zero,or if the value of the index is greater than or equal to the number of
	 * items in the list, then the item is added to the end of the list.
	 * 
	 * @param row The text used to create the cell that will be inserted into the row
	 * and, finally, into the ListBody.
	 * @param index the position at which to add the item.
	 */
	public void add(Row row, int index)
	{
		super.add(row.getView(), index);
		listedRows.add(index, row);
	}

	/**
	 * @return The select row.
	 * @throws IndexOutOfBoundsException if no element is selected.
	 */
	public Row getSelectedRow() throws IndexOutOfBoundsException
	{
		int i = getSelectedIndex();
		return listedRows.get(i);
	}

	/**
	 * @returnThe select rows.
	 */
	public Row[] getSelectedRows()
	{
		int[] indexes = getSelectedIndexes();
		int size = indexes.length;
		Row[] rows = new Row[size];
		for (int i = 0; i < size; i++)
		{
			rows[i] = listedRows.get(indexes[i]);
		}
		return rows;
	}
	
	/**
	 * Retrieve the data of the cell named as <b>columName</b> in the selected row.
	 * @param columnName The name of the cell which data is wanted.
	 * @return The cell's data inside the selected row
	 */
	public String getSelectedData(String columnName)
	{
		int i = getSelectedIndex();
		return listedRows.get(i).getCell(columnName).getData();
	}
	
	/**
	 * Retrieve the data of the cell in the position specified by
	 * <b>columnIndex</b>.
	 * @param columnIndex The index of the cell in the row, starting with 1.
	 * @return
	 * @throws IndexOutOfBoundsException if <b>columnIndex</b> is out of range.
	 */
	public String getSelectedData(int columnIndex) throws IndexOutOfBoundsException
	{
		int i = getSelectedIndex();
		return listedRows.get(i).getCell(columnIndex).getData();
	}
}
