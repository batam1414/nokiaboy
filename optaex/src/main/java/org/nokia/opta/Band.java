package org.nokia.opta;

public class Band {
	private int id;
	private int start;
	private int end;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public Band(int id, int start, int end) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Band [id=" + id + ", start=" + start + ", end=" + end + "]";
	}

	public boolean contains(int frequency) {
		if (frequency <= end && frequency >= start)
			return true;
		else
			return false;
	}
}
