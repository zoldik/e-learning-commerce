package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import org.elearning.entities.Library;

@Remote
public interface LibrarySessionRemote extends Serializable{
	
	public void persist(Library library);
	
	public void edit(Library library);

    public void remove(Library library);
    
    public Library find(Object id);
    
    public List<Library> findAll();
    
    public List<Library> findChecked(List<Integer> idx);

}
