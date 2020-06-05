package presentation ;
import javafx.scene.control.Label ;
import javafx.scene.text.* ;
import javafx.scene.layout.GridPane ;
import javafx.scene.layout.VBox ;

public class DoctorP extends VBox {
   
   GridPane detailsPane = new GridPane () ;
   Text detailsTitle = new Text ("   DETAILS") ;
   
   Label rppsTitle = new Label ("   RPPS   ") ;
   Label addressTitle = new Label ("   Address   ") ;
   Label phoneNumberTitle = new Label ("   Phone Number   ") ;
   Label lastNameTitle = new Label ("   Last Name   ") ;
   Label firstNameTitle = new Label ("   First Name   ") ;
   Label specialityTitle = new Label ("   Speciality   ") ;
   
   private Label rppsLabel = new Label () ;
   private Label addressLabel = new Label () ;
   private Label phoneNumberLabel = new Label () ;
   private Label lastNameLabel = new Label () ;
   private Label firstNameLabel = new Label () ;
   private Label specialityLabel = new Label () ;
   
   //Mise en page de l'affichage
   public DoctorP () {
      
      detailsTitle.setFont(Font.font("ABEL", FontWeight.BOLD, 12)) ;
      lastNameTitle.setFont(Font.font("LUCIDA CONSOLE", FontWeight.NORMAL, 12)) ;
      firstNameTitle.setFont(Font.font("LUCIDA CONSOLE", FontWeight.NORMAL, 12)) ;
      rppsTitle.setFont(Font.font("LUCIDA CONSOLE", FontWeight.NORMAL, 12)) ;
      addressTitle.setFont(Font.font("LUCIDA CONSOLE", FontWeight.NORMAL, 12)) ;
      phoneNumberTitle.setFont(Font.font("LUCIDA CONSOLE", FontWeight.NORMAL, 12)) ;
      specialityTitle.setFont(Font.font("LUCIDA CONSOLE", FontWeight.NORMAL, 12)) ;
      
      detailsPane.addRow (1, new Label (" ")) ;
      detailsPane.addRow (2, lastNameTitle, lastNameLabel) ;
      detailsPane.addRow (3, firstNameTitle, firstNameLabel) ;
      detailsPane.addRow (4, rppsTitle, rppsLabel) ;
      detailsPane.addRow (5, new Label (" ")) ;
      detailsPane.addRow (6, specialityTitle, specialityLabel) ;  
      detailsPane.addRow (7, addressTitle, addressLabel) ;
      detailsPane.addRow (8, phoneNumberTitle, phoneNumberLabel) ;
      detailsPane.addRow (9, new Label (" ")) ;
      detailsPane.addRow (10, new Label (" ")) ;
      
      getChildren().addAll(detailsTitle, detailsPane) ;
      
   }
   
   public void updateDetails (String lastName, String firstName) {
      lastNameLabel.setText (lastName);
      firstNameLabel.setText (firstName);
   }
   
}
