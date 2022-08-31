import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class BasicFunctionality {

    public Font font25 = new Font("Poppins",  Font.BOLD, 25);
    public Font font18 = new Font("Arial", Font.BOLD, 18);
    public Font font16 = new Font("Poppins", Font.BOLD, 16);
    public Font font14 = new Font("Arial", Font.BOLD, 14);
    public Font font12 = new Font("Arial", Font.BOLD, 12);
    public Font font10 = new Font("Arial", Font.BOLD, 10);

    public Color liteGreen = new Color(53,235,28,40);
    public Color liteGreen2 = new Color(230, 255, 238);
    public Color royalBlue = new Color(78, 138, 238);
    public Color errColor = new Color(114, 28, 36);
    public Color errBgColor = new Color(248, 215, 218);
    public Color offWhite = new Color(250,250,250);
    public Color semiDark = new Color(44, 46, 62);

    public Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);

    private JScrollPane frmScroll;

    //def frame
    public void defFrame(JFrame frame,  int width, int height){
        frame.setSize( width,height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("img/icon.png");
//        frame.setResizable(false);
        frame.setIconImage(icon.getImage());
    }


    //making a button layout
    public void mkBtn(JButton btn, int left, int top, int width, int height){
        btn.setBounds(left,top, width,height);
        btn.setFont(font14);
        btn.setCursor(handCursor);
    }


    //making def title
    public void smlTitle(JLabel label, JFrame frame){
        label.setBounds(0,0,frame.getWidth(),60);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.red);
        label.setFont(this.font18);
        label.setBackground(this.liteGreen);
    }


    //text field input group
    public void txtInpGroup(JLabel lbl, JTextField tf, Container c, int left, int top, int width, int height){
        lbl.setBounds(left,top,width, 20);
        lbl.setFont(font12);
        c.add(lbl);

        tf.setBounds(left,(top+20),width, (height-20));
        tf.setFont(font18);
        tf.setForeground(this.royalBlue);
        tf.setOpaque(false);

        //border style
        Border line = BorderFactory.createLineBorder(this.royalBlue, 1,true);
        Border padding = new EmptyBorder(5,10,5,10);
        CompoundBorder border = new CompoundBorder(line, padding);
        tf.setBorder(border);

        c.add(tf);
    }


    //text field input group
    public void passInpGroup(JLabel lbl, JPasswordField pf, Container c, int left, int top, int width, int height){
        lbl.setBounds(left,top,width, 20);
        lbl.setFont(font12);
        c.add(lbl);

        pf.setBounds(left,(top+20),width, (height-20));
        pf.setFont(font18);
        pf.setForeground(this.royalBlue);

        pf.setEchoChar('#');

        //border style
        Border line = BorderFactory.createLineBorder(this.royalBlue, 1,true);
        Border padding = new EmptyBorder(5,10,5,10);
        CompoundBorder border = new CompoundBorder(line, padding);

        pf.setBorder(border);
        c.add(pf);
    }


    //form button design
    public  void subBtn(JButton btn, int left, int top, int width, int height){
        btn.setBounds(left,top,width, height);
        btn.setBackground(this.royalBlue);
        btn.setForeground(Color.white);
        btn.setBorder(null);
        btn.setCursor(handCursor);
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                btn.setBackground(Color.white);
                btn.setForeground(royalBlue);
            }
            public void mouseExited(MouseEvent e){
                btn.setBackground(royalBlue);
                btn.setForeground(Color.white);
            }
        });
    }


    //file choose field
    public void mkFCbox(JLabel lbl, JPanel pan, JLabel imgLbl, JButton atBtn, Container c, int left, int top, int width, int height){
        //title
        lbl.setBounds(left,top,width, 20);
        lbl.setFont(font12);
        c.add(lbl);
        //panel creating
        pan.setBounds(left,top+20,width, height-20);
        pan.setLayout(null);
        pan.setOpaque(false);
        LineBorder x = new LineBorder(this.royalBlue, 1,true);
        pan.setBorder(x);
        //assigning button inside panel
        atBtn.setBounds(10,5,100, 30);
        pan.add(atBtn);
        //show attached image
        imgLbl.setBounds((width-40),0,40, 40);
        pan.add(imgLbl);
        //adding panel to the container
        c.add(pan);

    }


    //image round
