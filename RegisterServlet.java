import java.io.IOException;
import java.sql.SQLException;


public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=null;
        String email= request.getParameter("email");
        String password = request.getParameter("pswd");
        String ppassword = request.getParameter("ppswd");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String city = request.getParameter("city");
        int age1=0;
        System.out.println("Email="+email+"\nPassword="+password+"\nName="+name+"Gender="+gender+"\nAge="+age+"\nCity="+city);

        String message = null;
        String resource ="register.jsp";
        boolean flag=false;

        if(age!=null && !age.trim().equals(""))
        {
            age1=Integer.parseInt(age);
        }

        if(!password.equals(ppassword))
        {
            message="Password not matching";
        }
        else if(email==null || email.trim().equals(""))
        {
            message="Enter your Email Id";
        }
        else if(password==null || password.trim().equals(""))
        {
            message="Enter your Password";
        }
        else if(name==null || name.trim().equals(""))
        {
            message="Enter your Name";
        }
        else if(city==null || city.trim().equals(""))
        {
            message="Enter your city";
        }
        else if(gender==null || gender.trim().equals(""))
        {
            message="Enter your Gender";
        }
        else
        {
            user=new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setPpassword(ppassword);
            user.setName(name);
            user.setGender(gender);
            user.setCity(city);
            user.setAge(age1);
            System.out.println("Values are passed");
            try {
                DAO.saveUserData(user);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            flag = true;

        }
        request.setAttribute("message", message);
        RequestDispatcher rd = request.getRequestDispatcher(resource);
        rd.forward(request, response);

    }

}