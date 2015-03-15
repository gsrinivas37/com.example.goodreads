package com.example.goodreads.ui;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import com.example.goodreads.model.DataBase;
import com.example.goodreads.model.ModelPackage;

/**
 * Editor for Good Reads file. It contains two pages. <br>
 * 1. Profile page <br>
 * 2. Database page <br>
 * @see ProfileComposite
 * @see DataBaseComposite
 * @author sgudla
 *
 */

public class GoodReadsEditor extends FormEditor implements IResourceChangeListener{

	private static final String PROFILE_PAGE_TITLE = "Profile";
	private static final String DATABASE_PAGE_TITLE = "Database";
	
	private DataBase model;
	private IFileEditorInput fileEditorInput;
	private ProfileComposite profilePage;
	private DataBaseComposite databasePage;

	public GoodReadsEditor() {
		super();
		
		//Add resource change listener to close the editor when the project is closed or deleted.
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}
	
	@Override
	protected void addPages() {
		createProfilePage();
		createDatabasePage();
	}
	
	@Override
	protected void pageChange(int newPageIndex) {
		super.pageChange(newPageIndex);
		
		if(newPageIndex==0){
			profilePage.initialize();
		}
	}
	
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		if(input instanceof IFileEditorInput){
			this.fileEditorInput = (IFileEditorInput) input;
			IFile file = fileEditorInput.getFile();
			
			ModelPackage.eINSTANCE.eClass();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("model", new XMIResourceFactoryImpl());
			Resource resource = new ResourceSetImpl().getResource(URI.createFileURI(file.getLocation().toPortableString()), true);
			
			if(resource==null)
				throw new PartInitException("Unable to load the resource from file: "+file.getLocation().toPortableString());
			
			EList<EObject> contents = resource.getContents();
			
			if(contents!=null && contents.size()==1 && contents.get(0) instanceof DataBase){
				model  = (DataBase) contents.get(0);
			}else{
				throw new PartInitException("The file content is corrupt: "+file.getLocation().toPortableString());
			}
		}
	}
	
	private void createProfilePage() {
		profilePage = new ProfileComposite(getContainer(), this, model, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, false);
		profilePage.setLayout(gridLayout);
		
		int index = addPage(profilePage);
		setPageText(index, PROFILE_PAGE_TITLE);
	}
	
	private void createDatabasePage() {
		databasePage = new DataBaseComposite(getContainer(), this, model, SWT.NONE);
		GridLayout gridLayout = new GridLayout(3, true);
		databasePage.setLayout(gridLayout);
		
		int index = addPage(databasePage);
		setPageText(index, DATABASE_PAGE_TITLE);
	}
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		ModelPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("model", new XMIResourceFactoryImpl());
		Resource resource = new ResourceSetImpl().getResource(URI.createFileURI(fileEditorInput.getFile().getLocation().toPortableString()), true);
		resource.getContents().clear();
		resource.getContents().add(model);
		try {
			resource.save(java.util.Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void doSaveAs() {
	}
	
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}
	
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		if(event.getType()== IResourceChangeEvent.PRE_CLOSE || event.getType()== IResourceChangeEvent.PRE_DELETE){
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					IWorkbenchPage[] workbenchPages = getSite().getWorkbenchWindow().getPages();
					
					for(int i=0; i<workbenchPages.length; i++){
						if(fileEditorInput.getFile().getProject().equals(event.getResource())){
							IEditorPart editorPart = workbenchPages[i].findEditor(fileEditorInput);
							workbenchPages[i].closeEditor(editorPart, true);
						}
					}
				}
			});
		}
	}
}
