package com.translate.translate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Translate {

	public List<String> translateWord(String name) {
		
		List<String> paragraphs = new ArrayList<String>();
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\jonas\\OneDrive\\Área de Trabalho\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://wol.jw.org/pt/wol/s/r5/lp-t?q=" + name + "&fc%5B%5D=w&p=par&r=newest");

		List<WebElement> results = driver.findElements(By.xpath("//*[@id=\"searchResultsForm\"]/div[2]/div[2]/div"));
		WebElement firstResult = null;
		
		if(!results.isEmpty()) {
			for (WebElement item : results)
				firstResult = item.findElement(By.className("lnk"));
		}
		else
			firstResult = driver.findElement(By.className("lnk"));
		
		firstResult.click();

		WebElement selectWord = driver.findElement(By.className("mk"));
		selectWord.click();
		
		WebElement paragraph = selectWord.findElement(By.xpath("./.."));
		System.out.println(paragraph.getText());
		paragraphs.add(paragraph.getText());
		String idParagraph = paragraph.getAttribute("id");

		WebElement translate = driver.findElement(By.xpath("//*[@id='linkSynchronizeSwitch']/span"));
		translate.click();
		
		//remove and build url in kreyol

		WebElement languageFilter = driver.findElement(By.xpath("//*[@id=\"contentOnly\"]/div[1]/input"));
		languageFilter.sendKeys("kreyòl ayisyen");

		WebElement langSelected = driver.findElement(By.xpath("//*[@id=\"contentOnly\"]/div[3]/ul/li[230]"));
		langSelected.click();
		
		//remove and build url in kreyol
		
		WebElement paragraphTranslated = driver.findElement(By.id(idParagraph));
		System.out.println(paragraphTranslated.getText());

		paragraphs.add(paragraphTranslated.getText());
		
		driver.close();
		
		return paragraphs;
	}
}