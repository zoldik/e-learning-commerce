package com.elearning.admin.actions;

import java.io.File;
import java.io.IOException;
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
import org.elearning.entities.Category;
import org.elearning.entities.Formation;
import org.elearning.entities.Library;
import org.elearning.sessions.CategorySessionRemote;
import org.elearning.sessions.FormationSessionRemote;
import org.elearning.sessions.LibrarySessionRemote;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LibraryAction extends ActionSupport implements
		ModelDriven<Library>, RequestAware, ParameterAware {

	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	private Library library = new Library();
	private List<Library> libraries = new ArrayList<Library>();
	private Map<Integer, String> categorySelect = new HashMap<Integer, String>();
	private Map<Integer, String> formationSelect = new HashMap<Integer, String>();
	private LibrarySessionRemote libraryService;
	private FormationSessionRemote formationService;
	private CategorySessionRemote categoryService;

	private File file;
	private String contentType;
	private String filename;

	public LibraryAction() throws NamingException {
		try {
			InitialContext ctx = new InitialContext();
			libraryService = (LibrarySessionRemote) ctx
					.lookup("LibrarySession/remote");
			formationService = (FormationSessionRemote) ctx
					.lookup("FormationSession/remote");
			categoryService = (CategorySessionRemote) ctx
					.lookup("CategorySession/remote");

		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Library getModel() {
		// TODO Auto-generated method stub
		return library;
	}

	/**
	 * To save or update library.
	 * 
	 * @return String
	 */
	public String save() {
	File destDir = new File("../test");
	try {
		FileUtils.copyFileToDirectory(file, destDir, true);
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		library.setPath(file.getAbsolutePath());
		libraryService.edit(library);
		return SUCCESS;
	}

	/**
	 * To save or update library.
	 * 
	 * @return String
	 */
	public String edit() {
		library = (Library) libraryService.find(this.request.get("id"));
		libraryService.edit(library);
		return SUCCESS;
	}

	/**
	 * To list all libraries.
	 * 
	 * @return String
	 */
	public String list() {
		libraries = libraryService.findAll();
		return SUCCESS;
	}

	/**
	 * To delete a library.
	 * 
	 * @return String
	 */
	public String remove() {
		libraryService.remove(libraryService.find(this.request.get("id")));
		return SUCCESS;
	}

	public String input() {
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
			libraries = libraryService.findAll();
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
			libraries = libraryService.findChecked(results);
		}

		if (batchAction[0].equals("Supprimer")) {
			for (Library library : libraries) {
				libraryService.remove(library);
			}
		}
		return SUCCESS;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public List<Library> getLibrarys() {
		return libraries;
	}

	public void setLibrarys(List<Library> libraries) {
		this.libraries = libraries;
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
