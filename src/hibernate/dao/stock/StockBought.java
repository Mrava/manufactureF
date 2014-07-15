package hibernate.dao.stock;

import java.math.BigDecimal;
import java.util.Date;

/**
 * StockBoughtId entity. @author MyEclipse Persistence Tools
 */

public class StockBought implements java.io.Serializable
{

	// Fields

	private Integer itemId;
	private Double quantity;
	private Date tdate;

	// Constructors

	/** default constructor */
	public StockBought()
	{
	}

	/** full constructor */
	public StockBought(Integer itemId, Double quantity, Date tdate)
	{
		this.itemId = itemId;
		this.quantity = quantity;
		this.tdate = tdate;
	}

	// Property accessors

	public Integer getItemId()
	{
		return this.itemId;
	}

	public void setItemId(Integer itemId)
	{
		this.itemId = itemId;
	}

	public Double getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(Double quantity)
	{
		this.quantity = quantity;
	}

	public Date getTdate()
	{
		return this.tdate;
	}

	public void setTdate(Date tdate)
	{
		this.tdate = tdate;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StockBought))
			return false;
		StockBought castOther = (StockBought) other;

		return ((this.getItemId() == castOther.getItemId()) || (this.getItemId() != null
				&& castOther.getItemId() != null && this.getItemId().equals(castOther.getItemId())))
				&& ((this.getQuantity() == castOther.getQuantity()) || (this.getQuantity() != null
						&& castOther.getQuantity() != null && this.getQuantity().equals(castOther.getQuantity())))
				&& ((this.getTdate() == castOther.getTdate()) || (this.getTdate() != null
						&& castOther.getTdate() != null && this.getTdate().equals(castOther.getTdate())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getItemId() == null ? 0 : this.getItemId().hashCode());
		result = 37 * result + (getQuantity() == null ? 0 : this.getQuantity().hashCode());
		result = 37 * result + (getTdate() == null ? 0 : this.getTdate().hashCode());
		return result;
	}

}