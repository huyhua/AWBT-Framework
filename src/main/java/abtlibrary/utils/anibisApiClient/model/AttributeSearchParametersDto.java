package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;
import abtlibrary.utils.anibisApiClient.model.AttributeTextDto;
import java.util.*;
import java.util.Map;
import abtlibrary.utils.anibisApiClient.model.IdListDto;
import abtlibrary.utils.anibisApiClient.model.AttributeRangeDto;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class AttributeSearchParametersDto   {
  
  private IdListDto attributeIds = null;
  private Map<String, IdListDto> attributeOrIds = new HashMap<String, IdListDto>();
  private List<AttributeTextDto> attributeTexts = new ArrayList<AttributeTextDto>();
  private List<AttributeRangeDto> attributeRanges = new ArrayList<AttributeRangeDto>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("AttributeIds")
  public IdListDto getAttributeIds() {
    return attributeIds;
  }
  public void setAttributeIds(IdListDto attributeIds) {
    this.attributeIds = attributeIds;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("AttributeOrIds")
  public Map<String, IdListDto> getAttributeOrIds() {
    return attributeOrIds;
  }
  public void setAttributeOrIds(Map<String, IdListDto> attributeOrIds) {
    this.attributeOrIds = attributeOrIds;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("AttributeTexts")
  public List<AttributeTextDto> getAttributeTexts() {
    return attributeTexts;
  }
  public void setAttributeTexts(List<AttributeTextDto> attributeTexts) {
    this.attributeTexts = attributeTexts;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("AttributeRanges")
  public List<AttributeRangeDto> getAttributeRanges() {
    return attributeRanges;
  }
  public void setAttributeRanges(List<AttributeRangeDto> attributeRanges) {
    this.attributeRanges = attributeRanges;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributeSearchParametersDto {\n");
    
    sb.append("    attributeIds: ").append(StringUtil.toIndentedString(attributeIds)).append("\n");
    sb.append("    attributeOrIds: ").append(StringUtil.toIndentedString(attributeOrIds)).append("\n");
    sb.append("    attributeTexts: ").append(StringUtil.toIndentedString(attributeTexts)).append("\n");
    sb.append("    attributeRanges: ").append(StringUtil.toIndentedString(attributeRanges)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
