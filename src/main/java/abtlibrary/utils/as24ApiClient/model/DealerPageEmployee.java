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
 * DealerPageEmployee
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-12-21T15:07:04.675+07:00")
public class DealerPageEmployee   {
  @SerializedName("lastnameFirstname")
  private String lastnameFirstname = null;

  @SerializedName("phone1")
  private String phone1 = null;

  @SerializedName("phone2")
  private String phone2 = null;

  @SerializedName("fax")
  private String fax = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("comments")
  private String comments = null;

  @SerializedName("imageUrl")
  private String imageUrl = null;

  public DealerPageEmployee lastnameFirstname(String lastnameFirstname) {
    this.lastnameFirstname = lastnameFirstname;
    return this;
  }

   /**
   * Get lastnameFirstname
   * @return lastnameFirstname
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getLastnameFirstname() {
    return lastnameFirstname;
  }

  public void setLastnameFirstname(String lastnameFirstname) {
    this.lastnameFirstname = lastnameFirstname;
  }

  public DealerPageEmployee phone1(String phone1) {
    this.phone1 = phone1;
    return this;
  }

   /**
   * Get phone1
   * @return phone1
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getPhone1() {
    return phone1;
  }

  public void setPhone1(String phone1) {
    this.phone1 = phone1;
  }

  public DealerPageEmployee phone2(String phone2) {
    this.phone2 = phone2;
    return this;
  }

   /**
   * Get phone2
   * @return phone2
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getPhone2() {
    return phone2;
  }

  public void setPhone2(String phone2) {
    this.phone2 = phone2;
  }

  public DealerPageEmployee fax(String fax) {
    this.fax = fax;
    return this;
  }

   /**
   * Get fax
   * @return fax
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public DealerPageEmployee email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public DealerPageEmployee comments(String comments) {
    this.comments = comments;
    return this;
  }

   /**
   * Get comments
   * @return comments
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public DealerPageEmployee imageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

   /**
   * Get imageUrl
   * @return imageUrl
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DealerPageEmployee dealerPageEmployee = (DealerPageEmployee) o;
    return Objects.equals(this.lastnameFirstname, dealerPageEmployee.lastnameFirstname) &&
        Objects.equals(this.phone1, dealerPageEmployee.phone1) &&
        Objects.equals(this.phone2, dealerPageEmployee.phone2) &&
        Objects.equals(this.fax, dealerPageEmployee.fax) &&
        Objects.equals(this.email, dealerPageEmployee.email) &&
        Objects.equals(this.comments, dealerPageEmployee.comments) &&
        Objects.equals(this.imageUrl, dealerPageEmployee.imageUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastnameFirstname, phone1, phone2, fax, email, comments, imageUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DealerPageEmployee {\n");
    
    sb.append("    lastnameFirstname: ").append(toIndentedString(lastnameFirstname)).append("\n");
    sb.append("    phone1: ").append(toIndentedString(phone1)).append("\n");
    sb.append("    phone2: ").append(toIndentedString(phone2)).append("\n");
    sb.append("    fax: ").append(toIndentedString(fax)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
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

