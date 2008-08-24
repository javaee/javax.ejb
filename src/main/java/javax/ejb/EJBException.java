/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
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

/**
 * The EJBException exception is thrown by an enterprise Bean instance to 
 * its container to report that the invoked business method or callback method
 * could not be completed because of an unexpected error (e.g. the instance 
 * failed to open a database connection).
 */
public class EJBException extends java.lang.RuntimeException {
    /**
     * @serial
     */
    private Exception causeException = null;

    /**
     * Constructs an EJBException with no detail message.
     */  
    public EJBException() {
    }

    /**
     * Constructs an EJBException with the specified
     * detailed message.
     */  
    public EJBException(String message) {
        super(message);
    }

    /**
     * Constructs an EJBException that embeds the originally thrown exception.
     */  
    public EJBException(Exception  ex) {
        super();
	causeException = ex;
    }

    /**
     * Constructs an EJBException that embeds the originally thrown exception
     * with the specified detail message. 
     */  
    public EJBException(String message, Exception  ex) {
        super(message);
	causeException = ex;
    }


    /**
     * Obtain the exception that caused the EJBException being thrown.
     */
    public Exception getCausedByException() {
	return causeException;
    }

    /**
     * Returns the detail message, including the message from the nested
     * exception if there is one.
     */
    public String getMessage() {
	String msg = super.getMessage();
        if (causeException == null)
            return msg;
        else if ( msg == null ) {
            return "nested exception is: " + causeException.toString();
	}
	else {
            return msg + "; nested exception is: " + causeException.toString();
	}
    }

    /**
     * Prints the composite message and the embedded stack trace to
     * the specified stream <code>ps</code>.
     * @param ps the print stream
     */
    public void printStackTrace(java.io.PrintStream ps)
    {
        if (causeException == null) {
            super.printStackTrace(ps);
        } else {
            synchronized(ps) {
		ps.println(this);
		// Print the cause exception first, so that the output
		// appears in stack order (i.e. innermost exception first)
                causeException.printStackTrace(ps);
                super.printStackTrace(ps);
            }
        }
    }

    /** 
     * Prints the composite message to <code>System.err</code>.
     */ 
    public void printStackTrace()
    {
        printStackTrace(System.err);
    }

    /**
     * Prints the composite message and the embedded stack trace to
     * the specified print writer <code>pw</code>.
     * @param pw the print writer
     */
    public void printStackTrace(java.io.PrintWriter pw)
    {
        if (causeException == null) {
            super.printStackTrace(pw);
        } else {
            synchronized(pw) {
		pw.println(this);
		// Print the cause exception first, so that the output
		// appears in stack order (i.e. innermost exception first)
                causeException.printStackTrace(pw);
		super.printStackTrace(pw);
            }
        }
    }
}
