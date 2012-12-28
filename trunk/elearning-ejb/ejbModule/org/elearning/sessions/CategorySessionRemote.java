package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import org.elearning.entities.Category;

@Remote
public interface CategorySessionRemote extends Serializable{
	
	public void persist(Category category);
	
	public void edit(Category category);

    public void remove(Category category);
    
    public Category find(Object id);
    
    public List<Category> findAll();
    
    public List<Category> findChecked(List<Integer> idx);

}
