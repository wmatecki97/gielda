package AllObjects.GUI;

import AllObjects.functionalClasses.MenuFunctionality;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StartPageView.fxml"));
        primaryStage.setTitle("Wybierrz akcję");
        primaryStage.setScene(new Scene(root, 800, 275));
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
        primaryStage.show();

    }


    private static void setFewStartObjects(){

        MenuFunctionality.addNewCurrency();
        MenuFunctionality.addNewCurrency();
        MenuFunctionality.addNewCurrency();
        MenuFunctionality.addNewCompany();
        MenuFunctionality.addNewCompany();
        MenuFunctionality.addNewInvestor();
        MenuFunctionality.addNewInvestor();
        MenuFunctionality.addNewInvestor();MenuFunctionality.addNewInvestor();MenuFunctionality.addNewInvestor();MenuFunctionality.addNewInvestor();MenuFunctionality.addNewInvestor();MenuFunctionality.addNewInvestor();MenuFunctionality.addNewInvestor();MenuFunctionality.addNewInvestor();MenuFunctionality.addNewInvestor();MenuFunctionality.addNewInvestor();MenuFunctionality.addNewInvestor();MenuFunctionality.addNewInvestor();MenuFunctionality.addNewInvestor();

        MenuFunctionality.addNewInvestmentFund();
        MenuFunctionality.addNewInvestmentFund();
        MenuFunctionality.addNewInvestmentFund();MenuFunctionality.addNewInvestmentFund();MenuFunctionality.addNewInvestmentFund();MenuFunctionality.addNewInvestmentFund();MenuFunctionality.addNewInvestmentFund();MenuFunctionality.addNewInvestmentFund();MenuFunctionality.addNewInvestmentFund();MenuFunctionality.addNewInvestmentFund();MenuFunctionality.addNewInvestmentFund();MenuFunctionality.addNewInvestmentFund();MenuFunctionality.addNewInvestmentFund();MenuFunctionality.addNewInvestmentFund();

        MenuFunctionality.addNewRawMaterial();
        MenuFunctionality.addNewExchange();
        MenuFunctionality.addNewInvestor();
        MenuFunctionality.addNewCompany();
        MenuFunctionality.addNewCurrency();



    }

    public static void main(String[] args) {


        MenuFunctionality.initialize();
        setFewStartObjects();
        //PageOpener.startPage();
        launch(args);

    }
}
