/* 
 * polymap.org
 * Copyright (C) 2018, the @authors. All rights reserved.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3.0 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
package tideeapp.ui;

import java.util.logging.Logger;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import org.polymap.rhei.batik.PanelIdentifier;

import org.polymap.rap.updownload.upload.Upload;

/**
 * 
 *
 * @author Falko Bräutigam
 */
public class StartPanel
        extends TPanel {

    private static final Logger log = Logger.getLogger( StartPanel.class.getName() );

    public static final PanelIdentifier ID = new PanelIdentifier( "start" );


    @Override
    public boolean beforeInit() {
        return getSite().getPath().size() == 1;
    }


    @Override
    public void createContents( Composite parent ) {
        getSite().setTitle( "TideeApp!" );
        
        Upload upload = new Upload( parent, SWT.BORDER );
        upload.setText( "Upload" );
        
        tk().createButton( parent, "Push", SWT.PUSH );
    }
    
}
