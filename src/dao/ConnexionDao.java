/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import bean.ConnexionEmp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DaoEngigne;

/**
 *
 * @author Faissal
 */
public class ConnexionDao extends AbstractDao<ConnexionEmp> {
    public ConnexionDao() {
        super(ConnexionEmp.class);
    }
 
//    public ConnexionEmp findByEmployeId(Long idEmploye) throws Exception{
//           return loadOne("SELECT * FROM 'employeconnexion' WHERE employe='"+idEmploye+"'");
//       }
//    public static ConnexionEmp findById(long id) throws Exception {
//        ConnexionEmp bovin = new ConnexionEmp();
//        String sql = "select * from connexionemp where id=?";
//        ConnectDB connectDB = new ConnectDB();
//        try (Connection connection = connectDB.getConn()) {
//            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
//            preparedStatement.setLong(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                bovin.setId(resultSet.getLong(1));
//                bovin.setLogin(resultSet.getString(2));
//                bovin.setPrevilege(resultSet.getString(3));
//                bovin.setRole(resultSet.getString(4));
//                bovin.setConnected(resultSet.getBoolean(5));
//                bovin.setPassword(resultSet.getString(6));
//                bovin.setTentative(resultSet.getInt(7));
//                bovin.setChangementPassword(resultSet.getString(8));
//                bovin.setBlocked(resultSet.getBoolean(9));
//                //bovin.setEmploye(resultSet.getInt(9));
//                
//            } else {
//                return null;
//            }
//        }
//        return bovin;
//    }
}
