package AllObjects.GUI;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.io.IOException;

public class PageOpener {


    private static void open(String path, String title, int height, int width, boolean isCritical){

        Parent root;
        try {

            root = FXMLLoader.load(Main.class.getResource(path));
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root, width, height));

            if(isCritical) {
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent t) {
                        Platform.exit();
                        System.exit(0);
                    }
                });
            }
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }



    }

    private static void open(String path, String title, boolean isCritical){

        open(path, title, 300, 450, isCritical);

    }

    public static void startPage(){

        open("StartPageView.fxml", "Wybierz akcję", true);

    }


    public static void displayPage(){

        open("DisplayPageView.fxml", "Wyświetl dane", 400, 300, true);

    }

    public static void addPage(){

        open("AddPageView.fxml", "Dodaj nowe obiekty", 325, 300, false);

    }

    public static void investorPage(){
        open("DisplayTemplates/InvestorView.fxml", "Inwestorzy", 400, 500, false);
    }

    public static void companyPage(){
        open("./DisplayTemplates/CompanyView.fxml", "Spółki", 400, 1300, false);
    }

    public static void currencyPage(){
        open("./DisplayTemplates/CurrencyView.fxml", "Waluty", 400, 800, false);
    }

    public static void exchangePage(){
        open("./DisplayTemplates/ExchangeView.fxml", "Giełdy", 400, 1300, false);
    }

}