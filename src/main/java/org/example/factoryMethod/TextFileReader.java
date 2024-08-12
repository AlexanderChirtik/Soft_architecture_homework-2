package org.example.factoryMethod;

import org.example.templateMethod.LogEntry;
import org.example.templateMethod.LogReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileReader extends LogReader {

    private String data;

    public TextFileReader() {
    }

    public TextFileReader(String data) {
        this.data = data;
    }

    @Override
    public Object getDataSource() {
        return data;
    }

    @Override
    public void setDataSource(Object data) {
        this.data = data.toString();
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        Scanner scanner = new Scanner(data);
        List<String> logList = new ArrayList<>();
        int counter = 0;
        while (scanner.hasNextLine()) {
            counter++;
            if (counter >= position) {
                position = counter;
                String line = scanner.nextLine();
                logList.add(line);
            }
            else {
                scanner.nextLine();
            }
        }
        return logList;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }
}
