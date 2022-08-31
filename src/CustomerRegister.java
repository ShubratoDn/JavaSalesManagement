import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class CustomerRegister implements ActionListener {
    //global variables
    BasicFunctionality  bf = new BasicFunctionality();

    private JFrame frame;
    private Container c;
    private JLabel title;

    private JLabel errBox, lCompName, lOwnerName, lCompAdd, lPhone, lImg, imgShow, lPass, lConPass;
    private JTextField tfCompName, tfOwnerName, tfCompAdd, tfPhone;
    private JPasswordField pfPass, pfConPass;

    private JButton registerBtn, attachBtn;
    private JPanel fcPan;

    public CustomerRegister(){
        initComponent();
        frame.setVisible(true);
    }

    private void initComponent(){
        frame = new JFrame("Register Customer");
        bf.defFrame(frame, 640,600);
        c = frame.getContentPane();
        c.setLayout(null);


        title = new JLabel("REGISTER AS CUSTOMER");
        bf.smlTitle(title, frame);
        c.add(title);

        errBox = new JLabel("Error Message");
        errBox.setBounds(40,70, (frame.getWidth()-90), 40);
        errBox.setBorder(new EmptyBorder(5,20,5,20));
        errBox.setOpaque(true);
        errBox.setBackground(bf.errBgColor);
        errBox.setForeground(bf.errColor);
        errBox.setVisible(false);
        c.add(errBox);

        formComponent();
    }

    private void formComponent(){
        lCompName = new JLabel("Your Company Name");
        tfCompName = new JTextField();
        bf.txtInpGroup(lCompName,tfCompName,c, 40,120,250,60);

        lOwnerName = new JLabel("Your Name");
        tfOwnerName = new JTextField();
        bf.txtInpGroup(lOwnerName,tfOwnerName,c, 340,120,250,60);

        lCompAdd = new JLabel("Company Address");
        tfCompAdd = new JTextField();
        bf.txtInpGroup(lCompAdd,tfCompAdd,c, 40,200,250,60);

        lPhone = new JLabel("Your Phone");
        tfPhone = new JTextField();
        bf.txtInpGroup(lPhone,tfPhone,c, 340,200,250,60);


        //choose file button
        lImg = new JLabel("Your Image");
        fcPan = new JPanel();
        imgShow = new JLabel();
        attachBtn = new JButton("Choose File");
        attachBtn.addActionListener(this);
        bf.mkFCbox(lImg,fcPan,imgShow,attachBtn,c,40,280,250,60);
        //choose file ends

        lPass = new JLabel("Your Password");
        pfPass = new JPasswordField();
        bf.passInpGroup(lPass, pfPass,c, 40,360,250,60);

        lConPass = new JLabel("Confirm Your Password");
        pfConPass = new JPasswordField();
        bf.passInpGroup(lConPass, pfConPass,c, 340,360,250,60);


        registerBtn = new JButton("REGISTER NOW ");
        bf.subBtn(registerBtn,40,450,550 , 50);
        c.add(registerBtn);

        registerBtn.addActionListener(this);

    }



    private BufferedImage bfImg = null;
    private File file, newFile;
    private ImageIcon iconImg;
    private String fileFormat = "";

    //INPUT VALIDATION
    public void actionPerformed(ActionEvent e){

        if (e.getSource() == registerBtn){
            //getting inputs
            String compName = tfCompName.getText().trim();
            String ownName = tfOwnerName.getText().trim();
            String add = tfCompAdd.getText().trim();
            String phone = tfPhone.getText().trim();
            String pass = pfPass.getText().trim();
            String conPass = pfConPass.getText().trim();

            //confirmation
            boolean err = true;
            boolean filledAllInput = false;
            boolean imgFound = false;

            //error message
            String errMsg = "";

            //checking for image on image field
            if (imgShow.getIcon() == null){
                imgFound = false;
            }else {
                imgFound = true;
            }

            //checking for we get all inputs
            if(compName.isBlank() || ownName.isBlank() || add.isBlank() || phone.isBlank() || pass.isBlank() || conPass.isBlank() || imgFound == false){
                filledAllInput = false ;
                JOptionPane.showMessageDialog(frame,"MISSING SOME INPUTS","Missing Input", JOptionPane.ERROR_MESSAGE);
                errMsg = errMsg+"Insert All Inputs.";
            }else {
                filledAllInput = true;

                //if all inputs are filled
                //MATCHING PASSWORD
                if (!pass.equals(conPass)){
                    errMsg = errMsg + "PASSWORD NOT MATCH!";
                    JOptionPane.showMessageDialog(frame,"PASSWORD NOT MATCHING");
                    err = true;
                }else {
                    err = false;
                }
            }




            if(err){
                errBox.setVisible(true);
                errBox.setText(errMsg);
            }else{
                //IF THERE IS NO ERROR!!
                errBox.setText("");
                errBox.setVisible(false);
                JOptionPane.showMessageDialog(frame,"ALL IS OK");


                //if All is okay then Uploading the image
                try{
                    //creating customer_img folder
                    new File("img/customer_img").mkdir();
                    newFile = new File("img/customer_img/img.jpg");

                    if(ImageIO.write(bfImg,fileFormat,newFile)){
                        JOptionPane.showMessageDialog(frame,"File Uploaded Successfully");
                    }else {
                        JOptionPane.showMessageDialog(frame,"Failed to Upload your image", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(Exception ex){
                    System.out.println("Error file writing : " + e);
                }

            }
        }

        //if user click on choose file button
        if(e.getSource() == attachBtn){

            JFileChooser fileChoose = new JFileChooser();
            fileChoose.setCurrentDirectory(new File("F:\\"));
            int response = fileChoose.showOpenDialog(null);

            //if user Click into open button of Open Dialog box
            if(response == JFileChooser.APPROVE_OPTION){
                boolean fileFormatErr = true;
                String[] fileSplit = fileChoose.getSelectedFile().getName().split("\\.");
                //getting the file format
                if(fileSplit.length>0){
                    fileFormat = fileSplit[fileSplit.length-1].toLowerCase();
                }

                //checking for image file formats
                if(fileFormat.equals("png") || fileFormat.equals("jpg") || fileFormat.equals("jpeg")){
                    fileFormatErr = false;
                }

                if (!fileFormatErr){
                    //setting image to the imgShow(JLabel)
                    String filePath =fileChoose.getSelectedFile().getAbsolutePath();
                    iconImg = new ImageIcon(filePath);
                    Image reImg = iconImg.getImage().getScaledInstance(imgShow.getWidth(), imgShow.getHeight(), Image.SCALE_SMOOTH);
                    iconImg = new ImageIcon(reImg);
                    imgShow.setIcon(iconImg);

                    //reading image
                    try{
                        file = new File(filePath);
                        bfImg = new BufferedImage(400,400,BufferedImage.TYPE_INT_ARGB);
                        bfImg = ImageIO.read(file);
                    }catch(Exception ex){
                        System.out.println("Error in file read : " + e);
                    }

                }else {
                    JOptionPane.showMessageDialog(frame, "Unsupported file format", "Error Format ", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
