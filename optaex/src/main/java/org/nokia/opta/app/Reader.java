package org.nokia.opta.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.nokia.opta.Band;
import org.nokia.opta.FrequencyPlanner;
import org.nokia.opta.TRX;

public class Reader {

	private List<Band> bandList;
	private List<TRX> TRXList;
	private List<Integer> frequencyList;

	public static void main(String[] args) throws FileNotFoundException {
		Reader reader = new Reader();
		FrequencyPlanner testPlanner = reader.read();
		Reader.display(testPlanner);
	}

	public FrequencyPlanner read() throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(new File("/home/master/Work/opta_inputs/input/case1/band"));

		this.bandList = new ArrayList<Band>();

		while (scanner.hasNext()) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			int id = scanner.nextInt();

			bandList.add(new Band(id, start, end));
		}

		this.frequencyList = new ArrayList<Integer>();

		for (Band band : bandList) {
			for (int i = band.getStart(); i <= band.getEnd(); i++) {
				if (frequencyList.contains(i)) {
				} else {
					frequencyList.add(i);
				}
			}
		}

		scanner.close();
		scanner = new Scanner(new File("/home/master/Work/opta_inputs/input/case1/trx"));

		this.TRXList = new ArrayList<TRX>();

		while (scanner.hasNext()) {
			int id = scanner.nextInt();
			int band_id = scanner.nextInt();

			Band band = bandList.get(band_id - 1);
			String useless_line = scanner.nextLine();
			String line = scanner.nextLine();

			this.TRXList.add(new TRX(id, band));
		}

		scanner.close();
		scanner = new Scanner(new File("/home/master/Work/opta_inputs/input/case1/trx"));

		while (scanner.hasNext()) {
			int id = scanner.nextInt();
			String useless_line = scanner.nextLine();

			TRX myTRX = TRXList.get(id - 1);

			String line = scanner.nextLine();
			String[] ints = line.split(" ");

			for (String string_number : ints) {
				int int_number = Integer.parseInt(string_number);
				myTRX.addNeighbour(TRXList.get(int_number - 1));
			}
		}

		FrequencyPlanner answer = new FrequencyPlanner(TRXList, frequencyList);
		scanner.close();

		return answer;
	}

	public static String display(FrequencyPlanner solvedFrequencyPlanner) {
		// TODO Auto-generated method stub

		for (TRX i : solvedFrequencyPlanner.getTRXList()) {
			System.out.println(i);
		}

		try {

			int score = solvedFrequencyPlanner.getScore().getHardScore();

			System.out.println("Final hard score");
			System.out.println(score);
			System.out.println("No soft score yet");

		} catch (NullPointerException e) {
			System.out.println("solver not started so there is no score to display");
		} catch (Exception e) {
			System.out.println("?????????????????????");
		}
		return null;
	}

}