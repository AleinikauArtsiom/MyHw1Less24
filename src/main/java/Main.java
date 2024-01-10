import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");
       String country = req.getParameter("country");
        PrintWriter writer = resp.getWriter();
        //LocalDateTime lDT = LocalDateTime.now();
        ZoneId targetZone = ZoneId.of(country);
        ZonedDateTime targetDateTime = ZonedDateTime.now(targetZone);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = targetDateTime.format(formatter);

        System.out.println("local date of " + country + formattedDateTime);
        writer.print("Country = " + country + " " + formattedDateTime);
    }
}
/*  Europe/Minsk
    America/New_York
    Europe/London
    Asia/Tokyo
    Australia/Sydney
    Europe/Moscow   */
