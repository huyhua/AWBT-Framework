package abtlibrary.utils.anibisApiClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import abtlibrary.utils.anibisApiClient.model.*;

public class JsonUtil {
  public static GsonBuilder gsonBuilder;

  static {
    gsonBuilder = new GsonBuilder();
    gsonBuilder.serializeNulls();
    gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
  }

  public static Gson getGson() {
    return gsonBuilder.create();
  }

  public static String serialize(Object obj){
    return getGson().toJson(obj);
  }

  public static <T> T deserializeToList(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getListTypeForDeserialization(cls));
  }

  public static <T> T deserializeToObject(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getTypeForDeserialization(cls));
  }

  public static Type getListTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    
    if ("AddressDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<AddressDto>>(){}.getType();
    }
    
    if ("AdvertDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<AdvertDto>>(){}.getType();
    }
    
    if ("IdListDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<IdListDto>>(){}.getType();
    }
    
    if ("PictureDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<PictureDto>>(){}.getType();
    }
    
    if ("AdvertDetailDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<AdvertDetailDto>>(){}.getType();
    }
    
    if ("UserDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserDto>>(){}.getType();
    }
    
    if ("AddressModel".equalsIgnoreCase(className)) {
      return new TypeToken<List<AddressModel>>(){}.getType();
    }
    
    if ("AttributeDataDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<AttributeDataDto>>(){}.getType();
    }
    
    if ("AdvertInsertion".equalsIgnoreCase(className)) {
      return new TypeToken<List<AdvertInsertion>>(){}.getType();
    }
    
    if ("InsertionUpdateResult".equalsIgnoreCase(className)) {
      return new TypeToken<List<InsertionUpdateResult>>(){}.getType();
    }
    
    if ("AttributeDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<AttributeDto>>(){}.getType();
    }
    
    if ("AttributeEntryDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<AttributeEntryDto>>(){}.getType();
    }
    
    if ("NumericRangeDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<NumericRangeDto>>(){}.getType();
    }
    
    if ("CategoryAttributeListDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<CategoryAttributeListDto>>(){}.getType();
    }
    
    if ("CategoryAttributesDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<CategoryAttributesDto>>(){}.getType();
    }
    
    if ("CategoryDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<CategoryDto>>(){}.getType();
    }
    
    if ("FeedbackDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<FeedbackDto>>(){}.getType();
    }
    
    if ("KeyValueListDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<KeyValueListDto>>(){}.getType();
    }
    
    if ("GeoLocationDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<GeoLocationDto>>(){}.getType();
    }
    
    if ("MailContentDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<MailContentDto>>(){}.getType();
    }
    
    if ("RegisterModel".equalsIgnoreCase(className)) {
      return new TypeToken<List<RegisterModel>>(){}.getType();
    }
    
    if ("ChangesDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<ChangesDto>>(){}.getType();
    }
    
    if ("ProductDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<ProductDto>>(){}.getType();
    }
    
    if ("TextResourceDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<TextResourceDto>>(){}.getType();
    }
    
    if ("SearchResultDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<SearchResultDto>>(){}.getType();
    }
    
    if ("SearchParameterDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<SearchParameterDto>>(){}.getType();
    }
    
    if ("AttributeSearchParametersDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<AttributeSearchParametersDto>>(){}.getType();
    }
    
    if ("AttributeTextDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<AttributeTextDto>>(){}.getType();
    }
    
    if ("AttributeRangeDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<AttributeRangeDto>>(){}.getType();
    }
    
    if ("SearchJobDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<SearchJobDto>>(){}.getType();
    }
    
    if ("SettingDto".equalsIgnoreCase(className)) {
      return new TypeToken<List<SettingDto>>(){}.getType();
    }
    
    return new TypeToken<List<Object>>(){}.getType();
  }

  public static Type getTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    
    if ("AddressDto".equalsIgnoreCase(className)) {
      return new TypeToken<AddressDto>(){}.getType();
    }
    
    if ("AdvertDto".equalsIgnoreCase(className)) {
      return new TypeToken<AdvertDto>(){}.getType();
    }
    
    if ("IdListDto".equalsIgnoreCase(className)) {
      return new TypeToken<IdListDto>(){}.getType();
    }
    
    if ("PictureDto".equalsIgnoreCase(className)) {
      return new TypeToken<PictureDto>(){}.getType();
    }
    
    if ("AdvertDetailDto".equalsIgnoreCase(className)) {
      return new TypeToken<AdvertDetailDto>(){}.getType();
    }
    
    if ("UserDto".equalsIgnoreCase(className)) {
      return new TypeToken<UserDto>(){}.getType();
    }
    
    if ("AddressModel".equalsIgnoreCase(className)) {
      return new TypeToken<AddressModel>(){}.getType();
    }
    
    if ("AttributeDataDto".equalsIgnoreCase(className)) {
      return new TypeToken<AttributeDataDto>(){}.getType();
    }
    
    if ("AdvertInsertion".equalsIgnoreCase(className)) {
      return new TypeToken<AdvertInsertion>(){}.getType();
    }
    
    if ("InsertionUpdateResult".equalsIgnoreCase(className)) {
      return new TypeToken<InsertionUpdateResult>(){}.getType();
    }
    
    if ("AttributeDto".equalsIgnoreCase(className)) {
      return new TypeToken<AttributeDto>(){}.getType();
    }
    
    if ("AttributeEntryDto".equalsIgnoreCase(className)) {
      return new TypeToken<AttributeEntryDto>(){}.getType();
    }
    
    if ("NumericRangeDto".equalsIgnoreCase(className)) {
      return new TypeToken<NumericRangeDto>(){}.getType();
    }
    
    if ("CategoryAttributeListDto".equalsIgnoreCase(className)) {
      return new TypeToken<CategoryAttributeListDto>(){}.getType();
    }
    
    if ("CategoryAttributesDto".equalsIgnoreCase(className)) {
      return new TypeToken<CategoryAttributesDto>(){}.getType();
    }
    
    if ("CategoryDto".equalsIgnoreCase(className)) {
      return new TypeToken<CategoryDto>(){}.getType();
    }
    
    if ("FeedbackDto".equalsIgnoreCase(className)) {
      return new TypeToken<FeedbackDto>(){}.getType();
    }
    
    if ("KeyValueListDto".equalsIgnoreCase(className)) {
      return new TypeToken<KeyValueListDto>(){}.getType();
    }
    
    if ("GeoLocationDto".equalsIgnoreCase(className)) {
      return new TypeToken<GeoLocationDto>(){}.getType();
    }
    
    if ("MailContentDto".equalsIgnoreCase(className)) {
      return new TypeToken<MailContentDto>(){}.getType();
    }
    
    if ("RegisterModel".equalsIgnoreCase(className)) {
      return new TypeToken<RegisterModel>(){}.getType();
    }
    
    if ("ChangesDto".equalsIgnoreCase(className)) {
      return new TypeToken<ChangesDto>(){}.getType();
    }
    
    if ("ProductDto".equalsIgnoreCase(className)) {
      return new TypeToken<ProductDto>(){}.getType();
    }
    
    if ("TextResourceDto".equalsIgnoreCase(className)) {
      return new TypeToken<TextResourceDto>(){}.getType();
    }
    
    if ("SearchResultDto".equalsIgnoreCase(className)) {
      return new TypeToken<SearchResultDto>(){}.getType();
    }
    
    if ("SearchParameterDto".equalsIgnoreCase(className)) {
      return new TypeToken<SearchParameterDto>(){}.getType();
    }
    
    if ("AttributeSearchParametersDto".equalsIgnoreCase(className)) {
      return new TypeToken<AttributeSearchParametersDto>(){}.getType();
    }
    
    if ("AttributeTextDto".equalsIgnoreCase(className)) {
      return new TypeToken<AttributeTextDto>(){}.getType();
    }
    
    if ("AttributeRangeDto".equalsIgnoreCase(className)) {
      return new TypeToken<AttributeRangeDto>(){}.getType();
    }
    
    if ("SearchJobDto".equalsIgnoreCase(className)) {
      return new TypeToken<SearchJobDto>(){}.getType();
    }
    
    if ("SettingDto".equalsIgnoreCase(className)) {
      return new TypeToken<SettingDto>(){}.getType();
    }
    
    return new TypeToken<Object>(){}.getType();
  }

};
