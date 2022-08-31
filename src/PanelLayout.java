import javax.swing.*;
import java.awt.*;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PanelLayout {
    BasicFunctionality bf = new BasicFunctionality();
    JFrame frame;
    Container c;

    JPanel lfPan, rtPan;
    JPanel lfHd, lfBG;

    JLabel lblCompLogo, compName,lblUserImg;
    ImageIcon compLogo;
    JScrollPane bgScroll;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //layout creation
    FlowLayout flowLay = new FlowLayout();


    //setting user info
    ImageIcon userImg = new ImageIcon("img/customer_img/img.jpg");
    JLabel userName = new JLabel("Shubrato Debnath");
    JLabel userType = new JLabel("OWNER");


    PanelLayout(){
        frameCreate();
        initComponent();
        frame.setVisible(true);
    }

    private void frameCreate(){
        frame = new JFrame("PaNeL DASHBOARD");
        bf.defFrame(frame, screenSize.width, screenSize.height);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Container c = frame.getContentPane();
        c.setLayout(null);

        //left panel
        lfPan = new JPanel();
        lfPan.setBounds(0,0, 250,screenSize.height);
        lfPan.setBackground(bf.semiDark);
        lfPan.setLayout(flowLay);
        c.add(lfPan);

        //right panel
        rtPan = new JPanel();
        rtPan.setBounds(250, 0,screenSize.width-250,screenSize.height);
        rtPan.setBackground(bf.royalBlue);
        rtPan.setLayout(flowLay);
        c.add(rtPan);
    }

    private void initComponent(){
        //creating left panel
        lfHd = new JPanel();
        lfHd.setLayout(null);
        lfHd.setBackground(Color.black);
        lfHd.setOpaque(false);
        lfHd.setPreferredSize(new Dimension(230,185));
        lfHd.setMaximumSize(new Dimension(230,185));
        lfPan.add(lfHd);
        leftHeader();


        //panel for left button group
        lfBG = new JPanel();
        lfBG.setLayout(new BoxLayout(lfBG,BoxLayout.Y_AXIS));
        lfBG.setBackground(bf.semiDark);
        lfBG.setOpaque(true);

        bgScroll = new JScrollPane(lfBG, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        bgScroll.setPreferredSize(new Dimension(250,screenSize.height-lfHd.getHeight()));
        bgScroll.setMaximumSize(new Dimension(250,screenSize.height-lfHd.getHeight()));
//        bgScroll.setSize(250,screenSize.height-lfHd.getHeight());
        bgScroll.setBorder(null);
        lfPan.add(bgScroll);

        leftButtonGroup();

    }

    //left header
    void leftHeader(){
        //COMPANY INFO
        lblCompLogo = new JLabel();
        lblCompLogo.setBounds(0,0,80,80);
        lblCompLogo.setOpaque(false);
        lblCompLogo.setBackground(Color.white);
        compLogo = new ImageIcon("img/icon.png");
        Image sclComp = compLogo.getImage().getScaledInstance(lblCompLogo.getWidth(), lblCompLogo.getHeight(), Image.SCALE_SMOOTH);
        compLogo = new ImageIcon(sclComp);
        lblCompLogo.setIcon(compLogo);
        lfHd.add(lblCompLogo);

        compName = new JLabel("S Dn Sales");
        compName.setFont(bf.font25);
        compName.setBounds(85,0,180,80);
        compName.setForeground(Color.white);
        lfHd.add(compName);
        lfHd.add(bf.mkLine(0,90,250,1));
        //COMPANY INFO ENDS


        //USER INFO
        lblUserImg = new JLabel();
        lblUserImg.setBounds(0,105,60,60);
        lblUserImg.setOpaque(true);
        lblUserImg.setBackground(Color.white);

        Image scU = userImg.getImage().getScaledInstance(lblUserImg.getWidth(), lblUserImg.getHeight(), Image.SCALE_SMOOTH);
        userImg = new ImageIcon(scU);
        lblUserImg.setIcon(userImg);
        lfHd.add(lblUserImg);


        userName.setBounds(70,105,160,30);
        userName.setFont(bf.font16);
        userName.setForeground(Color.white);
        lfHd.add(userName);


        userType.setBounds(70,131,160,20);
        userType.setFont(bf.font10);
        userType.setForeground(bf.offWhite);
        lfHd.add(userType);

        lfHd.add(bf.mkLine(0,175,250,1));
    }


    //left button group
    protected void leftButtonGroup(){
        JButton testbtn = new JButton("Test Button");
        bf.mkBGBtn(testbtn, lfBG);
    }
}

