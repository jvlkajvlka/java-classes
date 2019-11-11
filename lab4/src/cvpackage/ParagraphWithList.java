package cvpackage;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ParagraphWithList extends Paragraph {

    UnorderedList lista= new UnorderedList();

    public ParagraphWithList() {
        super();
    }

    public ParagraphWithList setContent(String contentToAdd){
        content = contentToAdd;
        return this;
    }

    ParagraphWithList  addItemToList(String s){
        lista.addItem(new ListItem().content(s));
        return this;
    }

    void writeHTML(PrintStream out){
        super.writeHTML(out);
        lista.writeHTML(out);
    }

}
