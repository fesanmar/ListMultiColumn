package listmulticolumn;

/**
 * Represents a right align behavior for the content of a cell.
 * @author Felipe Santa-Cruz
 *
 */
public class RightAlign implements ContentAlign
{

	@Override
	public String getView(Cell cell)
	{
		return String.format("%" + cell.getSize() + "s", cell.getData());
	}

}
