package unit;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import listmulticolumn.Cell;
import listmulticolumn.ListMultiColumn;
import listmulticolumn.Row;

class TestListMultiColumn
{
	final int cellSize1 = 9;
	final int cellSize2 = 11;
	final int cellSize3 = 8;
	final int cellSize4 = 0;
	Cell[][] cells = {
			{
				new Cell(cellSize1, "Java", "Language"),
				new Cell(cellSize2, "Spring", "Framework"),
				new Cell(cellSize3, "4.3", "Version"),
				new Cell(cellSize4, 
						"Spring’s flexible libraries are trusted by developers all "
						+ "over the world.", 
						"Description")
			},
			{
				new Cell(cellSize1, "Python", "Language"),
				new Cell(cellSize2, "Django	", "Framework"),
				new Cell(cellSize3, "2.2.5", "Version"),
				new Cell(cellSize4, 
						"Django is a high-level Python Web framework that encourages"
						+ " rapid development and clean, pragmatic design.", 
						"Description")
			},
			{
				new Cell(cellSize1, "Ruby", "Language"),
				new Cell(cellSize2, "Rails", "Framework"),
				new Cell(cellSize3, "5.0", "Version"),
				new Cell(cellSize4, 
						"A web-application framework that includes everything needed "
						+ "to create database-backed web applications according to "
						+ "the Model-View-Controller", 
						"Description")
			}
	};
	ListMultiColumn lmc;
	
	
	@BeforeEach
	void instanceListMultiColumn()
	{
		lmc = new ListMultiColumn();
	}
	
	@Test
	void testAddRow()
	{
		for (Cell[] cellsRow : cells)
		{
			Row row = new Row(cellsRow);
			lmc.add(row);
		}
	}
	
	@Test
	void testAddRowInt()
	{
		fail("Not yet implemented");
	}

	@Test
	void testGetListRows()
	{
		fail("Not yet implemented");
	}


	@Test
	void testGetSelectedRow()
	{
		fail("Not yet implemented");
	}

	@Test
	void testGetSelectedRows()
	{
		fail("Not yet implemented");
	}

}
