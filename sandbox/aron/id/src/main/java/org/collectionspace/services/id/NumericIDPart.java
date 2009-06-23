 /*	
 * NumericIDPart
 *
 * Models a part of an identifier (ID) whose values come from an
 * incrementing numeric series, with those values represented as
 * String objects.
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

// @TODO: Add Javadoc comments

package org.collectionspace.services.id;

public class NumericIDPart extends IDPart {

	public NumericIDPart(String baseVal) {
		// Store the appropriate Numeric ID generator and the base value for this part.
		
		// @TODO: Determine how to handle the NumberFormatException that will be thrown
		// from parseLong "if the string does not contain a parsable long."  We may
		// need a shim to perform this conversion prior to setting up the generator.
		super(new NumericIDGenerator(baseVal));
	};

}