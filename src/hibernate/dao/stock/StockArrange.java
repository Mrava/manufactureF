package hibernate.dao.stock;

import hibernate.dao.Bom;

import java.util.List;

/**
 * StockArrangeId entity. @author MyEclipse Persistence Tools
 */

public class StockArrange implements java.io.Serializable
{

	// Fields

	private Integer itemId;
	private Integer quantity;

	// Constructors

	/** default constructor */
	public StockArrange()
	{
	}

	/** full constructor */
	public StockArrange(Integer itemId, Integer quantity)
	{
		this.itemId = itemId;
		this.quantity = quantity;
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

	public Integer getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StockArrange))
			return false;
		StockArrange castOther = (StockArrange) other;

		return ((this.getItemId() == castOther.getItemId()) || (this.getItemId() != null
				&& castOther.getItemId() != null && this.getItemId().equals(castOther.getItemId())))
				&& ((this.getQuantity() == castOther.getQuantity()) || (this.getQuantity() != null
						&& castOther.getQuantity() != null && this.getQuantity().equals(castOther.getQuantity())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getItemId() == null ? 0 : this.getItemId().hashCode());
		result = 37 * result + (getQuantity() == null ? 0 : this.getQuantity().hashCode());
		return result;
	}

	private Bom bom;

	public Bom getBom()
	{
		return bom;
	}

	public void setBom(Bom bom)
	{
		this.bom = bom;
	}

	private List<StockProcess> processes;

	public List<StockProcess> getProcesses()
	{
		return processes;
	}

	public void setProcesses(List<StockProcess> processes)
	{
		this.processes = processes;
	}

}