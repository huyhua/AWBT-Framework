package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;
import java.util.Date;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class UserDto   {
  
  private Integer id = null;
  private String username = null;
  private String eMail = null;
  private Date registeredSince = null;
  private Date lastLogin = null;
  private String language = null;
  private String roles = null;
  private Integer favoritesCount = null;
  private Integer searchJobsCount = null;
  private Integer activeAdvertsCount = null;

  
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
  @JsonProperty("Username")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("EMail")
  public String getEMail() {
    return eMail;
  }
  public void setEMail(String eMail) {
    this.eMail = eMail;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("RegisteredSince")
  public Date getRegisteredSince() {
    return registeredSince;
  }
  public void setRegisteredSince(Date registeredSince) {
    this.registeredSince = registeredSince;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("LastLogin")
  public Date getLastLogin() {
    return lastLogin;
  }
  public void setLastLogin(Date lastLogin) {
    this.lastLogin = lastLogin;
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
  @JsonProperty("Roles")
  public String getRoles() {
    return roles;
  }
  public void setRoles(String roles) {
    this.roles = roles;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("FavoritesCount")
  public Integer getFavoritesCount() {
    return favoritesCount;
  }
  public void setFavoritesCount(Integer favoritesCount) {
    this.favoritesCount = favoritesCount;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("SearchJobsCount")
  public Integer getSearchJobsCount() {
    return searchJobsCount;
  }
  public void setSearchJobsCount(Integer searchJobsCount) {
    this.searchJobsCount = searchJobsCount;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("ActiveAdvertsCount")
  public Integer getActiveAdvertsCount() {
    return activeAdvertsCount;
  }
  public void setActiveAdvertsCount(Integer activeAdvertsCount) {
    this.activeAdvertsCount = activeAdvertsCount;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDto {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    username: ").append(StringUtil.toIndentedString(username)).append("\n");
    sb.append("    eMail: ").append(StringUtil.toIndentedString(eMail)).append("\n");
    sb.append("    registeredSince: ").append(StringUtil.toIndentedString(registeredSince)).append("\n");
    sb.append("    lastLogin: ").append(StringUtil.toIndentedString(lastLogin)).append("\n");
    sb.append("    language: ").append(StringUtil.toIndentedString(language)).append("\n");
    sb.append("    roles: ").append(StringUtil.toIndentedString(roles)).append("\n");
    sb.append("    favoritesCount: ").append(StringUtil.toIndentedString(favoritesCount)).append("\n");
    sb.append("    searchJobsCount: ").append(StringUtil.toIndentedString(searchJobsCount)).append("\n");
    sb.append("    activeAdvertsCount: ").append(StringUtil.toIndentedString(activeAdvertsCount)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
