package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;
import abtlibrary.utils.anibisApiClient.model.AttributeSearchParametersDto;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class SearchParameterDto   {
  
  private Integer categoryId = null;
  private Integer memberId = null;
  private String username = null;
  private String language = null;
  private Boolean useLanguageFilter = null;
  private Boolean withImagesOnly = null;

public enum AdvertTypeEnum {
  UNKNOWN("Unknown"),
  TEXT("Text"),
  HTML("Html"),
  MARKDOWN("Markdown");

  private String value;

  AdvertTypeEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private AdvertTypeEnum advertType = null;
  private String searchText = null;
  private String searchLocation = null;
  private Integer searchDistance = null;
  private String stateCode = null;
  private Integer resultRows = null;
  private Integer resultStart = null;
  private String sortField = null;
  private Boolean sortOrder = null;
  private AttributeSearchParametersDto attributeFilter = null;

  
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
  @JsonProperty("MemberId")
  public Integer getMemberId() {
    return memberId;
  }
  public void setMemberId(Integer memberId) {
    this.memberId = memberId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Username")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
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
  @JsonProperty("UseLanguageFilter")
  public Boolean getUseLanguageFilter() {
    return useLanguageFilter;
  }
  public void setUseLanguageFilter(Boolean useLanguageFilter) {
    this.useLanguageFilter = useLanguageFilter;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("WithImagesOnly")
  public Boolean getWithImagesOnly() {
    return withImagesOnly;
  }
  public void setWithImagesOnly(Boolean withImagesOnly) {
    this.withImagesOnly = withImagesOnly;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("AdvertType")
  public AdvertTypeEnum getAdvertType() {
    return advertType;
  }
  public void setAdvertType(AdvertTypeEnum advertType) {
    this.advertType = advertType;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("SearchText")
  public String getSearchText() {
    return searchText;
  }
  public void setSearchText(String searchText) {
    this.searchText = searchText;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("SearchLocation")
  public String getSearchLocation() {
    return searchLocation;
  }
  public void setSearchLocation(String searchLocation) {
    this.searchLocation = searchLocation;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("SearchDistance")
  public Integer getSearchDistance() {
    return searchDistance;
  }
  public void setSearchDistance(Integer searchDistance) {
    this.searchDistance = searchDistance;
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
  @JsonProperty("ResultRows")
  public Integer getResultRows() {
    return resultRows;
  }
  public void setResultRows(Integer resultRows) {
    this.resultRows = resultRows;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("ResultStart")
  public Integer getResultStart() {
    return resultStart;
  }
  public void setResultStart(Integer resultStart) {
    this.resultStart = resultStart;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("SortField")
  public String getSortField() {
    return sortField;
  }
  public void setSortField(String sortField) {
    this.sortField = sortField;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("SortOrder")
  public Boolean getSortOrder() {
    return sortOrder;
  }
  public void setSortOrder(Boolean sortOrder) {
    this.sortOrder = sortOrder;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("AttributeFilter")
  public AttributeSearchParametersDto getAttributeFilter() {
    return attributeFilter;
  }
  public void setAttributeFilter(AttributeSearchParametersDto attributeFilter) {
    this.attributeFilter = attributeFilter;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchParameterDto {\n");
    
    sb.append("    categoryId: ").append(StringUtil.toIndentedString(categoryId)).append("\n");
    sb.append("    memberId: ").append(StringUtil.toIndentedString(memberId)).append("\n");
    sb.append("    username: ").append(StringUtil.toIndentedString(username)).append("\n");
    sb.append("    language: ").append(StringUtil.toIndentedString(language)).append("\n");
    sb.append("    useLanguageFilter: ").append(StringUtil.toIndentedString(useLanguageFilter)).append("\n");
    sb.append("    withImagesOnly: ").append(StringUtil.toIndentedString(withImagesOnly)).append("\n");
    sb.append("    advertType: ").append(StringUtil.toIndentedString(advertType)).append("\n");
    sb.append("    searchText: ").append(StringUtil.toIndentedString(searchText)).append("\n");
    sb.append("    searchLocation: ").append(StringUtil.toIndentedString(searchLocation)).append("\n");
    sb.append("    searchDistance: ").append(StringUtil.toIndentedString(searchDistance)).append("\n");
    sb.append("    stateCode: ").append(StringUtil.toIndentedString(stateCode)).append("\n");
    sb.append("    resultRows: ").append(StringUtil.toIndentedString(resultRows)).append("\n");
    sb.append("    resultStart: ").append(StringUtil.toIndentedString(resultStart)).append("\n");
    sb.append("    sortField: ").append(StringUtil.toIndentedString(sortField)).append("\n");
    sb.append("    sortOrder: ").append(StringUtil.toIndentedString(sortOrder)).append("\n");
    sb.append("    attributeFilter: ").append(StringUtil.toIndentedString(attributeFilter)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
