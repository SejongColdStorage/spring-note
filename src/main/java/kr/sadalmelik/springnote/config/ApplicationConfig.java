package kr.sadalmelik.springnote.config;

import kr.sadalmelik.springnote.util.parser.MarkdownParser;
import kr.sadalmelik.springnote.util.parser.NashornMarkdownParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//TODO Change name.. ApplicationConfig class is too ambiguous name
@Configuration
public class ApplicationConfig {

    @Bean
    public MarkdownParser markdownParser(){
        return new NashornMarkdownParser();
    }
}
