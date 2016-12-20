package abtlibrary.utils.is24ApiClient.Model.Searchjob;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class SearchResponse {

	@SerializedName("PropertiesList")
	@Expose
	private PropertiesList PropertiesList;

	/**
	 * 
	 * @return The PropertiesList
	 */
	public PropertiesList getPropertiesList() {
		return PropertiesList;
	}

	/**
	 * 
	 * @param PropertiesList
	 *            The PropertiesList
	 */
	public void setPropertiesList(PropertiesList PropertiesList) {
		this.PropertiesList = PropertiesList;
	}

}
