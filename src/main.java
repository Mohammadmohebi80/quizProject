import  java.sql.* ;
import java.util.ArrayList;


public class main {


    public static void main(String[] args) {

    //    ArrayList<Integer> adads = new ArrayList<>() ;
        ArrayList<String> names = new ArrayList<>() ;
        ArrayList<String> options = new ArrayList<>();

        String[][] op = new String[4][4] ;




        try {


            Connection connection = null ;
            String url = "jdbc:sqlite:test.db" ;
            connection = DriverManager.getConnection(url) ;
            Statement statement = connection.createStatement() ;
            String sql_q = "select * from m" ;

            ResultSet resultSet = statement.executeQuery(sql_q);

            while (resultSet.next()){
                String q   = resultSet.getString("soal") ;
               names.add(q) ;
            }
        }catch (Exception e){
           e.printStackTrace();
        }

      try {
          Connection connection = null ;
          String url = "jdbc:sqlite:test.db" ;
          connection = DriverManager.getConnection(url) ;
          Statement statement = connection.createStatement() ;
          String sql_q = "select * from o" ;

          ResultSet resultSet = statement.executeQuery(sql_q);

          while (resultSet.next()){
              String q   = resultSet.getString("op") ;
              options.add(q) ;


      }

      }catch (Exception e){
         e.printStackTrace();
      }

      int index = 0 ;
        for (int i=  0 ; i <4 ; i++) {
            for (int j= 0  ; j <4 ; j++) {
                op[i][j] = options.get(index) ;
                index++ ;
            }
        }
    //    System.out.println(options);




       quiz q = new quiz(names , op) ;

    }
}
