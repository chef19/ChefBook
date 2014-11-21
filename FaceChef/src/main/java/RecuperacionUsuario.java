import java.io.IOException;
import java.io.PrintWriter;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecuperacionUsuario
 */
@WebServlet("/RecuperacionUsuario")
@Named (value="Recuperacion")
@RequestScoped
public class RecuperacionUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperacionUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
         PrintWriter out = response.getWriter();
         Texto h = new Texto();

         out.println("<html>");
         out.println("<head></head>");         
         out.println("<body>");

         out.println("Usuario:");
         String usu=request.getParameter("usuario");
         
         out.println(usu);
         out.println("<br>");
         out.println("Clave:");         
         String cla=request.getParameter("clave");
         out.println(cla);
         h.guardar(request.getParameter(""));

         
         out.println("</body>");
         out.println("</html>");           
    }

}