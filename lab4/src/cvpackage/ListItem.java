package cvpackage;

import java.io.PrintStream;

public class ListItem {

    String item;


    ListItem content(String nameofItem){
        this.item = nameofItem;
        return this;
    }
    void writeHTML(PrintStream out) {
        out.printf("\t<li>%s</li>\n", item);
    }
}
