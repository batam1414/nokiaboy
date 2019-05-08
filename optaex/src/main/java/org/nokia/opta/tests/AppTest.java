package org.nokia.opta.tests;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.nokia.opta.FrequencyPlanner;
import org.nokia.opta.app.FrequencyPlannerHello;
import org.nokia.opta.app.Reader;

public class AppTest {

	@Test
	public void testCaseOne() throws FileNotFoundException {
		Reader reader = new Reader();
		FrequencyPlanner unsolved = reader.read("./src/main/resources/org/nokia/opta/solver/testCases/case1/band",
				"./src/main/resources/org/nokia/opta/solver/testCases/case1/trx");
		FrequencyPlanner solved = FrequencyPlannerHello.solve(unsolved);
		assertEquals(solved.getScore().getHardScore(), -10);
	}

	@Test
	public void testCaseFive() throws FileNotFoundException {
		Reader myRead = new Reader();
		FrequencyPlanner unsolved = myRead.read("./src/main/resources/org/nokia/opta/solver/testCases/case5/band", 
				"./src/main/resources/org/nokia/opta/solver/testCases/case5/trx");
		FrequencyPlanner solved = FrequencyPlannerHello.solve(unsolved);
		assertEquals(solved.getScore().getHardScore(), -10);
	}
	
	@Test
	public void testCaseSix() throws FileNotFoundException {
		Reader myRead = new Reader();
		FrequencyPlanner unsolved = myRead.read("./src/main/resources/org/nokia/opta/solver/testCases/case6/band", 
				"./src/main/resources/org/nokia/opta/solver/testCases/case6/trx");
		FrequencyPlanner solved = FrequencyPlannerHello.solve(unsolved);
		assertEquals(solved.getScore().getHardScore(), -20);
	}

	@Test
	public void testCaseSeven() throws FileNotFoundException {
		Reader myRead = new Reader();
		FrequencyPlanner unsolved = myRead.read("./src/main/resources/org/nokia/opta/solver/testCases/case7/band", 
				"./src/main/resources/org/nokia/opta/solver/testCases/case7/trx");
		FrequencyPlanner solved = FrequencyPlannerHello.solve(unsolved);
		assertEquals(solved.getScore().getHardScore(), -70);
	}
	
	@Test
	public void testCaseEight() throws FileNotFoundException {
		Reader myRead = new Reader();
		FrequencyPlanner unsolved = myRead.read("./src/main/resources/org/nokia/opta/solver/testCases/case8/band", 
				"./src/main/resources/org/nokia/opta/solver/testCases/case8/trx");
		FrequencyPlanner solved = FrequencyPlannerHello.solve(unsolved);
		assertEquals(solved.getScore().getHardScore(), -2440);
	}
}
