package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class MailContentDto   {
  
  private String sendername = null;
  private String senderEMail = null;
  private String message = null;
  private Integer advertId = null;
  private String language = null;
  private Boolean selfCopy = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Sendername")
  public String getSendername() {
    return sendername;
  }
  public void setSendername(String sendername) {
    this.sendername = sendername;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("SenderEMail")
  public String getSenderEMail() {
    return senderEMail;
  }
  public void setSenderEMail(String senderEMail) {
    this.senderEMail = senderEMail;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Message")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("AdvertId")
  public Integer getAdvertId() {
    return advertId;
  }
  public void setAdvertId(Integer advertId) {
    this.advertId = advertId;
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
  @JsonProperty("SelfCopy")
  public Boolean getSelfCopy() {
    return selfCopy;
  }
  public void setSelfCopy(Boolean selfCopy) {
    this.selfCopy = selfCopy;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailContentDto {\n");
    
    sb.append("    sendername: ").append(StringUtil.toIndentedString(sendername)).append("\n");
    sb.append("    senderEMail: ").append(StringUtil.toIndentedString(senderEMail)).append("\n");
    sb.append("    message: ").append(StringUtil.toIndentedString(message)).append("\n");
    sb.append("    advertId: ").append(StringUtil.toIndentedString(advertId)).append("\n");
    sb.append("    language: ").append(StringUtil.toIndentedString(language)).append("\n");
    sb.append("    selfCopy: ").append(StringUtil.toIndentedString(selfCopy)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
