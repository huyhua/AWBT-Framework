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


/**
 * SendToFriendRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-12-21T15:07:04.675+07:00")
public class SendToFriendRequest   {
  @SerializedName("vehicleId")
  private Integer vehicleId = null;

  @SerializedName("message")
  private String message = null;

  @SerializedName("senderEmail")
  private String senderEmail = null;

  @SerializedName("senderName")
  private String senderName = null;

  @SerializedName("recipientName")
  private String recipientName = null;

  @SerializedName("recipientEmail")
  private String recipientEmail = null;

  @SerializedName("lng")
  private String lng = null;

  public SendToFriendRequest vehicleId(Integer vehicleId) {
    this.vehicleId = vehicleId;
    return this;
  }

   /**
   * Get vehicleId
   * @return vehicleId
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Integer vehicleId) {
    this.vehicleId = vehicleId;
  }

  public SendToFriendRequest message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public SendToFriendRequest senderEmail(String senderEmail) {
    this.senderEmail = senderEmail;
    return this;
  }

   /**
   * Get senderEmail
   * @return senderEmail
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getSenderEmail() {
    return senderEmail;
  }

  public void setSenderEmail(String senderEmail) {
    this.senderEmail = senderEmail;
  }

  public SendToFriendRequest senderName(String senderName) {
    this.senderName = senderName;
    return this;
  }

   /**
   * Get senderName
   * @return senderName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getSenderName() {
    return senderName;
  }

  public void setSenderName(String senderName) {
    this.senderName = senderName;
  }

  public SendToFriendRequest recipientName(String recipientName) {
    this.recipientName = recipientName;
    return this;
  }

   /**
   * Get recipientName
   * @return recipientName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getRecipientName() {
    return recipientName;
  }

  public void setRecipientName(String recipientName) {
    this.recipientName = recipientName;
  }

  public SendToFriendRequest recipientEmail(String recipientEmail) {
    this.recipientEmail = recipientEmail;
    return this;
  }

   /**
   * Get recipientEmail
   * @return recipientEmail
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getRecipientEmail() {
    return recipientEmail;
  }

  public void setRecipientEmail(String recipientEmail) {
    this.recipientEmail = recipientEmail;
  }

  public SendToFriendRequest lng(String lng) {
    this.lng = lng;
    return this;
  }

   /**
   * Get lng
   * @return lng
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getLng() {
    return lng;
  }

  public void setLng(String lng) {
    this.lng = lng;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendToFriendRequest sendToFriendRequest = (SendToFriendRequest) o;
    return Objects.equals(this.vehicleId, sendToFriendRequest.vehicleId) &&
        Objects.equals(this.message, sendToFriendRequest.message) &&
        Objects.equals(this.senderEmail, sendToFriendRequest.senderEmail) &&
        Objects.equals(this.senderName, sendToFriendRequest.senderName) &&
        Objects.equals(this.recipientName, sendToFriendRequest.recipientName) &&
        Objects.equals(this.recipientEmail, sendToFriendRequest.recipientEmail) &&
        Objects.equals(this.lng, sendToFriendRequest.lng);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleId, message, senderEmail, senderName, recipientName, recipientEmail, lng);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendToFriendRequest {\n");
    
    sb.append("    vehicleId: ").append(toIndentedString(vehicleId)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    senderEmail: ").append(toIndentedString(senderEmail)).append("\n");
    sb.append("    senderName: ").append(toIndentedString(senderName)).append("\n");
    sb.append("    recipientName: ").append(toIndentedString(recipientName)).append("\n");
    sb.append("    recipientEmail: ").append(toIndentedString(recipientEmail)).append("\n");
    sb.append("    lng: ").append(toIndentedString(lng)).append("\n");
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

