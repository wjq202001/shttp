package test.models;

/**
 * Created by Wang Juqiang on 2018/3/18.
 */

public class Info {
    int dealerId;
    String sellPhone;
    String companySimple;

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    public void setSellPhone(String sellPhone) {
        this.sellPhone = sellPhone;
    }

    public void setCompanySimple(String companySimple) {
        this.companySimple = companySimple;
    }

    public int getDealerId() {
        return dealerId;
    }

    public String getSellPhone() {
        return sellPhone;
    }

    public String getCompanySimple() {
        return companySimple;
    }
}
