package org.nokia.opta;

public class Band {
	private Integer id;
	private Integer start;
	private Integer stop;

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

	public Integer getStop() {
		return stop;
	}

	public void setStop(Integer stop) {
		this.stop = stop;
	}

	public Band(Integer id, Integer start, Integer stop) {
		this.id = id;
		this.start = start;
		this.stop = stop;
	}

	@Override
	public String toString() {
		return "Band [id=" + id + ", start=" + start + ", end=" + stop + "]";
	}
}
