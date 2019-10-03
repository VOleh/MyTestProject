package model;

public class Contacts {
    private String homeTown;
    private String  mobilePhone;
    private String country;

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "homeTown='" + homeTown + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
