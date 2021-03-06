package AllObjects.GUI;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.io.IOException;


public class PageOpener {

    /**
     * open stage of given parameters
     * @param path fxml file path
     * @param title stage title
     * @param height
     * @param width
     * @param isCritical if is critical then closing this stage would close whole program
     */
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

    public synchronized static void startPage(){

        open("StartPageView.fxml", "Wybierz akcję", 300, 250, true);

    }

    public synchronized static void displayPage(){
        open("DisplayPageView.fxml", "Wyświetl dane", 450, 300, true);
    }

    public synchronized static void popUp(){
        open("EmptyGeneratorPopUp.fxml", "", 150, 600, false);
    }

    public synchronized static void addPage(){
        open("AddPageView.fxml", "Dodaj nowe obiekty", 375, 300, false);
    }

    public synchronized static void investorPage(){
        open("DisplayTemplates/InvestorView.fxml", "Inwestorzy", 400, 500, false);
    }

    public synchronized static void investmentFundPage(){
        open("DisplayTemplates/InvestmentFundView.fxml", "Fundusze inwestycyjne", 400, 500, false);
    }

    public synchronized static void companyPage(){
        open("DisplayTemplates/CompanyView.fxml", "Spółki", 400, 700, false);
    }

    public synchronized static void currencyPage(){
        open("DisplayTemplates/CurrencyView.fxml", "Waluty", 400, 450, false);
    }

    public synchronized static void exchangePage(){
        open("DisplayTemplates/ExchangeView.fxml", "Giełdy", 400, 1300, false);
    }

    public synchronized static void rawMaterialPage(){open("DisplayTemplates/RawMaterialView.fxml", "Surowce", 400, 450, false);
    }

    public synchronized static void detailsInvestor(){
        open("DisplayTemplates/DetailedView/Investor.fxml", "Szczegóły inwestora", 500, 400, false);
    }

    public synchronized static void detailsInvestmentFund(){
        open("DisplayTemplates/DetailedView/InvestmentFund.fxml", "Szczegóły funduszu inwestycyjnego", 600, 400, false);
    }

    public synchronized static void detailsCompany() {
        open("DisplayTemplates/DetailedView/Company.fxml", "Szczegóły funduszu inwestycyjnego", 550, 627, false);
    }

    public synchronized static void chart() {
        open("Chart.fxml", "Wykres", 450, 775, false);

    }

    public static void detailsRawMaterial() {
        open("DisplayTemplates/DetailedView/RawMaterials.fxml", "Szczegóły surowca", 475, 450, false);

    }

    public static void detailsCurrency() {
        open("DisplayTemplates/DetailedView/Currency.fxml", "Szczegóły waluty", 475, 450, false);
    }
}
