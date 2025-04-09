package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	
	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}
	
	public String getSelectedValueFromDropDown(WebElement element, String valueToSelect) {
		Select select = new Select(element);
		select.selectByValue(valueToSelect);
		WebElement selectedValue = select.getFirstSelectedOption();
		String text = selectedValue.getText();
		return text;
	}
	
	public boolean checkboxIsSelected(WebElement element) {
		boolean value = element.isSelected();
		return value;
	}
	
}
