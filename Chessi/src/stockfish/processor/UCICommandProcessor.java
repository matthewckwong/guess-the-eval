package stockfish.processor;

import java.util.List;

public abstract class UCICommandProcessor<T> {
    public abstract T process(List<String> list);
}
