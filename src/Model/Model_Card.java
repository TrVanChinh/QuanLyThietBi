
package Model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Card {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String décription) {
        this.description = décription;
    }

    public Model_Card(Icon icon, String title, String values, String description) {
        this.icon = icon;
        this.title = title;
        this.values = values;
        this.description = description;
    }
    
    public Icon toIcon(){
        return new ImageIcon(getClass().getResource("/assets/"+icon +".png"));
    }
    
    public Model_Card() {
    }
    
    private Icon icon;
    private String title;
    private String values;
    private String description;
}
