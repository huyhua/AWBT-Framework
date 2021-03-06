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
import abtlibrary.utils.as24ApiClient.model.DealerPageTab;

import java.util.ArrayList;
import java.util.List;


/**
 * DealerPageDealer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-12-21T15:07:04.675+07:00")
public class DealerPageDealer   {
  @SerializedName("accountId")
  private Integer accountId = null;

  @SerializedName("companyName")
  private String companyName = null;

  @SerializedName("additionalInfo")
  private String additionalInfo = null;

  @SerializedName("street")
  private String street = null;

  @SerializedName("poBox")
  private String poBox = null;

  @SerializedName("zip")
  private String zip = null;

  @SerializedName("city")
  private String city = null;

  @SerializedName("makes")
  private String makes = null;

  @SerializedName("logoUrl")
  private String logoUrl = null;

  @SerializedName("url")
  private String url = null;

  @SerializedName("tabInfos")
  private List<DealerPageTab> tabInfos = new ArrayList<DealerPageTab>();

  @SerializedName("numberOfVehicles")
  private Integer numberOfVehicles = null;

  /**
   * Gets or Sets vehicleTypes
   */
  public enum VehicleTypesEnum {
    @SerializedName("0")
    _0("0"),
    
    @SerializedName("10")
    _10("10"),
    
    @SerializedName("20")
    _20("20"),
    
    @SerializedName("30")
    _30("30"),
    
    @SerializedName("60")
    _60("60"),
    
    @SerializedName("70")
    _70("70"),
    
    @SerializedName("80")
    _80("80");

    private int value;

    VehicleTypesEnum(String value) {
      this.value = Integer.parseInt(value);
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("vehicleTypes")
  private List<VehicleTypesEnum> vehicleTypes = new ArrayList<VehicleTypesEnum>();

  @SerializedName("makeIds")
  private List<Integer> makeIds = new ArrayList<Integer>();

   /**
   * Get accountId
   * @return accountId
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getAccountId() {
    return accountId;
  }

   /**
   * Get companyName
   * @return companyName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getCompanyName() {
    return companyName;
  }

   /**
   * Get additionalInfo
   * @return additionalInfo
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getAdditionalInfo() {
    return additionalInfo;
  }

   /**
   * Get street
   * @return street
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getStreet() {
    return street;
  }

   /**
   * Get poBox
   * @return poBox
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getPoBox() {
    return poBox;
  }

   /**
   * Get zip
   * @return zip
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getZip() {
    return zip;
  }

   /**
   * Get city
   * @return city
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getCity() {
    return city;
  }

   /**
   * Get makes
   * @return makes
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getMakes() {
    return makes;
  }

   /**
   * Get logoUrl
   * @return logoUrl
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getLogoUrl() {
    return logoUrl;
  }

   /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getUrl() {
    return url;
  }

  public DealerPageDealer tabInfos(List<DealerPageTab> tabInfos) {
    this.tabInfos = tabInfos;
    return this;
  }

  public DealerPageDealer addTabInfosItem(DealerPageTab tabInfosItem) {
    this.tabInfos.add(tabInfosItem);
    return this;
  }

   /**
   * Get tabInfos
   * @return tabInfos
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<DealerPageTab> getTabInfos() {
    return tabInfos;
  }

  public void setTabInfos(List<DealerPageTab> tabInfos) {
    this.tabInfos = tabInfos;
  }

   /**
   * Get numberOfVehicles
   * @return numberOfVehicles
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getNumberOfVehicles() {
    return numberOfVehicles;
  }

  public DealerPageDealer vehicleTypes(List<VehicleTypesEnum> vehicleTypes) {
    this.vehicleTypes = vehicleTypes;
    return this;
  }

  public DealerPageDealer addVehicleTypesItem(VehicleTypesEnum vehicleTypesItem) {
    this.vehicleTypes.add(vehicleTypesItem);
    return this;
  }

   /**
   * Get vehicleTypes
   * @return vehicleTypes
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<VehicleTypesEnum> getVehicleTypes() {
    return vehicleTypes;
  }

  public void setVehicleTypes(List<VehicleTypesEnum> vehicleTypes) {
    this.vehicleTypes = vehicleTypes;
  }

  public DealerPageDealer makeIds(List<Integer> makeIds) {
    this.makeIds = makeIds;
    return this;
  }

  public DealerPageDealer addMakeIdsItem(Integer makeIdsItem) {
    this.makeIds.add(makeIdsItem);
    return this;
  }

   /**
   * Get makeIds
   * @return makeIds
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<Integer> getMakeIds() {
    return makeIds;
  }

  public void setMakeIds(List<Integer> makeIds) {
    this.makeIds = makeIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DealerPageDealer dealerPageDealer = (DealerPageDealer) o;
    return Objects.equals(this.accountId, dealerPageDealer.accountId) &&
        Objects.equals(this.companyName, dealerPageDealer.companyName) &&
        Objects.equals(this.additionalInfo, dealerPageDealer.additionalInfo) &&
        Objects.equals(this.street, dealerPageDealer.street) &&
        Objects.equals(this.poBox, dealerPageDealer.poBox) &&
        Objects.equals(this.zip, dealerPageDealer.zip) &&
        Objects.equals(this.city, dealerPageDealer.city) &&
        Objects.equals(this.makes, dealerPageDealer.makes) &&
        Objects.equals(this.logoUrl, dealerPageDealer.logoUrl) &&
        Objects.equals(this.url, dealerPageDealer.url) &&
        Objects.equals(this.tabInfos, dealerPageDealer.tabInfos) &&
        Objects.equals(this.numberOfVehicles, dealerPageDealer.numberOfVehicles) &&
        Objects.equals(this.vehicleTypes, dealerPageDealer.vehicleTypes) &&
        Objects.equals(this.makeIds, dealerPageDealer.makeIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, companyName, additionalInfo, street, poBox, zip, city, makes, logoUrl, url, tabInfos, numberOfVehicles, vehicleTypes, makeIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DealerPageDealer {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    poBox: ").append(toIndentedString(poBox)).append("\n");
    sb.append("    zip: ").append(toIndentedString(zip)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    makes: ").append(toIndentedString(makes)).append("\n");
    sb.append("    logoUrl: ").append(toIndentedString(logoUrl)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    tabInfos: ").append(toIndentedString(tabInfos)).append("\n");
    sb.append("    numberOfVehicles: ").append(toIndentedString(numberOfVehicles)).append("\n");
    sb.append("    vehicleTypes: ").append(toIndentedString(vehicleTypes)).append("\n");
    sb.append("    makeIds: ").append(toIndentedString(makeIds)).append("\n");
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

