package kr.sadalmelik.springnote.util.parser;

import org.junit.Test;

import static kr.sadalmelik.springnote.util.parser.MarkdownParserMatcher.parsedMarkdown;
import static org.junit.Assert.assertThat;

public class NashornMarkdownParserTest {

    private MarkdownParser markdownParser = new NashornMarkdownParser();

    @Test
    public void parseTest() {
        assertThat("Hello *world*", parsedMarkdown("<p>Hello <em>world</em></p>"));
        assertThat("# test", parsedMarkdown("<h1>test</h1>"));
        assertThat("# test\n\n- aaa\n- bbb", parsedMarkdown("<h1>test</h1>\n<ul>\n<li>aaa</li>\n<li>bbb</li>\n</ul>"));
    }
}