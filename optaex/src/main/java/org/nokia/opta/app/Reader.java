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

	public static void main(String[] args) throws FileNotFoundException {
		Reader reader = new Reader();
		FrequencyPlanner testPlanner = reader.read("/home/master/Work/opta_inputs/input/case1/band",
				"/home/master/Work/opta_inputs/input/case1/trx");
		Reader.display(testPlanner);
	}

	public FrequencyPlanner read(String bands, String trxs) throws FileNotFoundException {
		// TODO Auto-generated method stub

		this.bandList = readBandList(bands);

		return new FrequencyPlanner(readTRXList(trxs), readFrequencyList(this.bandList));
	}

	// bands

	private List<Band> readBandList(String bands) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File(bands));

		List<Band> result = new ArrayList<Band>();

		while (scanner.hasNext()) {

			result.add(readNewBand(scanner));

		}

		scanner.close();
		return result;
	}

	private Band readNewBand(Scanner scanner) {
		int start = scanner.nextInt();
		int end = scanner.nextInt();
		int id = scanner.nextInt();

		return new Band(id, start, end);
	}

	// trxs

	private List<TRX> readTRXList(String trxs) throws FileNotFoundException {

		List<TRX> result = firstReadTRXList(trxs);

		secondReadTRXList(result, trxs);

		return result;
	}

	// trx first

	private List<TRX> firstReadTRXList(String trxs) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File(trxs));

		List<TRX> result = new ArrayList<TRX>();

		while (scanner.hasNext()) {

			result.add(firstReadNewTRX(scanner));
		}

		scanner.close();
		return result;
	}

	private TRX firstReadNewTRX(Scanner scanner) {
		int id = scanner.nextInt();
		int band_id = scanner.nextInt();

		Band band = bandList.get(band_id - 1);

		String useless_line = scanner.nextLine();
		String line = scanner.nextLine();

		return new TRX(id, band);
	}

	// trx second

	private void secondReadTRXList(List<TRX> result, String trxs) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File(trxs));

		while (scanner.hasNext()) {
			secondReadNewTRX(result, scanner);
		}

		scanner.close();
	}

	private void secondReadNewTRX(List<TRX> result, Scanner scanner) {

		int id = scanner.nextInt();
		String useless_line = scanner.nextLine();

		TRX myTRX = result.get(id - 1);

		String line = scanner.nextLine();
		String[] ints = line.split(" ");

		for (String string_number : ints) {
			readNewNeighbour(result, myTRX, string_number);
		}

	}

	private void readNewNeighbour(List<TRX> result, TRX myTRX, String string_number) {
		int int_number = Integer.parseInt(string_number);
		myTRX.addNeighbour(result.get(int_number - 1));
	}

	// freq

	private List<Integer> readFrequencyList(List<Band> paramBandList) {
		List<Integer> result = new ArrayList<Integer>();

		for (Band band : paramBandList) {
			for (int i = band.getStart(); i <= band.getEnd(); i++) {
				if (result.contains(i)) {
				} else {
					result.add(i);
				}
			}

		}

		return result;
	}

	// print

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