package abtlibrary.utils.is24ApiClient.Model.Favorite;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Property {

	@SerializedName("PropertyDetails")
	@Expose
	private abtlibrary.utils.is24ApiClient.Model.Favorite.PropertyDetails PropertyDetails;
	@SerializedName("MainImage")
	@Expose
	private Object MainImage;

	/**
	 * 
	 * @return The PropertyDetails
	 */
	public abtlibrary.utils.is24ApiClient.Model.Favorite.PropertyDetails getPropertyDetails() {
		return PropertyDetails;
	}

	/**
	 * 
	 * @param PropertyDetails
	 *            The PropertyDetails
	 */
	public void setPropertyDetails(
			abtlibrary.utils.is24ApiClient.Model.Favorite.PropertyDetails PropertyDetails) {
		this.PropertyDetails = PropertyDetails;
	}

	/**
	 * 
	 * @return The MainImage
	 */
	public Object getMainImage() {
		return MainImage;
	}

	/**
	 * 
	 * @param MainImage
	 *            The MainImage
	 */
	public void setMainImage(Object MainImage) {
		this.MainImage = MainImage;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
