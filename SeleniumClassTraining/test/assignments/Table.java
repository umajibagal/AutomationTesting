package assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

public class Table {
	private final WebElement element;

	public Table(WebElement element) {
		String tagname = element.getTagName();

		if (null == tagname || !"table".equalsIgnoreCase(tagname))
			throw new UnexpectedTagNameException("table", tagname);
		this.element = element;
	}

	public WebElement getTable() {
		return element;
	}

	public List<WebElement> getAllDataRows() {
		return element.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
	}

	public int getRowCount() {
		return getAllDataRows().size();
	}

	public int getColumnCount() {
		WebElement currentRow = getAllDataRows().get(0);
		return currentRow.findElements(By.tagName("td")).size();
	}

	public int getHeaderIndex(String header) {
		int index = 1, f = 0;
		for (WebElement ele : element.findElement(By.tagName("thead")).findElements(By.tagName("th"))) {
			if (header.equalsIgnoreCase(ele.getText())) {
				f = 1;
				break;
			}
			index++;
		}
		if (f == 0)
			index = -1;
		System.out.println("hIndex : " + index);
		return index;
	}

	public int SearchInColumnWithOutHeader(int cIndex, String searchString) {
		int rIndex = 1, f = 0;
		List<WebElement> allData = getAllDataRows();

		for (WebElement row : allData) {
			System.out.println(row.findElements(By.tagName("td")).get(cIndex - 1).getText());
			if (row.findElements(By.tagName("td")).get(cIndex - 1).getText().contains(searchString)) {
				f = 1;
				break;
			}
			rIndex++;
		}

		if (f == 0)
			rIndex = -1;

		return rIndex;

	}
	
	public int SearchInColumnWithHeader(int cIndex, String searchString) {
		int rIndex = 1, f = 0;
		List<WebElement> allData = getAllDataRows();

		for (WebElement row : allData) {
			System.out.println(row.findElements(By.tagName("td")).get(cIndex - 2).getText());
			if (row.findElements(By.tagName("td")).get(cIndex - 2).getText().contains(searchString)) {
				f = 1;
				break;
			}
			rIndex++;
		}

		if (f == 0)
			rIndex = -1;

		return rIndex;

	}


	public void editCell() {

	}

	public WebElement deleteTableRow(int rIndex,String xPath,String actionName) {
		
		WebElement delete = element.findElement(
				By.xpath(xPath+"//tbody//tr[" + rIndex + "]//td[last()]//a[text()='"+actionName+"']"));
		return delete;
	}
}
