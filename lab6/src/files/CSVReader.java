package files;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader {
    BufferedReader reader;
    String delimiter;
    boolean hasHeader;

    // nazwy kolumn w takiej kolejności, jak w pliku
    List<String> columnLabels = new ArrayList<>();
    // odwzorowanie: nazwa kolumny -> numer kolumny
    Map<String,Integer> columnLabelsToInt = new HashMap<>();

    /**
     *
     * @param filename - nazwa pliku
     * @param delimiter - separator pól
     * @param hasHeader - czy plik ma wiersz nagłówkowy
     */
    public CSVReader(String filename,String delimiter,boolean hasHeader) throws IOException {
        this(new BufferedReader(new FileReader(filename)),delimiter,hasHeader);
    }

    public CSVReader(Reader reader, String delimiter, boolean hasHeader) throws IOException {
        this.reader = (BufferedReader) reader;
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
        if(hasHeader)parseHeader();
    }

    public CSVReader(String filename, String delimiter) throws IOException {

        this(filename,delimiter, false);
    }

    public CSVReader(String filename) throws IOException {
       this(filename, "" );

   }

    void parseHeader() throws IOException {
        // wczytaj wiersz
        String line  = null;
        line = reader.readLine();

        if(line==null){
            return;
        }
        // podziel na pola
        String[]header = line.split(delimiter);
        // przetwarzaj dane w wierszu
        for(int i=0;i<header.length;i++){
            // dodaj nazwy kolumn do columnLabels i numery do columnLabelsToInt
            columnLabels.add(header[i]);
            columnLabelsToInt.put(header[i],i);
        }
    }

    String[]current;

    boolean next() throws IOException {
        // czyta następny wiersz, dzieli na elementy i przypisuje do current
        //
        String line  = null;
        line = reader.readLine();

        if(line==null){
            return false;
        }
        // podziel na pola
        current = line.split(delimiter);
        return true;

    }

    List<String> getColumnLabels(){
        return columnLabels;
    }

    int getRecordLength(){
        return current.length;
    }

    boolean isMissing(int columnIndex){
        
    }
}
