package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;
import abtlibrary.utils.anibisApiClient.model.CategoryAttributesDto;
import java.util.*;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class CategoryAttributeListDto   {
  
  private List<CategoryAttributesDto> list = new ArrayList<CategoryAttributesDto>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("List")
  public List<CategoryAttributesDto> getList() {
    return list;
  }
  public void setList(List<CategoryAttributesDto> list) {
    this.list = list;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryAttributeListDto {\n");
    
    sb.append("    list: ").append(StringUtil.toIndentedString(list)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
