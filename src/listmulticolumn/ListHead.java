package listmulticolumn;

import java.awt.Font;
import java.awt.Label;

/**
 * Represents the head of a list with different columns
 * @author Felipe Santa-Cruz
 *
 */
public class ListHead extends Label
{
	private static final long serialVersionUID = 1L;
	private Row headRow;
	
	/**
	 * Creates an empty ListHead with an empty row.
	 */
	public ListHead()
	{
		super();
		super.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		this.headRow = new Row();
		
	}
	
	/**
	 * Creates a ListHead with the specified headRow.
	 * @param headRow The row representing the layout of the head.
	 */
	public ListHead(Row headRow)
	{
		super(headRow.getView());
		super.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		this.headRow = headRow;
	}

	/**
	 * @return the headRow The row representing the layout of the head.
	 */
	public Row getHeadRow()
	{
		return headRow;
	}
	
	/**
	 * Sets the text that will be performed as head.
	 * @param headRow The row representing the layout of the head.
	 */
	public void setHeadRow(Row headRow)
	{
		super.setText(headRow.getView());
	}
}
