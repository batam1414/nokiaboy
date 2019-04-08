package org.nokia.opta.app;

import org.nokia.opta.FrequencyPlanner;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class FrequencyPlannerHello {

	public static void main(String[] args) {
		// Build the Solver
		SolverFactory<FrequencyPlanner> solverFactory = SolverFactory
				.createFromXmlResource("org/nokia/opta/solver/frequencyPlannerSolverConfig.xml");
		Solver<FrequencyPlanner> solver = solverFactory.buildSolver();

		// Load a problem with 400 computers and 1200 processes
		FrequencyPlanner unsolvedFrequencyPlanner = Reader.read();// Solve the problem

		FrequencyPlanner solvedFrequencyPlanner = solver.solve(unsolvedFrequencyPlanner);

		// Display the result
		System.out.println("\nSolved :\n" + Reader.display(solvedFrequencyPlanner));
	}

}
