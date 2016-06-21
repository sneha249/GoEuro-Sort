package goeuro.utils;
	import org.testng.IClass;
	import org.testng.ITestResult;
	import org.testng.TestListenerAdapter;

	// TODO: Auto-generated Javadoc
/**
	 * The Class ListenerUtil.
	 */
	public class ListenerUtil extends TestListenerAdapter {

		
		/* (non-Javadoc)
		 * @see org.testng.TestListenerAdapter#onTestStart(org.testng.ITestResult)
		 */
		@Override
		public void onTestStart(ITestResult tr) {
			log("Test Started ..");
		}

		
		/* (non-Javadoc)
		 * @see org.testng.TestListenerAdapter#onTestSuccess(org.testng.ITestResult)
		 */
		@Override
		public void onTestSuccess(ITestResult tr) {
			log("Test '" + tr.getName() + "' PASSED");
			// This will print the class name in which the method is present
			log(tr.getTestClass());
			// This will print the priority of the method.
			// If the priority is not defined it will print the default priority as 0
			log("All the prices are displayed in ascending order");
			System.out.println("**..... **");
		}

		
		/* (non-Javadoc)
		 * @see org.testng.TestListenerAdapter#onTestFailure(org.testng.ITestResult)
		 */
		@Override
		public void onTestFailure(ITestResult tr) {
			log("Test '" + tr.getName() + "' FAILED");
			log("Priority of this method is " + tr.getMethod().getPriority());
			System.out.println("**.....**");
		}

		
		/* (non-Javadoc)
		 * @see org.testng.TestListenerAdapter#onTestSkipped(org.testng.ITestResult)
		 */
		@Override
		public void onTestSkipped(ITestResult tr) {
			log("Test '" + tr.getName() + "' SKIPPED");
			System.out.println("**.....**");
		}

		/**
		 * Log.
		 *
		 * @param methodName the method name
		 */
		private void log(String methodName) {
			System.out.println(methodName);
		}

		/**
		 * Log.
		 *
		 * @param testClass the test class
		 */
		private void log(IClass testClass) {
			System.out.println(testClass);
		}
	}
