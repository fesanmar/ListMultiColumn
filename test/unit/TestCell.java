package unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import listmulticolumn.Cell;
import listmulticolumn.CenterAlign;
import listmulticolumn.ContentAlign;
import listmulticolumn.RightAlign;

class TestCell
{
	@ParameterizedTest
	@MethodSource("paramsProviderGetView")
	final void testGetView(int size, String data, ContentAlign align,String expects)
	{
		Cell cell = new Cell(size, data);
		if (align != null) cell.setAlign(align);
		assertEquals(expects, cell.getView());
	}
	
	@ParameterizedTest
	@MethodSource("paramsProviderSetCell")
	final void testSetSize(int size, int expects)
	{
		Cell cell = new Cell();
		cell.setSize(size);
		assertEquals(expects, cell.getSize());
	}
	
	
	
	static Stream<Arguments> paramsProviderGetView()
	{
		return Stream.of(
				Arguments.arguments(2, "Hello", null,"He"),
				Arguments.arguments(10, "Hello", null,"Hello     "),
				Arguments.arguments(0, "Hello", null,""),
				Arguments.arguments(10, null, null,"          "),
				Arguments.arguments(10, "Hello", new RightAlign(),"     Hello"),
				Arguments.arguments(6, "Hello", new CenterAlign(), "Hello "),
				Arguments.arguments(7, "Hello", new CenterAlign(), " Hello ")
				);
	}
	
	static Stream<Arguments> paramsProviderSetCell()
	{
		return Stream.of(
				Arguments.arguments(1, 1),
				Arguments.arguments(-1, 0)
				);
	}

}
