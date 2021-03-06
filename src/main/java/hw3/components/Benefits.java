package hw3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.stream.Collectors;

public class Benefits extends AbstractPageComposite{

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitImages;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitTexts;

    public Benefits(WebDriver driver) {
        super(driver);
    }

    public int getBenefitImagesCount(){
        return wait.until(ExpectedConditions.visibilityOfAllElements(benefitImages)).size();
    }

    public int getBenefitTextsCount(){
        return wait.until(ExpectedConditions.visibilityOfAllElements(benefitTexts)).size();
    }

    public List<String> getBenefitTexts(){
        wait.until(ExpectedConditions.visibilityOfAllElements(benefitTexts));
        return benefitTexts.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isBenefitIconsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfAllElements(benefitImages));
        boolean isDisplayed = false;
        for (WebElement element : benefitImages) {
            isDisplayed = element.isDisplayed();
        }
        return isDisplayed;
    }
}
