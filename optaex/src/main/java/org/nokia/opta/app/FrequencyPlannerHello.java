package org.nokia.opta.app;

import java.io.FileNotFoundException;

import org.nokia.opta.FrequencyPlanner;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class FrequencyPlannerHello {

	public static void main(String[] args) throws FileNotFoundException {
		// you need to specify 2 arguments: the bands file and the trxs file
		if (args.length < 2) {
			System.out.println("this is not the way you run this tho, please add the arguments");
		}

		Solver<FrequencyPlanner> solver = getSolver();

		Reader reader = new Reader();
		FrequencyPlanner unsolvedFrequencyPlanner = reader.read(args[0], args[1]);

		FrequencyPlanner solvedFrequencyPlanner = solver.solve(unsolvedFrequencyPlanner);

		Reader.display(solvedFrequencyPlanner);

	}

	public static FrequencyPlanner solve(FrequencyPlanner unsolved) {
		Solver<FrequencyPlanner> solver = getSolver();

		FrequencyPlanner solved = solver.solve(unsolved);

		return solved;
	}

	private static Solver<FrequencyPlanner> getSolver() {
		SolverFactory<FrequencyPlanner> solverFactory = SolverFactory
				.createFromXmlResource("org/nokia/opta/solver/frequencyPlannerSolverConfig.xml");

		return solverFactory.buildSolver();
	}
}
