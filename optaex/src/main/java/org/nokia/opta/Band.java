package org.nokia.opta;

public class Band {
	private int id;
	private int start;
	private int end;

	public int getId() {
		return id;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
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
		return (frequency <= end && frequency >= start);
	}
}
