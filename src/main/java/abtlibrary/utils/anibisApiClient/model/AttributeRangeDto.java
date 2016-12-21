package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class AttributeRangeDto   {
  
  private Integer id = null;
  private Double from = null;
  private Double to = null;

  
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
  @JsonProperty("From")
  public Double getFrom() {
    return from;
  }
  public void setFrom(Double from) {
    this.from = from;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("To")
  public Double getTo() {
    return to;
  }
  public void setTo(Double to) {
    this.to = to;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributeRangeDto {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    from: ").append(StringUtil.toIndentedString(from)).append("\n");
    sb.append("    to: ").append(StringUtil.toIndentedString(to)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
