package imd0412.drugreminder;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DrugReminderNormalTest {
	
	@Parameters(name= "ID: {index}")
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]
				{
			{"21/03/2018 18:00", Frequency.SIX_HOURS, 1, 4},
			{"21/03/2018 18:00", Frequency.TWELVE_HOURS, 5, 10},
			{"21/02/2018 18:00", Frequency.TWENTYFOUR_HOURS, 30, 30},
			{"29/02/2020 18:00", Frequency.EIGHT_HOURS, 25, 75},
			{"28/02/2200 18:00", Frequency.TWELVE_HOURS, 30, 60},
			{"30/04/2018 18:00", Frequency.SIX_HOURS, 10, 40},
			{"31/12/2019 23:45", Frequency.TWENTYFOUR_HOURS, 18, 18},
			{"31/5/2019 23:45", Frequency.TWENTYFOUR_HOURS, 18, 18},
			{"31/10/2019 23:45", Frequency.TWENTYFOUR_HOURS, 18, 18},
			{"31/8/2019 23:45", Frequency.TWENTYFOUR_HOURS, 18, 18},
			{"31/7/2019 23:45", Frequency.TWENTYFOUR_HOURS, 18, 18},
			{"12/6/2019 23:45", Frequency.TWENTYFOUR_HOURS, 18, 18},
			{"12/11/2019 23:45", Frequency.TWENTYFOUR_HOURS, 18, 18},

			
	});
	}
	
	@Parameter(0)
	public String startTime;
	
	@Parameter(1)
	public Frequency frequency;
	
	@Parameter(2)
	public Integer duration;
	
	@Parameter(3)
	public int listLenght;
	
	@Test
	public void test() {
		DrugReminderImpl  drugReminder = new DrugReminderImpl();
		List<String> returnedList = drugReminder.createReminders(startTime, frequency, duration);
		
		assertEquals(listLenght, returnedList.size());
		
	}

}
