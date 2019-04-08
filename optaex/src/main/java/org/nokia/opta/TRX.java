package org.nokia.opta;

import java.util.List;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

// TODO unit test add/remove neighbour
// TODO check if public getters/setters are needed

@PlanningEntity
@XStreamAlias("TRX")
public class TRX {
	private int id;
	private Band band;
	private int frequency;
	private List<TRX> neighbours;

	public int getId() {
		return id;
	}

	public Band getBand() {
		return band;
	}

	@PlanningVariable(valueRangeProviderRefs = { "frequencyRange" })
	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public void addNeighbour(TRX trx) {
		this.neighbours.add(trx);
	}

	public TRX(int id, Band band) {
		super();
		this.id = id;
		this.band = band;
	}

	@Override
	public String toString() {
		return "TRX [id=" + id + ", band=" + band + ", frequency=" + frequency + "]";
	}

}
