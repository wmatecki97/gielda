package functionalClasses;

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
import AllObjects.Purchases.AllPurchases;


import java.util.ArrayList;
import java.util.List;

public class MenuFunctionality {

    static List<Investor> investorList;
    static List<InvestmentFund> investmentFundList;
    static List<Company> companyList;
    static List<Goods> currencyList;
    static List<AllInstancess> exchangeList;
    static List<Goods> rawMaterialList;
    static List<ShareIndex> shareIndexList;
    static AllPurchases purchasesList;
    static CurrencyMarket currencyMarket;
    static RawMaterialsMarket rawMaterialsMarket;


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
        purchasesList = new AllPurchases();

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
    public static void addNewInvestmentFund(){investmentFundList.add(new InvestmentFund());}
    public static void addNewCompany(){Company c = new Company(); companyList.add(c); addCompanyToExchanges(c);}
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

    public static AllPurchases getPurchasesList() {
        return purchasesList;
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

    public static double getValueOfGood(int id){

       for(Goods good : companyList){
           if(good.getId() == id)
               return good.getValue();
       }
        for(Goods good : currencyList){
            if(good.getId() == id)
                return good.getValue();
        }
        for(Goods good : rawMaterialList){
            if(good.getId() == id)
                return good.getValue();
        }
       return 0.0;

    }
}
