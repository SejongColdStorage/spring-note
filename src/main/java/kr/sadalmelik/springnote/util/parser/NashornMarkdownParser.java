package kr.sadalmelik.springnote.util.parser;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStreamReader;

public class NashornMarkdownParser implements MarkdownParser {
    private static final String COMMON_MARK_JS_PATH = "/commonmark/commonmark.js";
    private final ScriptEngine parserEngine;

    public NashornMarkdownParser() {
        try {
            parserEngine = new ScriptEngineManager().getEngineByName("nashorn");
            parserEngine.eval(new InputStreamReader(MarkdownParser.class.getClass().getResourceAsStream(COMMON_MARK_JS_PATH)));
            parserEngine.eval("var reader = new commonmark.Parser(); var writer = new commonmark.HtmlRenderer();");
        } catch (ScriptException e) {
            throw new IllegalStateException("Cannot init markdown parser engine", e);
        }
    }

    @Override
    public synchronized String parse(String markdown) {
        String parsedHtml;
        try {
            parserEngine.eval(new InputStreamReader(this.getClass().getResourceAsStream("/commonmark/commonmark.js")));
            parserEngine.eval("var parsed = reader.parse(\"" + markdown + "\")");
            parsedHtml = (String) parserEngine.eval("writer.render(parsed);");
        } catch (ScriptException e) {
            throw new IllegalStateException("Error while parsing markdown", e);
        }

        return parsedHtml;
    }
}
