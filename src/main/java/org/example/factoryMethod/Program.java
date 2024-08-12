package org.example.factoryMethod;

import org.example.templateMethod.LogEntry;
import org.example.templateMethod.LogReader;

public class Program {

    public static String data = """
            У лукоморья дуб зеленый;
            Златая цепь на дубе том:
            И днем и ночью кот ученый
            Всё ходит по цепи кругом;
            Идёт направо - песнь заводит,
            Налево - сказку говорит.""";

    public static void main(String[] args) {

        LogReader logReader = new ConcreteReaderCreator()
                .createLogReader(LogType.Poem, data);
        for (LogEntry log : logReader.readLogEntry()) {
            System.out.println(log.getText());
        }
    }
}
