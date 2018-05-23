/* 
 * Copyright (C) 2018, Falko Bräutigam. All rights reserved.
 */
package tideeapp;

import java.util.logging.Logger;

import org.osgi.framework.BundleContext;

import org.eclipse.ui.plugin.AbstractUIPlugin;

import org.polymap.core.security.SecurityContext;
import org.polymap.core.security.StandardConfiguration;
import org.polymap.core.ui.StatusDispatcher;

import org.polymap.rhei.batik.Context;
import org.polymap.rhei.batik.app.SvgImageRegistryHelper;
import org.polymap.rhei.batik.toolkit.BatikDialogStatusAdapter;

/**
 *
 * @author <a href="http://www.polymap.de">Falko Bräutigam</a>
 */
public class TPlugin
        extends AbstractUIPlugin {

    private static final Logger log = Logger.getLogger( TPlugin.class.getName() );

    public static final String      ID = "tideeapp";

    /** The globale {@link Context} scope for the {@link TPlugin}. */
    public static final String      Scope = "org.polymap.p4";
    
    public static final String      HEADER_ICON_CONFIG = SvgImageRegistryHelper.WHITE24;
    public static final String      TOOLBAR_ICON_CONFIG = SvgImageRegistryHelper.NORMAL24;

    private static TPlugin         instance;


    public static TPlugin instance() {
        return instance;
    }

    /**
     * Shortcut for <code>instance().images</code>.
     */
    public static SvgImageRegistryHelper images() {
        return instance().images;
    }
    
    // instance *******************************************

    public SvgImageRegistryHelper   images = new SvgImageRegistryHelper( this );


    public void start( BundleContext context ) throws Exception {
        log.info( "Starting..." );
        super.start( context );
        instance = this;
        
        // JAAS config: no dialog; let LoginPanel create UI
        SecurityContext.registerConfiguration( () -> new StandardConfiguration() {
            @Override
            public String getConfigName() {
                return SecurityContext.SERVICES_CONFIG_NAME;
            }
        });

        // handling errors in the UI
        StatusDispatcher.registerAdapter( new StatusDispatcher.LogAdapter() );
        StatusDispatcher.registerAdapter( new BatikDialogStatusAdapter() );
    }


    public void stop( BundleContext context ) throws Exception {
        instance = null;
        super.stop( context );
    }

}
