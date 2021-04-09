import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class AddThemeServlet extends HttpServlet {

    public AddThemeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=null;
        String message=null;
        HttpSession session = request.getSession();
        user=(User)session.getAttribute("user");
        if(user!=null)
        {
            RequestDispatcher rd = request.getRequestDispatcher();
            rd.forward(request, response);
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher();
            rd.forward(request, response);
        }


    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        Topic topic=null;
        String message=null;
        HttpSession session=request.getSession();
        user=(User)session.getAttribute("user");

        if(user==null)
        {

            RequestDispatcher rd = request.getRequestDispatcher();
            rd.forward(request, response);
        }
        else
        {

            String userid = user.getEmail();
            String themename =request.getParameter("theme");
            String comment=request.getParameter("Comment");
            if(themename ==null || themename.trim().equals(""))
            {
                message=" Name cannot  Blank";

            }
            else if(comment==null || comment.trim().equals(""))
            {
                message=" Enter comment";
                System.out.println(message);
            }
            else
            {
                ArrayList<Theme> themes = new ArrayList<Theme>();
                theme=new Theme();
                theme.setUserid(userid);
                theme.setTopicname(themename);
                theme.setComment(comment);
                theme.setDate(new Date());

                try {
                    DAO.saveTheme(theme);
                    System.out.println("Saved");

                } catch (SQLException | ThemeException e) {
                    e.printStackTrace();
                }
                try {
                    themes = DAO.getThemes(userid);
                    request.setAttribute("themes", themes);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                RequestDispatcher rd=request.getRequestDispatcher();
                rd.forward(request, response);

            }



        }
    }

    private class RequestDispatcher {
        public void forward(HttpServletRequest request, HttpServletResponse response) {
        }
    }
}