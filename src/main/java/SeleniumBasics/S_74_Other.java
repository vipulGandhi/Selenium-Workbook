// Interfaces in selenium
	// SearchContext
		// Methods
			// findElements(By by);
			// findElement(By by);
	// WebDriver
		// Inner/ Nested interfaces
			// Navigation
				// to();
				// back();
				// forward();
				// refresh();
			// TargetLocator
				// switchTo();
			// Options
				// addCookie(Cookie cookie);
				// deleteCookieNamed(String name);
				// deleteAllCookies();
			// Window
				// maximize();
				// minimize();
				// fullscreen();
		// Methods
			// get(String url);
			// getCurrentUrl();
			// getTitle();
			// close();
			// quit();
			// getWindowHandles();
			// getWindowHandle();
			// switchTo();
			// navigate();
			// timeouts();
			// window();
	// JavascriptExecutor
		// Methods
			// executeScript(String script, Object... args);
			// executeAsyncScript(String script, Object... args);
	// TakesScreenshot
		// Methods
			// getScreenshotAs(OutputType<X> target) throws WebDriverException;
	// Alert
		// Methods
			// dismiss();
			// accept();
			// getText();
			// sendKeys(String keysToSend);
	// WebElement extends SearchContext, TakesScreenshot
		// Methods
			// Click();
			// Submit();
			// sendKeys(CharSequence... keysToSend);
			// clear();
			// getTagName();
			// getAttribute(String name);
			// isSelected();
			// isEnabled();
			// getText();
	// ExpectedCondition [Interfce]
		// ExpectedConditions [Class]
	// Action [Interface]
		// Actions[Class]

// 