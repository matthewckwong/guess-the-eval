package stockfish.processor;

import stockfish.model.EngineInfo;
import stockfish.model.option.EngineOption;
import stockfish.parser.EngineNameParser;
import stockfish.parser.EngineOptionParser;

import java.util.List;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class EngineInfoProcessor extends UCICommandProcessor<EngineInfo> {

    protected static EngineNameParser engineNameParser = new EngineNameParser();
    protected static EngineOptionParser engineOptionParser = new EngineOptionParser();

    @Override
    public EngineInfo process(List<String> list) {
        final var engineName =
                list.stream()
                        .filter(engineNameParser::matches)
                        .map(engineNameParser::parse)
                        .findFirst()
                        .orElse("<<Unknown>>");
        final var options =
                list.stream()
                        .filter(engineOptionParser::matches)
                        .map(engineOptionParser::parse)
                        .collect(toMap(EngineOption::getName, identity()));
        return new EngineInfo(engineName, options);
    }
}
