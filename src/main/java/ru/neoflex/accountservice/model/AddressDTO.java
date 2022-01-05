package ru.neoflex.accountservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Enumerated;
import java.util.Objects;

import static javax.persistence.EnumType.STRING;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDTO {

    @JsonProperty(value = "city")
    private String city;

    @JsonProperty(value = "street_name")
    private String streetName;

    @JsonProperty(value = "street_address")
    private String streetAddress;

    @JsonProperty(value = "building_number")
    private String buildingNumber;

    @JsonProperty(value = "zip_code")
    private String zipCode;

    @JsonProperty(value = "postcode")
    private String postCode;

    @JsonProperty(value = "country")
    @Enumerated(STRING)
    private String country;

    public AddressDTO(String city, String streetName, String streetAddress, String buildingNumber, String zipCode, String postCode, String country) {
        this.city = city;
        this.streetName = streetName;
        this.streetAddress = streetAddress;
        this.buildingNumber = buildingNumber;
        this.zipCode = zipCode;
        this.postCode = postCode;
        this.country = country;
    }

    public AddressDTO() {
    }

    public String getCity() {
        return city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressDTO)) return false;
        AddressDTO that = (AddressDTO) o;
        return Objects.equals(getCity(), that.getCity()) && Objects.equals(getStreetName(), that.getStreetName()) && Objects.equals(getStreetAddress(), that.getStreetAddress()) && Objects.equals(getBuildingNumber(), that.getBuildingNumber()) && Objects.equals(getZipCode(), that.getZipCode()) && Objects.equals(getPostCode(), that.getPostCode()) && Objects.equals(getCountry(), that.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreetName(), getStreetAddress(), getBuildingNumber(), getZipCode(), getPostCode(), getCountry());
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "city='" + city + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
