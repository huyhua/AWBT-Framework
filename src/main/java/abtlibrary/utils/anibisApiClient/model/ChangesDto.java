package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;
import abtlibrary.utils.anibisApiClient.model.CategoryDto;
import abtlibrary.utils.anibisApiClient.model.AttributeDto;
import abtlibrary.utils.anibisApiClient.model.CategoryAttributesDto;
import java.util.*;
import abtlibrary.utils.anibisApiClient.model.TextResourceDto;
import java.util.Date;
import abtlibrary.utils.anibisApiClient.model.ProductDto;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class ChangesDto   {
  
  private Date checkTime = null;
  private List<CategoryDto> categories = new ArrayList<CategoryDto>();
  private List<AttributeDto> attributes = new ArrayList<AttributeDto>();
  private List<CategoryAttributesDto> categoryAttributes = new ArrayList<CategoryAttributesDto>();
  private List<ProductDto> products = new ArrayList<ProductDto>();
  private List<TextResourceDto> textResources = new ArrayList<TextResourceDto>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("CheckTime")
  public Date getCheckTime() {
    return checkTime;
  }
  public void setCheckTime(Date checkTime) {
    this.checkTime = checkTime;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Categories")
  public List<CategoryDto> getCategories() {
    return categories;
  }
  public void setCategories(List<CategoryDto> categories) {
    this.categories = categories;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Attributes")
  public List<AttributeDto> getAttributes() {
    return attributes;
  }
  public void setAttributes(List<AttributeDto> attributes) {
    this.attributes = attributes;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("CategoryAttributes")
  public List<CategoryAttributesDto> getCategoryAttributes() {
    return categoryAttributes;
  }
  public void setCategoryAttributes(List<CategoryAttributesDto> categoryAttributes) {
    this.categoryAttributes = categoryAttributes;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Products")
  public List<ProductDto> getProducts() {
    return products;
  }
  public void setProducts(List<ProductDto> products) {
    this.products = products;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("TextResources")
  public List<TextResourceDto> getTextResources() {
    return textResources;
  }
  public void setTextResources(List<TextResourceDto> textResources) {
    this.textResources = textResources;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChangesDto {\n");
    
    sb.append("    checkTime: ").append(StringUtil.toIndentedString(checkTime)).append("\n");
    sb.append("    categories: ").append(StringUtil.toIndentedString(categories)).append("\n");
    sb.append("    attributes: ").append(StringUtil.toIndentedString(attributes)).append("\n");
    sb.append("    categoryAttributes: ").append(StringUtil.toIndentedString(categoryAttributes)).append("\n");
    sb.append("    products: ").append(StringUtil.toIndentedString(products)).append("\n");
    sb.append("    textResources: ").append(StringUtil.toIndentedString(textResources)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
