package abtlibrary.utils.is24ApiClient.Model.Favorite;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class FavouriteProperty {

	@SerializedName("ID")
	@Expose
	private Integer ID;
	@SerializedName("PropertyID")
	@Expose
	private Integer PropertyID;
	@SerializedName("LastModifiedDate")
	@Expose
	private String LastModifiedDate;
	@SerializedName("Status")
	@Expose
	private String Status;
	@SerializedName("Property")
	@Expose
	private abtlibrary.utils.is24ApiClient.Model.Favorite.Property Property;

	/**
	 * 
	 * @return The ID
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * 
	 * @param ID
	 *            The ID
	 */
	public void setID(Integer ID) {
		this.ID = ID;
	}

	/**
	 * 
	 * @return The PropertyID
	 */
	public Integer getPropertyID() {
		return PropertyID;
	}

	/**
	 * 
	 * @param PropertyID
	 *            The PropertyID
	 */
	public void setPropertyID(Integer PropertyID) {
		this.PropertyID = PropertyID;
	}

	/**
	 * 
	 * @return The LastModifiedDate
	 */
	public String getLastModifiedDate() {
		return LastModifiedDate;
	}

	/**
	 * 
	 * @param LastModifiedDate
	 *            The LastModifiedDate
	 */
	public void setLastModifiedDate(String LastModifiedDate) {
		this.LastModifiedDate = LastModifiedDate;
	}

	/**
	 * 
	 * @return The Status
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * 
	 * @param Status
	 *            The Status
	 */
	public void setStatus(String Status) {
		this.Status = Status;
	}

	/**
	 * 
	 * @return The Property
	 */
	public abtlibrary.utils.is24ApiClient.Model.Favorite.Property getProperty() {
		return Property;
	}

	/**
	 * 
	 * @param Property
	 *            The Property
	 */
	public void setProperty(
			abtlibrary.utils.is24ApiClient.Model.Favorite.Property Property) {
		this.Property = Property;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
