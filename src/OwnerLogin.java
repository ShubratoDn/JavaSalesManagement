import javax.swing.*;
import java.awt.*;

public class OwnerLogin {

    public BasicFunctionality bf = new BasicFunctionality();
    private JFrame frame;
    private Container c;
    private JLabel title, lblPhone, lblPass, forgetPass;
    private JButton loginBtn;
    private JTextField tfPhone, tfPass;
    private JPasswordField pfPass;


    OwnerLogin(){
        initComponent();
    }

    void initComponent(){
        //basic frame and container
        frame = new JFrame("owner login".toUpperCase());
        bf.defFrame(frame, 350,400);
        c = frame.getContentPane();
        c.setLayout(null);


        title = new JLabel("OWNER LOGIN");
        title.setForeground(Color.red);
        bf.smlTitle(title, frame);
        c.add(title);

        //input group
        lblPhone = new JLabel("Enter your USER NAME : ");
        tfPhone = new JTextField();
        bf.txtInpGroup(lblPhone, tfPhone, c, 40,80,260,60);

        //input group
        lblPass = new JLabel("Enter your Password : ");
        pfPass = new JPasswordField();
        bf.passInpGroup(lblPass, pfPass, c, 40,160,260,60);

        //submit button
        loginBtn = new JButton("LOGIN NOW");
        bf.subBtn(loginBtn,40,240,260,40);
        c.add(loginBtn);

        forgetPass = new JLabel("Forgot password?");
        forgetPass.setBounds(40,290,260,40);
        forgetPass.setCursor(bf.handCursor);
        forgetPass.setHorizontalAlignment(JLabel.RIGHT);
        forgetPass.setFont(bf.font10);
        forgetPass.setForeground(Color.red);
        c.add(forgetPass);

        frame.setVisible(true);
    }
}
