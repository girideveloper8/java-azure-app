package com.demo.controller;

import com.demo.model.Cast;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("strangerthings/v1/")
public class OhioController {

   /* @GetMapping("/")
    public String  welcome() {

        return "Welcome to the Stranger Things series";

    }*/

    @GetMapping(value = "/", produces = "text/html")
    public ResponseEntity<String> getHtmlContent() {

        String htmlContent = "<html>"
                + "<head>"
                + "<style>"
                + "body {"
                + "    font-family: Arial, sans-serif;"
                + "    text-align: center;" // Center all text within the body
                + "    margin: 0;"
                + "    padding: 0;"
                + "    background-color: #f4f4f4;"
                + "}"
                + "h1 {"
                + "    color: #30a4a2;"
                + "    margin-top: 20px;"
                + "}"
                + "p {"
                + "    color: #333;"
                + "    line-height: 1.6;"
                + "    margin: 20px auto;"
                + "    max-width: 800px;" // Limit the width of the paragraph for better readability
                + "}"
                + "a {"
                + "    text-decoration: none;"
                + "    color: #0066cc;"
                + "}"
                + "a:hover {"
                + "    text-decoration: underline;"
                + "}"
                + "ul {"
                + "    list-style-type: none;" // Remove default list styling
                + "    padding: 0;"
                + "}"
                + "li {"
                + "    margin: 10px 0;"
                + "}"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<h1>Welcome to the Stranger Things Series</h1>"
                + "<p>Stranger Things is a Netflix series that follows a group of teenagers in the 1980s town of Hawkins, Indiana, as they investigate a mysterious portal that opens a gateway to an alternate dimension called the Upside Down. The Upside Down is a hostile reflection of the real world that releases supernatural creatures into Hawkins, including a monstrous humanoid that abducts a boy named Will Byers. The town's residents must work together to solve the mystery, which involves secret experiments, terrifying forces, and a strange little girl named Eleven who has psychokinetic powers.</p>"
                + "<p>For Cast details:</p>"
                + "<ul>"
               // + "<li><a href=\"http://localhost:8080/strangerthings/v1/getCastDetails\">Click here</a></li>"
                + "<li><a href=\"https://java-webapp-btamfkhpgmevcdfu.eastus-01.azurewebsites.net/strangerthings/v1/getCastDetails\">Click here</a></li>"
                + "</ul>"
                + "</body>"
                + "</html>";

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
        htmlBuilder.append("<html>")
                .append("<head><style>")
                   .append("body { text-align: center; font-family: Arial, sans-serif; }")
                   .append("table { margin: 0 auto; border-collapse: collapse; }")
                   .append("th, td { padding: 10px; border: 1px solid #ddd; }")
                   .append("th { background-color: #f4f4f4; }")
                   .append("a { text-decoration: none; color: #0066cc; }")
                   .append("a:hover { text-decoration: underline; }")
                   .append("</style></head>")
                   .append("<body>")
                   //.append("<p><a href=\"http://localhost:8080/strangerthings/v1/\">Home</a></p>")
                  .append("<p><a href=\"https://java-webapp-btamfkhpgmevcdfu.eastus-01.azurewebsites.net/strangerthings/v1/\">Home</a></p>")
                   .append("<h1 style=\"color: #a30667;\">Cast Details</h1>")
                   .append("<table border='1' cellpadding='10' cellspacing='0'>")
                   .append("<thead>")
                   .append("<tr><th>Name</th><th>Character Name</th></tr>")
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
                   .append("</body>")
                   .append("</html>");

        return new ResponseEntity<>(htmlBuilder.toString(), HttpStatus.OK);
}



}
