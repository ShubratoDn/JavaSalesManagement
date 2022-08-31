import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewItem implements ActionListener {
    //global variable declaration
    BasicFunctionality bf = new BasicFunctionality();
   private JPanel rtPan;
   private JPanel pPan;
   private JPanel cPan;
    private  int rowRange = 5;

    AddNewItem(JPanel rtPan,JPanel parentPan){
        this.rtPan = rtPan;
        this.pPan = parentPan;
        show();
    }


    //global variable declaration
    private JSpinner addItRowRan;
    private JButton addRow;


    private void show(){

        cPan = new JPanel();
        bf.mkCenter(rtPan,pPan, cPan);

        /*----------------------------------
        component of ADD NEW ITEM
        ----------------------------------*/
        //title
        JLabel title = new JLabel("ADD NEW ITEM INFO");
        bf.panTitle(cPan, title);

        //adding row
        JPanel rowRangePan = new JPanel(new FlowLayout());
        rowRangePan.setBackground(bf.liteGreen2);
        rowRangePan.setBounds(40,100,1000,45);

        //Row range
        JLabel crLbl = new JLabel("Enter How Many Rowumn you wants to add : ");
        rowRangePan.add(crLbl);

        addItRowRan =  new JSpinner();
        addItRowRan.setPreferredSize(new Dimension(40,30));
        rowRangePan.add(addItRowRan);

        addRow = new JButton("ADD");
        rowRangePan.add(addRow);
        cPan.add(rowRangePan);
        addRow.addActionListener(this);

        //Add Items
        JPanel inpPan = new JPanel();

        pPan.add(cPan);
    }

    public void actionPerformed(ActionEvent e){
        //clicking on Add Row button
        if(e.getSource() == addRow){
            int val = Integer.parseInt(addItRowRan.getValue().toString());
            rowRange = rowRange + val;
            JOptionPane.showMessageDialog(pPan,"Val is : " + rowRange);
        }
    }


}
