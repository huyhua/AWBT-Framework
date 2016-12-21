package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class AddressDto   {
  
  private Integer id = null;

public enum TypeEnum {
  MAIN("Main"),
  BILLING("Billing"),
  DELIVERY("Delivery"),
  CONTACT("Contact"),
  LOCATION("Location");

  private String value;

  TypeEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private TypeEnum type = null;

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
  private String firstname = null;
  private String lastname = null;
  private String nameAddon = null;
  private String companyName = null;
  private String companyPosition = null;
  private String profession = null;
  private String street = null;
  private String streetAddon = null;
  private String pOBox = null;
  private String ZIP = null;
  private String city = null;
  private String stateCode = null;
  private String countryCode = null;
  private String phonePrivate = null;
  private String phoneBusiness = null;
  private String phoneFax = null;
  private String phoneMobile = null;
  private String eMail = null;
  private String URL = null;
  private Double latitude = null;
  private Double longitude = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Type")
  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
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
  @JsonProperty("Firstname")
  public String getFirstname() {
    return firstname;
  }
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Lastname")
  public String getLastname() {
    return lastname;
  }
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("NameAddon")
  public String getNameAddon() {
    return nameAddon;
  }
  public void setNameAddon(String nameAddon) {
    this.nameAddon = nameAddon;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("CompanyName")
  public String getCompanyName() {
    return companyName;
  }
  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("CompanyPosition")
  public String getCompanyPosition() {
    return companyPosition;
  }
  public void setCompanyPosition(String companyPosition) {
    this.companyPosition = companyPosition;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Profession")
  public String getProfession() {
    return profession;
  }
  public void setProfession(String profession) {
    this.profession = profession;
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
  @JsonProperty("StreetAddon")
  public String getStreetAddon() {
    return streetAddon;
  }
  public void setStreetAddon(String streetAddon) {
    this.streetAddon = streetAddon;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("POBox")
  public String getPOBox() {
    return pOBox;
  }
  public void setPOBox(String pOBox) {
    this.pOBox = pOBox;
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
  @JsonProperty("StateCode")
  public String getStateCode() {
    return stateCode;
  }
  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
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
  @JsonProperty("PhoneBusiness")
  public String getPhoneBusiness() {
    return phoneBusiness;
  }
  public void setPhoneBusiness(String phoneBusiness) {
    this.phoneBusiness = phoneBusiness;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("PhoneFax")
  public String getPhoneFax() {
    return phoneFax;
  }
  public void setPhoneFax(String phoneFax) {
    this.phoneFax = phoneFax;
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
  @JsonProperty("EMail")
  public String getEMail() {
    return eMail;
  }
  public void setEMail(String eMail) {
    this.eMail = eMail;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("URL")
  public String getURL() {
    return URL;
  }
  public void setURL(String URL) {
    this.URL = URL;
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
    sb.append("class AddressDto {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    type: ").append(StringUtil.toIndentedString(type)).append("\n");
    sb.append("    gender: ").append(StringUtil.toIndentedString(gender)).append("\n");
    sb.append("    firstname: ").append(StringUtil.toIndentedString(firstname)).append("\n");
    sb.append("    lastname: ").append(StringUtil.toIndentedString(lastname)).append("\n");
    sb.append("    nameAddon: ").append(StringUtil.toIndentedString(nameAddon)).append("\n");
    sb.append("    companyName: ").append(StringUtil.toIndentedString(companyName)).append("\n");
    sb.append("    companyPosition: ").append(StringUtil.toIndentedString(companyPosition)).append("\n");
    sb.append("    profession: ").append(StringUtil.toIndentedString(profession)).append("\n");
    sb.append("    street: ").append(StringUtil.toIndentedString(street)).append("\n");
    sb.append("    streetAddon: ").append(StringUtil.toIndentedString(streetAddon)).append("\n");
    sb.append("    pOBox: ").append(StringUtil.toIndentedString(pOBox)).append("\n");
    sb.append("    ZIP: ").append(StringUtil.toIndentedString(ZIP)).append("\n");
    sb.append("    city: ").append(StringUtil.toIndentedString(city)).append("\n");
    sb.append("    stateCode: ").append(StringUtil.toIndentedString(stateCode)).append("\n");
    sb.append("    countryCode: ").append(StringUtil.toIndentedString(countryCode)).append("\n");
    sb.append("    phonePrivate: ").append(StringUtil.toIndentedString(phonePrivate)).append("\n");
    sb.append("    phoneBusiness: ").append(StringUtil.toIndentedString(phoneBusiness)).append("\n");
    sb.append("    phoneFax: ").append(StringUtil.toIndentedString(phoneFax)).append("\n");
    sb.append("    phoneMobile: ").append(StringUtil.toIndentedString(phoneMobile)).append("\n");
    sb.append("    eMail: ").append(StringUtil.toIndentedString(eMail)).append("\n");
    sb.append("    URL: ").append(StringUtil.toIndentedString(URL)).append("\n");
    sb.append("    latitude: ").append(StringUtil.toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(StringUtil.toIndentedString(longitude)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
