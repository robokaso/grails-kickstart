import org.joda.time.*

import boil.*

def now = new DateTime()

fixture {
	
	masterJoda(Joda) {
		dateTime = now	
		localDate = new LocalDate()
		duration = new Duration(now, now.plusDays(1))
	}
}