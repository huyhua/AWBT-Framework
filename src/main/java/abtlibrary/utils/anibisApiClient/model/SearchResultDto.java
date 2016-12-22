package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;
import java.util.*;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class SearchResultDto   {
  
  private Integer totalCount = null;
  private Integer resultRows = null;
  private Integer resultStart = null;
  private List<Integer> objectIds = new ArrayList<Integer>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("TotalCount")
  public Integer getTotalCount() {
    return totalCount;
  }
  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
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
  @JsonProperty("ObjectIds")
  public List<Integer> getObjectIds() {
    return objectIds;
  }
  public void setObjectIds(List<Integer> objectIds) {
    this.objectIds = objectIds;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchResultDto {\n");
    
    sb.append("    totalCount: ").append(StringUtil.toIndentedString(totalCount)).append("\n");
    sb.append("    resultRows: ").append(StringUtil.toIndentedString(resultRows)).append("\n");
    sb.append("    resultStart: ").append(StringUtil.toIndentedString(resultStart)).append("\n");
    sb.append("    objectIds: ").append(StringUtil.toIndentedString(objectIds)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
