package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class NumericRangeDto   {
  
  private Integer id = null;
  private Boolean isInteger = null;
  private Boolean isDescending = null;
  private Boolean isDynamic = null;
  private Double minValue = null;
  private Double maxValue = null;
  private Double stepValue = null;
  private String stringFormat = null;

  
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
  @JsonProperty("IsInteger")
  public Boolean getIsInteger() {
    return isInteger;
  }
  public void setIsInteger(Boolean isInteger) {
    this.isInteger = isInteger;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("IsDescending")
  public Boolean getIsDescending() {
    return isDescending;
  }
  public void setIsDescending(Boolean isDescending) {
    this.isDescending = isDescending;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("IsDynamic")
  public Boolean getIsDynamic() {
    return isDynamic;
  }
  public void setIsDynamic(Boolean isDynamic) {
    this.isDynamic = isDynamic;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("MinValue")
  public Double getMinValue() {
    return minValue;
  }
  public void setMinValue(Double minValue) {
    this.minValue = minValue;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("MaxValue")
  public Double getMaxValue() {
    return maxValue;
  }
  public void setMaxValue(Double maxValue) {
    this.maxValue = maxValue;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("StepValue")
  public Double getStepValue() {
    return stepValue;
  }
  public void setStepValue(Double stepValue) {
    this.stepValue = stepValue;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("StringFormat")
  public String getStringFormat() {
    return stringFormat;
  }
  public void setStringFormat(String stringFormat) {
    this.stringFormat = stringFormat;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class NumericRangeDto {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    isInteger: ").append(StringUtil.toIndentedString(isInteger)).append("\n");
    sb.append("    isDescending: ").append(StringUtil.toIndentedString(isDescending)).append("\n");
    sb.append("    isDynamic: ").append(StringUtil.toIndentedString(isDynamic)).append("\n");
    sb.append("    minValue: ").append(StringUtil.toIndentedString(minValue)).append("\n");
    sb.append("    maxValue: ").append(StringUtil.toIndentedString(maxValue)).append("\n");
    sb.append("    stepValue: ").append(StringUtil.toIndentedString(stepValue)).append("\n");
    sb.append("    stringFormat: ").append(StringUtil.toIndentedString(stringFormat)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
