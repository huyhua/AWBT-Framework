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
import abtlibrary.utils.as24ApiClient.model.MakeModels;
import java.util.ArrayList;
import java.util.List;


/**
 * VehicleTypeMakeModel
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-12-21T15:07:04.675+07:00")
public class VehicleTypeMakeModel   {
  @SerializedName("vehicleTypeId")
  private Integer vehicleTypeId = null;

  @SerializedName("makes")
  private List<MakeModels> makes = new ArrayList<MakeModels>();

  public VehicleTypeMakeModel vehicleTypeId(Integer vehicleTypeId) {
    this.vehicleTypeId = vehicleTypeId;
    return this;
  }

   /**
   * Get vehicleTypeId
   * @return vehicleTypeId
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getVehicleTypeId() {
    return vehicleTypeId;
  }

  public void setVehicleTypeId(Integer vehicleTypeId) {
    this.vehicleTypeId = vehicleTypeId;
  }

  public VehicleTypeMakeModel makes(List<MakeModels> makes) {
    this.makes = makes;
    return this;
  }

  public VehicleTypeMakeModel addMakesItem(MakeModels makesItem) {
    this.makes.add(makesItem);
    return this;
  }

   /**
   * Get makes
   * @return makes
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<MakeModels> getMakes() {
    return makes;
  }

  public void setMakes(List<MakeModels> makes) {
    this.makes = makes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleTypeMakeModel vehicleTypeMakeModel = (VehicleTypeMakeModel) o;
    return Objects.equals(this.vehicleTypeId, vehicleTypeMakeModel.vehicleTypeId) &&
        Objects.equals(this.makes, vehicleTypeMakeModel.makes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleTypeId, makes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VehicleTypeMakeModel {\n");
    
    sb.append("    vehicleTypeId: ").append(toIndentedString(vehicleTypeId)).append("\n");
    sb.append("    makes: ").append(toIndentedString(makes)).append("\n");
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
