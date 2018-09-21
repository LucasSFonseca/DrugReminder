package imd0412.drugreminder;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DrugReminderExceptionTest {
	@Parameters(name= "ID: {index}")
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]
				{
			{"21/03/2018 18:00", Frequency.SIX_HOURS, 0, IllegalArgumentException.class},
			{"21/03/2017 18:00", Frequency.TWELVE_HOURS, 5, IllegalArgumentException.class},
			{"21022018 18:00", Frequency.TWENTYFOUR_HOURS, 30, IllegalArgumentException.class},
			{"21/03/2018 28:00", Frequency.TWELVE_HOURS, 5, IllegalArgumentException.class},
			{"21/03/2018 18:70", Frequency.TWELVE_HOURS, 5, IllegalArgumentException.class},
			{"32/01/2018 18:00", Frequency.TWELVE_HOURS, 5, IllegalArgumentException.class},
			{"31/04/2018 18:00", Frequency.TWELVE_HOURS, 5, IllegalArgumentException.class},
			{"29/02/2018 18:00", Frequency.TWELVE_HOURS, 5, IllegalArgumentException.class},
			{"30/02/2020 18:00", Frequency.TWELVE_HOURS, 5, IllegalArgumentException.class},
			{"32/02/2400 18:00", Frequency.TWELVE_HOURS, 18, IllegalArgumentException.class},
			{"20/02/202018:00", Frequency.TWELVE_HOURS, 5, IllegalArgumentException.class},
			{"20/02/2020 1800", Frequency.TWELVE_HOURS, 5, IllegalArgumentException.class},
			{"20/13/2020 18:00", Frequency.TWELVE_HOURS, 5, IllegalArgumentException.class},
						
				});
	}
	
	@Parameter(0)
	public String startTime;
	
	@Parameter(1)
	public Frequency frequency;
	
	@Parameter(2)
	public Integer duration;
	
	@Parameter(3)
	public Class<? extends Throwable> expectedThrow;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test() {
		thrown.expect(expectedThrow);
		DrugReminderImpl drugReminder = new DrugReminderImpl();
		drugReminder.createReminders(startTime, frequency, duration);
	}

}
