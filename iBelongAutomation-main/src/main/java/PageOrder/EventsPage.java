package PageOrder;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventsPage {
	WebDriver driver;

	@FindBy(xpath = "//button[text()='ADD EVENTS']")
	WebElement AddEventBtn;
	@FindBy(xpath = "//input[@placeholder='Enter name of the event']")
	WebElement EventName;
	@FindBy(xpath = "(//input[@placeholder='dd-mm-yyyy'])[1]")
	WebElement NominationStartDate;
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[1]/div[2]/table/tbody/tr[3]/td[4]/div")
	WebElement SelectNStartDate;
	@FindBy(xpath = "(//input[@placeholder='dd-mm-yyyy'])[2]")
	WebElement NominationEndDate;
	@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[1]/div[2]/table/tbody/tr[4]/td[5]/div")
	WebElement SelectNEndDate;
	@FindBy(xpath = "(//input[@placeholder='dd-mm-yyyy'])[3]")
	WebElement EventStartDate;
	@FindBy(xpath = "/html/body/div[5]/div/div/div/div/div[1]/div[2]/table/tbody/tr[4]/td[6]/div")
	WebElement SelectEventStartDate;
	@FindBy(xpath = "(//input[@placeholder='dd-mm-yyyy'])[4]")
	WebElement EventEndDate;
	@FindBy(xpath = "/html/body/div[6]/div/div/div/div/div[1]/div[2]/table/tbody/tr[5]/td[2]/div")
	WebElement SelectEventEndDate;
	@FindBy(xpath = "//select[@id='eventType']")
	WebElement EventTypeDD; // Individual
	@FindBy(xpath = "//select[@id='fileType']")
	WebElement FileTypeDD; // Image, Video, Pdf
	@FindBy(xpath = "//textarea[@id='description']")
	WebElement DescriptionTextField;
	@FindBy(xpath = "//input[@id='firstWinnerPoints']")
	WebElement FirstWinnersPoint;
	@FindBy(xpath = "//input[@id='secondWinnerPoints']")
	WebElement SecondWinnersPoint;
	@FindBy(xpath = "//input[@id='thirdWinnerPoints']")
	WebElement ThirdWinnersPoint;
	@FindBy(xpath = "(//span[@class='ant-upload'])[1]")
	WebElement UploadEventThumbnailImage; // jpeg/jpg/png
	@FindBy(xpath = "(//span[@class='ant-upload'])[2]")
	WebElement UploadEventGuidelines; // pdf
	@FindBy(xpath = "//span[text()='ADD']")
	WebElement AddBtn;
	@FindBy(xpath = "(//div[@class='ant-form-item-control-input-content'])[13]")
	WebElement TotalPointsCount;

	@FindBy(xpath = "//div[@class='ant-col ant-col-11 eventCard']")
	WebElement EventsCount;

	@FindBy(xpath = "//span[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line eventTitle']")
	WebElement FirstEventTitle;
	@FindBy(xpath="//span[text()='ADD EVENT IMAGES']")
WebElement a ;
	public EventsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addEventsBtnDisplay() {
		boolean c = AddEventBtn.isDisplayed();
		System.out.println("Add Events button is displaying :-" + " " + c);
	}

	public void AllEvents() {
		int size = driver.findElements(By.xpath("//div[@class='ant-col ant-col-11 eventCard']")).size();
		System.out.println("Total number of events present :" + " " + size);
	}

	public void AddEventsBtn() {
		AddEventBtn.click();
	}

	public void AddEventName() {
		// random string of length 8 composed of alphabetic characters
		String title = RandomStringUtils.randomAlphabetic(5);
		System.out.println("The New Event Created  is .. " + title);
		driver.findElement(By.xpath("//input[@placeholder='Enter name of the event']")).sendKeys("NewEvent" + title);// "NewEvent"
																														// +
	}

	public void addingEventsDetails() throws InterruptedException {
		NominationStartDate.click();
		Thread.sleep(3000);
		SelectNStartDate.click();
		Thread.sleep(3000);
		NominationEndDate.click();
		Thread.sleep(3000);
		SelectNEndDate.click();
		Thread.sleep(3000);
		EventStartDate.click();
		Thread.sleep(3000);
		SelectEventStartDate.click();
		Thread.sleep(3000);
		EventEndDate.click();
		Thread.sleep(2000);
		SelectEventEndDate.click();
		Thread.sleep(2000);
		EventTypeDD.sendKeys("Individual");
		Thread.sleep(2000);
		FileTypeDD.sendKeys("Image");
		Thread.sleep(2000);
		DescriptionTextField.sendKeys("New has been created..... Let's participate");
		Thread.sleep(2000);
		FirstWinnersPoint.sendKeys("50");
		Thread.sleep(2000);
		SecondWinnersPoint.sendKeys("30");
		Thread.sleep(2000);
		ThirdWinnersPoint.sendKeys("20");

	}

	public void TotalPoints() {
		boolean d = TotalPointsCount.isDisplayed();
		System.out.println(TotalPointsCount);
	}

	public void uploadFile() throws InterruptedException {
		Actions act = new Actions(driver);
		WebElement uploadGuidelines = driver.findElement(By.xpath("(//span[@class='ant-upload'])[2]"));
		act.moveToElement(uploadGuidelines).click().perform();
		Thread.sleep(2000);
		uploadfile("C:\\Users\\Brigosha_Guest\\Downloads\\ResumeBrigosha.pdf");
		Thread.sleep(5000);
		WebElement Eventpic = driver.findElement(By.xpath("(//span[@class='ant-upload'])[1]"));
		act.moveToElement(Eventpic).click().perform();
		Thread.sleep(2000);
		uploadfile("C:\\Users\\Brigosha_Guest\\Desktop\\EventPic.jpg");

		System.out.println("Event Thumbnail image is  gets uploaded..");

		Thread.sleep(3000);
		AddBtn.click();
		Thread.sleep(1000);
		System.out.println("Events gets successfully created.");

	}

	private void uploadfile(String string) {
		// TODO Auto-generated method stub

	}

}
