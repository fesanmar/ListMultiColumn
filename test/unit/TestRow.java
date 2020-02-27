package unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import listmulticolumn.Cell;
import listmulticolumn.Row;

class TestRow
{
	Row row;
	String fRow;
	
	@BeforeEach
	void instanceRow()
	{
		row = new Row();
	}
	
	@AfterEach
	void nullRow()
	{
		row = null;
		fRow = null;
	}

	@Test
	final void testGetView1()
	{
		fRow = row.getView();
		assertEquals("", fRow);
	}
	@Test
	final void testGetView2()
	{
		row.add(new Cell(10, "Hello"));
		row.add(new Cell(10, "World"));
		fRow = row.getView();
		// System.out.println(fRow);
		assertEquals("Hello     |World     ", fRow);
	}

	@Test
	final void testGetCellInt()
	{
		row.add(new Cell(10, "Hello"));
		row.add(new Cell(10, "World"));
		Cell c2 = row.getCell(2);
		assertEquals("World", c2.getData());
	}

	@Test
	final void testGetCellString1()
	{
		Cell cell = row.getCell("");
		assertEquals(cell.getData(), "");
	}
	
	@Test
	final void testGetCellString2()
	{
		row.add(new Cell(7, "Hello", "First"));
		Cell cell = row.getCell("Second");
		assertEquals(cell.getData(), "");
	}
	
	@Test
	final void testGetCellString3()
	{
		row.add(new Cell(10, "Hello", "First"));
		row.add(new Cell(10, "World", "Second"));
		Cell cFirst = row.getCell("Second");
		assertEquals(cFirst.getData(), "World");
	}

}
