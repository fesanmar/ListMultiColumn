package listmulticolumn;

/**
 * Represents a right align behavior for the content of a cell.
 * @author Felipe Santa-Cruz
 *
 */
public class CenterAlign implements ContentAlign
{

	@Override
	public String getView(Cell cell)
	{
		final char filler = ' ';
		StringBuilder sbView = new StringBuilder(cell.getSize());
		
		for (int i = 0; i < (cell.getSize() - cell.getData().length()) /2; i++)
		{
			sbView.append(filler);
		}
		sbView.append(cell.getData());
		while (sbView.length() < cell.getSize())
		{
			sbView.append(filler);
		}
		
		return sbView.toString();
	}

}
