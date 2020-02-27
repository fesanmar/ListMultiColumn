package listmulticolumn;

/**
 * Represents a cell of a row.
 * @author Felipe Santa-Cruz
 * @version 0.1
 * @since 0.1
 */
public class Cell
{
	private final int SIZE = 10;
	private int size;
	private String data;
	private String columnName;
	
	/**
	 * Creates an empty cell.
	 */
	public Cell()
	{
		size = 0;
		data = "";
		columnName = "";
	}
	
	/**
	 * Creates a cell with the specified size.
	 * @param size The number of chars for the cell. It's set to 0 if the sepcified value is
	 * under 0.
	 */
	public Cell(int size)
	{
		setSize(size);
		data = "";
		columnName = "";
	}
	
	/**
	 * Creates a cell with the specified data and 10 chars of capacity.
	 * @param data The data within the cell.
	 */
	public Cell(String data)
	{
		size = SIZE;
		this.data = data;
		columnName = "";
	}
	
	/**
	 * Creates a cell with the specified data and size.
	 * @param size the number of chars for the cell. It's set to 0 if the sepcified
	 * value is under 0.
	 * @param data The data within the cell.
	 */
	public Cell(int size, String data)
	{
		setSize(size);
		this.data = data;
		columnName = "";
	}
	
	/**
	 * Creates a cell with the specified size, data and column name.
	 * @param size The number of chars for the cell. It's set to 0 if the 
	 * sepcified value is under 0.
	 * @param data The data within the cell.
	 * @param columnName The name of the column to which the cell belongs.
	 */
	public Cell(int size, String data, String columnName)
	{
		setSize(size);
		this.data = data;
		this.columnName = columnName;
	}
	
	/**
	 * @return int The capacity of the cell.
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * @param size The capacity of the cell. It's set to 0 if the sepcified value is
	 * under 0.
	 */
	public void setSize(int size)
	{
		if (size >= 0) this.size = size;
		else this.size = 0;
	}
	
	/**
	 * @return String The data within the cell.
	 */
	public String getData()
	{
		return data;
	}
	
	/**
	 * @param data The string inside the cell.
	 */
	public void setData(String data)
	{
		this.data = data;
	}
	
	/**
	 * @return The name of the column to which the cell belongs.
	 */
	public String getColumnName()
	{
		return columnName;
	}

	/**
	 * @param columnName Sets the name of the column to which the cell belongs.
	 */
	public void setColumnName(String columnName)
	{
		this.columnName = columnName;
	}

	/**
	 * @return String the cell with the specified data and size.
	 */
	public String getView()
	{
		String cell;
		// general format specifier:
		// %[argument_index$][flags][width][.precision]conversion
		if (data.length() > size)
		{
			// "." is for precision, max number of chars to be written
			cell = String.format("%." + size + "s", data);			
		}
		else
		{
			// The flag "-" --> output left-justified
			cell = String.format("%-" + size + "s", data);
		}
		return cell;
	}
}
