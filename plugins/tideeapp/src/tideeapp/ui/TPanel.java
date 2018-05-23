/* 
 * Copyright (C) 2018, Falko Bräutigam. All rights reserved.
 */
package tideeapp.ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.common.base.Joiner;

import org.eclipse.swt.widgets.Composite;

import org.polymap.rhei.batik.DefaultPanel;
import org.polymap.rhei.batik.toolkit.md.MdToolkit;

/**
 * 
 *
 * @author <a href="http://www.polymap.de">Falko Bräutigam</a>
 */
public abstract class TPanel
        extends DefaultPanel {

    private static final Log log = LogFactory.getLog( TPanel.class );
    
    public static final int                 SIDE_PANEL_WIDTH = 400;
    
    public static final int                 SIDE_PANEL_WIDTH2 = 450;
    
    public static String title( String type, String name ) {
        return StringUtils.abbreviate( 
                Joiner.on( ": " ).skipNulls().join( type, name ), 32 );    
    }
    
    
    // instance *******************************************
    
    /**
     * Sets size to: 
     * <pre>
     * SIDE_PANEL_WIDTH, SIDE_PANEL_WIDTH, Integer.MAX_VALUE
     * </pre>
     */
    @Override
    public void init() {
        site().setSize( SIDE_PANEL_WIDTH, SIDE_PANEL_WIDTH, Integer.MAX_VALUE );
    }

    
    protected MdToolkit tk() {
        return (MdToolkit)site().toolkit();
    }
    
    
    protected void createErrorContents( Composite parent, String msg, Throwable cause ) {
        log.warn( msg, cause );
        tk().createFlowText( parent, msg );
    }
    
}
