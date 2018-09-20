package imd0412.drugreminder;

import java.util.ArrayList;
import java.util.List;

public class Date {
	
	private boolean isLeapYear;
	private int year;
	private int month;
	private int day;
	private int hours;
	private int minutes;
	private int frequency;
		
	public Date() {
		super();
		this.isLeapYear = false;
		this.year = -1;
		this.month = -1;
		this.day = -1;
		this.hours = -1;
		this.minutes = -1;
		this.frequency = -1;
	}

	public boolean validateDuration(Integer duration) {
		if(duration > 0 && duration <= 30) {
			return true;
		}
		throw new IllegalArgumentException();
	}
	
	public boolean validateDate(String date) {
		String[] split = date.split("\\s+");
		
		if(split.length != 2) {
			throw new IllegalArgumentException();
		}
		else {
			checkDate(split[0]);
			checkHour(split[1]);
		}
		return true;
	}
	
	private boolean checkDate(String date) {
		String[] split;
		split = date.split("/");
		
		if(split.length != 3) {
			throw new IllegalArgumentException();
		}
		else {
			this.day = Integer.parseInt(split[0]);
			this.month = Integer.parseInt(split[1]);
			this.year = Integer.parseInt(split[2]);
		}
		
		if(this.validateYear()) {
			if (this.validateMonth()) {
				if(this.validateDay()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean validateDay() {
		if (this.month == 1 || this.month == 3 || this.month == 5
				|| this. month == 7 || this.month == 8 || this.month == 10
				|| this. month == 12) {
			if(this.day > 0 && this.day <= 31) {
				return true;
			}
			throw new IllegalArgumentException();
		}
		else if(this.month == 4 || this.month == 6 || this.month == 9 
				|| this.month == 11) {
			if(this.day > 0 && this.day <= 30) {
				return true;
			}
			throw new IllegalArgumentException();
		}
		else {
			if(this.isLeapYear) {
				if(this.day > 0 && this.day <= 29) {
					return true;
				}
				throw new IllegalArgumentException();
			}
			else {
				if(this.day > 0 && this.day <= 28) {
					return true;
				}
				throw new IllegalArgumentException();
			}
		}
	}

	private boolean validateMonth() {
		if (this.month > 0 && this.month <= 13) {
			return true;
		}
		throw new IllegalArgumentException();
	}

	private boolean validateYear() {
		if (this.year >= 2018) {
			this.checkLeapYear();
			return true;
		}
		throw new IllegalArgumentException();
	}
	
	
	private void checkLeapYear() {
		if(this.year%4 != 0) {
			this.isLeapYear = false;
			return;
		}
		else {
			if(this.year%100 == 0) {
				if(this.year%400 == 0) {
					this.isLeapYear = true;
					return;
				}
				else {
					this.isLeapYear = false;
					return;
				}
			}
			else {
				this.isLeapYear = true;
				return;
			}
		}
	}

	private boolean checkHour(String time) {
		String[] split;
		split = time.split(":");
		
		if(split.length != 2) {
			throw new IllegalArgumentException();
		}
		else {
			this.hours = Integer.parseInt(split[0]);
			this.minutes = Integer.parseInt(split[1]);
		}
		
		if(this.minutes < 0 || this.minutes > 60 || this.hours < 0 || this.hours > 24) {
			throw new IllegalArgumentException();
		}
		
		return true;
	}
	
	public List<String> generateAlarms(Frequency frequency, Integer duration){
		if (frequency == Frequency.SIX_HOURS) {
			this.frequency = 6;
		}
		else if (frequency == Frequency.EIGHT_HOURS) {
			this.frequency = 8;
		}
		else if(frequency == Frequency.TWELVE_HOURS) {
			this.frequency = 12;
		}
		else {
			this.frequency = 24;
		}
		
		List<String> alarmList = new ArrayList<String>();
		for(int i = 0 ; i < (24/this.frequency)*duration ; i++) {
			alarmList.add(this.createAlarms(duration));
		}	
		
		return alarmList;
		
	}

	private String createAlarms(Integer duration) {
		
		String alarmDate = this.newAlarmDate();			
		
		return alarmDate;
	}

	private String newAlarmDate() {
		String date = String.valueOf(this.day) + "/" + String.valueOf(this.month) + "/" + String.valueOf(this.year)
		+ " " + String.valueOf(this.hours) + ":" + String.valueOf(this.minutes);

		this.hours += this.frequency;
		if(this.hours >= 24) {
			this.hours -= 24;
			this.day += 1;
			this.confirmDay();
		}
		return date;
	}
	
	private void confirmDay() {
		if (this.month == 1 || this.month == 3 || this.month == 5
				|| this. month == 7 || this.month == 8 || this.month == 10
				|| this. month == 12) {
			if(this.day > 31) {
				this.day -= 31;
				this.month += 1;
				if(this.month > 12) {
					this.month -= 12;
					this.year += 1;
				}
			}
		}
		else if(this.month == 4 || this.month == 6 || this.month == 9 
				|| this.month == 11) {
			if(this.day > 31) {
				this.day -= 30;
				this.month += 1;
			}
		}
		else {
			if(this.isLeapYear) {
				if(this.day > 31) {
					this.day -= 29;
					this.month += 1;
				}
			}
			else {
				if(this.day > 31) {
					this.day -= 28;
					this.month += 1;
				}
			}
		}
	}
	
}
