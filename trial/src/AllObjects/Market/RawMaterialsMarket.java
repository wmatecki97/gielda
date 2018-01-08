package AllObjects.Market;

import AllObjects.Clients.InvestmentFund;
import AllObjects.Goods.Currency;
import AllObjects.Goods.Goods;
import AllObjects.Goods.RawMaterials;
import AllObjects.functionalClasses.MenuFunctionality;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RawMaterialsMarket extends Market implements Serializable {


    public RawMaterialsMarket(){

        List<Goods> rawMaterialList = MenuFunctionality.getRawMaterialList();
        goodsList = new ArrayList<Goods>();

        for(Goods material: rawMaterialList){

            goodsList.add(material);
        }
    }

    @Override
    public synchronized void buy(InvestmentFund client, double cost){
        Goods subject;
        synchronized (subject = getRandomGood()){
            RawMaterials rawMaterials = (RawMaterials) subject;
            Currency currency = (Currency) MenuFunctionality.getGood(rawMaterials.getCurrencyId());
            cost/=currency.getValue();
            buy(client, subject, cost);
        }
    }

    public synchronized void add(RawMaterials rawMaterial){
        goodsList.add(rawMaterial);
    }

}
