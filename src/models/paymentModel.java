
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class paymentModel extends Database{
private Statement statement;
private PreparedStatement preparedStatement;
private ResultSet resultSet;
private String query;
private final ArrayList<paymentModel> data=new ArrayList();
private int id;
private String amount;
private String date;

    public paymentModel() {
    }

    public paymentModel(int id, String amount, String date) {
        this.id = id;
        this.amount = amount;
        this.date = date;
    }




public void add(String amount){
 id=new Random().nextInt();
 date=new Date().toLocaleString();
 startConnection();
    try {
        query="insert into payment values ('"+id+"','"+amount+"','"+date+"')";
        statement=getConnection().createStatement();
        statement.execute(query);
    } catch (SQLException ex) {
    }
 closeConnection();
}

public ArrayList<paymentModel> selectAll(){
       this.startConnection();
        try {
            query = "select * from payment";
            preparedStatement = getConnection().prepareStatement(this.query);
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {                
                this.id = resultSet.getInt("id");
                this.amount = resultSet.getString("amount");
                this.date = resultSet.getString("date");
                data.add(new paymentModel(this.id,this.amount,this.date));
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

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
    public void clearData(){
        this.data.clear();
    }
}
