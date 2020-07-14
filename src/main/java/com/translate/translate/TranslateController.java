package com.translate.translate;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslateController {

	Translate translate = new Translate();
	
    @RequestMapping(value = "/{word}", method = RequestMethod.GET)
    public List<String> translateWord(@PathVariable String word) {
        return translate.translateWord(word);
    }
}