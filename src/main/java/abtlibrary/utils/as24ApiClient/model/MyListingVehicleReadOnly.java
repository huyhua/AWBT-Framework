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
import abtlibrary.utils.as24ApiClient.model.MyListingVehicleImages;
import org.joda.time.DateTime;


/**
 * MyListingVehicleReadOnly
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-12-21T15:07:04.675+07:00")
public class MyListingVehicleReadOnly   {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("status")
  private Integer status = null;

  @SerializedName("statusText")
  private String statusText = null;

  @SerializedName("publicationUrl")
  private String publicationUrl = null;

  @SerializedName("insertionUrl")
  private String insertionUrl = null;

  @SerializedName("productsUrl")
  private String productsUrl = null;

  @SerializedName("firstRegMonth")
  private Integer firstRegMonth = null;

  @SerializedName("firstRegYear")
  private Integer firstRegYear = null;

  @SerializedName("conditionTypeId")
  private Integer conditionTypeId = null;

  @SerializedName("hits")
  private Integer hits = null;

  @SerializedName("hitsPerDay")
  private Integer hitsPerDay = null;

  @SerializedName("hitsYesterday")
  private Integer hitsYesterday = null;

  @SerializedName("dateHitsReset")
  private DateTime dateHitsReset = null;

  @SerializedName("dateValidFrom")
  private DateTime dateValidFrom = null;

  @SerializedName("vehicleTypeId")
  private Integer vehicleTypeId = null;

  @SerializedName("makeId")
  private Integer makeId = null;

  @SerializedName("make")
  private String make = null;

  @SerializedName("modelId")
  private Integer modelId = null;

  @SerializedName("typeName")
  private String typeName = null;

  @SerializedName("priceOriginal")
  private Double priceOriginal = null;

  @SerializedName("publicationDurationDaysLeft")
  private Integer publicationDurationDaysLeft = null;

  @SerializedName("dateTopListing")
  private DateTime dateTopListing = null;

  @SerializedName("dateNewFlagExpires")
  private DateTime dateNewFlagExpires = null;

  @SerializedName("images")
  private MyListingVehicleImages images = null;

  @SerializedName("price")
  private Double price = null;

  @SerializedName("km")
  private Integer km = null;

  @SerializedName("teaser")
  private String teaser = null;

  @SerializedName("comments")
  private String comments = null;

  public MyListingVehicleReadOnly id(Integer id) {
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

  public MyListingVehicleReadOnly status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public MyListingVehicleReadOnly statusText(String statusText) {
    this.statusText = statusText;
    return this;
  }

   /**
   * Get statusText
   * @return statusText
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getStatusText() {
    return statusText;
  }

  public void setStatusText(String statusText) {
    this.statusText = statusText;
  }

  public MyListingVehicleReadOnly publicationUrl(String publicationUrl) {
    this.publicationUrl = publicationUrl;
    return this;
  }

   /**
   * Get publicationUrl
   * @return publicationUrl
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getPublicationUrl() {
    return publicationUrl;
  }

  public void setPublicationUrl(String publicationUrl) {
    this.publicationUrl = publicationUrl;
  }

  public MyListingVehicleReadOnly insertionUrl(String insertionUrl) {
    this.insertionUrl = insertionUrl;
    return this;
  }

   /**
   * Get insertionUrl
   * @return insertionUrl
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getInsertionUrl() {
    return insertionUrl;
  }

  public void setInsertionUrl(String insertionUrl) {
    this.insertionUrl = insertionUrl;
  }

  public MyListingVehicleReadOnly productsUrl(String productsUrl) {
    this.productsUrl = productsUrl;
    return this;
  }

   /**
   * Get productsUrl
   * @return productsUrl
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getProductsUrl() {
    return productsUrl;
  }

  public void setProductsUrl(String productsUrl) {
    this.productsUrl = productsUrl;
  }

  public MyListingVehicleReadOnly firstRegMonth(Integer firstRegMonth) {
    this.firstRegMonth = firstRegMonth;
    return this;
  }

   /**
   * Get firstRegMonth
   * @return firstRegMonth
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getFirstRegMonth() {
    return firstRegMonth;
  }

  public void setFirstRegMonth(Integer firstRegMonth) {
    this.firstRegMonth = firstRegMonth;
  }

  public MyListingVehicleReadOnly firstRegYear(Integer firstRegYear) {
    this.firstRegYear = firstRegYear;
    return this;
  }

   /**
   * Get firstRegYear
   * @return firstRegYear
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getFirstRegYear() {
    return firstRegYear;
  }

  public void setFirstRegYear(Integer firstRegYear) {
    this.firstRegYear = firstRegYear;
  }

  public MyListingVehicleReadOnly conditionTypeId(Integer conditionTypeId) {
    this.conditionTypeId = conditionTypeId;
    return this;
  }

   /**
   * Get conditionTypeId
   * @return conditionTypeId
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getConditionTypeId() {
    return conditionTypeId;
  }

  public void setConditionTypeId(Integer conditionTypeId) {
    this.conditionTypeId = conditionTypeId;
  }

  public MyListingVehicleReadOnly hits(Integer hits) {
    this.hits = hits;
    return this;
  }

   /**
   * Get hits
   * @return hits
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getHits() {
    return hits;
  }

  public void setHits(Integer hits) {
    this.hits = hits;
  }

  public MyListingVehicleReadOnly hitsPerDay(Integer hitsPerDay) {
    this.hitsPerDay = hitsPerDay;
    return this;
  }

   /**
   * Get hitsPerDay
   * @return hitsPerDay
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getHitsPerDay() {
    return hitsPerDay;
  }

  public void setHitsPerDay(Integer hitsPerDay) {
    this.hitsPerDay = hitsPerDay;
  }

  public MyListingVehicleReadOnly hitsYesterday(Integer hitsYesterday) {
    this.hitsYesterday = hitsYesterday;
    return this;
  }

   /**
   * Get hitsYesterday
   * @return hitsYesterday
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getHitsYesterday() {
    return hitsYesterday;
  }

  public void setHitsYesterday(Integer hitsYesterday) {
    this.hitsYesterday = hitsYesterday;
  }

  public MyListingVehicleReadOnly dateHitsReset(DateTime dateHitsReset) {
    this.dateHitsReset = dateHitsReset;
    return this;
  }

   /**
   * Get dateHitsReset
   * @return dateHitsReset
  **/
  @ApiModelProperty(example = "null", value = "")
  public DateTime getDateHitsReset() {
    return dateHitsReset;
  }

  public void setDateHitsReset(DateTime dateHitsReset) {
    this.dateHitsReset = dateHitsReset;
  }

  public MyListingVehicleReadOnly dateValidFrom(DateTime dateValidFrom) {
    this.dateValidFrom = dateValidFrom;
    return this;
  }

   /**
   * Get dateValidFrom
   * @return dateValidFrom
  **/
  @ApiModelProperty(example = "null", value = "")
  public DateTime getDateValidFrom() {
    return dateValidFrom;
  }

  public void setDateValidFrom(DateTime dateValidFrom) {
    this.dateValidFrom = dateValidFrom;
  }

  public MyListingVehicleReadOnly vehicleTypeId(Integer vehicleTypeId) {
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

  public MyListingVehicleReadOnly makeId(Integer makeId) {
    this.makeId = makeId;
    return this;
  }

   /**
   * Get makeId
   * @return makeId
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getMakeId() {
    return makeId;
  }

  public void setMakeId(Integer makeId) {
    this.makeId = makeId;
  }

  public MyListingVehicleReadOnly make(String make) {
    this.make = make;
    return this;
  }

   /**
   * Get make
   * @return make
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public MyListingVehicleReadOnly modelId(Integer modelId) {
    this.modelId = modelId;
    return this;
  }

   /**
   * Get modelId
   * @return modelId
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getModelId() {
    return modelId;
  }

  public void setModelId(Integer modelId) {
    this.modelId = modelId;
  }

  public MyListingVehicleReadOnly typeName(String typeName) {
    this.typeName = typeName;
    return this;
  }

   /**
   * Get typeName
   * @return typeName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public MyListingVehicleReadOnly priceOriginal(Double priceOriginal) {
    this.priceOriginal = priceOriginal;
    return this;
  }

   /**
   * Get priceOriginal
   * @return priceOriginal
  **/
  @ApiModelProperty(example = "null", value = "")
  public Double getPriceOriginal() {
    return priceOriginal;
  }

  public void setPriceOriginal(Double priceOriginal) {
    this.priceOriginal = priceOriginal;
  }

  public MyListingVehicleReadOnly publicationDurationDaysLeft(Integer publicationDurationDaysLeft) {
    this.publicationDurationDaysLeft = publicationDurationDaysLeft;
    return this;
  }

   /**
   * Get publicationDurationDaysLeft
   * @return publicationDurationDaysLeft
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getPublicationDurationDaysLeft() {
    return publicationDurationDaysLeft;
  }

  public void setPublicationDurationDaysLeft(Integer publicationDurationDaysLeft) {
    this.publicationDurationDaysLeft = publicationDurationDaysLeft;
  }

  public MyListingVehicleReadOnly dateTopListing(DateTime dateTopListing) {
    this.dateTopListing = dateTopListing;
    return this;
  }

   /**
   * Get dateTopListing
   * @return dateTopListing
  **/
  @ApiModelProperty(example = "null", value = "")
  public DateTime getDateTopListing() {
    return dateTopListing;
  }

  public void setDateTopListing(DateTime dateTopListing) {
    this.dateTopListing = dateTopListing;
  }

  public MyListingVehicleReadOnly dateNewFlagExpires(DateTime dateNewFlagExpires) {
    this.dateNewFlagExpires = dateNewFlagExpires;
    return this;
  }

   /**
   * Get dateNewFlagExpires
   * @return dateNewFlagExpires
  **/
  @ApiModelProperty(example = "null", value = "")
  public DateTime getDateNewFlagExpires() {
    return dateNewFlagExpires;
  }

  public void setDateNewFlagExpires(DateTime dateNewFlagExpires) {
    this.dateNewFlagExpires = dateNewFlagExpires;
  }

  public MyListingVehicleReadOnly images(MyListingVehicleImages images) {
    this.images = images;
    return this;
  }

   /**
   * Get images
   * @return images
  **/
  @ApiModelProperty(example = "null", value = "")
  public MyListingVehicleImages getImages() {
    return images;
  }

  public void setImages(MyListingVehicleImages images) {
    this.images = images;
  }

  public MyListingVehicleReadOnly price(Double price) {
    this.price = price;
    return this;
  }

   /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(example = "null", value = "")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public MyListingVehicleReadOnly km(Integer km) {
    this.km = km;
    return this;
  }

   /**
   * Get km
   * @return km
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getKm() {
    return km;
  }

  public void setKm(Integer km) {
    this.km = km;
  }

  public MyListingVehicleReadOnly teaser(String teaser) {
    this.teaser = teaser;
    return this;
  }

   /**
   * Get teaser
   * @return teaser
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getTeaser() {
    return teaser;
  }

  public void setTeaser(String teaser) {
    this.teaser = teaser;
  }

  public MyListingVehicleReadOnly comments(String comments) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MyListingVehicleReadOnly myListingVehicleReadOnly = (MyListingVehicleReadOnly) o;
    return Objects.equals(this.id, myListingVehicleReadOnly.id) &&
        Objects.equals(this.status, myListingVehicleReadOnly.status) &&
        Objects.equals(this.statusText, myListingVehicleReadOnly.statusText) &&
        Objects.equals(this.publicationUrl, myListingVehicleReadOnly.publicationUrl) &&
        Objects.equals(this.insertionUrl, myListingVehicleReadOnly.insertionUrl) &&
        Objects.equals(this.productsUrl, myListingVehicleReadOnly.productsUrl) &&
        Objects.equals(this.firstRegMonth, myListingVehicleReadOnly.firstRegMonth) &&
        Objects.equals(this.firstRegYear, myListingVehicleReadOnly.firstRegYear) &&
        Objects.equals(this.conditionTypeId, myListingVehicleReadOnly.conditionTypeId) &&
        Objects.equals(this.hits, myListingVehicleReadOnly.hits) &&
        Objects.equals(this.hitsPerDay, myListingVehicleReadOnly.hitsPerDay) &&
        Objects.equals(this.hitsYesterday, myListingVehicleReadOnly.hitsYesterday) &&
        Objects.equals(this.dateHitsReset, myListingVehicleReadOnly.dateHitsReset) &&
        Objects.equals(this.dateValidFrom, myListingVehicleReadOnly.dateValidFrom) &&
        Objects.equals(this.vehicleTypeId, myListingVehicleReadOnly.vehicleTypeId) &&
        Objects.equals(this.makeId, myListingVehicleReadOnly.makeId) &&
        Objects.equals(this.make, myListingVehicleReadOnly.make) &&
        Objects.equals(this.modelId, myListingVehicleReadOnly.modelId) &&
        Objects.equals(this.typeName, myListingVehicleReadOnly.typeName) &&
        Objects.equals(this.priceOriginal, myListingVehicleReadOnly.priceOriginal) &&
        Objects.equals(this.publicationDurationDaysLeft, myListingVehicleReadOnly.publicationDurationDaysLeft) &&
        Objects.equals(this.dateTopListing, myListingVehicleReadOnly.dateTopListing) &&
        Objects.equals(this.dateNewFlagExpires, myListingVehicleReadOnly.dateNewFlagExpires) &&
        Objects.equals(this.images, myListingVehicleReadOnly.images) &&
        Objects.equals(this.price, myListingVehicleReadOnly.price) &&
        Objects.equals(this.km, myListingVehicleReadOnly.km) &&
        Objects.equals(this.teaser, myListingVehicleReadOnly.teaser) &&
        Objects.equals(this.comments, myListingVehicleReadOnly.comments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, statusText, publicationUrl, insertionUrl, productsUrl, firstRegMonth, firstRegYear, conditionTypeId, hits, hitsPerDay, hitsYesterday, dateHitsReset, dateValidFrom, vehicleTypeId, makeId, make, modelId, typeName, priceOriginal, publicationDurationDaysLeft, dateTopListing, dateNewFlagExpires, images, price, km, teaser, comments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MyListingVehicleReadOnly {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    statusText: ").append(toIndentedString(statusText)).append("\n");
    sb.append("    publicationUrl: ").append(toIndentedString(publicationUrl)).append("\n");
    sb.append("    insertionUrl: ").append(toIndentedString(insertionUrl)).append("\n");
    sb.append("    productsUrl: ").append(toIndentedString(productsUrl)).append("\n");
    sb.append("    firstRegMonth: ").append(toIndentedString(firstRegMonth)).append("\n");
    sb.append("    firstRegYear: ").append(toIndentedString(firstRegYear)).append("\n");
    sb.append("    conditionTypeId: ").append(toIndentedString(conditionTypeId)).append("\n");
    sb.append("    hits: ").append(toIndentedString(hits)).append("\n");
    sb.append("    hitsPerDay: ").append(toIndentedString(hitsPerDay)).append("\n");
    sb.append("    hitsYesterday: ").append(toIndentedString(hitsYesterday)).append("\n");
    sb.append("    dateHitsReset: ").append(toIndentedString(dateHitsReset)).append("\n");
    sb.append("    dateValidFrom: ").append(toIndentedString(dateValidFrom)).append("\n");
    sb.append("    vehicleTypeId: ").append(toIndentedString(vehicleTypeId)).append("\n");
    sb.append("    makeId: ").append(toIndentedString(makeId)).append("\n");
    sb.append("    make: ").append(toIndentedString(make)).append("\n");
    sb.append("    modelId: ").append(toIndentedString(modelId)).append("\n");
    sb.append("    typeName: ").append(toIndentedString(typeName)).append("\n");
    sb.append("    priceOriginal: ").append(toIndentedString(priceOriginal)).append("\n");
    sb.append("    publicationDurationDaysLeft: ").append(toIndentedString(publicationDurationDaysLeft)).append("\n");
    sb.append("    dateTopListing: ").append(toIndentedString(dateTopListing)).append("\n");
    sb.append("    dateNewFlagExpires: ").append(toIndentedString(dateNewFlagExpires)).append("\n");
    sb.append("    images: ").append(toIndentedString(images)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    km: ").append(toIndentedString(km)).append("\n");
    sb.append("    teaser: ").append(toIndentedString(teaser)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
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

