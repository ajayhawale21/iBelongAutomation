package Test;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import BaseB.BaseT;

public class OverviewPageTest  extends BaseT{
	
	@Test(priority=0,enabled=true)
	public void displayingCards()
	{
		ov.displayingHouseCards();
		
	}

	@Test(priority=1)
	public void selectingCalender() throws InterruptedException {
		ov.OverviewCalender();
		System.out.println("Second Test");
	}
	
	@Test(priority=2)
	public void DisplaySuperad() {
		ov.displayingSuperAdm();
	}
	
	@Test(priority=3, groups={"iBelong"})
	public void TotalCards() {
		ov.TotalWhatsHappeningCards();
	}
	@Test(priority=4)
	public void EventsModule() throws InterruptedException {
		ov.ClickingOnEventsMod();
	}
	
	@Ignore
	@Test(priority = 5)
	public void DisplayEventsCount() {
		ev.addEventsBtnDisplay();
		ev.AllEvents();

	}
	@Ignore
	@Test(priority=6)
	public void AddingEvents() throws InterruptedException {
		ev.AddEventsBtn();
		ev.AddEventName();
		ev.addingEventsDetails();
		ev.TotalPoints();
		ev.uploadFile();
		
	
}
}
