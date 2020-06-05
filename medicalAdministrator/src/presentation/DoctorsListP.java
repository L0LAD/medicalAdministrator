package presentation ;

import java.util.List ;

import control.DoctorsList ;
import javafx.beans.value.ChangeListener ;
import javafx.beans.value.ObservableValue ;
import javafx.collections.FXCollections ;
import javafx.collections.ObservableList ;
import javafx.event.ActionEvent ;
import javafx.event.EventHandler ;
import javafx.scene.control.Button ;
import javafx.scene.control.ListView ;
import javafx.scene.control.Tab ;
import javafx.scene.layout.BorderPane ;
import javafx.scene.layout.FlowPane ;
import javafx.stage.Stage ;

//Classe de présentation de la liste des patients : c'est un onglet

public class DoctorsListP extends Tab {

   private ObservableList<String> doctorsNames ;
   private ListView<String> doctorsList ;
   private int currentIndex ;
   private BorderPane globalPane ;
   private Button editDoctorButton ;
   private Button deleteDoctorButton ;
   private Stage stage ;

   public DoctorsListP (Stage stage) {
      this.stage = stage ;    
   }
 
   public void initialize (DoctorsList control, List<String> doctors) {
      //Liste des noms des patients à lister
      doctorsNames = FXCollections.observableArrayList (doctors) ;
      //Remplissage du widget de présentation des noms avec la liste des noms des docteurs
      doctorsList = new ListView<String> (doctorsNames) ;
      //Ajout d'un listener sur la liste pour savoir quand un patient est sélectionné ou pas
      doctorsList.getSelectionModel().selectedItemProperty().addListener (new ChangeListener<String> () {
         public void changed (ObservableValue < ? extends String> ov, String old_val, String new_val) {
            if (! doctorsList.getSelectionModel ().isEmpty ()) {
               //Trouver l'index de l'élément sélectionné
               currentIndex = doctorsList.getSelectionModel ().getSelectedIndex () ;
               //Transfer au contrôle pour mémorisation
               control.selectDoctor (currentIndex) ;
               System.out.println(doctorsList.getSelectionModel ().getSelectedItem ());
            } else {
               //Aucun docteur n'est plus sélectionné : on le signale au contrôle
               control.selectNoDoctor () ;
            	System.out.println("AUCUN DOCTEUR SELECTIONNE");
            }
         }
      }) ;
      
      //Création des boutons New / Edit / Delete
      FlowPane buttons = new FlowPane () ;
      Button newDoctorButton = new Button () ;
      newDoctorButton.setText ("New") ;
      newDoctorButton.setOnAction (new EventHandler<ActionEvent> () {
         @Override
         public void handle (ActionEvent event) {
            System.out.println("NEW");
         }
      }) ;
      editDoctorButton = new Button () ;
      editDoctorButton.setText ("Edit") ;
      editDoctorButton.setOnAction (new EventHandler<ActionEvent> () {
         public void handle (ActionEvent event) {
        	 System.out.println("EDIT");
         }
      }) ;
      deleteDoctorButton = new Button () ;
      deleteDoctorButton.setText ("Delete") ;
      deleteDoctorButton.setOnAction (new EventHandler<ActionEvent> () {
         public void handle (ActionEvent event) {
        	 System.out.println("DELETE");
        }
      }) ;
      disableActionOnSelection () ;
      buttons.getChildren ().addAll (newDoctorButton, editDoctorButton, deleteDoctorButton) ;
      globalPane = new BorderPane () ;
      globalPane.setLeft (doctorsList) ;
      globalPane.setBottom (buttons);

      setText ("Doctors") ;
      setContent (globalPane) ;
      setClosable (false) ;
   }
   
   public Stage getStage () {
      return stage ;
   }

   //Désélection d'un médecin
   public void selectNoDoctor () {
      doctorsList.getSelectionModel ().clearSelection () ;
      globalPane.setCenter (null) ;
      globalPane.autosize () ;
   }

   //Sélection d'un médecin
   public void selectDoctor (DoctorP currentDoctor) {
      globalPane.setCenter (currentDoctor) ;
   }

   public void selectDoctor (String currentDoctorName) {
      doctorsList.getSelectionModel ().select (currentDoctorName) ;
   }

   //Activation des boutons
   public void enableActionOnSelection () {
      editDoctorButton.setDisable (false) ;
      deleteDoctorButton.setDisable (false) ;      
   }

   //Désactivation des boutons
   public void disableActionOnSelection () {
      editDoctorButton.setDisable (true) ;
      deleteDoctorButton.setDisable (true) ;                        
   }

   //Désactivation de la suppression uniquement
   public void disableDeleteOnSelection () {
      deleteDoctorButton.setDisable (true) ;      
   }


}