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
import abtlibrary.utils.as24ApiClient.model.LabelMatch;
import java.util.ArrayList;
import java.util.List;


/**
 * Location
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-12-21T15:07:04.675+07:00")
public class Location   {
  @SerializedName("label")
  private String label = null;

  @SerializedName("value")
  private String value = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("hint")
  private String hint = null;

  @SerializedName("labelMatches")
  private List<LabelMatch> labelMatches = new ArrayList<LabelMatch>();

  public Location label(String label) {
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Location value(String value) {
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

  public Location type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Location hint(String hint) {
    this.hint = hint;
    return this;
  }

   /**
   * Get hint
   * @return hint
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getHint() {
    return hint;
  }

  public void setHint(String hint) {
    this.hint = hint;
  }

  public Location labelMatches(List<LabelMatch> labelMatches) {
    this.labelMatches = labelMatches;
    return this;
  }

  public Location addLabelMatchesItem(LabelMatch labelMatchesItem) {
    this.labelMatches.add(labelMatchesItem);
    return this;
  }

   /**
   * Get labelMatches
   * @return labelMatches
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<LabelMatch> getLabelMatches() {
    return labelMatches;
  }

  public void setLabelMatches(List<LabelMatch> labelMatches) {
    this.labelMatches = labelMatches;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(this.label, location.label) &&
        Objects.equals(this.value, location.value) &&
        Objects.equals(this.type, location.type) &&
        Objects.equals(this.hint, location.hint) &&
        Objects.equals(this.labelMatches, location.labelMatches);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, value, type, hint, labelMatches);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    hint: ").append(toIndentedString(hint)).append("\n");
    sb.append("    labelMatches: ").append(toIndentedString(labelMatches)).append("\n");
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
