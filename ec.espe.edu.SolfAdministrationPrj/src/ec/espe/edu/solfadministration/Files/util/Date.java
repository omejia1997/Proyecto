package ec.espe.edu.solfadministration.Files.util;

import java.util.Calendar;
import java.util.Scanner;

public class Date {
	int year;
	int month;
	int day;
        Calendar actualDate = Calendar.getInstance();
        private int actualDay = actualDate.get(Calendar.DAY_OF_MONTH);
	private int actualMonth = actualDate.get(Calendar.MONTH);
	private int actualYear = actualDate.get(Calendar.YEAR);

    public Date() {
        
    }

    public  int getActualDay() {
        return actualDay;
    }

    public int getActualMonth() {
        return actualMonth;
    }

    public int getActualYear() {
        return actualYear;
    }
        
	public int getYear() {
		return year;
	}
	/**
	 * This method return the date that are in its parameters
	 * @author Pancho
	 * @return String of the date in format "YYYY/MM/DD"
	 */
	public String getDate () {
		String line=getYear()+"/"+getMonth()+"/"+getDay();
		return line;
		
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public Date(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		
	}
	   
	
}
