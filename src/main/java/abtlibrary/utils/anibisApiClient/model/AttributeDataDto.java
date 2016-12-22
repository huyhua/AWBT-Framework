package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;
import java.util.Date;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class AttributeDataDto   {
  
  private Integer attributeId = null;
  private Integer attributeEntryId = null;
  private String inputText = null;
  private Double inputNumber = null;
  private Date inputDate = null;

  
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
  @JsonProperty("AttributeEntryId")
  public Integer getAttributeEntryId() {
    return attributeEntryId;
  }
  public void setAttributeEntryId(Integer attributeEntryId) {
    this.attributeEntryId = attributeEntryId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("InputText")
  public String getInputText() {
    return inputText;
  }
  public void setInputText(String inputText) {
    this.inputText = inputText;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("InputNumber")
  public Double getInputNumber() {
    return inputNumber;
  }
  public void setInputNumber(Double inputNumber) {
    this.inputNumber = inputNumber;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("InputDate")
  public Date getInputDate() {
    return inputDate;
  }
  public void setInputDate(Date inputDate) {
    this.inputDate = inputDate;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributeDataDto {\n");
    
    sb.append("    attributeId: ").append(StringUtil.toIndentedString(attributeId)).append("\n");
    sb.append("    attributeEntryId: ").append(StringUtil.toIndentedString(attributeEntryId)).append("\n");
    sb.append("    inputText: ").append(StringUtil.toIndentedString(inputText)).append("\n");
    sb.append("    inputNumber: ").append(StringUtil.toIndentedString(inputNumber)).append("\n");
    sb.append("    inputDate: ").append(StringUtil.toIndentedString(inputDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
