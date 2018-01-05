package AllObjects.functionalClasses;

import AllObjects.*;
import AllObjects.Clients.Client;
import AllObjects.Clients.InvestmentFund;
import AllObjects.Clients.Investor;
import AllObjects.Goods.Company;
import AllObjects.Goods.Currency;
import AllObjects.Goods.Goods;
import AllObjects.Goods.RawMaterials;
import AllObjects.Market.CurrencyMarket;
import AllObjects.Market.Exchange;
import AllObjects.Market.Market;
import AllObjects.Market.RawMaterialsMarket;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

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
    static Semaphore sem;

    public static void initialize(){

        //TEMPORARY
        currencyList = new ArrayList<>();
        rawMaterialList = new ArrayList<>();

        currencyMarket = new CurrencyMarket();
        rawMaterialsMarket = new RawMaterialsMarket();
        currencyList = currencyMarket.getGoodsList();
        rawMaterialList= rawMaterialsMarket.getGoodsList();

        investorList = new ArrayList<>();
        investmentFundList = new ArrayList<>();
        companyList = new ArrayList<>();
        exchangeList = new ArrayList<>();
        shareIndexList = new ArrayList<>();

        sem = new Semaphore(1);

    }
    
    public static void addCompanyToExchanges(Goods g){
        List<AllInstancess> list = MenuFunctionality.getExchangeList();
        for(int i=0; i<list.size(); i++){
            if(AdditionalFunctions.getRandom(0,5)==0){
                Exchange temp = (Exchange)  list.get(i);
                temp.addToGoodsList(g);
            }
        }
    }

    public static void addNewInvestor(){Investor inv = new Investor(); investorList.add(inv); Thread t = new Thread(inv); t.start();}
    public static void addNewInvestmentFund(){InvestmentFund inv = new InvestmentFund(); investmentFundList.add(inv);  Thread t = new Thread(inv);  t.start();}
    public static void addNewCompany(){Company c = new Company(); companyList.add(c); addCompanyToExchanges(c);Thread t = new Thread(c);  t.start();}
    public static void addNewCurrency(){
        Currency c = new Currency();
        currencyList.add(c);
    }
    public static void addNewExchange(){exchangeList.add(new Exchange());}
    public static void addNewRawMaterial(){rawMaterialList.add(new RawMaterials());}

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

    public static Market getrandomMarket() {

        int rand = AdditionalFunctions.getRandom(0,2);
        if(rand==0)return (Market)currencyMarket;
        if(rand==1)return (Market)rawMaterialsMarket;
        if(rand==2)return (Market)exchangeList.get(AdditionalFunctions.getRandom(0,exchangeList.size()-1));

        return null;
    }

    public static AllInstancess getDisplayedObject() { 
        return displayedObject;
    }//is synchronized

    public static void releaseSemaphore(){
        sem.release();
    }//is synchronized

    public static void setDisplayedObject(AllInstancess displayedObject) {
        try {
            sem.acquire();
        } catch (InterruptedException e) {}
        MenuFunctionality.displayedObject = displayedObject;
    }//is synchronized

    public static HasName getGood(int id){
        synchronized (companyList){
            for(Goods good : companyList){
                if(good.getId() == id)
                    return good;
            }
        }
        synchronized (currencyList){
            for(Goods good : currencyList){
                if(good.getId() == id)
                    return good;
            }
        }
        synchronized (rawMaterialList){
            for(Goods good : rawMaterialList){
                if(good.getId() == id)
                    return good;
            }
        }
        synchronized (investmentFundList){
            for(InvestmentFund fund: investmentFundList){
                if(fund.getId()==id)
                    return fund;
            }
        }
        return null;
    }//is synchronized

    public static void goodHasBeenDeleted(int id){

        synchronized (investmentFundList){
            for(InvestmentFund fund: investmentFundList){
                fund.goodHasBeenDeleted(id);
            }
        }
        synchronized (investorList){
            for(Investor investor: investorList){
                investor.goodHasBeenDeleted(id);
            }
        }

    }

    public static InvestmentFund getInvestmentFund(int investmentFundId){

        return null;
    }

    public static void deleteObject(int objectId){

        synchronized (investmentFundList){
            for(int i=0; i<investmentFundList.size(); i++){
                if(investmentFundList.get(i).getId()==objectId){
                    investmentFundList.remove(i);
                    goodHasBeenDeleted(objectId);
                    return;
                }
            }
        }
        synchronized (investorList){
            
            for(int i=0; i<investorList.size(); i++){
                if(investorList.get(i).getId() == objectId){
                    investorList.remove(i);
                    return;                    
                }
            }
        }
        synchronized (companyList){
            for(int i=0; i<companyList.size(); i++){
                if(companyList.get(i).getId() == objectId){
                    companyList.remove(i);
                    goodHasBeenDeleted(objectId);
                    return;
                }
            }
        }



    }// is synchronized

}
