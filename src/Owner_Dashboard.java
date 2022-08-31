import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Owner_Dashboard extends PanelLayout implements ActionListener {

    private JButton homeBtn,addNewItemInfo, addCat, upItem, upCat, saleIss, purchase;
    protected JPanel pHome,pAddIt, pAddC, pUpI, pUpC, pSlI,pPur;
    JPanel pan = new JPanel();

    CardLayout cardLay = new CardLayout();

    Owner_Dashboard(){
        super.frame.setTitle("OWNER DASHBOARD");
        super.userName.setText("SHUBRATO DN");
        rightPanel();

        //adding all panels functionality  here
        panFunctionality();
    }

    @Override
    //left button group
    protected void leftButtonGroup(){
        homeBtn = new JButton("HOME");
        bf.mkBGBtn(homeBtn, lfBG);
        homeBtn.addActionListener(this);

        addNewItemInfo = new JButton("ADD NEW ITEM INFO");
        bf.mkBGBtn(addNewItemInfo, lfBG);
        addNewItemInfo.addActionListener(this);

        addCat = new JButton("ADD NEW CATEGORY");
        bf.mkBGBtn(addCat, lfBG);
        addCat.addActionListener(this);

        upItem = new JButton("UPDATE ITEM");
        bf.mkBGBtn(upItem, lfBG);
        upItem.addActionListener(this);

        upCat = new JButton("UPDATE CATEGORY");
        bf.mkBGBtn(upCat, lfBG);
        upCat.addActionListener(this);

        saleIss = new JButton("SALE ISSUE");
        bf.mkBGBtn(saleIss, lfBG);
        saleIss.addActionListener(this);

        purchase = new JButton("PURCHASED");
        bf.mkBGBtn(purchase,lfBG);
        purchase.addActionListener(this);
    }


    //right panel functionality
    private void  rightPanel(){
        super.rtPan.setLayout(cardLay);

        pHome = new JPanel();
        JLabel x = new JLabel("HOME");
        pHome.add(x);
        rtPan.add(pHome,"pan_Home");

        pAddIt = new JPanel();
        rtPan.add(pAddIt,"pan_AddNewItem");

        pAddC = new JPanel();
        rtPan.add(pAddC,"pan_AddCategory");

        pUpI= new JPanel();
        x = new JLabel("pan_UpdateItem");
        pUpI.add(x);
        rtPan.add(pUpI,"pan_UpdateItem");

        pUpC = new JPanel();
        x = new JLabel("pan_UpdateCategory");
        pUpC.add(x);
        rtPan.add(pUpC,"pan_UpdateCategory");

        pSlI= new JPanel();
        x = new JLabel("pan_SalesIssue");
        pSlI.add(x);
        rtPan.add(pSlI,"pan_SalesIssue");

        pPur= new JPanel();
        x = new JLabel("pan_Purchase");
        pPur.add(x);
        rtPan.add(pPur,"pan_Purchase");

    }


    //buttons functionality
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == homeBtn){
            cardLay.show(rtPan,"pan_Home");
        }else if(e.getSource() ==  addNewItemInfo){
            cardLay.show(rtPan,"pan_AddNewItem");
        } else if (e.getSource() ==  addCat) {
            cardLay.show(rtPan,"pan_AddCategory");
        } else if (e.getSource() ==  upItem) {
            cardLay.show(rtPan,"pan_UpdateItem");
        }else if (e.getSource() ==  upCat) {
            cardLay.show(rtPan,"pan_UpdateCategory");
        }else if (e.getSource() ==  saleIss) {
            cardLay.show(rtPan,"pan_SalesIssue");
        }else if (e.getSource() ==  purchase) {
            cardLay.show(rtPan,"pan_Purchase");
        }
    }

    void panFunctionality(){
        AddNewItem ani = new AddNewItem(rtPan,pAddIt);
        AddNewCategory anc = new AddNewCategory(rtPan,pAddC,pan);
    }
}
