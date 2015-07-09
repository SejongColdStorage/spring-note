package kr.sadalmelik.springnote.util.parser;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class MarkdownParserMatcher {
    private static MarkdownParser markdownParser = new NashornMarkdownParser();

    public static Matcher<String> parsedMarkdown(String html) {
        return new TypeSafeMatcher<String>() {
            @Override
            public void describeTo(Description description) {
                description.appendText(html);
            }

            @Override
            protected void describeMismatchSafely(String item, Description mismatchDescription) {
                mismatchDescription.appendText("was " + markdownParser.parse(item).trim());
            }

            @Override
            protected boolean matchesSafely(String markdown) {
                String parseResult = markdownParser.parse(markdown).trim();
                return parseResult.equals(html);
            }
        };
    }
}
