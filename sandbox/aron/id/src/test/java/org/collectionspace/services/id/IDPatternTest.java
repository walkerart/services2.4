/*	
 * IDPatternTest
 *
 * Test class for IDPattern.
 *
 * Copyright 2009 Regents of the University of California
 *
 * Licensed under the Educational Community License (ECL), Version 2.0.
 * You may not use this file except in compliance with this License.
 *
 * You may obtain a copy of the ECL 2.0 License at
 * https://source.collectionspace.org/collection-space/LICENSE.txt
 *
 * @author $Author: aron $
 * @version $Revision: 267 $
 * $Date: 2009-06-19 19:03:38 -0700 (Fri, 19 Jun 2009) $
 */

package org.collectionspace.services.id;

import static org.junit.Assert.fail;
import java.util.Vector;
import junit.framework.TestCase;

public class IDPatternTest extends TestCase {

	IDPattern pattern;
	IDPart part;

	// Note: tests may fail with IllegalArgumentException
	// if any initialization of new IDParts fails
	// due to invalid arguments passed to their constructors.

	public void testCurrentIDViaVector() {

		Vector parts = new Vector();
		parts.add(new YearIDPart("2009"));
		parts.add(new StringIDPart("."));
		parts.add(new NumericIDPart("1"));
		parts.add(new StringIDPart("-"));
		parts.add(new AlphabeticIDPart("a"));
		pattern = new IDPattern(parts);
		assertEquals("2009.1-a", pattern.getCurrentID());
			
	}

	public void testCurrentIDViaAdd() {

		pattern = new IDPattern();
		pattern.add(new YearIDPart("2009"));
		pattern.add(new StringIDPart("."));
		pattern.add(new NumericIDPart("1"));
		pattern.add(new StringIDPart("-"));
		pattern.add(new AlphabeticIDPart("a"));	
		assertEquals("2009.1-a", pattern.getCurrentID());
			
	}

	public void testNextID() {

		pattern = new IDPattern();
		pattern.add(new YearIDPart("2009"));
		pattern.add(new StringIDPart("."));
		pattern.add(new NumericIDPart("1"));
		assertEquals("2009.2", pattern.getNextID());
		assertEquals("2009.3", pattern.getNextID());

		pattern = new IDPattern();
		pattern.add(new YearIDPart("2009"));
		pattern.add(new StringIDPart("."));
		pattern.add(new NumericIDPart("1"));
		pattern.add(new StringIDPart("-"));
		pattern.add(new AlphabeticIDPart("a"));
		assertEquals("2009.1-b", pattern.getNextID());
		assertEquals("2009.1-c", pattern.getNextID());

		pattern = new IDPattern();
		pattern.add(new StringIDPart("T"));
		pattern.add(new NumericIDPart("1005"));
		assertEquals("T1006", pattern.getNextID());
		assertEquals("T1007", pattern.getNextID());
			
	}

	public void testNextIDWithConstantStringID() {
	
		pattern = new IDPattern();
		pattern.add(new YearIDPart("2009"));
		pattern.add(new StringIDPart("."));
		pattern.add(new NumericIDPart("1"));
		pattern.add(new StringIDPart("-"));
		assertEquals("2009.1-", pattern.getNextID());
		assertEquals("2009.1-", pattern.getNextID());

	}
	
	public void testEmptyPartsListCurrentID() {

		pattern = new IDPattern();
		assertEquals("", pattern.getCurrentID());
			
	}

	// @TODO: Add more tests of boundary conditions, exceptions ...
 
}