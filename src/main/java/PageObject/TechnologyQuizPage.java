package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.AllureAttachment;

import java.util.List;

public class TechnologyQuizPage extends MenuPage {

    @FindBy(css = ".c-button.btn")
    private WebElement StartBtn;
    @FindBy(css = ".v-grid-1 button>div>div")
    private List<WebElement> Round1List;
    @FindBy(css = ".v-grid-1 button>div>div")
    private List<WebElement> Round2List;
    @FindBy(css = ".v-grid-1 button>div>div")
    private List<WebElement> Round3List;
    @FindBy(css = ".v-grid-1 button>div>div")
    private List<WebElement> Round4List;
    @FindBy(css = ".v-grid-1 button>div>div")
    private List<WebElement> Round5List;
    @FindBy(css = ".c-button.btn")
    private WebElement NextBtn;
    @FindBy(css = ".e-headline span")
    private WebElement YourFinalScore;

    public TechnologyQuizPage(WebDriver driver) {
        super(driver);

    }

    @Step("To open the technological quiz")
    public void OpenTechnologyQuiz() {
        sleep(1000);
        click(StartBtn);
    }

    @Step("who founded apple computer?")
    public void whoFoundedAppleComputer(String name) {
        List<WebElement> computer = Round1List;
        for (WebElement Round1List : computer) {
            if (getText(Round1List).contains(name)) {
                AllureAttachment.attachElementScreenshot(Round1List);
                actions.click(Round1List).click(NextBtn).build().perform();
                break;
            }
            sleep(2000);
        }
        click(NextBtn);
        sleep(2000);
    }

    @Step("What shortcuts are there in the operating system?")
    public void whatShortcutsTheOperatingSystem(String name) {
        List<WebElement> OS = Round2List;
        for (WebElement Round2List : OS) {
            if (getText(Round2List).contains(name)) {
                AllureAttachment.attachElementScreenshot(Round2List);
                actions.click(Round2List).click(NextBtn).build().perform();
                break;
            }
            sleep(2000);
        }
        click(NextBtn);
        sleep(2000);
    }

    @Step("how many computers languages use?")
    public void howManyComputersLanguagesUse(String number) {
        List<WebElement> LanguagesAreInUse = Round3List;
        for (WebElement Round3List : LanguagesAreInUse) {
            if (getText(Round3List).contains(number)) {
                AllureAttachment.attachElementScreenshot(Round3List);
                actions.click(Round3List).click(NextBtn).build().perform();
                break;
            }
            sleep(2000);
        }
        click(NextBtn);
        sleep(2000);
    }

    @Step("What does the acronym WWW mean?")
    public void whatDoesWWWMean(String name) {
        List<WebElement> Acronyms = Round4List;
        for (WebElement Round4List : Acronyms) {
            if (getText(Round4List).contains(name)) {
                AllureAttachment.attachElementScreenshot(Round4List);
                actions.click(Round4List).click(NextBtn).build().perform();
                break;
            }
            sleep(2000);
        }
        click(NextBtn);
        sleep(2000);
    }

    @Step("where to put the MOV Extension?")
    public void whereToPutTheMOVExtension(String name) {
        List<WebElement> MOV = Round5List;
        for (WebElement Round5List : MOV) {
            if (getText(Round5List).contains(name)) {
                AllureAttachment.attachElementScreenshot(Round5List);
                actions.click(Round5List).click(NextBtn).build().perform();
                break;
            }
            sleep(2000);
        }
        click(NextBtn);
        sleep(2000);
    }

    @Step("answering the questions")
    public void answeringTheQuestions(String inventor, String Shortcut, String number, String Meaning, String Name) {
        whoFoundedAppleComputer(inventor);
        whatShortcutsTheOperatingSystem(Shortcut);
        howManyComputersLanguagesUse(number);
        whatDoesWWWMean(Meaning);
        whereToPutTheMOVExtension(Name);
        sleep(1000);
    }

    @Step("Get title")
    public String getTitle() {
        AllureAttachment.attachElementScreenshot(YourFinalScore);
        return getText(YourFinalScore);

    }
}