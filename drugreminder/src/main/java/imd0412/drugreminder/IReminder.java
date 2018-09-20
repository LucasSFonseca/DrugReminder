package imd0412.drugreminder;

import java.util.List;

public interface IReminder {
	List<String> createReminders(String startTime, Frequency frequency,
			Integer duration);

}
