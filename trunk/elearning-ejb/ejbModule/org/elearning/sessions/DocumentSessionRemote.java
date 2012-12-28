package org.elearning.sessions;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import org.elearning.entities.Document;

@Remote
public interface DocumentSessionRemote extends Serializable{
	
	public void persist(Document document);
	
	public void edit(Document document);

    public void remove(Document document);
    
    public Document find(Object id);
    
    public List<Document> findAll();
    
    public List<Document> findChecked(List<Integer> idx);

}
