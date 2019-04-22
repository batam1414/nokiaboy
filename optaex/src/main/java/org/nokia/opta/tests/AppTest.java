package org.nokia.opta.tests;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.nokia.opta.FrequencyPlanner;
import org.nokia.opta.app.FrequencyPlannerHello;
import org.nokia.opta.app.Reader;

public class AppTest {

	@Test
	public void test() throws FileNotFoundException {
		Reader reader = new Reader();
		FrequencyPlanner unsolved = reader.read("/home/master/Work/opta_inputs/input/case1/band",
				"/home/master/Work/opta_inputs/input/case1/trx");
		FrequencyPlanner solved = FrequencyPlannerHello.solve(unsolved);
		assertEquals(solved.getScore().getHardScore(), -10);
	}

}
