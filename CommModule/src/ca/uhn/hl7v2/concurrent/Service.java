/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ManagedRunnable.java".  Description: 
"Base class for a unified management of threads with a defined lifecycle." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
 */
package ca.uhn.hl7v2.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import ca.uhn.hl7v2.util.Constants;

import net.newel.android.Log;


/**
 * Base class for a unified management of threads with a defined lifecycle. It
 * uses a {@link #keepRunning} flag to regularly terminate a thread. Classes
 * implementing this class must implement {@link #handle()} to do the main
 * processing. {@link #afterStartup()} and {@link #afterTermination()} can be
 * overridden to acquire and release resources required for processing.
 */
public abstract class Service implements Runnable {

	private volatile boolean keepRunning;
	private long shutdownTimeout = 3000L;
	private final String name;
	private final ExecutorService executorService;
	private Future<?> thread;
	private Throwable serviceExitedWithException;

	public Service(String name, ExecutorService executorService) {
		super();
		this.name = name;
		this.executorService = executorService;
	}

	/**
	 * @return Returns <code>true</code> if the server has been started, and has
	 *         not yet been stopped.
	 */
	public boolean isRunning() {
		return keepRunning;
	}

	public ExecutorService getExecutorService() {
		return executorService;
	}

	/**
	 * Sets the time in milliseconds how long {@link #stopAndWait()} should wait
	 * for the thread to terminate. Defaults to 3000ms.
	 * 
	 * @param shutdownTimeout
	 */
	public void setShutdownTimeout(long shutdownTimeout) {
		this.shutdownTimeout = shutdownTimeout;
	}

	/**
	 * Starts the server listening for connections in a new thread. This
	 * continues until <code>stop()</code> is called.
	 */
	public void start() {
		Log.d(Constants.TAG, "Starting service {"+name+"}");
		keepRunning = true;
		thread = getExecutorService().submit(this);
	}

	/**
	 * Prepare any resources before entering the main thread.
	 * 
	 * @throws RuntimeException
	 *             if resources could not acquired. In this case, the thread
	 *             will shutdown. Note that {@link #afterTermination()} is
	 *             called before.
	 */
	protected void afterStartup() {
	}

	/**
	 * The main task of the thread, called in a loop as long as
	 * {@link #isRunning()} returns true. Overridden methods are responsible for
	 * yielding or pausing the thread when it's idle. The method must also not
	 * block indefinitely so that a call to {@link #stop()} is able to
	 * gracefully terminate the thread.
	 * 
	 * @throws Throwable
	 *             any exception thrown will terminate the thread.
	 */
	protected abstract void handle();

	/**
	 * Advises the thread to leave its main loop. {@link #beforeTermination()} is
	 * called before this method returns. {@link #afterTermination()} is
	 * called after the thread has left its main loop.
	 */
	public void stop() {
		if (isRunning()) {
			prepareTermination();
		}
	}

	public void waitForTermination() {
		if (!thread.isDone())
			try {
				thread.get(shutdownTimeout, TimeUnit.MILLISECONDS);
			} catch (ExecutionException ee) {
			} catch (TimeoutException te) {
				Log.w(Constants.TAG, "Thread did not stop after {"+shutdownTimeout+"} milliseconds. Now cancelling.");
				thread.cancel(true);
			} catch (InterruptedException e) {
			}
	}

	/**
	 * Stops the thread by leaving its main loop. {@link #afterTermination()} is
	 * called before the thread is terminated. The method waits until the thread
	 * has stopped.
	 * 
	 * @throws Exception
	 *             if the thread has not finished within shutdownTimeout
	 */
	public final void stopAndWait() {
		stop();
		waitForTermination();
	}

	/**
	 * Clean up any resources initialized in {@link #afterStartup()}.
	 */
	protected void afterTermination() {
	};
	
	/**
	 * Prepare thread to leave its main loop. By default sets {@link #keepRunning}
	 * to false, but some implementations may need to do additional stuff.
	 */
	protected void prepareTermination() {
		Log.d(Constants.TAG, "Prepare to stop thread {"+name+"}");
		keepRunning = false;
	};	

	/**
	 * Runs the thread.
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public final void run() {
		try {
			afterStartup();
			Log.d(Constants.TAG, "Thread {"+name+"} entering main loop");
			while (isRunning()) {
				handle();
			}
			Log.d(Constants.TAG, "Thread {"+name+"} leaving main loop");
		} catch (RuntimeException t) {
			serviceExitedWithException = t.getCause();
			Log.w(Constants.TAG, "Thread exiting main loop due to exception:", t.getCause());
		} catch (Throwable t) {
			serviceExitedWithException = t;
			Log.w(Constants.TAG, "Thread exiting main loop due to exception:" + t.getMessage());
		} finally {
			afterTermination();
		}

	}

	/**
	 * Provide the exception which caused this service to fail
	 */
	protected void setServiceExitedWithException(Throwable theThreadExitedWithException) {
		serviceExitedWithException = theThreadExitedWithException;
	}


	/**
	 * If this service exited with an exception, ths method returns that exception. This is useful for
	 * detecting if the service failed unexpectedly
	 */
	public Throwable getServiceExitedWithException() {
		return serviceExitedWithException;
	}

}
