/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package julianasoares;

import java.sql.*;

public class JulianaSoares {

    String url = "jdbc:mysql://localhost/sakila";
    String usr = "root";
    String pwd = "1234";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        Connection con = null;

        try {
            con = new ConnectionFactory().getConnection();
            System.out.println("Connection OK!");

            // ********** CRUD ********** 
            String sql = "insert into customer (store_id, first_name, last_name, email, address_id, active)"
                    + " values (?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt( 1, 1 );
            pst.setString( 2, "Charles" );
            pst.setString( 3, "Silva" );
            pst.setString( 4, "charles.silva@escolar.ifrn.edu.br" );
            pst.setInt( 5, 10 );
            pst.setInt( 6,1 );

            pst.execute();
            pst.close();

      
        pst = con.prepareStatement(sql);
           
            pst.setInt( 1, 5 );
            pst.setInt( 2, 2 );
            pst.setString( 3, "Charles" );
           
            pst.execute( );
            pst.close( );
           
          
           
            String query = "select * from customer"
                    + " order by customer_id desc"
                    + " limit 7";
           
            Statement st = con.createStatement();
           
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData md = rs.getMetaData();
            int col = md.getColumnCount();
           
            for (int i = 1; i <= col; i++) {
                System.out.print(md.getColumnName(i) + "\t");
            }   System.out.println("");
           
            while (rs.next()){
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                } System.out.println("");
            }
           
        }   catch (SQLException e) {
                e.printStackTrace();
        }   finally {
                con.close();
        }
       
    }}

