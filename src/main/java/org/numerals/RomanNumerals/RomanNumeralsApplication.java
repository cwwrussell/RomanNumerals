package org.numerals.RomanNumerals;

import org.numerals.RomanNumerals.service.RomanNumeralConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class RomanNumeralsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RomanNumeralsApplication.class, args);
    }

    @GetMapping("/romannumeral")
    public Map<String, String> romanNumeral(@RequestParam(required = true, value = "query") int query) {
        Map<String, String> response = new HashMap<String, String>();
        response.put("input", query + "");
        response.put("output", RomanNumeralConverter.intToRomanNumeral(query));
        return response;
    }

    /**
     * handle requests to unimplemented/unknown apis
     *
     * @return - 404 error
     */
    @RequestMapping("/**")
    public ResponseEntity<Map<String, Object>> unknownRequest() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(Map.of(
                "error", "Endpoint not found",
                "status", 404
            ));
    }
}
