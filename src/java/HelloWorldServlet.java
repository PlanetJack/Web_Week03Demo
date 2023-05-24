import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kihyun Kim
 */

public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/hellowWorldForm.jsp")
                .forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        


        // if firstName is null --> not exist
        // or firstName is empty
        // or IastName is null
        // or IastName is empty
        if(firstName == null || firstName.equals("") || lastName.equals("")){
            getServletContext().getRequestDispatcher("/WEB-INF/helloWorldForm.jsp")
                    .forward(request, response);
            
            return; // stop here and do not continue
        }
        
        
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        
        getServletContext().getRequestDispatcher("/WEB-INF/sayHello.jsp")
                .forward(request, response);
        
        
    }

 

}
