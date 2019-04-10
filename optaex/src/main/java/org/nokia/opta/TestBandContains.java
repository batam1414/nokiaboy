package org.nokia.opta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBandContains {


	@Test
	void testContains() {
		Band test = new Band(1,30,100);
		boolean output = test.contains(44);
		assertEquals(true,output);
	}

}
