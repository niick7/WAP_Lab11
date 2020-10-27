import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/calc2", "/"})
public class Calculator2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<form action='calc2' method='post'>");

        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String num3 = req.getParameter("num3");
        String num4 = req.getParameter("num4");

        if(!num1.equals("") && !num2.equals("")) {
            Integer sum = Integer.parseInt(num1) + Integer.parseInt(num2);
            out.println("<p>" +
                    "<input type='number' value='" + num1 + "' name='number1'> + " +
                    "<input type='number' value='" + num2 + "' name='number2'> = " +
                    "<input type='number' value='" + sum + "' name='sum' disabled></p>");
        } else {
            out.println("<p><input type='number' name='number1'> + <input type='number' name='number2'> = <input type='number' name='sum' disabled></p>");
        }

        if(!num3.equals("") && !num4.equals("")) {
            Integer product = Integer.parseInt(num3) * Integer.parseInt(num4);
            out.println("<p>" +
                    "<input type='number' value='" + num3 + "' name='number3'> + " +
                    "<input type='number' value='" + num4 + "' name='number4'> = " +
                    "<input type='number' value='" + product + "' name='product' disabled></p>");
        } else {
            out.println("<p><input type='number' name='number3'> + <input type='number' name='number4'> = <input type='number' name='product' disabled></p>");
        }
        out.println("<p><input type='submit'></p>");
        out.println("</form>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
