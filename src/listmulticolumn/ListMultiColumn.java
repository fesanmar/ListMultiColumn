package listmulticolumn;

import java.awt.List;
import java.util.ArrayList;

/**
 * Represents a list with different columns.
 * 
 * @author Felipe Santa-Cruz
 *
 */
@SuppressWarnings("serial")
public class ListMultiColumn extends List
{
	private ArrayList<Row> listRows;

	public ListMultiColumn()
	{
		super();
		listRows = new ArrayList<Row>();
	}

	public ListMultiColumn(int rows)
	{
		super(rows);
		listRows = new ArrayList<Row>();
	}

	public ListMultiColumn(int rows, boolean multipleMode)
	{
		super(rows, multipleMode);
		listRows = new ArrayList<Row>();
	}

	/**
	 * @return the row elements that compose the list.
	 */
	public Row[] getListRows()
	{
		return (Row[]) listRows.toArray();
	}

	/**
	 * Adds the specified item to the end of scrolling list.
	 * @param row The row you want to add.
	 */
	public void add(Row row)
	{
		super.add(row.getView());
		listRows.add(row);
	}

	/**
	 * Adds the specified item to the the scrolling listat the position indicated by
	 * the index. The index iszero-based. If the value of the index is less than
	 * zero,or if the value of the index is greater than or equal tothe number of
	 * items in the list, then the item is addedto the end of the list.
	 * 
	 * @param row The row you want to add.
	 * @param index the position at which to add the item.
	 */
	public void add(Row row, int index)
	{
		super.add(row.getView(), index);
		listRows.add(index, row);
	}

	/**
	 * @return The select row.
	 * @throws IndexOutOfBoundsException if no element is selected.
	 */
	public Row getSelectedRow() throws IndexOutOfBoundsException
	{
		int i = getSelectedIndex();
		return listRows.get(i);
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
			rows[i] = listRows.get(indexes[i]);
		}
		return rows;
	}
}
