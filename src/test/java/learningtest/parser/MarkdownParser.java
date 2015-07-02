package learningtest.parser;


import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class MarkdownParser {

    static ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    static{
        try {
            engine.eval(new InputStreamReader(MarkdownParser.class.getClass().getResourceAsStream("/commonmark/commonmark.js")));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void simpleMarkdownParser() throws ScriptException, FileNotFoundException {
        engine.eval(new InputStreamReader(this.getClass().getResourceAsStream("/commonmark/commonmarkparser.js")));
        engine.eval(new InputStreamReader(this.getClass().getResourceAsStream("/commonmark/commonmarkparser.js")));
        engine.eval(new InputStreamReader(this.getClass().getResourceAsStream("/commonmark/commonmarkparser.js")));
        engine.eval(new InputStreamReader(this.getClass().getResourceAsStream("/commonmark/commonmarkparser.js")));
        engine.eval(new InputStreamReader(this.getClass().getResourceAsStream("/commonmark/commonmarkparser.js")));
    }
}
