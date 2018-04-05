package TestAcres;


import Common.Base;
import org.testng.annotations.Test;

import javax.swing.plaf.basic.BasicEditorPaneUI;

public class TC1 extends Base{

    private String URL="http://flamenipper.33across.com/?__rtcreativeid=138224697000";

    @Test
    public void Test33Across() {
        navigateTo(URL);
        clickByXpath("//div[@class='tynt-close-btn']");

    }


}
