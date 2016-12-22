package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;
import abtlibrary.utils.anibisApiClient.model.AddressModel;
import java.util.*;
import java.util.Map;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class AdvertInsertion   {
  
  private Integer id = null;
  private String title = null;
  private String description = null;

public enum ContactTypeEnum {
  NONE("None"),
  FORM("Form"),
  PHONE("Phone"),
  SHOWLOCATION("ShowLocation");

  private String value;

  ContactTypeEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private ContactTypeEnum contactType = null;
  private Double price = null;
  private Map<String, String> attributes = new HashMap<String, String>();
  private Integer userId = null;
  private AddressModel contactAddress = null;
  private Integer categoryId = null;
  private String language = null;

  
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
  @JsonProperty("Title")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("ContactType")
  public ContactTypeEnum getContactType() {
    return contactType;
  }
  public void setContactType(ContactTypeEnum contactType) {
    this.contactType = contactType;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Price")
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Attributes")
  public Map<String, String> getAttributes() {
    return attributes;
  }
  public void setAttributes(Map<String, String> attributes) {
    this.attributes = attributes;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("UserId")
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("ContactAddress")
  public AddressModel getContactAddress() {
    return contactAddress;
  }
  public void setContactAddress(AddressModel contactAddress) {
    this.contactAddress = contactAddress;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("CategoryId")
  public Integer getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Language")
  public String getLanguage() {
    return language;
  }
  public void setLanguage(String language) {
    this.language = language;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdvertInsertion {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    title: ").append(StringUtil.toIndentedString(title)).append("\n");
    sb.append("    description: ").append(StringUtil.toIndentedString(description)).append("\n");
    sb.append("    contactType: ").append(StringUtil.toIndentedString(contactType)).append("\n");
    sb.append("    price: ").append(StringUtil.toIndentedString(price)).append("\n");
    sb.append("    attributes: ").append(StringUtil.toIndentedString(attributes)).append("\n");
    sb.append("    userId: ").append(StringUtil.toIndentedString(userId)).append("\n");
    sb.append("    contactAddress: ").append(StringUtil.toIndentedString(contactAddress)).append("\n");
    sb.append("    categoryId: ").append(StringUtil.toIndentedString(categoryId)).append("\n");
    sb.append("    language: ").append(StringUtil.toIndentedString(language)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
