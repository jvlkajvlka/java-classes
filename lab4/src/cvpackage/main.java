package cvpackage;

public class main {
    public static void main(String []args){
        Document cv = new Document("Jana Kowalski - CV");
        cv.setPhoto("...");
        cv.addSection("Wykształcenie")
                .addParagraph("2000-2005 Przedszkole im. Królewny Snieżki w ...")
                .addParagraph("2006-2012 SP7 im Ronalda Regana w ...")
                .addParagraph("...");
        cv.addSection("Umiejętności")
                .addParagraph(
                        new ParagraphWithList().setContent("Umiejętności")
                                .addItemToList("C")
                                .addItemToList("C++")
                                .addItemToList("Java")
                );

    }

}
