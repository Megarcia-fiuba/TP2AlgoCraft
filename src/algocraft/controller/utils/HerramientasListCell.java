package algocraft.controller.utils;

import algocraft.controller.containers.HerramientaContainer;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;

public class HerramientasListCell extends ListCell<HerramientaContainer> {
    @Override
    protected void updateItem(HerramientaContainer item, boolean empty){
        super.updateItem(item, empty);

        if(item == null || empty){
            setGraphic(null);
            setText(null);
        } else {
            ImageView imageView = item.getImageView();
            imageView.setFitWidth(30);
            imageView.setFitHeight(30);
            setGraphic(imageView);
            setText(item.getNombreHerramienta());
        }
    }
}
