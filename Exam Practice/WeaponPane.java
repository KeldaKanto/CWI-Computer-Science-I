import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

/**
 * Holds a set of weapons and title. Gives each weapon a sprite
 * with a MouseEvent that calls weaponTest() each time it's
 * clicked.
 */
public class WeaponPane extends VBox {
    public WeaponPane(Weapon[] weapons) {
        setStyle("-fx-background-color: CORNSILK");
        setSpacing(10);
        setAlignment(Pos.CENTER);

        Label title = new Label("Weapons Workshop");
        title.setFont(new Font("Helvetica", 48));
        title.setTextFill(Color.GREEN);

        getChildren().add(title);

        for ( Weapon weapon : weapons ) {
            WeaponSprite weaponSprite = new WeaponSprite(weapon);
            weaponSprite.setOnMouseClicked(this::mouseClickSprite);
            getChildren().add(weaponSprite);
        }
    }

    /**
     * Calls weaponTest() each time a weapon sprite is clicked.
     * @param event A mouse click that triggers the test.
     */
    private void mouseClickSprite(MouseEvent event) {
        WeaponSprite weapon = (WeaponSprite)event.getSource();
        weapon.weaponTest();
    }
}