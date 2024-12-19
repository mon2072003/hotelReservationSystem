
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class mealPlanModel extends Database{
private Statement statement;
private PreparedStatement preparedStatement;
private ResultSet resultSet;
private String query;
private final ArrayList<mealPlanModel> data=new ArrayList();
private int id;
private String meal;
private String date;
    public mealPlanModel() {
    }

    public mealPlanModel(int id, String meal, String date) {
        this.id = id;
        this.meal = meal;
        this.date = date;
    }


public void add(String meal){
 id=new Random().nextInt();
 date=new Date().toLocaleString();
 startConnection();
    try {
        query="insert into mealplan values ('"+id+"','"+meal+"','"+date+"')";
        statement=getConnection().createStatement();
        statement.execute(query);
    } catch (SQLException ex) {
    }
 closeConnection();
}

public ArrayList<mealPlanModel> selectAll(){
       this.startConnection();
        try {
            query = "select * from mealplan";
            preparedStatement = getConnection().prepareStatement(this.query);
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {                
                this.id = resultSet.getInt("id");
                this.meal = resultSet.getString("meal");
                this.date = resultSet.getString("date");
                data.add(new mealPlanModel(this.id,this.meal,this.date));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException);
        }
       this.closeConnection();
       return data;
}

    public int getId() {
        return id;
    }

    public String getMeal() {
        return meal;
    }

    public String getDate() {
        return date;
    }
    public void clearData(){
        this.data.clear();
    }
}
