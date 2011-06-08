package boil

import groovy.transform.EqualsAndHashCode;

import org.joda.time.*

/**
 * Sample class with persistent joda-time attributes.
 * 
 * @author Robert Kasanicky
 *
 */
@EqualsAndHashCode
class Joda {

	DateTime dateTime
	
	LocalDate localDate
	
	Duration duration
}
