/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Mail;

/**
 *
 * @author pasan
 */
@WebServlet(name = "Sendmail", urlPatterns = {"/Sendmail"})
public class Sendmail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String recipient = "shopwebtoons@gmail.com";
        String subject = "Invoice for Your Purchase";
        
        // HTML invoice content with embedded CSS
        String htmlContent = "<html>"
                + "<head>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; margin: 20px; padding: 0; }"
                + ".invoice-box { max-width: 800px; margin: auto; padding: 30px; border: 1px solid #eee; box-shadow: 0 0 10px rgba(0, 0, 0, 0.15); }"
                + ".invoice-box table { width: 100%; line-height: 24px; text-align: left; border-collapse: collapse; }"
                + ".invoice-box table td { padding: 5px; vertical-align: top; }"
                + ".invoice-box table tr td:nth-child(2) { text-align: right; }"
                + ".invoice-box table tr.top table td { padding-bottom: 20px; }"
                + ".invoice-box table tr.top table td.title { font-size: 45px; line-height: 45px; color: #333; }"
                + ".invoice-box table tr.information table td { padding-bottom: 40px; }"
                + ".invoice-box table tr.heading td { background: #eee; border-bottom: 1px solid #ddd; font-weight: bold; }"
                + ".invoice-box table tr.details td { padding-bottom: 20px; }"
                + ".invoice-box table tr.item td { border-bottom: 1px solid #eee; }"
                + ".invoice-box table tr.item.last td { border-bottom: none; }"
                + ".invoice-box table tr.total td:nth-child(2) { border-top: 2px solid #eee; font-weight: bold; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<div class='invoice-box'>"
                + "<table>"
                + "<tr class='top'>"
                + "<td colspan='2'>"
                + "<table>"
                + "<tr>"
                + "<td class='title'><h1>Your Company</h1></td>"
                + "<td>Invoice #: 123<br> Created: January 1, 2024<br> Due: January 31, 2024</td>"
                + "</tr>"
                + "</table>"
                + "</td>"
                + "</tr>"
                + "<tr class='information'>"
                + "<td colspan='2'>"
                + "<table>"
                + "<tr>"
                + "<td>Company Name, Inc.<br> 12345 Street Name<br> City, ST 12345</td>"
                + "<td>Customer Name<br> customer@example.com<br> (555) 555-5555</td>"
                + "</tr>"
                + "</table>"
                + "</td>"
                + "</tr>"
                + "<tr class='heading'>"
                + "<td>Payment Method</td>"
                + "<td>Check #</td>"
                + "</tr>"
                + "<tr class='details'>"
                + "<td>Check</td>"
                + "<td>1000</td>"
                + "</tr>"
                + "<tr class='heading'>"
                + "<td>Item</td>"
                + "<td>Price</td>"
                + "</tr>"
                + "<tr class='item'>"
                + "<td>Product 1</td>"
                + "<td>$300.00</td>"
                + "</tr>"
                + "<tr class='item'>"
                + "<td>Product 2</td>"
                + "<td>$150.00</td>"
                + "</tr>"
                + "<tr class='item last'>"
                + "<td>Product 3</td>"
                + "<td>$200.00</td>"
                + "</tr>"
                + "<tr class='total'>"
                + "<td></td>"
                + "<td>Total: $650.00</td>"
                + "</tr>"
                + "</table>"
                + "</div>"
                + "</body>"
                + "</html>";

        // Send email with HTML content
        Mail.sendMail(recipient, subject, htmlContent, true);
    }
}