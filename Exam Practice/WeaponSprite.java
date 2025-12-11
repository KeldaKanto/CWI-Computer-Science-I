import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Sprite representation of the weapons to be tested.
 */
public class WeaponSprite extends HBox {
    private final Weapon weapon;
    private final Label weaponLabel;
    private final Text dieResult;

    /**
     * Constructs a weapon sprite and a die's roll as ImageView
     * displays and adds them to the appropriate VBox and StackPane
     * @param weapon The weapon the sprite represents.
     */
    public WeaponSprite(Weapon weapon) {
        this.weapon = weapon;
        setAlignment(Pos.CENTER);
        setSpacing(10);

        Image weaponSprite = new Image(weapon + ".png");
        ImageView weaponView = new ImageView(weaponSprite);
        weaponView.setFitWidth(100);
        weaponView.setFitHeight(100);

        weaponLabel = new Label("Test " + weapon);
        weaponLabel.setFont(new Font("Helvetica", 36));
        weaponLabel.setTextFill(Color.CRIMSON);

        VBox weaponBox = new VBox(weaponView, weaponLabel);
        weaponBox.setSpacing(10);
        weaponBox.setAlignment(Pos.CENTER);

        Image dieSprite = new Image(weapon.getDamageDie().name() + ".png");
        ImageView dieView = new ImageView(dieSprite);
        dieView.setFitWidth(100);
        dieView.setFitHeight(100);

        dieResult = new Text();
        dieResult.setFont(Font.font("Helvetica", FontWeight.BOLD, 48));
        dieResult.setFill(Color.CRIMSON);
        dieResult.setTextAlignment(TextAlignment.CENTER);

        StackPane diePane = new StackPane(dieView, dieResult);
        diePane.setAlignment(Pos.CENTER);

        getChildren().addAll(weaponBox, diePane);
    }

    /**
     * Rolls a weapon attack until the weapon has run out of
     * remaining attacks.
     */
    public void weaponTest() {
        if ( weapon.getAttacksRemaining() == 0 ) {
            Alert endTestDialog = new Alert(Alert.AlertType.ERROR);
            endTestDialog.setContentText("You have done enough testing for now!");
            endTestDialog.setTitle(null);
            endTestDialog.setHeaderText(null);
            endTestDialog.showAndWait();
        } else {
            weapon.attack();
            weaponLabel.setText("Test " + weapon);
            dieResult.setText(String.valueOf(weapon.getLastDamage()));
        }
    }
}
