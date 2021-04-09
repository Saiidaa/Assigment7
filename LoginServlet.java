import java.io.IOException;
import java.sql.SQLException;


public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String message=null;
        String resource ="Login.jsp";
        boolean validLogin=false;
        User user=null;

        String email=request.getParameter("email");
        String pswd= request.getParameter("password");

        if(email==null || email.trim().equals(""))
        {
            message="Please Enter Your Email Id";
        }
        else if(pswd==null || pswd.trim().equals(""))
        {
            message="Please Enter Your Password";

        }
        else
        {
            try {
                user = DAO.getUser(email);
                System.out.println("Got User Object");
                if(user!=null)
                {
                    if(pswd.equals(user.getPassword()))
                    {

                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        resource="Menu.jsp";
                        validLogin=true;
                        message="Login Success";
                        request.setAttribute("message", message);

                    }

                    else
                        message="Invalid Login Details";
                }
            }catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(!validLogin)
        {
            request.setAttribute("message", message);

        }
        RequestDispatcher rd = request.getRequestDispatcher(resource);
        rd.forward(request, response);
    }

}