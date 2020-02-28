package listmulticolumn;

/**
 * Represents a right align behavior for the content of a cell.
 * @author Felipe Santa-Cruz
 *
 */
public class LeftAlign implements ContentAlign
{

	@Override
	public String getView(Cell cell)
	{
		// The flag "-" --> output left-justified
		return String.format("%-" + cell.getSize() + "s", cell.getData());
	}

}
