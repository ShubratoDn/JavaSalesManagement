import javax.swing.*;

public class AddNewCategory {

    BasicFunctionality bf = new BasicFunctionality();

    public AddNewCategory(JPanel rtPan, JPanel pPan, JPanel cPan){
        show( rtPan, pPan, cPan);
    }

    private void show(JPanel rtPan,JPanel pPan,JPanel cPan){
        cPan = new JPanel();
        bf.mkCenter(rtPan,pPan, cPan);

        /*----------------------------------
        component of adding new category
        ----------------------------------*/
        //title
        JLabel title = new JLabel(("ADD NEW ITEM CATEGORY").toUpperCase());
        bf.panTitle(cPan, title);




        pPan.add(cPan);
    }

}
