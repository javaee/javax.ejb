/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2006-2009 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 *
 * Contributor(s):
 *
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package javax.ejb;

import java.io.Serializable;

/**
 * <p>TimerConfig is used to specify additional timer configuration settings during
 * timer creation.</p>   
 *
 * <p>The info object represents a serializable object made available to
 * corresponding timer callbacks.  It is optional and defaults to null.</p>
 *
 * <p>The persistent property determines whether the corresponding timer has
 * a lifetime that spans the JVM in which it was created.  It is optional
 * and defaults to true.</p> 
 */
public class TimerConfig {

    public TimerConfig() {}

    public TimerConfig(Serializable info, boolean persistent) {
	info_ = info;
  	persistent_ = persistent;
    }

    public void setInfo(Serializable i) {
	info_ = i;
    }

    public Serializable getInfo() {
	return info_;
    }

    public void setPersistent(boolean p) {
	persistent_ = p;
    }

    public boolean isPersistent() {
	return persistent_;
    }

    public String toString() {
        return "TimerConfig [persistent=" + persistent_ + ";info=" + info_ + "]";
    }

    private Serializable info_ = null;

    private boolean persistent_ = true;

}

