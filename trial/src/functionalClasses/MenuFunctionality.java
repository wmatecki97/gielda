package functionalClasses;

import AllObjects.*;
import AllObjects.Goods.Company;
import AllObjects.Goods.Currency;
import AllObjects.Goods.Goods;
import AllObjects.Goods.RawMaterials;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MenuFunctionality {

    static List<AllInstancess> investorList;
    static List<AllInstancess> investmentFundList;
    static List<AllInstancess> companyList;
    static List<AllInstancess> currencyList;
    static List<AllInstancess> exchangeList;
    static List<AllInstancess> rawMaterialList;
    static List<AllInstancess> shareIndexList;
    static AllPurchases purchasesList;


    public static void initialize(){
        investorList = new ArrayList<>();
        investmentFundList = new ArrayList<>();
        companyList = new ArrayList<>();
        currencyList = new ArrayList<>();
        exchangeList = new ArrayList<>();
        rawMaterialList= new ArrayList<>();
        shareIndexList = new ArrayList<>();
        purchasesList = new AllPurchases();
    }

    public static AllPurchases getPurchasesList() {
        return purchasesList;
    }

    private static String getInput(){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input="";

        try {
            input = br.readLine();
        } catch (IOException e) {
            System.out.println("bledna komenda, sprobuj ponownie");
        }

        return input;
    }

    public static void selectAction (){


        String input="";

        boolean ok = false;

        while(!ok){
            System.out.print("Co chcesz zrobic?\n" + "Aby dodac wpisz: dodaj\n" + "Aby zapisac wpisz: zapisz\n" + "Aby usunac wpisz usun\n"+ "Aby wyswietlic wpisz: wyswietl\n" + "Aby wyjsc wpisz exit\n");
            input = getInput();
            switch (input){
                case "dodaj":

                    break;

                case "zapisz":
                    SaveRead.save(companyList);
                    SaveRead.save(currencyList);
                    SaveRead.save(exchangeList);
                    SaveRead.save(investmentFundList);
                    SaveRead.save(investorList);
                    SaveRead.save(rawMaterialList);
                    SaveRead.save(shareIndexList);
                    break;

                case "wyswietl":
                    display();
                    break;

                case "usun":
                    deletItem();
                    break;

                case "exit":
                    ok=true;
                    break;

                default: ok=false; System.out.println("bledna komenda, sproboj ponownie");
            }
        }

    }

    public static void display(){


        String input="";
        boolean ok=false;
        while(!ok){
            //System.out.println("Co chcesz wyswietlic? \n" +"wybierz i wpisz jedno: spolki, waluty, gieldy, fundusze, inwestorzy, surowce, indeksy\n" +
                    //"Aby cofnac wpisz cofnij\n");
            //input = getInput();
            switch(input) {
                case "spolki": {

                    AdditionalFunctions.display(companyList);
                    break;
                }

                case "waluty": {

                    AdditionalFunctions.display(currencyList);
                    break;
                }

                case "gieldy": {

                    AdditionalFunctions.display(exchangeList);
                    break;
                }

                case "fundusze": {

                   AdditionalFunctions.display(investmentFundList);
                    break;
                }

                case "inwestorzy": {

                   AdditionalFunctions.display(investorList);
                    break;
                }

                case "surowce": {

                    AdditionalFunctions.display(rawMaterialList);
                    break;
                }

                case "indeksy": {

                   AdditionalFunctions.display(shareIndexList);
                    break;
                }

                case "cofnij": {
                    ok = true;
                    break;
                }


            }

        }
    }

    public static void addGoddToList(Goods g){
        List<AllInstancess> list = MenuFunctionality.getExchangeList();
        for(int i=0; i<list.size(); i++){
            if(AdditionalFunctions.getRandom(0,0)==0){
                Exchange temp = (Exchange)  list.get(i);
                temp.addToGoodsList(g);
            }
        }
    }
    public static void addNewInvestor(){investorList.add(new Investor());}
    public static void addNewInvestmentFund(){investmentFundList.add(new InvestmentFund());}
    public static void addNewCompany(){companyList.add(new Company());}
    public static void addNewCurrency(){Currency c = new Currency(); currencyList.add(c); addGoddToList(c);}
    public static void addNewExchange(){exchangeList.add(new Exchange());}
    public static void addNewRawMaterial(){rawMaterialList.add(new RawMaterials());}
    private static void addItem(List<AllInstancess> inputList, AllInstancess temp){

        String answer = getInput();
        try {
            inputList.add(temp.setValues(answer));
        } catch (Exception e) {
            System.out.println("bledne dane");
        }

    }

    public static void deletItem (){

        boolean ok=false;
        String input="";

        while(!ok){
            System.out.println("Co chcesz usunac? \n" +"Wybierz i wpisz jedno: spolka waluta gielda fundusz inwestor surowiec indeks\n" +
                    "Aby cofnac wpisz cofnij\n");
            input = getInput();

            switch(input){

                case "spolka": deleteitem(companyList); break;

                case "waluta": deleteitem(currencyList); break;

                case "gielda": deleteitem(exchangeList); break;

                case "fundusz": deleteitem(investmentFundList); break;

                case "inwestor": deleteitem(investorList); break;

                case "surowiec": deleteitem(rawMaterialList); break;

                case "indeks": deleteitem(shareIndexList); break;

                case "cofnij": ok=true; break;

            }

        }


    }

    private static void deleteitem(List<AllInstancess> inputList){
        AdditionalFunctions.display(inputList);
        System.out.println("Podaj numer ktory chceszusunac\n" + "Aby zrezygnowac wpisz: cofnij");
        String answer = getInput();
        try{
          //  AdditionalFunctions.checkIndex(inputList, Integer.parseInt(answer));
        }
        catch (Exception e){}

        try{
            inputList.remove(Integer.parseInt(answer));
        }
        catch (Exception e)
        {
            System.out.println("usuwanie nie powiodlo sie");
        }
    }

    private static void buy(int cost, Client client){/*
        boolean isGood=false;
        int whatToBuy;

        while(!isGood)
        {
            whatToBuy=AdditionalFunctions.getRandom(0,2);
            switch (whatToBuy){

                case 0: if(raw)

            }
        }*/
    }

    public static AllInstancess getRandomGoods(){
        return companyList.get(AdditionalFunctions.getRandom(0, companyList.size()-1));
    }

    public static Exchange getRandomExchange(){

        return (Exchange) exchangeList.get(AdditionalFunctions.getRandom(0,exchangeList.size()-1));

    }

    private static List<AllInstancess> getRandomListOfGoods() {

       return companyList;


    }

    public static List<AllInstancess> getInvestorList() {
        return investorList;
    }

    public static List<AllInstancess> getInvestmentFundList() {
        return investmentFundList;
    }

    public static List<AllInstancess> getCompanyList() {
        return companyList;
    }

    public static List<AllInstancess> getCurrencyList() {
        return currencyList;
    }

    public static List<AllInstancess> getExchangeList() {
        return exchangeList;
    }

    public static List<AllInstancess> getRawMaterialList() {
        return rawMaterialList;
    }

    public static List<AllInstancess> getShareIndexList() {
        return shareIndexList;
    }
}
