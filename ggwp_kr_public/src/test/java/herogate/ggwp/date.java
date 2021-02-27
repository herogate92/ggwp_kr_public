package herogate.ggwp;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class date {

	@Test
	public void test() {
		LocalDate localNowdate = LocalDate.now();
		localNowdate.minus(Period.ofWeeks(3));
		System.out.println("DEBUG###");
		System.out.println(localNowdate.minusDays(1));
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println();;
		
		String today = localNowdate.format(dateTimeFormatter)+"T00:00:00Z";
	}

}
