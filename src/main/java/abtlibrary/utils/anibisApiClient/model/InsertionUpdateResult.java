package abtlibrary.utils.anibisApiClient.model;

import abtlibrary.utils.anibisApiClient.StringUtil;
import java.util.*;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class InsertionUpdateResult   {
  

public enum StateEnum {
  UNKNOWN("Unknown"),
  FAILADVERTISNULL("FailAdvertIsNull"),
  FAILADVERTACCCESSDENIED("FailAdvertAcccessDenied"),
  FAILADVERTCATEGORYISMISSING("FailAdvertCategoryIsMissing"),
  FAILADVERTCATEGORYISINVALID("FailAdvertCategoryIsInvalid"),
  FAILADVERTHASNOCONTACTADDRESS("FailAdvertHasNoContactAddress"),
  FAILADVERTVALIDATION("FailAdvertValidation"),
  FAILADVERTCANTPUBLISHNEWADVERTS("FailAdvertCantPublishNewAdverts"),
  FAILADVERTCANTBEUPGRADED("FailAdvertCantBeUpgraded"),
  FAILADVERTBLOCKED("FailAdvertBlocked"),
  FAILPICTURENOTFOUND("FailPictureNotFound"),
  FAILPICTURELIMITEXCEEDED("FailPictureLimitExceeded"),
  FAILPICTUREINVALIDTYPE("FailPictureInvalidType"),
  FAILPICTURESIZEINVALID("FailPictureSizeInvalid"),
  FAILPICTURERESIZINGERROR("FailPictureResizingError"),
  FAILPRODUCTDISABLED("FailProductDisabled"),
  FAILPRODUCTINVALIDAMOUNT("FailProductInvalidAmount"),
  FAILPRODUCTCANTBUYEXPRESS("FailProductCantBuyExpress"),
  FAILPRODUCTRESTRICTIONS("FailProductRestrictions"),
  SUCCESSADVERTSAVED("SuccessAdvertSaved"),
  SUCCESSADVERTUNCHANGED("SuccessAdvertUnchanged"),
  SUCCESSADVERTONLYVALIDATED("SuccessAdvertOnlyValidated"),
  SUCCESSADVERTCANBEUPGRADED("SuccessAdvertCanBeUpgraded"),
  SUCCESSPICTUREDELETED("SuccessPictureDeleted"),
  SUCCESSPICTURESAVED("SuccessPictureSaved"),
  SUCCESSPRODUCTCONTRACTCREATED("SuccessProductContractCreated"),
  FAILCONTRACTISNULL("FailContractIsNull"),
  FAILPICTUREBLACKLISTED("FailPictureBlackListed");

  private String value;

  StateEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private StateEnum state = null;
  private Boolean isValid = null;

public enum AdvertValidationErrorEnum {
  OK("Ok"),
  LANGUAGE("Language"),
  TITLE("Title"),
  TITLEHTML("TitleHtml"),
  TITLENUMBEROFWORDS("TitleNumberOfWords"),
  TITLETOOMUCHNONALPHANUM("TitleTooMuchNonAlphanum"),
  TITLEEXISTINGTITLE("TitleExistingTitle"),
  TITLEPERCENTUPPER("TitlePercentUpper"),
  TITLEREGEXFAILED("TitleRegexFailed"),
  TITLEEMPTY("TitleEmpty"),
  DESCRIPTION("Description"),
  DESCRIPTIONHTML("DescriptionHtml"),
  DESCRIPTIONPERCENTUPPER("DescriptionPercentUpper"),
  DESCRIPTIONREGEXFAILED("DescriptionRegexFailed"),
  DESCRIPTIONEMPTY("DescriptionEmpty"),
  PRICE("Price"),
  TITLECONTAINSURL("TitleContainsUrl");

  private String value;

  AdvertValidationErrorEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private AdvertValidationErrorEnum advertValidationError = null;

public enum AddressLocationValidationErrorEnum {
  OK("Ok"),
  CITY("City"),
  CITYALLOWEDSYMBOLS("CityAllowedSymbols"),
  CITYALLOWEDSYMBOLSTREAK("CityAllowedSymbolStreak"),
  ZIP("Zip"),
  ZIPSWISS("ZipSwiss"),
  ZIPCITYCOMBINATION("ZipCityCombination"),
  COUNTRY("Country"),
  STATE("State"),
  PHONE("Phone"),
  STREET("Street");

  private String value;

  AddressLocationValidationErrorEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private AddressLocationValidationErrorEnum addressLocationValidationError = null;
  private Boolean contactTypeValid = null;
  private List<Integer> attributeGroupValidationErrors = new ArrayList<Integer>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("State")
  public StateEnum getState() {
    return state;
  }
  public void setState(StateEnum state) {
    this.state = state;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("IsValid")
  public Boolean getIsValid() {
    return isValid;
  }
  public void setIsValid(Boolean isValid) {
    this.isValid = isValid;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("AdvertValidationError")
  public AdvertValidationErrorEnum getAdvertValidationError() {
    return advertValidationError;
  }
  public void setAdvertValidationError(AdvertValidationErrorEnum advertValidationError) {
    this.advertValidationError = advertValidationError;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("AddressLocationValidationError")
  public AddressLocationValidationErrorEnum getAddressLocationValidationError() {
    return addressLocationValidationError;
  }
  public void setAddressLocationValidationError(AddressLocationValidationErrorEnum addressLocationValidationError) {
    this.addressLocationValidationError = addressLocationValidationError;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("ContactTypeValid")
  public Boolean getContactTypeValid() {
    return contactTypeValid;
  }
  public void setContactTypeValid(Boolean contactTypeValid) {
    this.contactTypeValid = contactTypeValid;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("AttributeGroupValidationErrors")
  public List<Integer> getAttributeGroupValidationErrors() {
    return attributeGroupValidationErrors;
  }
  public void setAttributeGroupValidationErrors(List<Integer> attributeGroupValidationErrors) {
    this.attributeGroupValidationErrors = attributeGroupValidationErrors;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsertionUpdateResult {\n");
    
    sb.append("    state: ").append(StringUtil.toIndentedString(state)).append("\n");
    sb.append("    isValid: ").append(StringUtil.toIndentedString(isValid)).append("\n");
    sb.append("    advertValidationError: ").append(StringUtil.toIndentedString(advertValidationError)).append("\n");
    sb.append("    addressLocationValidationError: ").append(StringUtil.toIndentedString(addressLocationValidationError)).append("\n");
    sb.append("    contactTypeValid: ").append(StringUtil.toIndentedString(contactTypeValid)).append("\n");
    sb.append("    attributeGroupValidationErrors: ").append(StringUtil.toIndentedString(attributeGroupValidationErrors)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
