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
 * DeviceToken
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-12-21T15:07:04.675+07:00")
public class DeviceToken   {
  @SerializedName("tokenId")
  private Integer tokenId = null;

  @SerializedName("value")
  private String value = null;

  @SerializedName("osType")
  private String osType = null;

  @SerializedName("dateLastModified")
  private DateTime dateLastModified = null;

  public DeviceToken tokenId(Integer tokenId) {
    this.tokenId = tokenId;
    return this;
  }

   /**
   * Get tokenId
   * @return tokenId
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getTokenId() {
    return tokenId;
  }

  public void setTokenId(Integer tokenId) {
    this.tokenId = tokenId;
  }

  public DeviceToken value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public DeviceToken osType(String osType) {
    this.osType = osType;
    return this;
  }

   /**
   * Get osType
   * @return osType
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getOsType() {
    return osType;
  }

  public void setOsType(String osType) {
    this.osType = osType;
  }

  public DeviceToken dateLastModified(DateTime dateLastModified) {
    this.dateLastModified = dateLastModified;
    return this;
  }

   /**
   * Get dateLastModified
   * @return dateLastModified
  **/
  @ApiModelProperty(example = "null", value = "")
  public DateTime getDateLastModified() {
    return dateLastModified;
  }

  public void setDateLastModified(DateTime dateLastModified) {
    this.dateLastModified = dateLastModified;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeviceToken deviceToken = (DeviceToken) o;
    return Objects.equals(this.tokenId, deviceToken.tokenId) &&
        Objects.equals(this.value, deviceToken.value) &&
        Objects.equals(this.osType, deviceToken.osType) &&
        Objects.equals(this.dateLastModified, deviceToken.dateLastModified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tokenId, value, osType, dateLastModified);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeviceToken {\n");
    
    sb.append("    tokenId: ").append(toIndentedString(tokenId)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    osType: ").append(toIndentedString(osType)).append("\n");
    sb.append("    dateLastModified: ").append(toIndentedString(dateLastModified)).append("\n");
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

