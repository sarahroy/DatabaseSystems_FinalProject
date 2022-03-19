package sample;
import java.sql.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Statement s = null;
        Connection c = null;
        try
        {
            // db parameters
            String url = "jdbc:sqlite:C:/db/University.db";
            // create a connection to the database
            c = DriverManager.getConnection(url);
            //System.out.println("Connection to SQLite has been established.");

            s = c.createStatement();
            Scanner myObj = new Scanner(System.in);
            System.out.println("\nWelcome to the Trent University Database\n");
            System.out.println("1. What is the percentage in PHYS 1001H at Trent? \n" +
                    "2. Who is the Head of Department of the History Department?\n" +
                    "3. Which students attending Trent University don’t live in Peterborough?\n" +
                    "4. Who are freshmen students in the year 2018? \n" +
                    "5. Which are the half-credit courses in the Computer Science Department?\n" +
                    "6. What are the Chemistry courses taught in the university? \n" +
                    "7. What are the names of all professors in alphabetical order?\n" +
                    "8. What are the courses that commenced before 2005?\n" +
                    "9. What is the percentage of each course in the Business Administration Department?\n" +
                    "10. Display students born after the year 2000?\n Enter your option: ");
            String option = myObj.next();  // get user input
            if (option.equals("1")) {
                try {
                    String sql = "Select CourseId, Department, Percentage from Course WHERE Department = 'Physics' AND CourseId = 1001";
                    ResultSet rs = s.executeQuery(sql);
                    while (rs.next())
                    {
                        Integer CourseID = rs.getInt("CourseID");
                        String Department = rs.getString("Department");
                        Double Percentage = rs.getDouble("Percentage");
                        System.out.println(CourseID + " "+Department+"\t Percentage: "+ Percentage+ "%\n");
                    }
                    s.executeUpdate(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
            } else if (option.equals("2")) {
                try {
                    String sql = "Select DepartmentHead,DepartmentName from Department WHERE DepartmentName = 'History'";
                    ResultSet rs = s.executeQuery(sql);
                    while (rs.next())
                    {
                        String DepartmentHead = rs.getString("DepartmentHead");
                        String DepartmentName = rs.getString("DepartmentName");
                        System.out.println(DepartmentHead + " is the Head of Department of "+ DepartmentName +"\n");
                    }
                    s.executeUpdate(sql);

                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
            } else if (option.equals("3")) {
                try {
                    String sql = "Select StudentName,StudentCity from Student WHERE StudentCity NOT LIKE '%Peterborough%'";
                    ResultSet rs = s.executeQuery(sql);
                    while (rs.next())
                    {
                        String StudentName = rs.getString("StudentName");
                        String StudentCity = rs.getString("StudentCity");
                        System.out.println(StudentName +" lives in: "+StudentCity+",ON\n");
                    }
                    s.executeUpdate(sql);

                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
            } else if (option.equals("4")) {
                try {
                    String sql = "Select StudentName,CatalogYear from Student WHERE CatalogYear = '2018'";
                    ResultSet rs = s.executeQuery(sql);
                    while (rs.next())
                    {
                        Integer CatalogYear = rs.getInt("CatalogYear");
                        String StudentName = rs.getString("StudentName");
                        System.out.println(StudentName+" joined the university in "+CatalogYear+"\n");
                    }
                    s.executeUpdate(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }

            } else if (option.equals("5")) {
                try {
                    String sql = "Select CourseId,CourseName,Department,Credits from Course WHERE Department = 'Computer Science' AND Credits = 0.5";
                    ResultSet rs = s.executeQuery(sql);
                    while (rs.next())
                    {
                        Integer CourseId = rs.getInt("CourseId");
                        String CourseName = rs.getString("CourseName");
                        String Department = rs.getString("Department");
                        Double Credits = rs.getDouble("Credits");
                        System.out.println(CourseId+"\t"+CourseName+"\t"+Department+"\t"+Credits+" credits\n");
                    }
                    s.executeUpdate(sql);

                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
            } else if (option.equals("6")) {
                try {
                    String sql = "Select CourseId,CourseName,Department from Course WHERE Department = 'Chemistry'";
                    ResultSet rs = s.executeQuery(sql);
                    while (rs.next())
                    {
                        Integer CourseId = rs.getInt("CourseId");
                        String CourseName = rs.getString("CourseName");
                        String Department = rs.getString("Department");
                        System.out.println(CourseId+"\t"+CourseName +"\t"+Department+"\n");
                    }
                    s.executeUpdate(sql);

                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
            } else if (option.equals("7")) {
                try {
                    String sql = "SELECT ProfessorName FROM Professor ORDER BY ProfessorName";
                    ResultSet rs = s.executeQuery(sql);
                    while (rs.next())
                    {
                        String ProfessorName = rs.getString("ProfessorName");
                        System.out.println(ProfessorName+"\n");
                    }
                    s.executeUpdate(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
                //System.out.println("Records updated successfully.");
            } else if (option.equals("8")) {
                try {
                    String sql = "Select CourseId,CourseName,Year from Course WHERE Year< 2005";
                    ResultSet rs = s.executeQuery(sql);
                    while (rs.next())
                    {
                        Integer CourseId = rs.getInt("CourseId");
                        String CourseName = rs.getString("CourseName");
                        String Year = rs.getString("Year");
                        System.out.println(CourseId +" "+CourseName+",\tCommenced in the year: "+Year+"\n");
                    }
                    s.executeUpdate(sql);

                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
            } else if (option.equals("9")) {
                try {
                    String sql = "Select CourseId, CourseName,Department,Percentage from Course WHERE Department='Business Administration'";
                    ResultSet rs = s.executeQuery(sql);
                    while (rs.next())
                    {
                       Double Percentage = rs.getDouble("Percentage");
                       Integer CourseId= rs.getInt("CourseId");
                       String CourseName =rs.getString("CourseName");
                       String Department =rs.getString("Department");
                        System.out.println(CourseId+" "+CourseName+",\t"+Department+",\tPercentage: "+Percentage +"%\n");
                    }
                    s.executeUpdate(sql);

                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
            } else if (option.equals("10")) {
                try {
                    String sql = "Select StudentName,DateOfBirth from Student WHERE DateOfBirth > '2000-01-01'";
                    ResultSet rs = s.executeQuery(sql);
                    while (rs.next())
                    {
                        String StudentName = rs.getString("StudentName");
                        String DateOfBirth = rs.getString("DateOfBirth");
                        System.out.println(StudentName+"\t Date of Birth: " +DateOfBirth+"\n");
                    }
                    s.executeUpdate(sql);

                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
            }
            else {
                System.out.println("INVALID OPTION!!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
