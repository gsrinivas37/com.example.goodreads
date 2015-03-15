package com.example.goodreads;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class GoodReadsPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.example.goodreads"; //$NON-NLS-1$

	// The shared instance
	private static GoodReadsPlugin plugin;
	
	/**
	 * The constructor
	 */
	public GoodReadsPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry registry) {
		super.initializeImageRegistry(registry);
		
		URL url = getBundle().getEntry("icons/book.png"); //$NON-NLS-1$
		registry.put("book", ImageDescriptor.createFromURL(url));
		
		url = getBundle().getEntry("icons/book_64.png"); //$NON-NLS-1$
		registry.put("book_64", ImageDescriptor.createFromURL(url));
		
		url = getBundle().getEntry("icons/bookshelf.png"); //$NON-NLS-1$
		registry.put("bookshelf", ImageDescriptor.createFromURL(url));
		
		url = getBundle().getEntry("icons/reader.png"); //$NON-NLS-1$
		registry.put("reader", ImageDescriptor.createFromURL(url));
		
		url = getBundle().getEntry("icons/reader_64.png"); //$NON-NLS-1$
		registry.put("reader_64", ImageDescriptor.createFromURL(url));
		
		url = getBundle().getEntry("icons/writer.png"); //$NON-NLS-1$
		registry.put("writer", ImageDescriptor.createFromURL(url));
		
		url = getBundle().getEntry("icons/add.png"); //$NON-NLS-1$
		registry.put("add", ImageDescriptor.createFromURL(url));
		
		url = getBundle().getEntry("icons/remove.png"); //$NON-NLS-1$
		registry.put("remove", ImageDescriptor.createFromURL(url));
	}
	
	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static GoodReadsPlugin getDefault() {
		return plugin;
	}

}
