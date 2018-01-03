package AllObjects.Market;

import AllObjects.Goods.Currency;
import AllObjects.Goods.RawMaterials;
import functionalClasses.AdditionalFunctions;
import functionalClasses.AllInstancess;
import functionalClasses.MenuFunctionality;

import java.util.ArrayList;
import java.util.List;

public class RawMaterialsMarket extends Market {


    public RawMaterialsMarket(){

        List<AllInstancess> rawMaterialList = MenuFunctionality.getRawMaterialList();
        goodsList = new ArrayList<>();

        for(AllInstancess material: rawMaterialList){
            goodsList.add(material);
        }
    }

}
