package abtlibrary.utils.is24ApiClient.Model.Searchjob;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Property {

	@SerializedName("PropertyDetails")
	@Expose
	private PropertyDetails PropertyDetails;
	@SerializedName("MainImage")
	@Expose
	private MainImage MainImage;

	/**
	 * 
	 * @return The PropertyDetails
	 */
	public PropertyDetails getPropertyDetails() {
		return PropertyDetails;
	}

	/**
	 * 
	 * @param PropertyDetails
	 *            The PropertyDetails
	 */
	public void setPropertyDetails(PropertyDetails PropertyDetails) {
		this.PropertyDetails = PropertyDetails;
	}

	/**
	 * 
	 * @return The MainImage
	 */
	public MainImage getMainImage() {
		return MainImage;
	}

	/**
	 * 
	 * @param MainImage
	 *            The MainImage
	 */
	public void setMainImage(MainImage MainImage) {
		this.MainImage = MainImage;
	}

}
