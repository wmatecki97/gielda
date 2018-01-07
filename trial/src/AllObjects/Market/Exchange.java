package AllObjects.Market;

import AllObjects.Clients.InvestmentFund;
import AllObjects.Goods.Company;
import AllObjects.Goods.Goods;
import AllObjects.functionalClasses.AdditionalFunctions;
import AllObjects.functionalClasses.AllInstancess;
import AllObjects.functionalClasses.DataGenerator.DataGenerator;
import AllObjects.functionalClasses.MenuFunctionality;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Exchange extends Market implements AllInstancess, Serializable {
    private String name;
    private String country;
    private String currency;
    private String city;
    private String adress;
    private List<String> indexList;


    public Exchange(){

        indexList = new ArrayList<String>();
        name = DataGenerator.getExchangeName();
        country = DataGenerator.getCountry();
        List<Goods> curList = MenuFunctionality.getCurrencyList();
        Goods good = curList.get(AdditionalFunctions.getRandom(0,curList.size()-1));
        currency = good.getName();
        city = DataGenerator.getCity();
        adress = DataGenerator.getStreet();


        //Adding companys to the list
        List<Company> companyList = MenuFunctionality.getCompanyList();
        goodsList = new ArrayList<>();

        for(Company companny: companyList){
            if(goodsList.size()==0 || AdditionalFunctions.getRandom(0,5)==0){
                goodsList.add(companny);
            }
        }
        updateGoods();



    }

    private synchronized void updateGoods(){

        List<String> list = new ArrayList<>();

        for(int i=0; i<goodsList.size(); i++){
            Goods temp =  (Goods)goodsList.get(i);
            list.add(temp.getName());
        }
        goods = AdditionalFunctions.ListToString(list);

    }

    @Override
    public synchronized void buy (InvestmentFund client, double cost){

        Goods subject = getRandomGood();
        if(subject.checkIfIsEnough(cost-cost*markup)==false){
            Company temp =(Company)subject;
            double amounnt = temp.getActionsLeft();
            cost = amounnt*subject.getValue()/(1-markup);
        }


        super.buy(client,subject, cost);
        
        
        
       /* Goods toBuy = (Goods) goodsList.get(AdditionalFunctions.getRandom(0,goodsList.size()-1));

        AllPurchases purchasesList = MenuFunctionality.getPurchasesList();
        Purchase purchase = new Purchase(client.getId(), toBuy.getId(), cost);

        AllPurchases.addToList(purchase);
        toBuy.buy(cost, client, markup);
*/
    }

    public synchronized String getOutputString(){

        String output="";

        output=name + " " + country + " " + currency + " " + city + " " + adress + " " + markup + AdditionalFunctions.ListToString(indexList);
        return output;
    };

    public synchronized Exchange setValues(String inputString){

        String[] strArr = AdditionalFunctions.split(inputString);
        Exchange output = new Exchange();

        output.name = strArr[0];
        output.country = strArr[1];
        output.currency = strArr[2];
        output.city= strArr[3];
        output.adress= strArr[4];
        output.markup = Double.parseDouble(strArr[5]);

        for(int i=6; i<strArr.length; i++)
        {
            output.indexList.add(strArr[i]);
        }

        return output;
    };

    public synchronized void display(){
        System.out.println("nazwa: " + name + " kraj: " + country+ " waluta: " + currency + " miasto: " + city + " adres: " + adress + "lista indeksw " + indexList + " marża: " + markup );
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized String getCountry() {
        return country;
    }

    public synchronized void setCountry(String country) {
        this.country = country;
    }

    public synchronized String getCurrency() {
        return currency;
    }

    public synchronized void setCurrency(String currency) {
        this.currency = currency;
    }

    public synchronized String getCity() {
        return city;
    }

    public synchronized void setCity(String city) {
        this.city = city;
    }

    public synchronized String getAdress() {
        return adress;
    }

    public synchronized void setAdress(String adress) {
        this.adress = adress;
    }

    public synchronized double getMarkup() {
        return markup;
    }

    public synchronized void setMarkup(double markup) {
        this.markup = markup;
    }

    private volatile String goods;

    public synchronized String getGoods() {
        return goods;
    }

    public synchronized void addToGoodsList(Goods good){

        goodsList.add(good);
        updateGoods();

    }

}
