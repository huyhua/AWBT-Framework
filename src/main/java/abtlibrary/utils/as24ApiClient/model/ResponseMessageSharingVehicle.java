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
import abtlibrary.utils.as24ApiClient.model.MetaData;
import abtlibrary.utils.as24ApiClient.model.SharingVehicle;


/**
 * ResponseMessageSharingVehicle
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-12-21T15:07:04.675+07:00")
public class ResponseMessageSharingVehicle   {
  @SerializedName("result")
  private SharingVehicle result = null;

  @SerializedName("metaData")
  private MetaData metaData = null;

  @SerializedName("href")
  private String href = null;

  @SerializedName("normalizedQuery")
  private String normalizedQuery = null;

  public ResponseMessageSharingVehicle result(SharingVehicle result) {
    this.result = result;
    return this;
  }

   /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(example = "null", value = "")
  public SharingVehicle getResult() {
    return result;
  }

  public void setResult(SharingVehicle result) {
    this.result = result;
  }

  public ResponseMessageSharingVehicle metaData(MetaData metaData) {
    this.metaData = metaData;
    return this;
  }

   /**
   * Get metaData
   * @return metaData
  **/
  @ApiModelProperty(example = "null", value = "")
  public MetaData getMetaData() {
    return metaData;
  }

  public void setMetaData(MetaData metaData) {
    this.metaData = metaData;
  }

   /**
   * Get href
   * @return href
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getHref() {
    return href;
  }

   /**
   * Get normalizedQuery
   * @return normalizedQuery
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getNormalizedQuery() {
    return normalizedQuery;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseMessageSharingVehicle responseMessageSharingVehicle = (ResponseMessageSharingVehicle) o;
    return Objects.equals(this.result, responseMessageSharingVehicle.result) &&
        Objects.equals(this.metaData, responseMessageSharingVehicle.metaData) &&
        Objects.equals(this.href, responseMessageSharingVehicle.href) &&
        Objects.equals(this.normalizedQuery, responseMessageSharingVehicle.normalizedQuery);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, metaData, href, normalizedQuery);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseMessageSharingVehicle {\n");
    
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    metaData: ").append(toIndentedString(metaData)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    normalizedQuery: ").append(toIndentedString(normalizedQuery)).append("\n");
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

