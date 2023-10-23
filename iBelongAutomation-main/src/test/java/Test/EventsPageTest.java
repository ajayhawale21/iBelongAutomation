package Test;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import BaseB.BaseT;

public class EventsPageTest extends BaseT {

	@Test(priority = 5, dependsOnGroups = { "iBelong" })
	public void DisplayEventsCount() {
		ev.addEventsBtnDisplay();
		ev.AllEvents();

	}
	
	@Test(priority=6)
	public void AddingEvents() throws InterruptedException {
		ev.AddEventName();
		ev.addingEventsDetails();
		ev.TotalPoints();
		ev.uploadFile();
		
		
		
	}
	
	
	

}
