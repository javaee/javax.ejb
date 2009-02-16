/*
 * The contents of this file are subject to the terms 
 * of the Common Development and Distribution License 
 * (the License).  You may not use this file except in
 * compliance with the License.
 * 
 * You can obtain a copy of the license at 
 * https://glassfish.dev.java.net/public/CDDLv1.0.html or
 * glassfish/bootstrap/legal/CDDLv1.0.txt.
 * See the License for the specific language governing 
 * permissions and limitations under the License.
 * 
 * When distributing Covered Code, include this CDDL 
 * Header Notice in each file and include the License file 
 * at glassfish/bootstrap/legal/CDDLv1.0.txt.  
 * If applicable, add the following below the CDDL Header, 
 * with the fields enclosed by brackets [] replaced by
 * you own identifying information: 
 * "Portions Copyrighted [year] [name of copyright owner]"
 * 
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 */


package javax.ejb;

import java.io.Serializable;
import java.util.concurrent.*;

/**
  * Wraps the result of an asynchronous method call as a Future
  * object preserving compatability with the business interface signature.
  *
  * The value specified in the constructor will be retrieved by the container
  * and made available to the client.
  */

public final class AsyncResult<V> implements Future<V> {

    private final V resultValue;

    public AsyncResult(V result) {
        resultValue = result;
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        throw new java.lang.IllegalStateException
	    ("Object does not represent an acutal Future");
    }

    public boolean isCancelled() {
        throw new java.lang.IllegalStateException
	    ("Object does not represent an acutal Future");
    }

    public boolean isDone() {
        throw new java.lang.IllegalStateException
	    ("Object does not represent an acutal Future");
    }

    public V get() throws InterruptedException, ExecutionException {
        return resultValue;
    }

    public V get(long timeout, TimeUnit unit) 
	throws InterruptedException, ExecutionException, TimeoutException {
        return resultValue;
    }

}