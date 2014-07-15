package hibernate.dao.ex;

import hibernate.dao.MaterialPlan;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import juinfo.hibernate.HibernateDAO;
import juinfo.paper.PaperHQL;

import org.hibernate.SessionFactory;

public class MaterialPlanDAO extends hibernate.dao.MaterialPlanDAO implements PaperHQL
{
	private HibernateDAO hibernateDAO;

	public MaterialPlanDAO(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
		hibernateDAO = new HibernateDAO(sessionFactory);
	}

	/**
	 * @author huangzhixia
	 */
	public String getHQLFind()
	{
		return "from MaterialPlan order by to_char(tdate,'yyyy-MM-dd')";
	}

	public String getHQLFindCount()
	{
		return "select count(*) from MaterialPlan";
	}

	public String getHQLSearch(String key)
	{
		return String.format("from MaterialPlan where bom.code like '%%%s%%'", key);
	}

	public String getHQLSearchCount(String key)
	{
		return String.format("select count(*) from MaterialPlan where bom.code like '%%%s%%'", key);
	}

	/**
	 * @author huangzhixia
	 * */
	@SuppressWarnings("unchecked")
	public List<MaterialPlan> findByCodeAndDate(Integer codeId, String date)
	{
		String sql = String.format("from MaterialPlan where bomId = %d and to_char(tdate,'yyyy-MM-dd') = '%s'", codeId,
				date);
		return (List<MaterialPlan>) getHibernateTemplate().find(sql);
	}

	public boolean hasRecord(Integer itemId, String date)
	{
		String sql = String.format(
				"select * from make.MaterialPlan where bom_Id = %d and to_char(tdate,'yyyy-MM-dd') = '%s'", itemId,
				date);
		System.out.println(sql);
		try
		{
			return hibernateDAO.hasRecordSQL(sql);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean hasRecord(Integer itemId, Date date)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = format.format(date);
		String sql = String.format(
				"select * from make.MaterialPlan where bom_id = %d and to_char(tdate, 'yyyy-MM-dd') = '%s'", itemId,
				strDate);
		try
		{
			return hibernateDAO.hasRecordSQL(sql);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public void delete(Integer bomId)
	{
		String sql = String.format("delete from make.MaterialPlan where item_id = %d", bomId);
		hibernateDAO.executeSQL(sql);
	}

	public void delete(Integer bomId, Date date)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = format.format(date);
		String sql = String.format(
				"delete from make.MaterialPlan where bom_id = %d and to_char(tdate, 'yyyy-MM-dd') = '%s'", bomId,
				strDate);
		hibernateDAO.executeSQL(sql);
	}

	// public void insertBatch(List<MaterialPlan> data)
	// {
	// for (int i = 0; i < data.size(); i++)
	// {
	// MaterialPlan plan = data.get(i);
	// save(plan);
	// }
	// }
}
