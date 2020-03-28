package listmulticolumn;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;

/**
 * Joins and display together the head of a list with his body.
 * @author Felipe Santa-Cruz
 *
 */
public class DisplayTogether extends Panel
{
	private static final long serialVersionUID = 1L;
	public ListHead head;
	public ListBody body;
	
	/**
	 * Creates a multicolumns list with the specified head and body.
	 * @param head The head of the multicolumn list.
	 * @param body The body of the multicolumn list
	 */
	public DisplayTogether(ListHead head, ListBody body)
	{
		super(new GridBagLayout());
		this.head = head;
		this.body = body;
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(head, constraints);
		constraints.gridy = 1;
		add(body, constraints);
	}
}
