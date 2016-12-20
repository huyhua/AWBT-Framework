package abtlibrary.utils.is24ApiClient.Model.Searchjob;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class MainImage {

	@SerializedName("ID")
	@Expose
	private Integer ID;
	@SerializedName("Title")
	@Expose
	private String Title;
	@SerializedName("Description")
	@Expose
	private Object Description;
	@SerializedName("Source")
	@Expose
	private Integer Source;
	@SerializedName("Url")
	@Expose
	private String Url;
	@SerializedName("ImgWidth")
	@Expose
	private Integer ImgWidth;
	@SerializedName("ImgHeight")
	@Expose
	private Integer ImgHeight;
	@SerializedName("SortOrder")
	@Expose
	private Integer SortOrder;
	@SerializedName("LastModifiedDate")
	@Expose
	private String LastModifiedDate;
	@SerializedName("Type")
	@Expose
	private String Type;

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
	 * @return The Title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * 
	 * @param Title
	 *            The Title
	 */
	public void setTitle(String Title) {
		this.Title = Title;
	}

	/**
	 * 
	 * @return The Description
	 */
	public Object getDescription() {
		return Description;
	}

	/**
	 * 
	 * @param Description
	 *            The Description
	 */
	public void setDescription(Object Description) {
		this.Description = Description;
	}

	/**
	 * 
	 * @return The Source
	 */
	public Integer getSource() {
		return Source;
	}

	/**
	 * 
	 * @param Source
	 *            The Source
	 */
	public void setSource(Integer Source) {
		this.Source = Source;
	}

	/**
	 * 
	 * @return The Url
	 */
	public String getUrl() {
		return Url;
	}

	/**
	 * 
	 * @param Url
	 *            The Url
	 */
	public void setUrl(String Url) {
		this.Url = Url;
	}

	/**
	 * 
	 * @return The ImgWidth
	 */
	public Integer getImgWidth() {
		return ImgWidth;
	}

	/**
	 * 
	 * @param ImgWidth
	 *            The ImgWidth
	 */
	public void setImgWidth(Integer ImgWidth) {
		this.ImgWidth = ImgWidth;
	}

	/**
	 * 
	 * @return The ImgHeight
	 */
	public Integer getImgHeight() {
		return ImgHeight;
	}

	/**
	 * 
	 * @param ImgHeight
	 *            The ImgHeight
	 */
	public void setImgHeight(Integer ImgHeight) {
		this.ImgHeight = ImgHeight;
	}

	/**
	 * 
	 * @return The SortOrder
	 */
	public Integer getSortOrder() {
		return SortOrder;
	}

	/**
	 * 
	 * @param SortOrder
	 *            The SortOrder
	 */
	public void setSortOrder(Integer SortOrder) {
		this.SortOrder = SortOrder;
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
	 * @return The Type
	 */
	public String getType() {
		return Type;
	}

	/**
	 * 
	 * @param Type
	 *            The Type
	 */
	public void setType(String Type) {
		this.Type = Type;
	}

}
