import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDao{

    Connection con;

    @Override
    public void createEmployee(Employee emp) {
       con = DBConnection.createDBConnection();
       String query = "insert into employee values(?,?,?,?)";
       try{
           PreparedStatement pstm = con.prepareStatement(query);
           pstm.setInt(1, emp.getId());
           pstm.setString(2, emp.getName());
           pstm.setDouble(3, emp.getSalary());
           pstm.setInt(4, emp.getAge());
           int cnt = pstm.executeUpdate();
           if(cnt != 0){
               System.out.println("Employee has been created");
           }
       }catch (Exception e) {
           e.printStackTrace();
       }

    }

    @Override
    public void showAllEmployee() {

        con = DBConnection.createDBConnection();
        String query = "select * from employee";

        try{
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            if(resultSet == null){
                System.out.println("No records found");
            }else{
                System.out.format("%s\t\t\t%s\t%s\t\t%s\n",
                        "ID", "Name", "Salary", "Age");
                System.out.println("-----------------------------------");
                while(resultSet.next()){
                    System.out.format("%d\t%s\t%.2f\t%d\n",
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getDouble(3),
                            resultSet.getInt(4));
                }
                System.out.println("-----------------------------------");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showEmployee(int id) {
        con = DBConnection.createDBConnection();
        String query = "select * from employee where id="+id;
        try{
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            System.out.format("%s\t\t\t%s\t%s\t\t%s\n",
                    "ID", "Name", "Salary", "Age");
            System.out.println("-----------------------------------");
            while(resultSet.next()){
                System.out.format("%d\t%s\t%.2f\t%d\n",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4));
            }

        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DBConnection.createDBConnection();
        String query = "update employee set name=? where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, name);
            pstm.setInt(2, id);
            int count = pstm.executeUpdate();
            if(count != 0){
                System.out.println("Employee has been updated");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteEmployee(int id) {
        con = DBConnection.createDBConnection();
        String query = "delete from employee where id=?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            int cnt = pstm.executeUpdate();
            if(cnt != 0){
                System.out.println("Employee has been deleted");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
