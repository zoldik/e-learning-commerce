package com.elearning.admin.actions;

import java.io.File;
import java.io.IOException;
import java.security.cert.Extension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.elearning.entities.Administrator;
import org.elearning.entities.Category;
import org.elearning.entities.Formation;
import org.elearning.entities.Document;
import org.elearning.sessions.CategorySessionRemote;
import org.elearning.sessions.FormationSessionRemote;
import org.elearning.sessions.DocumentSessionRemote;

import com.elearning.front.actions.LoginRequired;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DocumentAction extends ActionSupport implements
		ModelDriven<Document>, RequestAware, ParameterAware, LoginRequired {

	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	private Document document = new Document();
	private List<Document> documents = new ArrayList<Document>();
	private Map<Integer, String> categorySelect = new HashMap<Integer, String>();
	private Map<Integer, String> formationSelect = new HashMap<Integer, String>();
	private DocumentSessionRemote documentService;
	private FormationSessionRemote formationService;
	private CategorySessionRemote categoryService;

	private File file;
	private String contentType;
	private String filename;

	public DocumentAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			documentService = (DocumentSessionRemote) ctx
					.lookup("DocumentSession/remote");
			formationService = (FormationSessionRemote) ctx
					.lookup("FormationSession/remote");
			categoryService = (CategorySessionRemote) ctx
					.lookup("CategorySession/remote");

		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Document getModel() {
		// TODO Auto-generated method stub
		return document;
	}

	/**
	 * To save or update document.
	 * 
	 * @return String
	 */
	public String save() {
		int mid= this.filename.lastIndexOf(".");
		String extension=this.filename.substring(mid+1,this.filename.length());
		Category category = this.detectCategoryForFile(extension);
		String path= "C:\\Library";
		this.uploadFile(path);
		document.setCategory(category);
		document.setPath(path+"\\"+this.filename);
		documentService.edit(document);
		return SUCCESS;
	}
	
	private Category detectCategoryForFile(String extension){
		List<Category> categories = categoryService.findAll();
		for(Category category : categories){
			if(category.getExtension().contains(extension)){
				return category;
			}
		}
		return null;
	}
	
	private void uploadFile(String path){
		try {
			File destDir = new File(path,this.filename);
			FileUtils.copyFile(file, destDir, true);
			} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * To save or update document.
	 * 
	 * @return String
	 */
	public String edit() {
		document = (Document) documentService.find(this.request.get("id"));
		documentService.edit(document);
		return SUCCESS;
	}

	/**
	 * To list all documents.
	 * 
	 * @return String
	 */
	public String list() {
		documents = documentService.findAll();
		return SUCCESS;
	}

	/**
	 * To delete a document.
	 * 
	 * @return String
	 */
	public String remove() {
		documentService.remove(documentService.find(this.request.get("id")));
		return SUCCESS;
	}

	public String input() {
		if((Integer)this.request.get("id") > 0 ){
			document = (Document) documentService.find(this.request.get("id"));
		}
		List<Formation> formations = formationService.findAll();
		for (Formation formation : formations) {
			this.formationSelect.put(formation.getId(), formation.getName());
		}

		List<Category> categories = categoryService.findAll();
		for (Category category : categories) {
			this.categorySelect.put(category.getId(), category.getName());
		}
		return INPUT;
	}

	public String batch() {
		String[] checkedAll = parameters.get("all_elements");
		String[] batchAction = parameters.get("action");
		if (checkedAll[0].equals("true")) {
			documents = documentService.findAll();
		} else {
			String[] checkedLibraries = parameters.get("idx[]");

			List<Integer> results = new ArrayList<Integer>();
			for (int i = 0; i < checkedLibraries.length; i++) {
				try {
					results.add(Integer.parseInt(checkedLibraries[i]));
				} catch (NumberFormatException nfe) {
				}
				;
			}
			documents = documentService.findChecked(results);
		}

		if (batchAction[0].equals("Supprimer")) {
			for (Document document : documents) {
				documentService.remove(document);
			}
		}
		return SUCCESS;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}

	public Map<Integer, String> getCategorySelect() {
		return categorySelect;
	}

	public void setCategorySelect(Map<Integer, String> categorySelect) {
		this.categorySelect = categorySelect;
	}

	public Map<Integer, String> getFormationSelect() {
		return formationSelect;
	}

	public void setFormationSelect(Map<Integer, String> formationSelect) {
		this.formationSelect = formationSelect;
	}

	public void setUpload(File file) {
		this.file = file;
	}

	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setUploadFileName(String filename) {
		this.filename = filename;
	}

}
