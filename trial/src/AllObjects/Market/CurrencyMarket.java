package AllObjects.Market;

import AllObjects.Goods.Currency;
import functionalClasses.AdditionalFunctions;
import functionalClasses.AllInstancess;
import functionalClasses.MenuFunctionality;

import java.util.ArrayList;
import java.util.List;

public class CurrencyMarket extends Market {

    public CurrencyMarket(){

        List<AllInstancess> currencyList = MenuFunctionality.getCurrencyList();
        goodsList = new ArrayList<>();

        for(AllInstancess currency: currencyList){
            goodsList.add(currency);
        }
    }

}
