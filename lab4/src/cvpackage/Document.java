package cvpackage;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class Document {
    String title;
    Photo photo = new Photo();
    List<Section> sections = new ArrayList<>();

    Document(String documentTitle){
        this.title = documentTitle;

    }

    Document setTitle(String title){
        this.title = title;
        return this;
    }

    Document setPhoto(String photoUrl){
        photo.url = photoUrl;
        return this;
    }

    Section addSection(String sectionTitle){
        Section newSection = new Section(sectionTitle);
        sections.add(newSection);
        return newSection;
    }
    Document addSection(Section s){
       sections.add(s);
       return this;
    }


    void writeHTML(PrintStream out){
        // zapisz niezbędne znaczniki HTML
        // dodaj tytuł i obrazek
        // dla każdej sekcji wywołaj section.writeHTML(out)
        out.print("<html>\n<body>\n");
        photo.writeHTML(out);
        out.printf("<h1>%s</h1>\n", title);

        for (Section section: sections) {
            section.writeHTML(out);
        }

        out.print("</body>\n</html>");

    }


}
