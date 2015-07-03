package kr.sadalmelik.springnote.util.parser;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NashornMarkdownParserTest {

    private MarkdownParser markdownParser = new NashornMarkdownParser();

    @Test
    public void testParse() {
        assertThat("<p>Hello <em>world</em></p>", is(markdown("Hello *world*")));
        assertThat("<h1>test</h1>", is(markdown("# test")));
    }

    private Matcher<String> markdown(String markdown) {
        return new TypeSafeMatcher<String>() {
            String parseResult = markdownParser.parse(markdown).trim();

            @Override
            public void describeTo(Description description) {
                description.appendText(parseResult);
            }

            @Override
            protected boolean matchesSafely(String html) {
                return parseResult.equals(html);
            }
        };
    }
}