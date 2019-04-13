package org.nokia.opta;

import java.util.LinkedList;
import java.util.List;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

// TODO unit test add/remove neighbour
// TODO check if public getters/setters are needed

@PlanningEntity
public class TRX {
	private int id;
	private Band band;

	private Integer frequency;
	private List<TRX> neighbours;

	public TRX() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}

	@PlanningVariable(valueRangeProviderRefs = { "frequencyRange" })
	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public void addNeighbour(TRX trx) {
		this.neighbours.add(trx);
	}

	public TRX(int id, Band band) {
		super();
		this.id = id;
		this.band = band;
		this.neighbours = new LinkedList<TRX>();
	}

	@Override
	public String toString() {
		return "TRX [id=" + id + ", band=" + band + ", frequency=" + frequency + "]";
	}

}
