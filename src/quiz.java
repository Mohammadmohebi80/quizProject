import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class quiz  implements ActionListener {

    String[] questions = {
            "which company created java  ? " ,
            "which year was java created ? " ,
            "what was java originally called  ?" ,
            "what is your name  ?"
    } ;
    String[][] option = {
            {"kfjg" , "fgkjfg" , "fkgj" ,"fkgjfg"} ,
            {"kfjg" , "fgkjfg" , "fkgj" ,"fkgjfg"} ,
            {"kfjg" , "fgkjfg" , "fkgj" ,"fkgjfg"} ,
            {"kfjg" , "fgkjfg" , "fkgj" ,"fkgjfg"}
    };
    char[] answres = {
            'A' ,
            'B' ,
            'C' ,
            'C' ,
    } ;
  char guess ;
  char answer ;
  int index ;
  int corrent_guess = 0 ;
  int total_question = questions.length;
  int result ;
  int secodes = 10 ;

  JFrame frame = new JFrame() ;
  JTextField textField = new JTextField() ;
  JTextArea area = new JTextArea() ;
  JButton btn1 = new JButton() ;
  JButton btn2 = new JButton() ;
  JButton btn3 = new JButton() ;
  JButton btn4 = new JButton() ;
  JLabel answer_a = new JLabel() ;
  JLabel answer_b = new JLabel() ;
  JLabel answer_c = new JLabel() ;
  JLabel answer_d = new JLabel() ;
  JLabel label_time = new JLabel() ;
  JLabel time_left = new JLabel() ;
  JTextField number_right = new JTextField() ;
  JTextField percentage = new JTextField() ;

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        secodes--;
        time_left.setText(String.valueOf(secodes));
        if (secodes <=0){
            displayans();
        }


        }
    }) ;

    quiz(){
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(650 ,650);
          frame.getContentPane().setBackground(new Color(50 ,50 ,50));
          frame.setLayout(null);
          frame.setResizable(false);

          textField.setBounds(0 , 0, 650 , 50);
          textField.setBackground(new Color(25 ,25 ,25));
          textField.setForeground(new Color(25 ,255 , 0 ));
          textField.setFont(new Font("Ink Free" , Font.BOLD , 30));
          textField.setBorder(BorderFactory.createBevelBorder(1));
          textField.setHorizontalAlignment(JTextField.CENTER);
          textField.setEditable(false);
        //  textField.setText("mohamamd");


         area.setBounds(0 , 50, 650 , 50);
         area.setLineWrap(true);
         area.setWrapStyleWord(true);
         area.setBackground(new Color(25 ,25 ,25));
         area.setForeground(new Color(25 ,255 , 0 ));
         area.setFont(new Font("MV Boli" , Font.BOLD , 25));
         area.setBorder(BorderFactory.createBevelBorder(1));
         area.setEditable(false);
       //  area.setText("mohamamd");

        btn1.setBounds(0 , 100, 100 ,100);
        btn1.setFont(new Font("MV Boil" , Font.BOLD , 25));
        btn1.setFocusable(false);
        btn1.addActionListener(this);
        btn1.setText("A");

        btn2.setBounds(0 , 200, 100 ,100);
        btn2.setFont(new Font("MV Boil" , Font.BOLD , 25));
        btn2.setFocusable(false);
        btn2.addActionListener(this);
        btn2.setText("B");

        btn3.setBounds(0 , 300, 100 ,100);
        btn3.setFont(new Font("MV Boil" , Font.BOLD , 25));
        btn3.setFocusable(false);
        btn3.addActionListener(this);
        btn3.setText("C");

        btn4.setBounds(0 , 400, 100 ,100);
        btn4.setFont(new Font("MV Boil" , Font.BOLD , 25));
        btn4.setFocusable(false);
        btn4.addActionListener(this);
        btn4.setText("D");

        answer_a.setBounds(125 , 100 , 500 ,100);
        answer_a.setBackground(new Color(50 ,50 ,50));
        answer_a.setForeground(new Color(25 ,255 , 0 ));
        answer_a.setFont(new Font("MV Boil" , Font.PLAIN , 35));
      //  answer_a.setText("mohamamd");

        answer_b.setBounds(125 , 200 , 500 ,100);
        answer_b.setBackground(new Color(50 ,50 ,50));
        answer_b.setForeground(new Color(25 ,255 , 0 ));
        answer_b.setFont(new Font("MV Boil" , Font.PLAIN , 35));
     //   answer_b.setText("mohamamd");

        answer_c.setBounds(125 , 300 , 500 ,100);
        answer_c.setBackground(new Color(50 ,50 ,50));
        answer_c.setForeground(new Color(25 ,255 , 0 ));
        answer_c.setFont(new Font("MV Boil" , Font.PLAIN , 35));
      //  answer_c.setText("mohamamd");

        answer_d.setBounds(125 , 400 , 500 ,100);
        answer_d.setBackground(new Color(50 ,50 ,50));
        answer_d.setForeground(new Color(25 ,255 , 0 ));
        answer_d.setFont(new Font("MV Boil" , Font.PLAIN , 35));
     //   answer_d.setText("mohamamd");

        time_left.setBounds(535 , 510 ,100,100);
        time_left.setBackground(new Color(25 ,25 ,25));
        time_left.setForeground(new Color(255 ,0 , 0));
        time_left.setFont(new Font("Ink Free" , Font.BOLD , 60));
        time_left.setBorder(BorderFactory.createBevelBorder(1));
        time_left.setOpaque(true);
        time_left.setHorizontalAlignment(JTextField.CENTER);
        time_left.setText(String.valueOf(secodes));

        label_time.setBounds(535 , 485 , 100 ,25);
        label_time.setBackground(new Color(50 , 50 , 50 ));
        label_time.setForeground(new Color(255 , 0 ,0 ));
        label_time.setFont(new Font("MV Boil" , Font.PLAIN , 16));
        label_time.setHorizontalAlignment(JTextField.CENTER);
        label_time.setText("timer > :D");


        number_right.setBounds(255 ,255 ,200 , 100);
        number_right.setBackground(new Color(25 ,25 ,25));
        number_right.setForeground(new Color(25 ,255 , 0));
        number_right.setFont(new Font("Ink Free" ,Font.BOLD , 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);


        percentage.setBounds(255 ,355 ,200 , 100);
        percentage.setBackground(new Color(25 ,25 ,25));
        percentage.setForeground(new Color(25 ,255 , 0));
        percentage.setFont(new Font("Ink Free" ,Font.BOLD , 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);


       //   frame.add(number_right) ;
      //    frame.add(percentage) ;
          frame.add(label_time) ;
          frame.add(time_left) ;
          frame.add(answer_a);
          frame.add(answer_b);
          frame.add(answer_c);
          frame.add(answer_d);
          frame.add(btn1) ;
          frame.add(btn2) ;
          frame.add(btn3) ;
          frame.add(btn4) ;
          frame.add(area)  ;
          frame.add(textField) ;
          frame.setVisible(true);

          nextq();
    }

    public void nextq(){
       if (index >= total_question){
           result();
       }
       else {
           textField.setText("Question "+ (index+1));
           area.setText(questions[index]);
           answer_a.setText(option[index][0]);
           answer_b.setText(option[index][1]);
           answer_c.setText(option[index][2]);
           answer_d.setText(option[index][3]);
           timer.start();

       }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);

        if (e.getSource() == btn1){
                answer = 'A' ;
                if (answer == answres[index]){
                    corrent_guess++ ;
                }
            }
        if (e.getSource() == btn2){
            answer = 'B' ;
            if (answer == answres[index]){
                corrent_guess++ ;
            }
        }
        if (e.getSource() == btn3){
            answer = 'C' ;
            if (answer == answres[index]){
                corrent_guess++ ;
            }
        }
        if (e.getSource() == btn4){
            answer = 'D' ;
            if (answer == answres[index]){
                corrent_guess++ ;
            }
        }
      //  System.out.println(corrent_guess);
        displayans();
    }

    public  void displayans(){
       if (answres[index] != 'A'){
           answer_a.setForeground(new Color(255 , 0 ,0));
       }
        if (answres[index] != 'B'){
            answer_b.setForeground(new Color(255 , 0 ,0));
        }
        if (answres[index] != 'C'){
            answer_c.setForeground(new Color(255 , 0 ,0));
        }
        if (answres[index] != 'D'){
            answer_d.setForeground(new Color(255 , 0 ,0));
        }

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_a.setForeground(new Color(25 , 255 ,0));
                answer_b.setForeground(new Color(25 , 255 ,0));
                answer_c.setForeground(new Color(25 , 255 ,0));
                answer_d.setForeground(new Color(25 , 255 ,0));

                answer =' ' ;
                secodes = 10 ;
                time_left.setText(String.valueOf(secodes));
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                index++ ;
                nextq();


            }
        }) ;
        pause.setRepeats(false);
        pause.start();

    }

    public void result(){
        timer.stop();

        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);

        result = (int)((corrent_guess / (double)total_question)*100 );
        textField.setText("RESULT");
        area.setText("");
        answer_a.setText("");
        answer_b.setText("");
        answer_c.setText("");
        answer_d.setText("");

        number_right.setText("("+corrent_guess + "/" + total_question+")");
        percentage.setText(result + "%");

        frame.add(number_right) ;
        frame.add(percentage) ;

    }
}
