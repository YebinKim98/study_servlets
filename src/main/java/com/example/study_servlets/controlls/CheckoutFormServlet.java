package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// contorlls/Checkout*Servlet.java
// - form : CheckoutFormServlet.java
// + refer : https://getbootstrap.com/docs/5.3/examples/checkout/
// - CheckoutResponseServlet.java
// + 항목 맞게 표시
// - github와 동작 url 공유

@WebServlet(urlPatterns = "/checkoutFormServlet")
public class CheckoutFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            PrintWriter printWriter = response.getWriter();
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Bootstrap checkout</title>\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css\">\r\n"
                    + //
                    "    <link rel=\"stylesheet\" href=\"../toy_publishings/css/commons.css\">\r\n" + //
                    "</head>  \r\n" + //
                    "<body>\r\n" + //
                    "    <div class=\"container py-5 text-center\">\r\n" + //
                    "        <img  src=\"https://getbootstrap.com/docs/5.2/assets/brand/bootstrap-logo.svg\" alt width=\"75\" height=\"60\" >\r\n"
                    + //
                    "        <h1>Checkout form</h1>\r\n" + //
                    "        <P>Below is an example form built entirely with Bootstrap\u2019s form controls. Each required form group has a \r\n"
                    + //
                    "        validation state that can be triggered by attempting to submit the form without completing it.</P>\r\n"
                    + //
                    "    </div>\r\n" + //
                    "          \r\n" + //
                    "    <div class=\"container pb-5\">\r\n" + //
                    "        <div class=\"row g-5\">\r\n" + //
                    "            <div class=\"col-lg-8\"><!--8,4\uB85C \uB098\uB214-->\r\n" + //
                    "                    <div class=\"fs-3\">Billing address</div>            \r\n" + //
                    "                    <form action=\"checkoutResponseServlet\"> <!-- \uD3FC-->    \r\n" + //  -->  form acion 버튼 누르면 checkoutResponseServlet 로 넘어가게 함
                    "                        <div class=\"m-3 w-75\">\r\n" + //
                    "                            <div class=\"row py-2\">\r\n" + //
                    "                                <div class=\"col-sm-6\"><!--firstname-->\r\n" + //
                    "                                        <label class=\"form-label\" for=\"idfirstname\">First name</label>\r\n"
                    + //
                    "                                        <input class=\"form-control\" type=\"text\" name=\"firstname\" placeholder=\"hyowon\" id=\"idfirstname\"> \r\n"
                    + //
                    "                                </div>\r\n" + //
                    "                                <div class=\"col-sm-6\">\r\n" + //
                    "                                    <label class=\"form-label\" for=\"idlastname\">Last name</label>\r\n"
                    + //
                    "                                    <input class=\"form-control\" type=\"text\"  name=\"lastname\"  placeholder=\"cho\" id=\"idlastname\"> \r\n"
                    + //
                    "                                </div>\r\n" + //
                    "                            </div>\r\n" + //
                    "                            <div class=\"py-2\">\r\n" + //
                    "                                <lable class=\"form-label\" for=\"idusername\">Username</lable>\r\n"
                    + //
                    "                                <input class=\"form-control\" type=\"text\" placeholder=\"Userame\" name=\"username\" id=\"idusername\" >\r\n"
                    + //
                    "                            </div>\r\n" + //
                    "                    \r\n" + //
                    "                            <div class=\"py-2\"><!--\uC774\uBA54\uC77C \uC791\uC131-->\r\n" + //
                    "                                <label class=\"form-label\" for=\"idemail\">Email (Optional)</label>\r\n"
                    + //
                    "                                <input class=\"form-control\" type=\"email\" name=\"emailAddress\" id=\"idemail\" placeholder=\"otter@yojulab.com\"> \r\n"
                    + //
                    "                            </div>\r\n" + //
                    "\r\n" + //
                    "                            <div class=\"py-2\"><!--Address-->\r\n" + //
                    "                                <label class=\"form-label\" for=\"idaddress\">Address</label>\r\n"
                    + //
                    "                                <input class=\"form-control\" type=\"text\" name=\"address\"  value=\"39 sorae\" placeholder=\"1234 Man St\" id=\"idaddress\"> \r\n"
                    + //
                    "                            </div>\r\n" + //
                    "                    \r\n" + //
                    "                            <div class=\"py-2\"><!--Address-->\r\n" + //
                    "                                <label class=\"form-label\" for=\"idaddress2\">Address 2 (Optional) </label>\r\n"
                    + //
                    "                                <input class=\"form-control\" type=\"text\" name=\"address2\"  value=\"000-000\" placeholder=\"Apartment or suite\" id=\"idaddress2\"> \r\n"
                    + //
                    "                            </div>\r\n" + //
                    "\r\n" + //
                    "                            <div class=\"row py-2\">\r\n" + //
                    "                                <div class=\"col-md-5\">\r\n" + //
                    "                                    <div><!--Country select\uB85C \uC120\uD0DD\uD558\uAE30-->\r\n"
                    + //
                    "                                        <label class=\"form-label\" for=\"idcountry\">Country </label> <!--form-select \uBC29\uD5A5\uD0A4\uB098\uC634-->\r\n"
                    + //
                    "                                        <select  class=\"form-select\"  name =\"country\" id=\"idcountry\"> <!--choose\uAC12\uC740 \uB118\uC5B4\uAC00\uC9C0 \uC54A\uAE30 \uC704\uD574\uC11C value \uACF5\uBC31\uC73C\uB85C \uC124\uC815 -->\r\n"
                    + //
                    "                                            <option disabled selected value=\"\">Choose...</option> <!--\uC544\uC608 \uC120\uD0DD\uBABB\uD558\uAC8C disabled \uC120\uD0DD \uBE44\uD65C\uC131\uD654\uD568-->\r\n"
                    + //
                    "                                            <option value=\"France\">France</option>\r\n" + //
                    "                                            <option value=\"Korea\" >Korea</option>\r\n" + //
                    "                                            <option value=\"China\">China</option>\r\n" + //
                    "                                            <option value=\"USA \">USA</option>\r\n" + //
                    "                                            <option value=\"Germany \">Germany</option>\r\n" + //
                    "                                        </select>\r\n" + //
                    "                                    </div>\r\n" + //
                    "                                </div>\r\n" + //
                    "\r\n" + //
                    "                                <div class=\"col-md-4\">\r\n" + //
                    "                                    <div><!--State select\uB85C \uC120\uD0DD\uD558\uAE30-->\r\n" + //
                    "                                        <label class=\"form-label\" for=\"idstate\">State </label>\r\n"
                    + //
                    "                                        <select  class=\"form-select\"  name =\"state\" id=\"idstate\"> \r\n"
                    + //
                    "                                            <option disabled selected value=\"\">Choose...</option>\r\n"
                    + //
                    "                                            <option value=\"gyeonggi-do\">Gyeonggi-do</option>\r\n"
                    + //
                    "                                            <option value=\"chungcheong-do\" >Chungcheong-do</option>\r\n"
                    + //
                    "                                            <option value=\"gangwon-do\">Gangwon-do</option>\r\n" + //
                    "                                        </select>\r\n" + //
                    "            \r\n" + //
                    "                                    </div>\r\n" + //
                    "                                </div>\r\n" + //
                    "\r\n" + //
                    "                                <div class=\"col-md-3\">\r\n" + //
                    "                                    <div><!--zip-->\r\n" + //
                    "                                            <label class=\"form-label\" for=\"zip\">Zip </label>\r\n"
                    + //
                    "                                            <input class=\"form-control\" type=\"text\" name=\"zip \" placeholder=\"123455\" id=\"idzip\"> \r\n"
                    + //
                    "                                    </div>\r\n" + //
                    "                                </div>\r\n" + //
                    "                            </div>\r\n" + //
                    "                        <div>\r\n" + //
                    "                            <button type=\"submit\" class=\"w-75 btn btn-primary\" >Continu to checkout</button>\r\n"
                    + //
                    "                        </div>\r\n" + //
                    "                    </form>\r\n" + //
                    "            </div>\r\n" + //
                    "        </div>\r\n" + //
                    "    </div>\r\n" + //
                    "    \r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
                    + //
                    "</html>";

            printWriter.println(contents);
            printWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage()); // TODO: handle exception
        }

    }
}
