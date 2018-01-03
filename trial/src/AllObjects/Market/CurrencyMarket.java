package AllObjects.Market;

import AllObjects.Goods.Currency;
import AllObjects.Goods.Goods;
import AllObjects.Goods.RawMaterials;
import functionalClasses.AdditionalFunctions;
import functionalClasses.AllInstancess;
import functionalClasses.MenuFunctionality;

import java.util.ArrayList;
import java.util.List;

public class CurrencyMarket extends Market {

    public CurrencyMarket(){

        List<Goods> currencyList = MenuFunctionality.getCurrencyList();
        goodsList = new ArrayList<>();

        for(Goods currency: currencyList){
            goodsList.add((Currency)currency);
        }
    }

    /*
    public synchronized List<Currency> getGoodsList() {

        List<Currency> result = new ArrayList<>();
        for(Goods good: goodsList) {
            result.add((Currency)good);
        }
        return result;
    }
*/
    public synchronized void add(Currency currency){
        goodsList.add(currency);
    }
}
