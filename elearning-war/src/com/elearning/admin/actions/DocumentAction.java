package com.elearning.admin.actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.elearning.entities.Administrator;
import org.elearning.entities.Category;
import org.elearning.entities.Formation;
import org.elearning.entities.Document;
import org.elearning.entities.Role;
import org.elearning.entities.User;
import org.elearning.entities.UserInterface;
import org.elearning.sessions.CategorySessionRemote;
import org.elearning.sessions.FormationSessionRemote;
import org.elearning.sessions.DocumentSessionRemote;

import com.elearning.front.actions.LoginRequired;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DocumentAction extends ActionSupport implements
		ModelDriven<Document>, RequestAware, ParameterAware, LoginRequired {

	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	private Document document = new Document();
	private List<Document> documents = new ArrayList<Document>();
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
		int mid = this.filename.lastIndexOf(".");
		String extension = this.filename.substring(mid + 1,
				this.filename.length());
		Category category = this.detectCategoryForFile(extension);
		String path = "C:\\Library";
		this.uploadFile(path);
		document.setCategory(category);
		document.setPath(path + "\\" + this.filename);
		documentService.edit(document);
		return SUCCESS;
	}

	private Category detectCategoryForFile(String extension) {
		List<Category> categories = categoryService.findAll();
		for (Category category : categories) {
			if (category.getExtension().contains(extension)) {
				return category;
			}
		}
		return null;
	}

	private void uploadFile(String path) {
		try {
			File destDir = new File(path, this.filename);
			FileUtils.copyFile(file, destDir, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * To list all documents.
	 * 
	 * @return String
	 */
	public String list() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user instanceof Administrator) {
			Collection<Formation> formations = formationService
					.findByAffiliate(((Administrator) user).getAffiliate());
			for (Formation formation : formations) {
				Collection<Document> doc = formation.getDocuments();
				documents.addAll(formation.getDocuments());
			}
		} else {
			documents = documentService.findAll();
		}

		return SUCCESS;
	}

	@SkipValidation
	public String edit() {
		Integer id = (Integer) this.request.get("id");
		if (id > 0) {
			document = (Document) documentService.find(id);
		}
		return this.input();
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
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		List<Formation> formations = new ArrayList<Formation>();
		if (user instanceof UserInterface) {
			if (user instanceof Administrator) {
				formations = formationService
						.findByAffiliate(((Administrator) user).getAffiliate());
			} else {
				List<Role> roles = (List<Role>) user.getRoles();
				for (Role role : roles) {
					if (role.getName().equals("admin")) {
						formations = formationService.findAll();
						break;
					}
				}

			}
		}
		for (Formation formation : formations) {
			this.formationSelect.put(formation.getId(), formation.getName());
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
