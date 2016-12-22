package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class TextResourceDto   {
  
  private Integer resourceId = null;
  private String section = null;
  private String key = null;
  private String language = null;
  private String text = null;
  private Boolean isHtml = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("ResourceId")
  public Integer getResourceId() {
    return resourceId;
  }
  public void setResourceId(Integer resourceId) {
    this.resourceId = resourceId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Section")
  public String getSection() {
    return section;
  }
  public void setSection(String section) {
    this.section = section;
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
  @JsonProperty("Text")
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("IsHtml")
  public Boolean getIsHtml() {
    return isHtml;
  }
  public void setIsHtml(Boolean isHtml) {
    this.isHtml = isHtml;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TextResourceDto {\n");
    
    sb.append("    resourceId: ").append(StringUtil.toIndentedString(resourceId)).append("\n");
    sb.append("    section: ").append(StringUtil.toIndentedString(section)).append("\n");
    sb.append("    key: ").append(StringUtil.toIndentedString(key)).append("\n");
    sb.append("    language: ").append(StringUtil.toIndentedString(language)).append("\n");
    sb.append("    text: ").append(StringUtil.toIndentedString(text)).append("\n");
    sb.append("    isHtml: ").append(StringUtil.toIndentedString(isHtml)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
