package lib.dto;

import javax.swing.*;

//nu trebuie sa implementeze Serializable deoarece ImageIcon este Serializabila
//atentie-> s-ar putea sa apara probleme in fucntie de versiunea de swing
//deoarece serializarea la versiuni diferite nu este compatibila
public class BackGroundImage extends ImageIcon{




    public BackGroundImage() {
//        Image image = new ImageIcon(path).getImage()
//                .getScaledInstance(960,540,Image.SCALE_SMOOTH);
//
//        this.setImage(image);
    }

//    public ImageIcon getImageIcon(){
//       Image lib.image = new ImageIcon("./src/lib.image/flow-2.jpg").getImage()
//                .getScaledInstance(960,540,Image.SCALE_SMOOTH);
//
//        ImageIcon imageIcon = new ImageIcon(lib.image);
//        return imageIcon;
//    }






}
