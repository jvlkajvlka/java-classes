package cvpackage;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class UnorderedList {
    List<ListItem> ListItems = new ArrayList<>() ;

    UnorderedList addItem(ListItem listitem){
        ListItems.add(listitem);
        return this;
    }



    void writeHTML(PrintStream out){

    }
}
