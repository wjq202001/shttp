package test.models;

/**
 * Created by Wang Juqiang on 2018/3/21.
 */
public class OrderInfo {
    private int specId;
    private String userPhone;
    private int cityId;
    private int dealerId;

    public int getSpecId() {
        return specId;
    }

    public void setSpecId(int specId) {
        this.specId = specId;
    }

    public void setUserPhone(String userPone) {
        this.userPhone = userPone;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public int getCityId() {
        return cityId;
    }

    public int getDealerId() {
        return dealerId;
    }
}
