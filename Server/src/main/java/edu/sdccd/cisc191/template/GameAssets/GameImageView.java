package edu.sdccd.cisc191.template.GameAssets;

import edu.sdccd.cisc191.template.ItemTypes.Item;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameImageView extends ImageView {

    public GameImageView (Image image){
    super(image);
    //makes it fit a third of the screen
    setFitHeight(ViewGame.getScreenDimensions()*9/48);
    setFitWidth(ViewGame.getScreenDimensions()*9/48);
    }

    public GameImageView(String name){
    //sets image size for item
        super(new Image("image/items/"+name+".png"));
        setFitHeight(ViewGame.getScreenDimensions()*9/192-25);
        setFitWidth(ViewGame.getScreenDimensions()*9/192-25);

    }
}
