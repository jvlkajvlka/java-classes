package cvpackage;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ParagraphWithList extends Paragraph {

    List<ListItem> lista= new ArrayList<>();

    public ParagraphWithList setContent(String contentToAdd){
        content = contentToAdd;
        return this;
    }



    ParagraphWithList  addItemToList(String s){
        lista.add(new ListItem().content(s));
        return this;
    }

    void writeHTML(PrintStream out){

    }

}
