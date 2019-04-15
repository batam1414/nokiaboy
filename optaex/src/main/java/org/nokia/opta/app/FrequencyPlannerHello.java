package org.nokia.opta.app;

import java.io.FileNotFoundException;

import org.nokia.opta.FrequencyPlanner;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class FrequencyPlannerHello {

	public static void main(String[] args) throws FileNotFoundException {
		// Build the Solver
		SolverFactory<FrequencyPlanner> solverFactory = SolverFactory
				.createFromXmlResource("org/nokia/opta/solver/frequencyPlannerSolverConfig.xml");
		Solver<FrequencyPlanner> solver = solverFactory.buildSolver();

		Reader reader = new Reader();
		FrequencyPlanner unsolvedFrequencyPlanner = reader.read();

		FrequencyPlanner solvedFrequencyPlanner = solver.solve(unsolvedFrequencyPlanner);

		// Display the result
		Reader.display(solvedFrequencyPlanner);
		// System.out.println(solver.explainBestScore());
	}

}
