package Project;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Properties;

public class Electric_Bill {
    static String name, address, city, state, email, customerName, caddress, cmail, pr, cphone;
    static int nm, mmm, p;
    static long phone, cr;
    static JFrame jf, jfl, jf2;

    static boolean flag;

    static public void gui() {
        jf = new JFrame("Login");
        jf.setBounds(10, 10, 600, 500);
        jf.setLayout(null);
        jf.setBackground(Color.black);
        JLabel jl = new JLabel("New  Customer");
        jl.setBounds(250, 10, 200, 20);
        jf.add(jl);
        JLabel jln = new JLabel("Customer Name");
        jln.setBounds(70, 50, 200, 20);
        jf.add(jln);
        JTextField jtf = new JTextField();
        jtf.setBounds(200, 50, 250, 20);
        jf.add(jtf);
        JLabel jla = new JLabel("Address");
        jla.setBounds(70, 100, 200, 20);
        jf.add(jla);
        JTextField jta = new JTextField();
        jta.setBounds(200, 100, 250, 20);
        jf.add(jta);
        JLabel jlc = new JLabel("City");
        jlc.setBounds(70, 150, 250, 20);
        jf.add(jlc);
        JTextField jtc = new JTextField();
        jtc.setBounds(200, 150, 250, 20);
        jf.add(jtc);
        JLabel jls = new JLabel("State");
        jls.setBounds(70, 200, 250, 20);
        jf.add(jls);
        JTextField jts = new JTextField();
        jts.setBounds(200, 200, 250, 20);
        jf.add(jts);
        JLabel jle = new JLabel("Email");
        jle.setBounds(70, 250, 200, 20);
        jf.add(jle);
        JTextField jte = new JTextField();
        jte.setBounds(200, 250, 250, 20);
        jf.add(jte);
        JLabel jlp = new JLabel("Phone Number");
        jlp.setBounds(70, 300, 200, 20);
        jf.add(jlp);
        JTextField jtp = new JTextField();
        jtp.setBounds(200, 300, 250, 20);
        jf.add(jtp);
        JButton jb = new JButton("Submit");
        jb.setBounds(200, 350, 100, 20);
        jf.add(jb);
        JButton jb1 = new JButton("Clear");
        jb1.setBounds(400, 350, 100, 20);
        jf.add(jb1);
       /* JButton jb2=new JButton("Next");
        jb2.setBounds(300,350,100,20);
        jf.add(jb2);*/
        JLabel jlr = new JLabel();
        jlr.setBounds(70, 400, 300, 20);
        jf.add(jlr);

        // jf.setVisible(true);

        jfl = new JFrame("Home page for electricity bill dask");
        jfl.setBounds(10, 10, 300, 300);
        jfl.setLayout(null);
        jfl.setBackground(Color.black);
        JLabel jll = new JLabel("Welcome on home page");
        jll.setBounds(100, 20, 200, 20);
        jfl.add(jll);
        JLabel jll1 = new JLabel("Meter Number");
        jll1.setBounds(20, 60, 100, 20);
        jfl.add(jll1);

        JTextField jtfl = new JTextField();
        jtfl.setBounds(120, 60, 150, 20);
        jfl.add(jtfl);
        JButton jbl = new JButton("Login");
        jbl.setBounds(20, 150, 80, 20);
        jfl.add(jbl);
        JButton jbl2 = new JButton("Registration");
        jbl2.setBounds(150, 150, 120, 20);
        jfl.add(jbl2);
        jfl.setVisible(true);
        jf2 = new JFrame("login");
        jf2.setBounds(10, 10, 600, 600);
        jf2.setLayout(null);
        JLabel jlf = new JLabel("Customer Detail");
        jlf.setBounds(200, 30, 200, 20);
        jf2.add(jlf);
        JLabel jtf2 = new JLabel();
        jtf2.setBounds(50, 50, 100, 20);
        jf2.add(jtf2);
        JLabel jtf3 = new JLabel();
        jtf3.setBounds(200, 50, 200, 20);
        jf2.add(jtf3);
        JLabel jtf4 = new JLabel();
        jtf4.setBounds(50, 100, 200, 20);
        jf2.add(jtf4);
        JLabel jtf5 = new JLabel();
        jtf5.setBounds(200, 100, 200, 20);
        jf2.add(jtf5);
        JLabel jtf6 = new JLabel("Previous Meter Reading");
        jtf6.setBounds(50, 150, 200, 20);
        jf2.add(jtf6);
        JLabel jtf7 = new JLabel();
        jtf7.setBounds(200, 150, 100, 20);
        jf2.add(jtf7);
        JLabel jtf8 = new JLabel("Current Meter Reading");
        jtf8.setBounds(50, 200, 200, 20);
        jf2.add(jtf8);
        JTextField jtf9 = new JTextField();
        jtf9.setBounds(200, 200, 100, 20);
        jf2.add(jtf9);
        JButton jbf2 = new JButton("Generate bill");
        jbf2.setBounds(200, 250, 125, 20);
        jf2.add(jbf2);
        // jtf2.setText(name);
        //jf2.setVisible(true);
        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfl.setVisible(false);
                jf.setVisible(true);
            }
        };
        jbl2.addActionListener(action2);
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = jtf.getText();
                address = jta.getText();
                city = jtc.getText();
                state = jts.getText();
                email = jte.getText();
                phone = Long.parseLong((jtp.getText()));
                jfl.setVisible(true);
                jf.setVisible(false);
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java",
                            "root", "123456789");
                    System.out.println("connection done");
                    String mm = "select * from electricbill where Meter_Number=(select max(Meter_Number) from electricbill)";
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(mm);


                    while (rs.next()) {
                        nm = rs.getInt("Meter_Number");
                        System.out.println(nm);
                    }
                    nm++;
                    String qr = "insert into electricbill values(\"" + nm + "\",\"" + name + "\",\"" + address + "\",\"" + city + "\"," +
                            "\"" + state + "\",\"" + email + "\"," + phone + ",0,0)";
                    Statement st1 = con.createStatement();
                    System.out.println(qr);
                    st.executeUpdate(qr);


                } catch (Exception e1) {
                    System.out.println(e1);
                }
                jlr.setText("Congratulations your meter number is " + nm);
                JOptionPane.showMessageDialog(jf, "Congratulations your meter number is" + nm);

            }
        };
        jb.addActionListener(action);

        ActionListener action3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText("");
                jta.setText("");
                jtc.setText("");
                jts.setText("");
                jte.setText("");
                jtp.setText("");
            }
        };
        jb1.addActionListener(action3);
        ActionListener action4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfl.setVisible(false);
                jf2.setVisible(true);
                mmm = Integer.parseInt(jtfl.getText());
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java",
                            "root", "123456789");
                    String fatch = "select * from electricbill where Meter_Number=\"" + mmm + "\"";
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(fatch);
                    while (rs.next()) {
                        customerName = rs.getString("Customer_Name");
                        caddress = rs.getString("Address");
                        cmail = rs.getString("Email");
                        cphone = rs.getString("Phone_Number");
                        pr = rs.getString("Prevoius_Reading");
                        p = Integer.parseInt(pr);
                        // cr= Integer.parseInt(rs.getString("Current_Reading"));
                    }

                } catch (Exception l) {
                    System.out.println(l);
                }
                jtf2.setText(customerName);
                jtf3.setText(caddress);
                jtf4.setText(cmail);
                jtf5.setText(cphone);
                jtf7.setText(pr);
                System.out.println(pr);
            }
        };
        jbl.addActionListener(action4);

        ActionListener up = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cr = Long.parseLong((jtf9.getText()));
                int c = (int) cr;
                int r = c - p;
                int t = r * 10;
                System.out.println(cr);
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java",
                            "root", "123456789");
                    String update = "update  electricbill set Prevoius_Reading=\"" + cr + "\" where Meter_Number=\"" + mmm + "\" ";
                    Statement st = con.createStatement();
                    st.executeUpdate(update);
                } catch (Exception aa) {
                    System.out.println(aa);
                }
                JOptionPane.showMessageDialog(jf2, "Your electricity bill total amount is rs \"" + t + "\"");
                Properties pp = new Properties();
                pp.put("mail.smtp.port", "587");
                pp.put("mail.smtp.host", "smtp.gmail.com");
                pp.put("mail.smtp.auth", "true");
                pp.put("mail.smtp.starttls.enable", true);

                String uname = "er.jat1992";
                String pass = "pafhmxyovyxfnsru";

                Session session = Session.getInstance(pp, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(uname, pass);
                    }
                });

                try{
                    Message msg=new MimeMessage(session);
                    msg.setFrom(new InternetAddress("er.jat1992gmail.com"));
                    msg.setSubject("electricity bill");
                    msg.setRecipient(Message.RecipientType.TO, new InternetAddress( cmail));
                    msg.setText("Your electricity bill total amount is rs " + t );



                    Transport.send(msg);
                    flag =true;
                }catch(MessagingException ef){
                    System.out.println(ef);
                }

            }
        };
        jbf2.addActionListener(up);

    }





        public static void main (String[]args){

            gui();
        }
    }

