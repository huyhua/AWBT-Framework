package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;
import java.util.*;
import java.util.Date;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class AdvertDto   {
  
  private Integer id = null;
  private Integer sourceId = null;
  private String externalCode = null;

public enum TypeEnum {
  UNKNOWN("Unknown"),
  TEXT("Text"),
  HTML("Html"),
  MARKDOWN("Markdown");

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
  private Integer state = null;
  private String title = null;
  private String _abstract = null;
  private String description = null;
  private Double price = null;
  private String location = null;
  private Integer userId = null;
  private Integer categoryId = null;
  private List<Integer> productIds = new ArrayList<Integer>();
  private Date modified = null;
  private Date posted = null;
  private Date expiring = null;
  private String thumbnail = null;
  private Integer hits = null;

  
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
  @JsonProperty("SourceId")
  public Integer getSourceId() {
    return sourceId;
  }
  public void setSourceId(Integer sourceId) {
    this.sourceId = sourceId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("ExternalCode")
  public String getExternalCode() {
    return externalCode;
  }
  public void setExternalCode(String externalCode) {
    this.externalCode = externalCode;
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
  @JsonProperty("State")
  public Integer getState() {
    return state;
  }
  public void setState(Integer state) {
    this.state = state;
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
  @JsonProperty("Abstract")
  public String getAbstract() {
    return _abstract;
  }
  public void setAbstract(String _abstract) {
    this._abstract = _abstract;
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
  @JsonProperty("Location")
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
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
  @JsonProperty("ProductIds")
  public List<Integer> getProductIds() {
    return productIds;
  }
  public void setProductIds(List<Integer> productIds) {
    this.productIds = productIds;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Modified")
  public Date getModified() {
    return modified;
  }
  public void setModified(Date modified) {
    this.modified = modified;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Posted")
  public Date getPosted() {
    return posted;
  }
  public void setPosted(Date posted) {
    this.posted = posted;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Expiring")
  public Date getExpiring() {
    return expiring;
  }
  public void setExpiring(Date expiring) {
    this.expiring = expiring;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Thumbnail")
  public String getThumbnail() {
    return thumbnail;
  }
  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Hits")
  public Integer getHits() {
    return hits;
  }
  public void setHits(Integer hits) {
    this.hits = hits;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdvertDto {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    sourceId: ").append(StringUtil.toIndentedString(sourceId)).append("\n");
    sb.append("    externalCode: ").append(StringUtil.toIndentedString(externalCode)).append("\n");
    sb.append("    type: ").append(StringUtil.toIndentedString(type)).append("\n");
    sb.append("    state: ").append(StringUtil.toIndentedString(state)).append("\n");
    sb.append("    title: ").append(StringUtil.toIndentedString(title)).append("\n");
    sb.append("    _abstract: ").append(StringUtil.toIndentedString(_abstract)).append("\n");
    sb.append("    description: ").append(StringUtil.toIndentedString(description)).append("\n");
    sb.append("    price: ").append(StringUtil.toIndentedString(price)).append("\n");
    sb.append("    location: ").append(StringUtil.toIndentedString(location)).append("\n");
    sb.append("    userId: ").append(StringUtil.toIndentedString(userId)).append("\n");
    sb.append("    categoryId: ").append(StringUtil.toIndentedString(categoryId)).append("\n");
    sb.append("    productIds: ").append(StringUtil.toIndentedString(productIds)).append("\n");
    sb.append("    modified: ").append(StringUtil.toIndentedString(modified)).append("\n");
    sb.append("    posted: ").append(StringUtil.toIndentedString(posted)).append("\n");
    sb.append("    expiring: ").append(StringUtil.toIndentedString(expiring)).append("\n");
    sb.append("    thumbnail: ").append(StringUtil.toIndentedString(thumbnail)).append("\n");
    sb.append("    hits: ").append(StringUtil.toIndentedString(hits)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
