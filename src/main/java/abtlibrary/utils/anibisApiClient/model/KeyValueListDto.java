package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;
import java.util.*;
import java.util.Map;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class KeyValueListDto   {
  
  private Map<String, String> list = new HashMap<String, String>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("List")
  public Map<String, String> getList() {
    return list;
  }
  public void setList(Map<String, String> list) {
    this.list = list;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyValueListDto {\n");
    
    sb.append("    list: ").append(StringUtil.toIndentedString(list)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
