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
 * Make
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-12-21T15:07:04.675+07:00")
public class Make   {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("makename")
  private String makename = null;

  @SerializedName("hasBrandLogo")
  private Boolean hasBrandLogo = null;

  public Make id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Make makename(String makename) {
    this.makename = makename;
    return this;
  }

   /**
   * Get makename
   * @return makename
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getMakename() {
    return makename;
  }

  public void setMakename(String makename) {
    this.makename = makename;
  }

  public Make hasBrandLogo(Boolean hasBrandLogo) {
    this.hasBrandLogo = hasBrandLogo;
    return this;
  }

   /**
   * Get hasBrandLogo
   * @return hasBrandLogo
  **/
  @ApiModelProperty(example = "null", value = "")
  public Boolean getHasBrandLogo() {
    return hasBrandLogo;
  }

  public void setHasBrandLogo(Boolean hasBrandLogo) {
    this.hasBrandLogo = hasBrandLogo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Make make = (Make) o;
    return Objects.equals(this.id, make.id) &&
        Objects.equals(this.makename, make.makename) &&
        Objects.equals(this.hasBrandLogo, make.hasBrandLogo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, makename, hasBrandLogo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Make {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    makename: ").append(toIndentedString(makename)).append("\n");
    sb.append("    hasBrandLogo: ").append(toIndentedString(hasBrandLogo)).append("\n");
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
