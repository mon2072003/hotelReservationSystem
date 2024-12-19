
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class currencyModel extends Database{
private Statement statement;
private PreparedStatement preparedStatement;
private ResultSet resultSet;
private String query;
private final ArrayList<currencyModel> data=new ArrayList();
private String euro;
private String usd;
private String date;

    public currencyModel() {
    }

    public currencyModel( String euro, String usd, String date) {
        this.euro = euro;
        this.usd = usd;
        this.date = date;
    }

    
public void add(String euro,String usd){
 date=new Date().toLocaleString();
 startConnection();
    try {
        query="insert into currency values ('"+euro+"','"+usd+"','"+date+"')";
        statement=getConnection().createStatement();
        statement.execute(query);
    } catch (SQLException ex) {
    }
 closeConnection();
}

public ArrayList<currencyModel> selectAll(){
       this.startConnection();
        try {
            query = "select * from currency";
            preparedStatement = getConnection().prepareStatement(this.query);
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {                
                this.euro = resultSet.getString("euro");
                this.usd = resultSet.getString("usd");
                this.date = resultSet.getString("date");
                data.add(new currencyModel(this.euro,this.usd,this.date));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException);
        }
       this.closeConnection();
       return data;
}

    public String getEuro() {
        return euro;
    }

    public String getUsd() {
        return usd;
    }

    public String getDate() {
        return date;
    }
    public void clearData(){
        this.data.clear();
    }
}
