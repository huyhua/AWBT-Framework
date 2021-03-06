/**
 * AS24 API v4.1
 * No descripton provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v4.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package abtlibrary.utils.as24ApiClient.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;


/**
 * SearchJob
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-12-21T15:07:04.675+07:00")
public class SearchJob   {
  @SerializedName("searchJobId")
  private Integer searchJobId = null;

  @SerializedName("dateCreated")
  private DateTime dateCreated = null;

  @SerializedName("dateModified")
  private DateTime dateModified = null;

  @SerializedName("dateValid")
  private DateTime dateValid = null;

  @SerializedName("isContact")
  private Boolean isContact = null;

  @SerializedName("isEmail")
  private Boolean isEmail = null;

  @SerializedName("queryString")
  private String queryString = null;

  @SerializedName("title")
  private String title = null;

  @SerializedName("remoteUrl")
  private String remoteUrl = null;

  @SerializedName("searchUrl")
  private String searchUrl = null;

  @SerializedName("userId")
  private Integer userId = null;

  @SerializedName("isPush")
  private Boolean isPush = null;

  public SearchJob searchJobId(Integer searchJobId) {
    this.searchJobId = searchJobId;
    return this;
  }

   /**
   * Get searchJobId
   * @return searchJobId
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getSearchJobId() {
    return searchJobId;
  }

  public void setSearchJobId(Integer searchJobId) {
    this.searchJobId = searchJobId;
  }

  public SearchJob dateCreated(DateTime dateCreated) {
    this.dateCreated = dateCreated;
    return this;
  }

   /**
   * Get dateCreated
   * @return dateCreated
  **/
  @ApiModelProperty(example = "null", value = "")
  public DateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(DateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  public SearchJob dateModified(DateTime dateModified) {
    this.dateModified = dateModified;
    return this;
  }

   /**
   * Get dateModified
   * @return dateModified
  **/
  @ApiModelProperty(example = "null", value = "")
  public DateTime getDateModified() {
    return dateModified;
  }

  public void setDateModified(DateTime dateModified) {
    this.dateModified = dateModified;
  }

  public SearchJob dateValid(DateTime dateValid) {
    this.dateValid = dateValid;
    return this;
  }

   /**
   * Get dateValid
   * @return dateValid
  **/
  @ApiModelProperty(example = "null", value = "")
  public DateTime getDateValid() {
    return dateValid;
  }

  public void setDateValid(DateTime dateValid) {
    this.dateValid = dateValid;
  }

  public SearchJob isContact(Boolean isContact) {
    this.isContact = isContact;
    return this;
  }

   /**
   * Get isContact
   * @return isContact
  **/
  @ApiModelProperty(example = "null", value = "")
  public Boolean getIsContact() {
    return isContact;
  }

  public void setIsContact(Boolean isContact) {
    this.isContact = isContact;
  }

  public SearchJob isEmail(Boolean isEmail) {
    this.isEmail = isEmail;
    return this;
  }

   /**
   * Get isEmail
   * @return isEmail
  **/
  @ApiModelProperty(example = "null", value = "")
  public Boolean getIsEmail() {
    return isEmail;
  }

  public void setIsEmail(Boolean isEmail) {
    this.isEmail = isEmail;
  }

  public SearchJob queryString(String queryString) {
    this.queryString = queryString;
    return this;
  }

   /**
   * Get queryString
   * @return queryString
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getQueryString() {
    return queryString;
  }

  public void setQueryString(String queryString) {
    this.queryString = queryString;
  }

  public SearchJob title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public SearchJob remoteUrl(String remoteUrl) {
    this.remoteUrl = remoteUrl;
    return this;
  }

   /**
   * Get remoteUrl
   * @return remoteUrl
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getRemoteUrl() {
    return remoteUrl;
  }

  public void setRemoteUrl(String remoteUrl) {
    this.remoteUrl = remoteUrl;
  }

  public SearchJob searchUrl(String searchUrl) {
    this.searchUrl = searchUrl;
    return this;
  }

   /**
   * Get searchUrl
   * @return searchUrl
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getSearchUrl() {
    return searchUrl;
  }

  public void setSearchUrl(String searchUrl) {
    this.searchUrl = searchUrl;
  }

  public SearchJob userId(Integer userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public SearchJob isPush(Boolean isPush) {
    this.isPush = isPush;
    return this;
  }

   /**
   * Get isPush
   * @return isPush
  **/
  @ApiModelProperty(example = "null", value = "")
  public Boolean getIsPush() {
    return isPush;
  }

  public void setIsPush(Boolean isPush) {
    this.isPush = isPush;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchJob searchJob = (SearchJob) o;
    return Objects.equals(this.searchJobId, searchJob.searchJobId) &&
        Objects.equals(this.dateCreated, searchJob.dateCreated) &&
        Objects.equals(this.dateModified, searchJob.dateModified) &&
        Objects.equals(this.dateValid, searchJob.dateValid) &&
        Objects.equals(this.isContact, searchJob.isContact) &&
        Objects.equals(this.isEmail, searchJob.isEmail) &&
        Objects.equals(this.queryString, searchJob.queryString) &&
        Objects.equals(this.title, searchJob.title) &&
        Objects.equals(this.remoteUrl, searchJob.remoteUrl) &&
        Objects.equals(this.searchUrl, searchJob.searchUrl) &&
        Objects.equals(this.userId, searchJob.userId) &&
        Objects.equals(this.isPush, searchJob.isPush);
  }

  @Override
  public int hashCode() {
    return Objects.hash(searchJobId, dateCreated, dateModified, dateValid, isContact, isEmail, queryString, title, remoteUrl, searchUrl, userId, isPush);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchJob {\n");
    
    sb.append("    searchJobId: ").append(toIndentedString(searchJobId)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
    sb.append("    dateValid: ").append(toIndentedString(dateValid)).append("\n");
    sb.append("    isContact: ").append(toIndentedString(isContact)).append("\n");
    sb.append("    isEmail: ").append(toIndentedString(isEmail)).append("\n");
    sb.append("    queryString: ").append(toIndentedString(queryString)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    remoteUrl: ").append(toIndentedString(remoteUrl)).append("\n");
    sb.append("    searchUrl: ").append(toIndentedString(searchUrl)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    isPush: ").append(toIndentedString(isPush)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

