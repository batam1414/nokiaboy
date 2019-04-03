package org.nokia.opta;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;

@PlanningSolution
public class FrequencyPlanner {

	private int id;
	private List<TRX> TRXList;

	private List<int> frequencyList;

	public FrequencyPlanner() {

	}

	public FrequencyPlanner(int id, List<TRX> tRXList, List<Band> bandList) {
		super();
		this.id = id;
		this.TRXList = tRXList;
		this.bandList = bandList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<TRX> getTRXList() {
		return TRXList;
	}

	public void setTRXList(List<TRX> tRXList) {
		TRXList = tRXList;
	}

	@ValueRangeProvider(id = "bandRange")
	@ProblemFactCollectionProperty
	public List<Band> getBandList() {
		return bandList;
	}

	public void setBandList(List<Band> bandList) {
		this.bandList = bandList;
	}

}
