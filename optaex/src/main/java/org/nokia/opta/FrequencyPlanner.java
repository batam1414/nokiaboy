package org.nokia.opta;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.persistence.xstream.api.score.buildin.hardsoft.HardSoftScoreXStreamConverter;

import com.thoughtworks.xstream.annotations.XStreamConverter;

@PlanningSolution
public class FrequencyPlanner {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private List<TRX> TRXList;
	private List<Integer> frequencyList;

	@XStreamConverter(HardSoftScoreXStreamConverter.class)
	private HardSoftScore score;

	public FrequencyPlanner() {

	}

	public FrequencyPlanner(List<TRX> tRXList, List<Integer> frequencyList) {
		super();
		this.TRXList = tRXList;
		this.frequencyList = frequencyList;
	}

	@PlanningEntityCollectionProperty
	public List<TRX> getTRXList() {
		return TRXList;
	}

	public void setTRXList(List<TRX> tRXList) {
		TRXList = tRXList;
	}

	@ValueRangeProvider(id = "frequencyRange")
	@ProblemFactCollectionProperty
	public List<Integer> getFrequencyList() {
		return frequencyList;
	}

	public void setFrequencyList(List<Integer> frequencyList) {
		this.frequencyList = frequencyList;
	}

	@PlanningScore
	public HardSoftScore getScore() {
		return score;
	}

	public void setScore(HardSoftScore score) {
		this.score = score;
	}

}
