package org.nokia.opta;

public class Band {
	private Integer id;
	private Integer start;
	private Integer end;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Band(Integer id, Integer start, Integer end) {
		this.id = id;
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Band [id=" + id + ", start=" + start + ", end=" + end + "]";
	}

	public boolean contains(Integer frequency) {
		return (frequency <= end && frequency >= start);
	}
}
