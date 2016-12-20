package abtlibrary.utils.is24ApiClient.Model.Favorite;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class FavoriteResponse {

	@SerializedName("FavouriteProperties")
	@Expose
	private List<FavouriteProperty> FavouriteProperties = new ArrayList<FavouriteProperty>();

	/**
	 * 
	 * @return The FavouriteProperties
	 */
	public List<FavouriteProperty> getFavouriteProperties() {
		return FavouriteProperties;
	}

	/**
	 * 
	 * @param FavouriteProperties
	 *            The FavouriteProperties
	 */
	public void setFavouriteProperties(
			List<FavouriteProperty> FavouriteProperties) {
		this.FavouriteProperties = FavouriteProperties;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
