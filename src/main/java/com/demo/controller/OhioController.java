package com.demo.controller;

import com.demo.model.Cast;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/strangerthings/v1/")
public class OhioController {

   /* @GetMapping("/")
    public String  welcome() {

        return "Welcome to the Stranger Things series";

    }*/

    @GetMapping(value = "/getHtmlContent", produces = "text/html")
    public ResponseEntity<String> getHtmlContent() {
        // Properly format and concatenate HTML content
        String htmlContent = "<html><body>" +
                "<h1>Welcome to the Stranger Things Series</h1>" +
                "<ul>" + // Adding <ul> tag to properly structure the list
                "<li><a href=\"https://java-webapp-btamfkhpgmevcdfu.eastus-01.azurewebsites.net/strangerthings/v1/getCastDetails\">Click here</a></li>" +
                "</ul>" + // Closing <ul> tag
                "<p>For Cast details, click the link above.</p>" +
                "</body></html>";

        // Return the HTML content with OK status
        return new ResponseEntity<>(htmlContent, HttpStatus.OK);
    }



    @GetMapping("/getCastDetails")
    public ResponseEntity<String> getCastDetailsHtml() {
        List<Cast> list = List.of(
                new Cast("Millie Bobby Brown", "Eleven"),
                new Cast("Finn Wolfhard", "Mike Wheeler"), // Corrected typo
                new Cast("Natalia Dyer", "Nancy"),
                new Cast("David Harbour", "Jim Hopper"),
                new Cast("Winona Ryder", "Joyce Byers"),
                new Cast("Cara Buono", "Karen Wheeler"),
                new Cast("Matthew Modine", "Dr. Martin Brenner"),
                new Cast("Sean Astin", "Bob Newby"),
                new Cast("Paul Reiser", "Dr. Owens"),
                new Cast("Aimee Mullins", "Heather Holloway")
        );

        // Build HTML table
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html><body>")
                .append("<h1>Cast Details</h1>")
                .append("<table border='1' cellpadding='10' cellspacing='0'>")
                .append("<thead>")
                .append("<tr><th>Name</th><th>Character</th></tr>")
                .append("</thead>")
                .append("<tbody>");

        for (Cast cast : list) {
            htmlBuilder.append("<tr>")
                    .append("<td>").append(cast.getName()).append("</td>")
                    .append("<td>").append(cast.getCharacterName()).append("</td>")
                    .append("</tr>");
        }

        htmlBuilder.append("</tbody>")
                .append("</table>")
                .append("</body></html>");

        return new ResponseEntity<>(htmlBuilder.toString(), HttpStatus.OK);
    }


}
