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
import abtlibrary.utils.as24ApiClient.model.AdDealer;
import abtlibrary.utils.as24ApiClient.model.MetaData;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;


/**
 * ResponseMessageCollectionListAdDealer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-12-21T15:07:04.675+07:00")
public class ResponseMessageCollectionListAdDealer   {
  @SerializedName("lastModified")
  private DateTime lastModified = null;

  @SerializedName("total")
  private Integer total = null;

  @SerializedName("count")
  private Integer count = null;

  @SerializedName("skip")
  private Integer skip = null;

  @SerializedName("take")
  private Integer take = null;

  @SerializedName("results")
  private List<AdDealer> results = new ArrayList<AdDealer>();

  @SerializedName("metaData")
  private MetaData metaData = null;

  @SerializedName("href")
  private String href = null;

  @SerializedName("normalizedQuery")
  private String normalizedQuery = null;

  public ResponseMessageCollectionListAdDealer lastModified(DateTime lastModified) {
    this.lastModified = lastModified;
    return this;
  }

   /**
   * Get lastModified
   * @return lastModified
  **/
  @ApiModelProperty(example = "null", value = "")
  public DateTime getLastModified() {
    return lastModified;
  }

  public void setLastModified(DateTime lastModified) {
    this.lastModified = lastModified;
  }

  public ResponseMessageCollectionListAdDealer total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * Get total
   * @return total
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public ResponseMessageCollectionListAdDealer count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * Get count
   * @return count
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

   /**
   * Get skip
   * @return skip
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getSkip() {
    return skip;
  }

   /**
   * Get take
   * @return take
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getTake() {
    return take;
  }

  public ResponseMessageCollectionListAdDealer results(List<AdDealer> results) {
    this.results = results;
    return this;
  }

  public ResponseMessageCollectionListAdDealer addResultsItem(AdDealer resultsItem) {
    this.results.add(resultsItem);
    return this;
  }

   /**
   * Get results
   * @return results
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<AdDealer> getResults() {
    return results;
  }

  public void setResults(List<AdDealer> results) {
    this.results = results;
  }

  public ResponseMessageCollectionListAdDealer metaData(MetaData metaData) {
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
    ResponseMessageCollectionListAdDealer responseMessageCollectionListAdDealer = (ResponseMessageCollectionListAdDealer) o;
    return Objects.equals(this.lastModified, responseMessageCollectionListAdDealer.lastModified) &&
        Objects.equals(this.total, responseMessageCollectionListAdDealer.total) &&
        Objects.equals(this.count, responseMessageCollectionListAdDealer.count) &&
        Objects.equals(this.skip, responseMessageCollectionListAdDealer.skip) &&
        Objects.equals(this.take, responseMessageCollectionListAdDealer.take) &&
        Objects.equals(this.results, responseMessageCollectionListAdDealer.results) &&
        Objects.equals(this.metaData, responseMessageCollectionListAdDealer.metaData) &&
        Objects.equals(this.href, responseMessageCollectionListAdDealer.href) &&
        Objects.equals(this.normalizedQuery, responseMessageCollectionListAdDealer.normalizedQuery);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastModified, total, count, skip, take, results, metaData, href, normalizedQuery);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseMessageCollectionListAdDealer {\n");
    
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    skip: ").append(toIndentedString(skip)).append("\n");
    sb.append("    take: ").append(toIndentedString(take)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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

