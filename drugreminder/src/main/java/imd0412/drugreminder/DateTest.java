package imd0412.drugreminder;

import java.util.List;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i = 7;
		DrugReminderImpl  reminder = new DrugReminderImpl();
		List<String> list = reminder.createReminders("10/09/2018 12:30", Frequency.SIX_HOURS, i);
		System.out.println(list.size());
	}

}
