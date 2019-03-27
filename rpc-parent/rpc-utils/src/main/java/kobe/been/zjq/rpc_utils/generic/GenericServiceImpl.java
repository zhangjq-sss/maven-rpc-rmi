package kobe.been.zjq.rpc_utils.generic;

import org.springframework.transaction.annotation.Transactional;

/**
 * GenericService的实现类, 其他的自定义 ServiceImpl, 继承自它,可以获得常用的增删查改操作,
 * 未实现的方法有 子类各自实现
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 * @author junquanzhang
 */
public abstract class GenericServiceImpl<Model, PK> implements GenericService<Model, PK> {

    /**
     * 定义成抽象方法,由子类实现,完成dao的注入
     *
     * @return GenericDao实现类
     */
    public abstract GenericDao<Model, PK> getDao();

    @Transactional
    @Override
    public int insert(Model model) {
    	int result = 0;
    	result = getDao().insertSelective(model);
        return result;
    }

    @Transactional
    @Override
    public int update(Model model) {
        int result = 0;
    	result = getDao().updateByPrimaryKeySelective(model);
        return result;
    }

    @Transactional
    @Override
    public int deleteByKey(PK id) {
        int result = 0;
    	result = getDao().deleteByPrimaryKey(id);
        return result;
    }
    
    @Override
    public Model getById(PK id) {
        return getDao().selectByPrimaryKey(id);
    }

    @Override
	public boolean checkoutInsert(Model model) {
		return true;
	}

	@Override
	public boolean checkoutUpdate(Model model) {
		return true;
	}

	@Override
	public boolean checkoutDelete(Model model) {
		return true;
	}
}
