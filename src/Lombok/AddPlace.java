package Lombok;

import java.util.List;

public class AddPlace {

    private int accuracy;
    private String name;
    private String phoneNumber;
    private String address;
    private String website;
    private String language;
    private Location location;
    private List<String> types;

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public static class Builder {
        private final AddPlace place = new AddPlace();

        public Builder accuracy(int accuracy) { place.setAccuracy(accuracy); return this; }
        public Builder name(String name) { place.setName(name); return this; }
        public Builder phoneNumber(String phoneNumber) { place.setPhoneNumber(phoneNumber); return this; }
        public Builder address(String address) { place.setAddress(address); return this; }
        public Builder website(String website) { place.setWebsite(website); return this; }
        public Builder language(String language) { place.setLanguage(language); return this; }
        public Builder location(Location location) { place.setLocation(location); return this; }
        public Builder types(List<String> types) { place.setTypes(types); return this; }

        public AddPlace build() { return place; }
    }

}