//    public void roundImg(String imgPath, JLabel label, int left, int top, int width,int height){
//        BufferedImage image = null;
//        try{
//            image = ImageIO.read(new File("img/icon.png"));
//
//            Area clip = new Area( new Rectangle(left, top, width, height) );
//            Area oval = new Area( new Ellipse2D.Double( left, top, width-1, height-1));
//            clip.subtract( oval );
//            Graphics g2d = image.createGraphics();
//
//            image.getScaledInstance(80,80,BufferedImage.SCALE_SMOOTH);
//
//            g2d.setColor(Color.green);
//
//            g2d.setClip( clip );
//            g2d.setColor( new Color(0,0,255,127));
//            g2d.fillRect(left, top, width, height);
//
//        }catch(Exception e){
//            System.out.println("Error " +  e);
//        }
//
//        ImageIcon roundImg = new ImageIcon(image);
//        label.setIcon(roundImg);
//        label.setOpaque(true);
//    }



//    class RoundedPanel extends JPanel{
//        private Color backgroundColor;
//        private int cornerRadius = 15;
//
//        public RoundedPanel(LayoutManager layout, int radius) {
//            super(layout);
//            cornerRadius = radius;
//        }
//
//        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
//            super(layout);
//            cornerRadius = radius;
//            backgroundColor = bgColor;
//        }
//
//        public RoundedPanel(int radius) {
//            super();
//            cornerRadius = radius;
//        }
//
//        public RoundedPanel(int radius, Color bgColor) {
//            super();
//            cornerRadius = radius;
//            backgroundColor = bgColor;
//        }
//
//        @Override
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
//            int width = getWidth();
//            int height = getHeight();
//            Graphics2D graphics = (Graphics2D) g;
//            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//            //Draws the rounded panel with borders.
//            if (backgroundColor != null) {
//                graphics.setColor(backgroundColor);
//            } else {
//                graphics.setColor(getBackground());
//            }
//            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
//            graphics.setColor(getForeground());
//            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//
//            //delete from here
//            try{
//                BufferedImage image = ImageIO.read(new File("img/icon.png"));
//                Graphics2D g2D = (Graphics2D) image.getGraphics();
//                g2D.drawImage(imageToWrite, x, y, width, heigth, null);
//                g2D.dispose();
//            }catch (Exception e){
//                System.out.println("Erro :  " + e);
//            }
//
//
//        }
//    }





    //line creation
    public JLabel mkLine( int left, int top, int width,int height){
        JLabel line = new JLabel();
        line.setBounds(left,top,width,height);
        line.setOpaque(true);
        line.setBackground(new Color(154,154,154));
        return line;
    }



    // making buttons for left panel button group
    public void mkBGBtn(JButton btn, JPanel pan){
        btn.setPreferredSize(new Dimension(250,50));
        btn.setMaximumSize(new Dimension(250,50));
        btn.setForeground(new Color(166, 169, 183));
        btn.setBackground(this.semiDark);
        btn.setOpaque(false);
        btn.setBorder(null);
        btn.setAlignmentY(JButton.LEFT_ALIGNMENT);
        pan.add(btn);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setOpaque(true);
                btn.setForeground(new Color(248, 249, 250 ));
                btn.setBackground(new Color(31, 33, 45));
            }
            @Override
            public void mouseExited(MouseEvent e){
                btn.setForeground(new Color(166, 169, 183));
                btn.setOpaque(false);
            }
        });
    }


    //making the panel at center
    public void mkCenter(JPanel relativePan, JPanel parentPan,JPanel childPanel){

        parentPan.setLayout(null);
        childPanel.setSize(relativePan.getWidth(),relativePan.getHeight());
        childPanel.setLayout(null);

        int locX = (relativePan.getWidth()/2)-(childPanel.getWidth()/2);
        int locY = (relativePan.getHeight()/2)-(childPanel.getHeight()/2);
        childPanel.setLocation(locX, locY);

        LineBorder x = new LineBorder(this.royalBlue, 1,true);
        childPanel.setBorder(x);

    }


    //panel title
    public void panTitle(JPanel pan, JLabel title){
        title.setBounds(0,0,pan.getWidth(), 60);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(this.font25);
        title.setForeground(this.offWhite);
        title.setOpaque(true);
        title.setBackground(this.semiDark);

        pan.add(title);
    }

}
