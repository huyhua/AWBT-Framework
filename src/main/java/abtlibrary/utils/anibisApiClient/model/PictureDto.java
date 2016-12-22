package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class PictureDto   {
  
  private Integer id = null;

public enum SizeEnum {
  ORIGINAL("Original"),
  LARGE("Large"),
  MEDIUM("Medium"),
  SMALL("Small"),
  TINY("Tiny");

  private String value;

  SizeEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private SizeEnum size = null;
  private Integer sortOrder = null;
  private String filePath = null;

  
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
  @JsonProperty("Size")
  public SizeEnum getSize() {
    return size;
  }
  public void setSize(SizeEnum size) {
    this.size = size;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("SortOrder")
  public Integer getSortOrder() {
    return sortOrder;
  }
  public void setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("FilePath")
  public String getFilePath() {
    return filePath;
  }
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PictureDto {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    size: ").append(StringUtil.toIndentedString(size)).append("\n");
    sb.append("    sortOrder: ").append(StringUtil.toIndentedString(sortOrder)).append("\n");
    sb.append("    filePath: ").append(StringUtil.toIndentedString(filePath)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
