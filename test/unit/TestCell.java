package unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import listmulticolumn.Cell;

class TestCell
{
	@ParameterizedTest
	@MethodSource("paramsProviderGetView")
	final void testGetView(int size, String data, String expects)
	{
		Cell cell = new Cell(size, data);
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
				Arguments.arguments(2, "Hello", "He"),
				Arguments.arguments(10, "Hello","Hello     "),
				Arguments.arguments(0, "Hello", ""),
				Arguments.arguments(10, null, "          ")
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
