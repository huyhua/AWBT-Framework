package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class CategoryAttributesDto   {
  
  private Integer categoryId = null;
  private Integer attributeId = null;
  private Integer sortOrder = null;
  private Boolean isMandatory = null;
  private Boolean isMainSearch = null;
  private Boolean isInSummary = null;
  private Boolean isSearchable = null;

  
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
  @JsonProperty("AttributeId")
  public Integer getAttributeId() {
    return attributeId;
  }
  public void setAttributeId(Integer attributeId) {
    this.attributeId = attributeId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("SortOrder")
  public Integer getSortOrder() {
    return sortOrder;
  }
  public void setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("IsMandatory")
  public Boolean getIsMandatory() {
    return isMandatory;
  }
  public void setIsMandatory(Boolean isMandatory) {
    this.isMandatory = isMandatory;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("IsMainSearch")
  public Boolean getIsMainSearch() {
    return isMainSearch;
  }
  public void setIsMainSearch(Boolean isMainSearch) {
    this.isMainSearch = isMainSearch;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("IsInSummary")
  public Boolean getIsInSummary() {
    return isInSummary;
  }
  public void setIsInSummary(Boolean isInSummary) {
    this.isInSummary = isInSummary;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("IsSearchable")
  public Boolean getIsSearchable() {
    return isSearchable;
  }
  public void setIsSearchable(Boolean isSearchable) {
    this.isSearchable = isSearchable;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryAttributesDto {\n");
    
    sb.append("    categoryId: ").append(StringUtil.toIndentedString(categoryId)).append("\n");
    sb.append("    attributeId: ").append(StringUtil.toIndentedString(attributeId)).append("\n");
    sb.append("    sortOrder: ").append(StringUtil.toIndentedString(sortOrder)).append("\n");
    sb.append("    isMandatory: ").append(StringUtil.toIndentedString(isMandatory)).append("\n");
    sb.append("    isMainSearch: ").append(StringUtil.toIndentedString(isMainSearch)).append("\n");
    sb.append("    isInSummary: ").append(StringUtil.toIndentedString(isInSummary)).append("\n");
    sb.append("    isSearchable: ").append(StringUtil.toIndentedString(isSearchable)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
