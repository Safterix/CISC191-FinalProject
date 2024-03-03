package edu.sdccd.cisc191.template.GameAssets;

import edu.sdccd.cisc191.template.ItemTypes.Item;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameImageView extends ImageView {

    public GameImageView (Image image){
    super(image);
    //makes it fit a third of the screen
    setFitHeight(ViewGame.getScreenDimensions()/16*9/3);
    setFitWidth(ViewGame.getScreenDimensions()/3);
    }

    public GameImageView(String name){

        super(new Image("image/items/"+name+".png"));
        setFitHeight(ViewGame.getScreenDimensions()/18);
        setFitWidth(ViewGame.getScreenDimensions()/18);

    }
}
