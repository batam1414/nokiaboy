package org.nokia.opta.tests;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.nokia.opta.FrequencyPlanner;
import org.nokia.opta.app.FrequencyPlannerHello;
import org.nokia.opta.app.Reader;

public class AppTest {

	@Test
	public void testWhen3Trx2Freq1Band() throws FileNotFoundException {
		Reader reader = new Reader();
		FrequencyPlanner unsolved = reader.read("./src/main/resources/org/nokia/opta/solver/testCases/case1/band",
				"./src/main/resources/org/nokia/opta/solver/testCases/case1/trx");
		FrequencyPlanner solved = FrequencyPlannerHello.solve(unsolved);
		assertEquals(solved.getScore().getHardScore(), -65);
	}
	
	@Test
	public void testWhen4Trx6Freq1Band() throws FileNotFoundException {
		Reader myRead = new Reader();
		FrequencyPlanner unsolved = myRead.read("./src/main/resources/org/nokia/opta/solver/testCases/case2/band", 
				"./src/main/resources/org/nokia/opta/solver/testCases/case2/trx");
		FrequencyPlanner solved = FrequencyPlannerHello.solve(unsolved);
		assertEquals(solved.getScore().getHardScore(), -60);
	}

	@Test
	public void testWhen2Trx9Freq2Bands() throws FileNotFoundException {
		Reader myRead = new Reader();
		FrequencyPlanner unsolved = myRead.read("./src/main/resources/org/nokia/opta/solver/testCases/case3/band", 
				"./src/main/resources/org/nokia/opta/solver/testCases/case3/trx");
		FrequencyPlanner solved = FrequencyPlannerHello.solve(unsolved);
		assertEquals(solved.getScore().getHardScore(), 0);
	}
	
	@Test
	public void testWhen5Trx2Freq1Band() throws FileNotFoundException {
		Reader myRead = new Reader();
		FrequencyPlanner unsolved = myRead.read("./src/main/resources/org/nokia/opta/solver/testCases/case5/band", 
				"./src/main/resources/org/nokia/opta/solver/testCases/case5/trx");
		FrequencyPlanner solved = FrequencyPlannerHello.solve(unsolved);
		assertEquals(solved.getScore().getHardScore(), -130);
	}
	
	@Test
	public void testWhen7Trx7Freq2Bands() throws FileNotFoundException {
		Reader myRead = new Reader();
		FrequencyPlanner unsolved = myRead.read("./src/main/resources/org/nokia/opta/solver/testCases/case6/band", 
				"./src/main/resources/org/nokia/opta/solver/testCases/case6/trx");
		FrequencyPlanner solved = FrequencyPlannerHello.solve(unsolved);
		assertEquals(solved.getScore().getHardScore(), -30);
	}

	@Test
	public void testWhen10Trx7Freq2Bands() throws FileNotFoundException {
		Reader myRead = new Reader();
		FrequencyPlanner unsolved = myRead.read("./src/main/resources/org/nokia/opta/solver/testCases/case7/band", 
				"./src/main/resources/org/nokia/opta/solver/testCases/case7/trx");
		FrequencyPlanner solved = FrequencyPlannerHello.solve(unsolved);
		assertEquals(solved.getScore().getHardScore(), -15);
	}
	
//	@Test
//	public void testCaseEight() throws FileNotFoundException {
//		Reader myRead = new Reader();
//		FrequencyPlanner unsolved = myRead.read("./src/main/resources/org/nokia/opta/solver/testCases/case8/band", 
//				"./src/main/resources/org/nokia/opta/solver/testCases/case8/trx");
//		FrequencyPlanner solved = FrequencyPlannerHello.solve(unsolved);
//		assertEquals(solved.getScore().getHardScore(), -67930);
//	}
}
