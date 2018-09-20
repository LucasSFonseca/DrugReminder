package imd0412.drugreminder;

import java.util.List;

public class DrugReminderImpl implements IReminder {

	public List<String> createReminders(String startTime, Frequency frequency,
			Integer duration) {
		Date date = new Date();
		
		date.validateDate(startTime);
		date.validateDuration(duration);
				
		return date.generateAlarms(frequency, duration);
	}

}
