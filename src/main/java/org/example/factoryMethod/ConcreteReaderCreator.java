package org.example.factoryMethod;

import org.example.templateMethod.LogReader;
import org.example.templateMethod.PoemReader;

public class ConcreteReaderCreator extends BaseLogReaderCreator{
    @Override
    protected LogReader createLogReaderInstance(LogType logType) {
        return switch (logType){
            case Poem -> new PoemReader();
            case Text -> new TextFileReader();
            case Database -> new DatabaseReader();
        };
    }
}
