package abtlibrary.utils.is24ApiClient.Model.Searchjob;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class PropertiesList {

	@SerializedName("CurrentPage")
	@Expose
	private Integer CurrentPage;
	@SerializedName("ItemsOnPage")
	@Expose
	private Integer ItemsOnPage;
	@SerializedName("ItemsPerPage")
	@Expose
	private Integer ItemsPerPage;
	@SerializedName("TotalMatches")
	@Expose
	private Integer TotalMatches;
	@SerializedName("TotalPages")
	@Expose
	private Integer TotalPages;
	@SerializedName("ContainsAbroadProperties")
	@Expose
	private Boolean ContainsAbroadProperties;
	@SerializedName("HasAbroadProperties")
	@Expose
	private Boolean HasAbroadProperties;
	@SerializedName("Properties")
	@Expose
	private List<Property> Properties = new ArrayList<Property>();

	/**
	 * 
	 * @return The CurrentPage
	 */
	public Integer getCurrentPage() {
		return CurrentPage;
	}

	/**
	 * 
	 * @param CurrentPage
	 *            The CurrentPage
	 */
	public void setCurrentPage(Integer CurrentPage) {
		this.CurrentPage = CurrentPage;
	}

	/**
	 * 
	 * @return The ItemsOnPage
	 */
	public Integer getItemsOnPage() {
		return ItemsOnPage;
	}

	/**
	 * 
	 * @param ItemsOnPage
	 *            The ItemsOnPage
	 */
	public void setItemsOnPage(Integer ItemsOnPage) {
		this.ItemsOnPage = ItemsOnPage;
	}

	/**
	 * 
	 * @return The ItemsPerPage
	 */
	public Integer getItemsPerPage() {
		return ItemsPerPage;
	}

	/**
	 * 
	 * @param ItemsPerPage
	 *            The ItemsPerPage
	 */
	public void setItemsPerPage(Integer ItemsPerPage) {
		this.ItemsPerPage = ItemsPerPage;
	}

	/**
	 * 
	 * @return The TotalMatches
	 */
	public Integer getTotalMatches() {
		return TotalMatches;
	}

	/**
	 * 
	 * @param TotalMatches
	 *            The TotalMatches
	 */
	public void setTotalMatches(Integer TotalMatches) {
		this.TotalMatches = TotalMatches;
	}

	/**
	 * 
	 * @return The TotalPages
	 */
	public Integer getTotalPages() {
		return TotalPages;
	}

	/**
	 * 
	 * @param TotalPages
	 *            The TotalPages
	 */
	public void setTotalPages(Integer TotalPages) {
		this.TotalPages = TotalPages;
	}

	/**
	 * 
	 * @return The ContainsAbroadProperties
	 */
	public Boolean getContainsAbroadProperties() {
		return ContainsAbroadProperties;
	}

	/**
	 * 
	 * @param ContainsAbroadProperties
	 *            The ContainsAbroadProperties
	 */
	public void setContainsAbroadProperties(Boolean ContainsAbroadProperties) {
		this.ContainsAbroadProperties = ContainsAbroadProperties;
	}

	/**
	 * 
	 * @return The HasAbroadProperties
	 */
	public Boolean getHasAbroadProperties() {
		return HasAbroadProperties;
	}

	/**
	 * 
	 * @param HasAbroadProperties
	 *            The HasAbroadProperties
	 */
	public void setHasAbroadProperties(Boolean HasAbroadProperties) {
		this.HasAbroadProperties = HasAbroadProperties;
	}

	/**
	 * 
	 * @return The Properties
	 */
	public List<Property> getProperties() {
		return Properties;
	}

	/**
	 * 
	 * @param Properties
	 *            The Properties
	 */
	public void setProperties(List<Property> Properties) {
		this.Properties = Properties;
	}

}
