
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

    public static void saveUserData(User user) throws SQLException {
        Connection connection =null;
        connection = DBConnection.getConnection();
        System.out.println("Database connection");

        PreparedStatement pss = connection.prepareStatement("Insert user values");
        pss.setString(1, user.getEmail());
        pss.setString(2, user.getPassword());
        pss.setString(3, user.getPpassword());
        pss.setString(4, user.getName());
        pss.setString(5, user.getGender());
        pss.setInt(6, user.getAge());
        pss.setString(7, user.getCity());

        pss.executeUpdate();
        System.out.println("Data inserted");
    }

    public static User getUser(String email) throws SQLException {
        Connection connection =null;
        connection = DBConnection.getConnection();
        User user=null;
        ResultSet rs=null;
        PreparedStatement pss = connection.prepareStatement("Select");
        pss.setString(1, email);
        rs= pss.executeQuery();
        while(rs.next())
        {
            user=new User();
            user.setEmail(rs.getString(1));
            user.setPassword(rs.getString(2));
            user.setPpassword(rs.getString(3));
            user.setName(rs.getString(4));
            user.setGender(rs.getString(5));
            user.setAge(rs.getInt(6));
            user.setCity(rs.getString(7));
        }

        return user;
    }

    public static void saveTheme(Theme theme) throws SQLException, ThemeException {
        Connection connection =null;
        PreparedStatement pss =null;
        int rows=0;
        connection = DBConnection.getConnection();
        pss = connection.prepareStatement("Insert into Theme values(?,?,?,?)");
        pss.setString(1, theme.getUserid());
        pss.setString(2, theme.getThemename());
        pss.setString(3, theme.getComment());
        pss.setTimestamp(4, new java.sql.Timestamp(theme.getDate().getTime()));
        rows= pss.executeUpdate();

        if(rows==-1)
        {
            throw new ThemeException();
        }

    }

    public static ArrayList<Theme> getThemes(String userid) throws SQLException {
        Connection connection =null;
        Theme theme=null;
        connection =DBConnection.getConnection();
        User user=null;
        ResultSet rs=null;
        ArrayList<Theme> topics = new ArrayList<Theme>();
        PreparedStatement pss = connection.prepareStatement("Select * from topic where userid=?");
        pss.setString(1, userid);
        rs= pss.executeQuery();
        while(rs.next())
        {
            Theme=new Theme();
            Theme.setThemeid(rs.getInt(1));
            Theme.setUserid(rs.getString(2));
            Theme.setThemename(rs.getString(3));
            Theme.setComment(rs.getString(4));
            Theme.setDate(rs.getTimestamp(5));
            Themes.add(Theme);
        }

        return Themes;
    }

    public static Theme getTheme(int userid) throws SQLException {
        Connection connection =null;
        Theme topic=null;
        connection =DBConnection.getConnection();
        User user=null;
        ResultSet rs=null;
        PreparedStatement pss = connection.prepareStatement("Select ");
        pss.setInt(1, userid);
        rs= pss.executeQuery();
        while(rs.next())
        {
            topic = new Theme();
            topic.setThemeid(rs.getInt(1));
            topic.setUserid(rs.getString(2));
            topic.setThemename(rs.getString(3));
            topic.setComment(rs.getString(4));
            topic.setDate(rs.getTimestamp(5));


        }


        return Theme;
    }

    public static void updateTheme(int id, String comment) throws SQLException, ThemeException {
        Connection connection =null;
        PreparedStatement pss =null;
        int rows=0;
        connection = DBConnection.getConnection();
        pss = connection.prepareStatement("Update Theme");
        pss.setString(1,comment);
        pss.setInt(2, id);


        rows= pss.executeUpdate();

        if(rows==-1)
        {
            throw new ThemeException();
        }



    }

    public static ArrayList<Theme> listTheme() throws SQLException {
        Connection connection =null;
        Theme theme =null;
        connection =DBConnection.getConnection();
        User user=null;
        ResultSet rs=null;
        ArrayList<Theme> topics = new ArrayList<Theme>();
        PreparedStatement pss = connection.prepareStatement("Select ");

        rs= pss.executeQuery();
        while(rs.next())
        {
            Theme=new Theme();
            Theme.setThemeid(rs.getInt(1));
            Theme.setUserid(rs.getString(2));
            Theme.setThemename(rs.getString(3));
            Theme.setComment(rs.getString(4));
            theme.setDate(rs.getTimestamp(5));
            topics.add(theme);
        }

        return Theme;

    }

    public static ArrayList<Theme> searchTheme(String key) throws SQLException {
        Connection connection =null;
        Theme theme =null;
        connection =DBConnection.getConnection();
        User user=null;
        ResultSet rs=null;
        ArrayList<Theme> themes = new ArrayList<Theme>();
        String query ="select * Theme '%" + key + "%'";

        java.sql.Statement pss = connection.createStatement();

        rs= pss.executeQuery(query);

        while(rs.next())
        {
            Theme=new Theme();
            Theme.setThemeid(rs.getInt(1));
            Theme.setUserid(rs.getString(2));
            Theme.setThemename(rs.getString(3));
            Theme.setComment(rs.getString(4));
            Theme.setDate(rs.getTimestamp(5));
            themes.add(theme);
        }

        for(Theme theme1: themes)
        {
            System.out.println(theme.getThemename());
        }
        return themes;



    }

}
