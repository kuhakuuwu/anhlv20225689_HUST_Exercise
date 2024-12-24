/**
 * 
 */
/**
 * 
 */
module AimsProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires java.desktop;
	requires javafx.graphics;
	requires javafx.base;  
    
    exports hust.soict.dsai.aims.screen;
    opens hust.soict.dsai.aims.screen to javafx.fxml;
    opens hust.soict.dsai.aims.media to javafx.base; 

}
