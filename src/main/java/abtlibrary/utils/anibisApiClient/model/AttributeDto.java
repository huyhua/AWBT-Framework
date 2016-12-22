package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;
import java.util.*;
import abtlibrary.utils.anibisApiClient.model.AttributeEntryDto;
import abtlibrary.utils.anibisApiClient.model.NumericRangeDto;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class AttributeDto   {
  
  private Integer id = null;
  private Integer parentId = null;
  private String language = null;
  private String name = null;
  private String unit = null;
  private Integer defaultSelectItemId = null;

public enum TypeEnum {
  SELECTSINGLE("SelectSingle"),
  SELECTMULTI("SelectMulti"),
  SELECTMULTISEARCHSINGLE("SelectMultiSearchSingle"),
  INPUTTEXT("InputText"),
  INPUTTEXTSUGGEST("InputTextSuggest"),
  INPUTINT("InputInt"),
  INPUTDECIMAL("InputDecimal"),
  INPUTDATE("InputDate"),
  CHECKMARK("Checkmark"),
  SELECTSINGLEEXT("SelectSingleExt"),
  SELECTSINGLESEARCHMULTI("SelectSingleSearchMulti");

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
  private List<AttributeEntryDto> entries = new ArrayList<AttributeEntryDto>();
  private NumericRangeDto numericRange = null;

  
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
  @JsonProperty("ParentId")
  public Integer getParentId() {
    return parentId;
  }
  public void setParentId(Integer parentId) {
    this.parentId = parentId;
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
  @JsonProperty("Unit")
  public String getUnit() {
    return unit;
  }
  public void setUnit(String unit) {
    this.unit = unit;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("DefaultSelectItemId")
  public Integer getDefaultSelectItemId() {
    return defaultSelectItemId;
  }
  public void setDefaultSelectItemId(Integer defaultSelectItemId) {
    this.defaultSelectItemId = defaultSelectItemId;
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
  @JsonProperty("Entries")
  public List<AttributeEntryDto> getEntries() {
    return entries;
  }
  public void setEntries(List<AttributeEntryDto> entries) {
    this.entries = entries;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("NumericRange")
  public NumericRangeDto getNumericRange() {
    return numericRange;
  }
  public void setNumericRange(NumericRangeDto numericRange) {
    this.numericRange = numericRange;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributeDto {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    parentId: ").append(StringUtil.toIndentedString(parentId)).append("\n");
    sb.append("    language: ").append(StringUtil.toIndentedString(language)).append("\n");
    sb.append("    name: ").append(StringUtil.toIndentedString(name)).append("\n");
    sb.append("    unit: ").append(StringUtil.toIndentedString(unit)).append("\n");
    sb.append("    defaultSelectItemId: ").append(StringUtil.toIndentedString(defaultSelectItemId)).append("\n");
    sb.append("    type: ").append(StringUtil.toIndentedString(type)).append("\n");
    sb.append("    entries: ").append(StringUtil.toIndentedString(entries)).append("\n");
    sb.append("    numericRange: ").append(StringUtil.toIndentedString(numericRange)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
