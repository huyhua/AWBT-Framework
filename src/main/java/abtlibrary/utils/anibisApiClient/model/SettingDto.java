package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class SettingDto   {
  
  private String module = null;
  private String key = null;
  private String value = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Module")
  public String getModule() {
    return module;
  }
  public void setModule(String module) {
    this.module = module;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Key")
  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Value")
  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SettingDto {\n");
    
    sb.append("    module: ").append(StringUtil.toIndentedString(module)).append("\n");
    sb.append("    key: ").append(StringUtil.toIndentedString(key)).append("\n");
    sb.append("    value: ").append(StringUtil.toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
