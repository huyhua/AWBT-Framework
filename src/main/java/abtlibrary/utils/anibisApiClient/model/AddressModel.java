package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class AddressModel   {
  
  private String name = null;
  private String firstName = null;
  private String lastName = null;

public enum GenderEnum {
  UNKNOWN("Unknown"),
  MALE("Male"),
  FEMALE("Female");

  private String value;

  GenderEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private GenderEnum gender = null;
  private String street = null;
  private String ZIP = null;
  private String city = null;
  private String phone = null;
  private String phoneMobile = null;
  private String phonePrivate = null;
  private String countryCode = null;
  private Boolean allowEMail = null;
  private Double latitude = null;
  private Double longitude = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("FirstName")
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("LastName")
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Gender")
  public GenderEnum getGender() {
    return gender;
  }
  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Street")
  public String getStreet() {
    return street;
  }
  public void setStreet(String street) {
    this.street = street;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("ZIP")
  public String getZIP() {
    return ZIP;
  }
  public void setZIP(String ZIP) {
    this.ZIP = ZIP;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("City")
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Phone")
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("PhoneMobile")
  public String getPhoneMobile() {
    return phoneMobile;
  }
  public void setPhoneMobile(String phoneMobile) {
    this.phoneMobile = phoneMobile;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("PhonePrivate")
  public String getPhonePrivate() {
    return phonePrivate;
  }
  public void setPhonePrivate(String phonePrivate) {
    this.phonePrivate = phonePrivate;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("CountryCode")
  public String getCountryCode() {
    return countryCode;
  }
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("AllowEMail")
  public Boolean getAllowEMail() {
    return allowEMail;
  }
  public void setAllowEMail(Boolean allowEMail) {
    this.allowEMail = allowEMail;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Latitude")
  public Double getLatitude() {
    return latitude;
  }
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Longitude")
  public Double getLongitude() {
    return longitude;
  }
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressModel {\n");
    
    sb.append("    name: ").append(StringUtil.toIndentedString(name)).append("\n");
    sb.append("    firstName: ").append(StringUtil.toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(StringUtil.toIndentedString(lastName)).append("\n");
    sb.append("    gender: ").append(StringUtil.toIndentedString(gender)).append("\n");
    sb.append("    street: ").append(StringUtil.toIndentedString(street)).append("\n");
    sb.append("    ZIP: ").append(StringUtil.toIndentedString(ZIP)).append("\n");
    sb.append("    city: ").append(StringUtil.toIndentedString(city)).append("\n");
    sb.append("    phone: ").append(StringUtil.toIndentedString(phone)).append("\n");
    sb.append("    phoneMobile: ").append(StringUtil.toIndentedString(phoneMobile)).append("\n");
    sb.append("    phonePrivate: ").append(StringUtil.toIndentedString(phonePrivate)).append("\n");
    sb.append("    countryCode: ").append(StringUtil.toIndentedString(countryCode)).append("\n");
    sb.append("    allowEMail: ").append(StringUtil.toIndentedString(allowEMail)).append("\n");
    sb.append("    latitude: ").append(StringUtil.toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(StringUtil.toIndentedString(longitude)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
