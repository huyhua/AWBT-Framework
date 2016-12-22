package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class GeoLocationDto   {
  
  private Integer id = null;
  private String countryCode = null;
  private Integer stateId = null;
  private Integer districtId = null;
  private String zipCode = null;
  private Double latitude = null;
  private Double longitude = null;
  private Boolean isPreferred = null;
  private String name = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("CountryCode")
  public String getCountryCode() {
    return countryCode;
  }
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("StateId")
  public Integer getStateId() {
    return stateId;
  }
  public void setStateId(Integer stateId) {
    this.stateId = stateId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("DistrictId")
  public Integer getDistrictId() {
    return districtId;
  }
  public void setDistrictId(Integer districtId) {
    this.districtId = districtId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("ZipCode")
  public String getZipCode() {
    return zipCode;
  }
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Latitude")
  public Double getLatitude() {
    return latitude;
  }
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Longitude")
  public Double getLongitude() {
    return longitude;
  }
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("IsPreferred")
  public Boolean getIsPreferred() {
    return isPreferred;
  }
  public void setIsPreferred(Boolean isPreferred) {
    this.isPreferred = isPreferred;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoLocationDto {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    countryCode: ").append(StringUtil.toIndentedString(countryCode)).append("\n");
    sb.append("    stateId: ").append(StringUtil.toIndentedString(stateId)).append("\n");
    sb.append("    districtId: ").append(StringUtil.toIndentedString(districtId)).append("\n");
    sb.append("    zipCode: ").append(StringUtil.toIndentedString(zipCode)).append("\n");
    sb.append("    latitude: ").append(StringUtil.toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(StringUtil.toIndentedString(longitude)).append("\n");
    sb.append("    isPreferred: ").append(StringUtil.toIndentedString(isPreferred)).append("\n");
    sb.append("    name: ").append(StringUtil.toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
