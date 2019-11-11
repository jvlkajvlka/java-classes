package cvpackage;

import java.io.PrintStream;

public class Paragraph {
    String content;

    public Paragraph setContent(String contentToAdd){
        content = contentToAdd;
        return this;
    }

    void writeHTML(PrintStream out){
        out.printf("<p>%s</p>\n", content);
    }


}
