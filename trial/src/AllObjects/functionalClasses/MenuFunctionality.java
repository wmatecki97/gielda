package AllObjects.functionalClasses;

import AllObjects.*;
import AllObjects.Clients.Client;
import AllObjects.Clients.InvestmentFund;
import AllObjects.Clients.Investor;
import AllObjects.GUI.PageOpener;
import AllObjects.Goods.Company;
import AllObjects.Goods.Currency;
import AllObjects.Goods.Goods;
import AllObjects.Goods.RawMaterials;
import AllObjects.Market.CurrencyMarket;
import AllObjects.Market.Exchange;
import AllObjects.Market.Market;
import AllObjects.Market.RawMaterialsMarket;


import java.io.*;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class MenuFunctionality {

    static List<Investor> investorList;
    static List<InvestmentFund> investmentFundList;
    static List<Company> companyList;
    static List<Goods> currencyList;
    static List<AllInstancess> exchangeList;
    static List<Goods> rawMaterialList;
    static List<ShareIndex> shareIndexList;
    static CurrencyMarket currencyMarket;
    static RawMaterialsMarket rawMaterialsMarket;
    static AllInstancess displayedObject;
    static List<Integer> chartList;
    static List<>
    static String errorMessage;

    static Semaphore displaysemaphore;

    public static void initialize() {

        //TEMPORARY
        currencyList = new ArrayList<>();
        rawMaterialList = new ArrayList<>();

        currencyMarket = new CurrencyMarket();
        rawMaterialsMarket = new RawMaterialsMarket();
        currencyList = currencyMarket.getGoodsList();
        rawMaterialList = rawMaterialsMarket.getGoodsList();

        investorList = new ArrayList<>();
        investmentFundList = new ArrayList<>();
        companyList = new ArrayList<>();
        exchangeList = new ArrayList<>();
        shareIndexList = new ArrayList<>();
        chartList = new ArrayList<>();
        errorMessage="";
        displayedObject=null;

        displaysemaphore = new Semaphore(1);

    }


    //block is synchronized
    public static void addNewInvestor() {
        synchronized (investorList) {
            Investor inv = new Investor();
            investorList.add(inv);
            Thread t = new Thread(inv);
            t.start();

        }
    }
    public static void addNewInvestmentFund() {
        synchronized (investmentFundList){
            InvestmentFund inv = new InvestmentFund();
            investmentFundList.add(inv);
            Thread t = new Thread(inv);
            t.start();
        }

    }
    public static void addNewCompany() {
        synchronized (companyList){
            Company c = new Company();
            companyList.add(c);
            addCompanyToExchanges(c);
            Thread t = new Thread(c);
            t.start();
        }
    }
    public static void addNewCurrency() {
        Currency c = new Currency();
        synchronized (currencyList){
            currencyList.add(c);
        }
        Thread t = new Thread(c);
        t.start();
    }
    public static void addNewExchange() {
        synchronized (exchangeList){
            synchronized (currencyList){
                synchronized (companyList){
                    synchronized (rawMaterialList){
                        Exchange e = new Exchange();
                        exchangeList.add(e);
                    }
                }
            }
        }
    }
    public static void addNewRawMaterial() {
        RawMaterials r = new RawMaterials();
        synchronized (rawMaterialList){
            synchronized (currencyList){
                rawMaterialList.add(r);
            }
        }
        Thread t = new Thread(r);
        t.start();
    }

    public static List<Investor> getInvestorList() {
        return investorList;
    }
    public static List<InvestmentFund> getInvestmentFundList() {
        return investmentFundList;
    }
    public static List<Company> getCompanyList() {
        return companyList;
    }
    public static List<Goods> getCurrencyList() {
        return currencyList;
    }
    public static List<AllInstancess> getExchangeList() {
        return exchangeList;
    }
    public static List<Goods> getRawMaterialList() {
        return rawMaterialList;
    }
    public static List<ShareIndex> getShareIndexList() {
        return shareIndexList;
    }
    public static CurrencyMarket getCurrencyMarket() {
        return currencyMarket;
    }
    public static RawMaterialsMarket getRawMaterialsMarket() {
        return rawMaterialsMarket;
    }
    public static Semaphore getDisplaysemaphore() {
        return displaysemaphore;
    }
    public static List<Integer> getChartList() {
        return chartList;
    }
    public static String getErrorMessage() {
        synchronized (errorMessage){
            return errorMessage;
        }

    }
    public static AllInstancess getDisplayedObject() {
        return displayedObject;
    }//is synchronized

    public static void save(){
        synchronized (investorList){
            synchronized (investmentFundList){
                synchronized (companyList){
                    synchronized (currencyList){
                        synchronized (exchangeList){
                            synchronized (rawMaterialList){
                                synchronized (shareIndexList){
                                    synchronized (currencyMarket){
                                        synchronized (rawMaterialsMarket){
                                            synchronized (displaysemaphore){
                                                synchronized (chartList){
                                                    synchronized (errorMessage){
                                                        synchronized (displayedObject){
                                                            SaveRead save =new SaveRead();
                                                            try{
                                                                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("zapis.bin"));
                                                                os.writeObject(save);
                                                                os.close();
                                                                errorMessage="Pomyślnie zapisano";
                                                                PageOpener.popUp();
                                                            } catch (FileNotFoundException e) {
                                                                errorMessage="Nie znaleziono zapisu";
                                                                PageOpener.popUp();
                                                            } catch (IOException e) {
                                                                errorMessage="Wystąpił problem podczas zapisu";
                                                                PageOpener.popUp();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void read(){
        synchronized (investorList){
            synchronized (investmentFundList){
                synchronized (companyList){
                    synchronized (currencyList){
                        synchronized (exchangeList){
                            synchronized (rawMaterialList){
                                synchronized (shareIndexList){
                                    synchronized (currencyMarket){
                                        synchronized (rawMaterialsMarket){
                                            synchronized (displaysemaphore){
                                                synchronized (chartList){
                                                    synchronized (errorMessage){
                                                        synchronized (displayedObject) {
                                                            try {
                                                                ObjectInputStream is = new ObjectInputStream(new FileInputStream("zapis.bin"));
                                                                SaveRead save = (SaveRead) is.readObject();
                                                                is.close();

                                                                for (Company company : companyList) company.terminate();
                                                                for (InvestmentFund investmentFund : investmentFundList)investmentFund.terminate();
                                                                for (Investor investor : investorList)investor.terminate();
                                                                for(Goods currency: currencyList)currency.terminate();
                                                                for(Goods rawMaterials: rawMaterialList)rawMaterials.terminate();


                                                                investorList = save.getInvestorList();
                                                                investmentFundList = save.getInvestmentFundList();
                                                                companyList = save.getCompanyList();
                                                                currencyList = save.getCurrencyList();
                                                                exchangeList = save.getExchangeList();
                                                                rawMaterialList = save.getRawMaterialList();
                                                                shareIndexList = save.getShareIndexList();
                                                                currencyMarket = save.getCurrencyMarket();
                                                                rawMaterialsMarket = save.getRawMaterialsMarket();
                                                                displayedObject = save.getDisplayedObject();
                                                                chartList = save.getChartList();
                                                                errorMessage = save.getErrorMessage();

                                                                for (Company company : companyList)
                                                                    new Thread(company).start();
                                                                for (InvestmentFund investmentFund : investmentFundList)
                                                                    new Thread(investmentFund).start();
                                                                for (Investor investor : investorList)
                                                                    new Thread(investor).start();

                                                                displaysemaphore = save.getDisplaysemaphore();
                                                                errorMessage = "Pomyślnie wczytano";
                                                                PageOpener.popUp();
                                                            } catch (FileNotFoundException e) {
                                                                errorMessage = "Nie znaleziono zapisu";
                                                                PageOpener.popUp();
                                                            } catch (IOException e) {
                                                                errorMessage = "Wystąpił problem podczas odczytu";
                                                                PageOpener.popUp();
                                                            } catch (ClassNotFoundException e) {
                                                                e.printStackTrace();
                                                            }

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void setErrorMessage(String errorMessage) {
        synchronized (errorMessage){
            MenuFunctionality.errorMessage = errorMessage;
        }
    }

    public static void addCompanyToExchanges(Goods g) {
        synchronized (exchangeList){
            List<AllInstancess> list = exchangeList;
            for (int i = 0; i < list.size(); i++) {
                if (AdditionalFunctions.getRandom(0, 5) == 0) {
                    Exchange temp = (Exchange) list.get(i);
                    temp.addToGoodsList(g);
                }
            }
        }
    }

    public static boolean checkCompanyOccurance(int id) {
        synchronized (companyList) {
            for (Company company : companyList) {
                if (company.getId() == id) return true;
            }
        }
        return false;
    }

    public static AllInstancess getRandomGoods() {
        synchronized (companyList){
            return companyList.get(AdditionalFunctions.getRandom(0, companyList.size() - 1));
        }
    }

    public static Purchase buyParticipationUnits(Double price){
        synchronized (investmentFundList){
            InvestmentFund fund = investmentFundList.get(AdditionalFunctions.getRandom(0,investmentFundList.size()-1));
            return fund.buyPurchases(price);
        }

    }

    public static void buyOnRandomMarket(InvestmentFund client, double cost) {

        synchronized (client){
            synchronized (currencyMarket){
                synchronized (rawMaterialsMarket){
                    synchronized (exchangeList){
                        Market randomMarket;
                        int rand = AdditionalFunctions.getRandom(0, 2);
                        if (rand == 0) randomMarket = (Market) currencyMarket;
                        if (rand == 1) randomMarket = (Market) rawMaterialsMarket;
                        else randomMarket = (Market) exchangeList.get(AdditionalFunctions.getRandom(0, exchangeList.size() - 1));
                        synchronized (currencyList){
                            synchronized (companyList){
                                synchronized (rawMaterialList){
                                    randomMarket.buy(client, cost);
                                }
                            }
                        }
                    }
                }
            }
        }



    }//is good

    public static void releaseDisplayedObjectSemaphore() {
        displaysemaphore.release();
    }//is synchronized
    public static void setDisplayedObject(AllInstancess displayedObject) {
        try {
            displaysemaphore.acquire();
        } catch (InterruptedException e) {
        }
        MenuFunctionality.displayedObject = displayedObject;
    }//is synchronized

    public static void releaseDisplaySemaphore(){
        displaysemaphore.release();
    }

    public static HasName getGood(int id) {
        synchronized (companyList) {
            for (Goods good : companyList) {
                if (good.getId() == id)
                    return good;
            }
        }
        synchronized (currencyList) {
            for (Goods good : currencyList) {
                if (good.getId() == id)
                    return good;
            }
        }
        synchronized (rawMaterialList) {
            for (Goods good : rawMaterialList) {
                if (good.getId() == id)
                    return good;
            }
        }
        synchronized (investmentFundList) {
            for (InvestmentFund fund : investmentFundList) {
                if (fund.getId() == id)
                    return fund;
            }
        }
        return null;
    }//is synchronized

    public static void goodHasBeenDeleted(int id) {

        synchronized (investmentFundList) {
            for (InvestmentFund fund : investmentFundList) {
                fund.goodHasBeenDeleted(id);
            }
        }
        synchronized (investorList) {
            for (Investor investor : investorList) {
                investor.goodHasBeenDeleted(id);
            }
        }

    }

    public static void deleteObject(int objectId) {

        synchronized (investmentFundList) {
            for (int i = 0; i < investmentFundList.size(); i++) {
                if (investmentFundList.get(i).getId() == objectId) {
                    investmentFundList.remove(i);
                    goodHasBeenDeleted(objectId);
                    return;
                }
            }
        }
        synchronized (investorList) {

            for (int i = 0; i < investorList.size(); i++) {
                if (investorList.get(i).getId() == objectId) {
                    investorList.remove(i);
                    return;
                }
            }
        }
        synchronized (companyList) {
            for (int i = 0; i < companyList.size(); i++) {
                if (companyList.get(i).getId() == objectId) {
                    companyList.remove(i);
                    goodHasBeenDeleted(objectId);
                    deleteChartLine(objectId);
                    return;
                }
            }
        }


    }// is synchronized


    public static void addChartLine(Company company) {

        synchronized (company) {
            if (checkOccuranceInChart(company.getId())) {
                deleteChartLine(company.getId());
            }
            synchronized (chartList) {
                chartList.add(company.getId());
            }
        }
    }
    public static boolean checkOccuranceInChart(int id) {
        synchronized (chartList) {
            for (int line : chartList) {
                if (line == id) return true;
            }
        }
        return false;
    }
    public static void deleteChartLine(int id) {
        synchronized (chartList) {
            for (int i = 0; i < chartList.size(); i++) {
                if (chartList.get(i) == id) {
                    chartList.remove(i);
                    return;
                }
            }
        }

    }


    public static List<ChartLine> getChartIdList() {
        List<ChartLine> chartItemList = new ArrayList<>();
        synchronized (chartList) {
            for (int id : chartList) {
                Company company;
                synchronized (company = (Company) getGood(id)) {
                    ChartLine chartLine = new ChartLine(company.getId(), company.getName());
                    List<Double> valueList = new ArrayList<>();
                    List<Double> from = company.getValueList();
                    for (double val : from) {
                        valueList.add(val);
                    }
                    chartLine.setList(valueList);
                    chartItemList.add(chartLine);
                }
            }
        }


        return chartItemList;
    }
}
