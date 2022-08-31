import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginAs extends MouseAdapter implements ActionListener {
    BasicFunctionality bf = new BasicFunctionality();
    private JFrame frame;
    private JLabel title;
    private Container c;
    private JButton custLog, visLog, ownLog;
    private JLabel newCus, newOwn;


    public LoginAs(){
        initComponent();
    }


    private void initComponent(){
        frame = new JFrame("Choose login type");
        bf.defFrame(frame, 400,400);
        c = frame.getContentPane();
        c.setLayout(null);

        //title
        title = new JLabel("CHOOSE A LOGIN OPTION");
        bf.smlTitle(title,frame);
        c.add(title);

        //button creation
        custLog = new JButton("Customer Login");
        bf.mkBtn(custLog, 120,80,150,50);
        c.add(custLog);

        visLog = new JButton("Visitor Login");
        bf.mkBtn(visLog, 120,140,150,50);
        c.add(visLog);

        ownLog = new JButton("Owner Login");
        bf.mkBtn(ownLog, 120,200,150,50);
        c.add(ownLog);


        //labels
        newCus = new JLabel("Create new CUSTOMER ACCOUNT");
        newCus.setBounds(0,270, frame.getWidth(), 20);
        newCus.setFont(bf.font10);
        newCus.setHorizontalAlignment(JLabel.CENTER);
        newCus.setCursor(bf.handCursor);
        c.add(newCus);

//        newOwn = new JLabel("Register as Owner");
//        newOwn.setBounds(0,300, frame.getWidth(), 20);
//        newOwn.setFont(bf.font10);
//        newOwn.setHorizontalAlignment(JLabel.CENTER);
//        newOwn.setCursor(bf.handCursor);
//        c.add(newOwn);

        frame.setVisible(true);

        //button functionality
        custLog.addActionListener(this);
        visLog.addActionListener(this);
        ownLog.addActionListener(this);

        newCus.addMouseListener(this);
//        newOwn.addMouseListener(this);
    }



    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == custLog){
            //request for customer login
            CustomerLogin cl= new CustomerLogin();
            frame.dispose();
        }
        else if(ae.getSource() == visLog){
            JOptionPane.showMessageDialog(frame,"Visitor Login");
        }
        else if(ae.getSource() == ownLog){
            OwnerLogin ol = new OwnerLogin();
            frame.dispose();
        }
    }

    public void mouseClicked(MouseEvent me){
        if(me.getSource() == newCus){
            CustomerRegister cr = new CustomerRegister();
            frame.dispose();
        }
        else if (me.getSource() == newOwn) {
            JOptionPane.showMessageDialog(frame,"owner new");
        }
    }

    public void mouseEntered(MouseEvent me){
        if(me.getSource() == newCus){
            newCus.setOpaque(true);
            newCus.setBackground(bf.royalBlue);
            newCus.setForeground(Color.white);
        }
//        else if (me.getSource() == newOwn) {
//            newOwn.setOpaque(true);
//            newOwn.setBackground(bf.royalBlue);
//        }
    }

    public void mouseExited(MouseEvent me){
        if(me.getSource() == newCus){
            newCus.setOpaque(false);
            newCus.setBackground(Color.white);
            newCus.setForeground(Color.black);
        }
//        else if (me.getSource() == newOwn) {
//            newOwn.setOpaque(false);
//            newOwn.setBackground(Color.white);
//        }
    }

}
