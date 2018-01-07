package AllObjects.functionalClasses;

import AllObjects.Clients.InvestmentFund;
import AllObjects.Clients.Investor;
import AllObjects.Goods.Company;
import AllObjects.Goods.Goods;
import AllObjects.Market.CurrencyMarket;
import AllObjects.Market.RawMaterialsMarket;
import AllObjects.ShareIndex;

import java.io.*;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SaveRead implements Serializable{

    private List<Investor> investorList;
    private List<InvestmentFund> investmentFundList;
    private List<Company> companyList;
    private List<Goods> currencyList;
    private List<AllInstancess> exchangeList;
    private List<Goods> rawMaterialList;
    private List<ShareIndex> shareIndexList;
    private CurrencyMarket currencyMarket;
    private RawMaterialsMarket rawMaterialsMarket;
    private AllInstancess displayedObject;
    private List<Integer> chartList;
    private String errorMessage;
    private Semaphore displaysemaphore;

    public SaveRead() {
        investorList=MenuFunctionality.getInvestorList();
        investmentFundList=MenuFunctionality.getInvestmentFundList();
        companyList=MenuFunctionality.getCompanyList();
        currencyList=MenuFunctionality.getCurrencyList();
        exchangeList=MenuFunctionality.getExchangeList();
        rawMaterialList=MenuFunctionality.getRawMaterialList();
        shareIndexList=MenuFunctionality.getShareIndexList();
        currencyMarket=MenuFunctionality.getCurrencyMarket();
        rawMaterialsMarket=MenuFunctionality.getRawMaterialsMarket();
        displayedObject=MenuFunctionality.getDisplayedObject();
        chartList=MenuFunctionality.getChartList();
        errorMessage=MenuFunctionality.getErrorMessage();
        displaysemaphore=new Semaphore(1);
    }

    public List<Investor> getInvestorList() {
        return investorList;
    }

    public List<InvestmentFund> getInvestmentFundList() {
        return investmentFundList;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public List<Goods> getCurrencyList() {
        return currencyList;
    }

    public List<AllInstancess> getExchangeList() {
        return exchangeList;
    }

    public List<Goods> getRawMaterialList() {
        return rawMaterialList;
    }

    public List<ShareIndex> getShareIndexList() {
        return shareIndexList;
    }

    public CurrencyMarket getCurrencyMarket() {
        return currencyMarket;
    }

    public RawMaterialsMarket getRawMaterialsMarket() {
        return rawMaterialsMarket;
    }

    public AllInstancess getDisplayedObject() {
        return displayedObject;
    }

    public List<Integer> getChartList() {
        return chartList;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Semaphore getDisplaysemaphore() {
        return displaysemaphore;
    }
}
