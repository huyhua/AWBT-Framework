package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class ProductDto   {
  
  private Integer id = null;
  private String language = null;
  private String name = null;
  private String description = null;
  private String type = null;
  private String unitType = null;
  private String unitTypePlural = null;
  private Double unitPrice = null;
  private Integer unitMinAmount = null;
  private Integer unitMaxAmount = null;
  private Integer unitDefaultAmount = null;
  private Integer maxAdverts = null;

  
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
  @JsonProperty("Language")
  public String getLanguage() {
    return language;
  }
  public void setLanguage(String language) {
    this.language = language;
  }

  
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
  @JsonProperty("Type")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("UnitType")
  public String getUnitType() {
    return unitType;
  }
  public void setUnitType(String unitType) {
    this.unitType = unitType;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("UnitTypePlural")
  public String getUnitTypePlural() {
    return unitTypePlural;
  }
  public void setUnitTypePlural(String unitTypePlural) {
    this.unitTypePlural = unitTypePlural;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("UnitPrice")
  public Double getUnitPrice() {
    return unitPrice;
  }
  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("UnitMinAmount")
  public Integer getUnitMinAmount() {
    return unitMinAmount;
  }
  public void setUnitMinAmount(Integer unitMinAmount) {
    this.unitMinAmount = unitMinAmount;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("UnitMaxAmount")
  public Integer getUnitMaxAmount() {
    return unitMaxAmount;
  }
  public void setUnitMaxAmount(Integer unitMaxAmount) {
    this.unitMaxAmount = unitMaxAmount;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("UnitDefaultAmount")
  public Integer getUnitDefaultAmount() {
    return unitDefaultAmount;
  }
  public void setUnitDefaultAmount(Integer unitDefaultAmount) {
    this.unitDefaultAmount = unitDefaultAmount;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("MaxAdverts")
  public Integer getMaxAdverts() {
    return maxAdverts;
  }
  public void setMaxAdverts(Integer maxAdverts) {
    this.maxAdverts = maxAdverts;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductDto {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    language: ").append(StringUtil.toIndentedString(language)).append("\n");
    sb.append("    name: ").append(StringUtil.toIndentedString(name)).append("\n");
    sb.append("    description: ").append(StringUtil.toIndentedString(description)).append("\n");
    sb.append("    type: ").append(StringUtil.toIndentedString(type)).append("\n");
    sb.append("    unitType: ").append(StringUtil.toIndentedString(unitType)).append("\n");
    sb.append("    unitTypePlural: ").append(StringUtil.toIndentedString(unitTypePlural)).append("\n");
    sb.append("    unitPrice: ").append(StringUtil.toIndentedString(unitPrice)).append("\n");
    sb.append("    unitMinAmount: ").append(StringUtil.toIndentedString(unitMinAmount)).append("\n");
    sb.append("    unitMaxAmount: ").append(StringUtil.toIndentedString(unitMaxAmount)).append("\n");
    sb.append("    unitDefaultAmount: ").append(StringUtil.toIndentedString(unitDefaultAmount)).append("\n");
    sb.append("    maxAdverts: ").append(StringUtil.toIndentedString(maxAdverts)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
