
### Serenity BDD Release Notes

### v1.1.26-rc.4
**Commits with examples:**


* [commit:](https://github.com/serenity-bdd/serenity-core/commit/c80004c26a41faa) Made the Cucumber support more robust 

 > The parser will no longer crash if there are empty or badly-formed feature files. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/7200f4b42c1dc8d) Minor bug fix with the Saucelabs video icon 

 > Minor bug fix where the Saucelabs video icon was incorrectly displayed. 


### v1.1.26-rc.3
**Commits with examples:**

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/433b732734f4eaa) Allow more elegant waits in the Screenplay module 

 > You can now write code like this: 
 > jane.should(eventually(seeThat(TheClickerValue.of(clicker), equalTo(10)))) 
 > This will not fail if the matcher cannot be evaluated the first time, but will retry up to a maximum of &#39;serenity.timouts&#39; seconds (5 by default). 



### v1.1.26-rc.2
**Commits with examples:**












* [commit:](https://github.com/serenity-bdd/serenity-core/commit/909f21a66d8f732) Renamed serenity-journey to serenity-screenplay 

 > Also allow conditional tasks of the following form: 
 > dana.attemptsTo( 
 > Check.whether(cost&gt;100) 
 > .andIfSo(purchaseAPear) 
 > .otherwise(purchaseAnApple) 
 > ); 
 > Or with a Question&lt;Boolean&gt;: 
 > dana.attemptsTo( 
 > Check.whether(itIsTooExpensive) 
 > .andIfSo(purchaseAPear) 
 > .otherwise(purchaseAnApple) 
 > ); 



### v1.1.26-rc.1
**Commits with examples:**









* [commit:](https://github.com/serenity-bdd/serenity-core/commit/c9572c849d9e710) Actors can now perform tasks conditionally 

 > Use the Unless class static methods and a bolean expression, e.g. 
 > ``` 
 > Unless.the(items.isEmpty(), AddTodoItems.called(items)) 
 > ``` 
 > or use a question of type Question&lt;Boolean&gt;: 
 > ``` 
 > Unless.the(itemsListisEmpty(), AddTodoItems.called(items)) 
 > ``` 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/3e0d99168dbec1a) Actors can now perform tasks conditionally 

 > Use the Unless class static methods and a bolean expression, e.g. 
 > ``` 
 > Unless.the(items.isEmpty(), AddTodoItems.called(items)) 
 > ``` 
 > or use a question of type Question&lt;Boolean&gt;: 
 > ``` 
 > Unless.the(itemsListisEmpty(), AddTodoItems.called(items)) 
 > ``` 


### v1.1.25-rc.7
**Commits with examples:**

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/5cb49b2e6ce64c5) Made reading UI values more fluent. 

 > The narrative was interrupted by the .value() so hidden away for now behind a more fluent method 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/c28a95ec9310748) Support for multiple matchers in Consequences 

 > You can now make multiple assertions against a single question 



### v1.1.25-rc.6
**Commits with examples:**




### v1.1.25-rc.5
**Commits with examples:**




### v1.1.25-rc.4
**Commits with examples:**











* [commit:](https://github.com/serenity-bdd/serenity-core/commit/4531d43df845228) Fixed issue #281 

 > During verbose logging, Serenity tried to read the tag from web elements. This could cause failures if the element was stale or unavailable when the logging happen. This has now been changed to log the locator and not the element tag type. 










### v1.1.25-rc.3
**Commits with examples:**




















### v1.1.25-rc.2
**Commits with examples:**





### v1.1.25-rc.1
**Commits with examples:**
















### v1.1.24
**Commits with examples:**



* [commit:](https://github.com/serenity-bdd/serenity-core/commit/f36115c4978f460) Added matchers to allow questions about web element states (designed mainly to be used for low-level preconditions or assertions), e.g. 

 > then(dana).should(seeThat(the(ProfilePage.NAME_FIELD), isVisible())); 





### v1.1.22-rc.15
**Commits with examples:**





### v1.1.22-rc.14
**Commits with examples:**



* [commit:](https://github.com/serenity-bdd/serenity-core/commit/a700aa2d0654491) The Target class now accepts a prefix notation to specify the locator, e.g Target.the(&quot;name field&quot;).locatedBy(&quot;css:#name&quot;) or Target.the(&quot;name field&quot;).locatedBy(&quot;id:name&quot;) 

 > This supports all of the WebDriver locator strategies: 
 > - id 
 > - css 
 > - xpath 
 > - name 
 > - tagName 
 > - className 
 > - linkText 
 > - partialLinkText 





### v1.1.22-rc.13
**Commits with examples:**









### v1.1.22-rc.12
**Commits with examples:**











### v1.1.22-rc.11
**Commits with examples:**









### v1.1.22-rc.10
**Commits with examples:**







### v1.1.22-rc.9
**Commits with examples:**










### v1.1.22-rc.8
**Commits with examples:**



### v1.1.22-rc.7
**Commits with examples:**



### v1.1.22-rc.6
**Commits with examples:**













* [commit:](https://github.com/serenity-bdd/serenity-core/commit/ece74d2b38035f3) Remove an unnecessary moveTo() operation. 

 > This seems to cause class cast exceptions from time to time. 







### v1.1.22-rc.4
**Commits with examples:**



### v1.1.22-rc.3
**Commits with examples:**



### v1.1.22-rc.2
**Commits with examples:**


















### v1.1.22-rc.1
**Commits with examples:**



* [commit:](https://github.com/serenity-bdd/serenity-core/commit/3794e2b28ed858c) Improved reporting 

 > Add the &#39;serenity.linked.tags&#39; property, which allows you to defined tag types which will result in human-readable tags that can be used as bookmarks or external links. 




### v1.1.21-rc.1
**Commits with examples:**



### v1.1.20-rc.1
**Commits with examples:**




### v1.1.19
**Commits with examples:**



### v1.1.18-rc.2
**Commits with examples:**








* [commit:](https://github.com/serenity-bdd/serenity-core/commit/e28f899a152e798) 130_issue: fixing copying jars bug 

 > Conflicts: 
 > serenity-gradle-plugin/build.gradle 









### v1.1.18-rc.1
**Commits with examples:**

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/6e91a31d3426c4d) Revert &quot;Merge branch &#39;master&#39; of github.com:serenity-bdd/serenity-core&quot; 

 > This reverts commit 4397786f9fd7f37cb6c2e4f00741a2343e9e4d57, reversing 
 > changes made to 84d095558dcd61554c2a0a988977bb1e9eecb71d. 
















### v1.1.17-rc.5
**Commits with examples:**





### v1.1.17-rc.4
**Commits with examples:**


* [commit:](https://github.com/serenity-bdd/serenity-core/commit/271ffe108f5880f) Added support for customising exception handling. 

 > You can now specify your own exceptions that will cause a failure by using the /serenity.fail.on/ property. You can also specify those that will cause an error using /serenity.error.on/. 







* [commit:](https://github.com/serenity-bdd/serenity-core/commit/01a6e9d3a51cff8) Improved reporting 

 > Use FontAwesome for more readable test result icons. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/7de1dd5ba3fe508) Better error/failure distinction 

 > Exceptions such as ElementShouldBeInvisibleException are now reported as failures, not errors. 



### v1.1.17-rc.3
**Commits with examples:**








### v1.1.17-rc.2
**Commits with examples:**















### v1.1.17-rc.1
**Commits with examples:**






* [commit:](https://github.com/serenity-bdd/serenity-core/commit/0b94e8daba308bc) Minor refactoring 

 > Added multi-thread testing for the screenshot pipeline, and removed misleading warnings that could happen when two threads try to save the same screenshot. 








* [commit:](https://github.com/serenity-bdd/serenity-core/commit/2341b7409624050) [JDK7 compatibility] Corrections to maintain JDK7 compatibility 

 > Replace usage of java Optional with Guava optional 






### v1.1.16
**Commits with examples:**






### v1.1.15
**Commits with examples:**





















* [commit:](https://github.com/serenity-bdd/serenity-core/commit/540ce87d44b93cb) fix: Adds JAVA_HOME to the environment (map) in case the key / value is 

 > not available from the System.getenv() 




* [commit:](https://github.com/serenity-bdd/serenity-core/commit/666e9dcfd8d8df3) refactor: Removes maven-easyb-plugin, is not used, or correct me if I&#39;m 

 > wrong. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/1381ebdaa955146) refactor: Removes warning that log4j was not initialized 

 > Updates thucydides-core with exclusion of log4j 
 > Adds dependency log4j-over-slf4j 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/6200d4effd5470a) fix: Updates default URL to &#39;http://www.google.com/ncr&#39; this prevents 

 > redirects from &#39;google.com&#39; to country specific google search pages. 




* [commit:](https://github.com/serenity-bdd/serenity-core/commit/5556ddae9469a43) chore: Adds profiles &#39;firefox&#39; and &#39;chrome&#39;, for easier running the 

 > tests with different browsers. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/a860b0bb5f3b58f) fix: Corrects issue with auto redirect to secure connection (https 

 > instead of http) 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/7d21048e9a2b3b0) fix: Corrects issue auto forwarding from google.com to google.xxx the 

 > country specific search page. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/476a18322150cbb) fix: Updates dependencies to latest stable release 0.8 

 > thucydides-junit 0.8.31 (was 0.8.1-SNAPSHTOT) 
 > thucydides-core  0.8.31 (was 0.8.1-SNAPSHTOT) 
 > Adds dependency 
 > slf4j-simple  1.6.4 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/7974322366574a3) fix: Brings package name in class inline with the package directory 

 > structure 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/7b58b52e3c13baa) Renames package &#39;net.serenity_bdd.*&#39; into &#39;net.serenitybdd.*&#39;, to bring 

 > them inline with the rest 


















### v1.1.14
**Commits with examples:**








### v1.1.13
**Commits with examples:**





### v1.1.12
**Commits with examples:**





### v1.1.11
**Commits with examples:**





### v1.1.10
**Commits with examples:**





### v1.1.9
**Commits with examples:**



### v1.1.8
**Commits with examples:**



* [commit:](https://github.com/serenity-bdd/serenity-core/commit/32f488557eea780) Fixed #115 

 > Only record REST responses for non-binary response types. 



* [commit:](https://github.com/serenity-bdd/serenity-core/commit/cbfb1788cd8e35a) Fixing Java warnings - Redundant cast 

 > GoogleSearchSteps.java:27: warning: [cast] redundant cast to GoogleHomePage 
 > GoogleHomePage page = (GoogleHomePage) getPages().currentPageAt(GoogleHomePage.class); 
 > GoogleSearchSteps.java:33: warning: [cast] redundant cast to GoogleResultsPage 
 > GoogleResultsPage page = (GoogleResultsPage) getPages().currentPageAt(GoogleResultsPage.class); 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/c6ed01d846f4646) Added support for multiple browsers in the same test using the Journey pattern 

 > For example: 
 > @Managed(driver=&quot;chrome&quot;) 
 > WebDriver firstBrowser; 
 > @Managed(driver=&quot;firefox&quot;) 
 > WebDriver anotherBrowser; 
 > @Test 
 > public void danaCanUpdateHerProfile() { 
 > Actor dana = new Actor(&quot;Dana&quot;); 
 > dana.can(BrowseTheWeb.with(firstBrowser)); 
 > givenThat(dana).has(openedTheApplication); 
 > when(dana).attemptsTo(viewHerProfile); 
 > and(dana).attemptsTo(UpdateHerProfile.withName(&quot;Dana&quot;).andCountryOfResidence(&quot;France&quot;)); 
 > then(dana).should(seeThat(TheProfile.name(), equalTo(&quot;Dana&quot;))); 
 > and(dana).should(seeThat(TheProfile.country(), equalTo(&quot;France&quot;))); 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/a8ae2e5f4ac22d1) Debug log: Adding exception to output 

 > Sample output: 
 > 11:29:07.868 [Test worker] DEBUG n.s.j.r.RetryFilteringRunNotifier - Test failed: com.skagenfondene.test.stories.InactiveUser: java.lang.NullPointerException--&gt;null 
 > net.sf.cglib.core.CodeGenerationException: java.lang.NullPointerException--&gt;null 
 > at net.sf.cglib.core.ReflectUtils.newInstance(ReflectUtils.java:235) ~[cglib-3.1.jar:na] 
 > at net.sf.cglib.core.ReflectUtils.newInstance(ReflectUtils.java:220) ~[cglib-3.1.jar:na] 
 > at net.sf.cglib.proxy.Enhancer.createUsingReflection(Enhancer.java:639) ~[cglib-3.1.jar:na] 
 > at net.sf.cglib.proxy.Enhancer.firstInstance(Enhancer.java:538) ~[cglib-3.1.jar:na] 
 > at net.sf.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:225) ~[cglib-3.1.jar:na] 
 > at net.sf.cglib.proxy.Enhancer.createHelper(Enhancer.java:377) ~[cglib-3.1.jar:na] 
 > at net.sf.cglib.proxy.Enhancer.create(Enhancer.java:304) ~[cglib-3.1.jar:na] 
 > at net.thucydides.core.steps.StepFactory.webEnabledStepLibrary(StepFactory.java:167) ~[serenity-core-1.1.5.jar:1.1.5] 
 > at net.thucydides.core.steps.StepFactory.createProxyStepLibrary(StepFactory.java:157) ~[serenity-core-1.1.5.jar:1.1.5] 
 > at net.thucydides.core.steps.StepFactory.instantiateNewStepLibraryFor(StepFactory.java:111) ~[serenity-core-1.1.5.jar:1.1.5] 
 > at net.thucydides.core.steps.StepFactory.instantiateNewStepLibraryFor(StepFactory.java:103) ~[serenity-core-1.1.5.jar:1.1.5] 
 > at net.thucydides.core.steps.StepFactory.getNewStepLibraryFor(StepFactory.java:75) ~[serenity-core-1.1.5.jar:1.1.5] 
 > at net.thucydides.core.steps.StepFactory.getStepLibraryFor(StepFactory.java:70) ~[serenity-core-1.1.5.jar:1.1.5] 
 > at net.thucydides.core.steps.StepAnnotations.instantiateAnyUnitiaializedSteps(StepAnnotations.java:52) ~[serenity-core-1.1.5.jar:1.1.5] 
 > at net.thucydides.core.steps.StepAnnotations.instanciateScenarioStepFields(StepAnnotations.java:41) ~[serenity-core-1.1.5.jar:1.1.5] 
 > at net.thucydides.core.steps.StepAnnotations.injectScenarioStepsInto(StepAnnotations.java:23) ~[serenity-core-1.1.5.jar:1.1.5] 
 > at net.serenitybdd.junit.runners.SerenityRunner.injectScenarioStepsInto(SerenityRunner.java:590) [serenity-junit-1.1.5.jar:na] 
 > at net.serenitybdd.junit.runners.SerenityRunner.methodInvoker(SerenityRunner.java:552) [serenity-junit-1.1.5.jar:na] 
 > at org.junit.runners.BlockJUnit4ClassRunner.methodBlock(BlockJUnit4ClassRunner.java:251) ~[junit-4.11.jar:na] 
 > at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:70) ~[junit-4.11.jar:na] 
 > at net.serenitybdd.junit.runners.SerenityRunner.runChild(SerenityRunner.java:440) [serenity-junit-1.1.5.jar:na] 
 > at net.serenitybdd.junit.runners.SerenityRunner.runChild(SerenityRunner.java:60) [serenity-junit-1.1.5.jar:na] 
 > at org.junit.runners.ParentRunner$3.run(ParentRunner.java:238) ~[junit-4.11.jar:na] 
 > at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63) ~[junit-4.11.jar:na] 
 > at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236) ~[junit-4.11.jar:na] 
 > at org.junit.runners.ParentRunner.access$000(ParentRunner.java:53) ~[junit-4.11.jar:na] 
 > at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229) ~[junit-4.11.jar:na] 
 > at org.junit.runners.ParentRunner.run(ParentRunner.java:309) ~[junit-4.11.jar:na] 
 > at net.serenitybdd.junit.runners.SerenityRunner.run(SerenityRunner.java:249) [serenity-junit-1.1.5.jar:na] 
 > at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecuter.runTestClass(JUnitTestClassExecuter.java:86) [gradle-plugins-2.2.1.jar:2.2.1] 
 > at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecuter.execute(JUnitTestClassExecuter.java:49) [gradle-plugins-2.2.1.jar:2.2.1] 
 > at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassProcessor.processTestClass(JUnitTestClassProcessor.java:69) [gradle-plugins-2.2.1.jar:2.2.1] 
 > at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.processTestClass(SuiteTestClassProcessor.java:48) [gradle-plugins-2.2.1.jar:2.2.1] 
 > at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_05] 
 > at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_05] 
 > at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_05] 
 > at java.lang.reflect.Method.invoke(Method.java:483) ~[na:1.8.0_05] 
 > at org.gradle.messaging.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35) [gradle-messaging-2.2.1.jar:2.2.1] 
 > at org.gradle.messaging.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24) [gradle-messaging-2.2.1.jar:2.2.1] 
 > at org.gradle.messaging.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:32) [gradle-messaging-2.2.1.jar:2.2.1] 
 > at org.gradle.messaging.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:93) [gradle-messaging-2.2.1.jar:2.2.1] 
 > at com.sun.proxy.$Proxy2.processTestClass(Unknown Source) [na:na] 




### v1.1.7
**Commits with examples:**

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/75415857c76fa70) Better integration of Actors and Question objects 

 > Actors can now ask questions directly, e.g. 
 > --- 
 > Integer totalCost = dana.asksFor(theTotalCost()); 
 > --- 
 > They can also remember the answers to questions for future use: 
 > --- 
 > dana.remember(&quot;Total Cost&quot;, theTotalCost()); 
 > assertThat(dana.recall(&quot;Total Cost&quot;)).isEqualTo(14); 
 > --- 


### v1.1.6
**Commits with examples:**


* [commit:](https://github.com/serenity-bdd/serenity-core/commit/a2089724582c419) Ensure that Consequence steps are not evaluated after a previous step has failed. 

 > This avoids misleading error messages. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/4404ea3c9f3c91b) Refactored the journey demo test 

 > To better illustrate tasks/interaction layers. 




* [commit:](https://github.com/serenity-bdd/serenity-core/commit/3006a4ea233ddc9) fix: Improved error reporting for provided drivers 

 > DriverSources may implement some non-trivial logic, so it is very handy 
 > for debugging to include in stack trace exception occurred while tried to 
 > initialize new webdriver. Especially in multi-node test environment 
 > configurations. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/63458448580c2b0) Removed redundant code that was causing errors in the reports. 

 > If there were more than one given clause in a journey-style test, the initial givens where incorrectly nested. 


### v1.1.5
**Commits with examples:**











### v1.1.4
**Commits with examples:**





* [commit:](https://github.com/serenity-bdd/serenity-core/commit/9722c9025f24bef) You can now include assertions in the tests 

 > You can now include assertions in the tests and reports using the Consequence class. 







* [commit:](https://github.com/serenity-bdd/serenity-core/commit/7755f2efdada037) Simplified variable injection into step descriptions. 

 > You can now inject any member variable in the step class by name into step descriptions 
 > You can now use member variables of a step library in the @Step annotation to augment the step description. Just refer to the variable using the name of the variable prefixed by a &quot;#&quot;, as shown in this example: 
 > ---- 
 > private final String siteName = &quot;Etsy&quot;; 
 > @Step(&quot;Search for a shop called {0} on the #siteName website&quot;) 
 > public void searches_for_shop_called(String shopName) { 
 > homePage.searchForShopCalled(shopName); 
 > } 
 > ---- 



* [commit:](https://github.com/serenity-bdd/serenity-core/commit/9b7c6025d8fef90) Inject step variables by name into step descriptions 

 > You can now use member variables of a step library in the @Step annotation to augment the step description. Just refer to the variable using the name of the variable prefixed by a &quot;#&quot;, as shown in this example: 
 > ---- 
 > @Reported 
 > private final String siteName = &quot;Etsy&quot;; 
 > @Step(&quot;Search for a shop called {0} on the #siteName website&quot;) 
 > public void searches_for_shop_called(String shopName) { 
 > homePage.searchForShopCalled(shopName); 
 > } 
 > ---- 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/c0b0fffc15caa85) Added support for TypeSafeConfig 

 > You can now provide a TypeSafeConfig configuration file (https://github.com/typesafehub/config) instead of a serenity.properties file. The file can be called &#39;serenity.conf&#39; or any of the other Type Safe Config configuration files names. 
 > The configuration file can contain both Serenity variables and other arbitrary variables, which will be available in the EnvironmentVariables field. For example, a simple configuration file might look like this. 
 > ---- 
 > serenity { 
 > logging = DEBUG 
 > } 
 > environment { 
 > uat = uat-server 
 > } 
 > ---- 



### v1.1.3
**Commits with examples:**



### v1.1.2
**Commits with examples:**




### v1.1.1
**Commits with examples:**






### v1.1.0
**Commits with examples:**











* [commit:](https://github.com/serenity-bdd/serenity-core/commit/9c94af955b05e0f) Added the &#39;deep.step.execution.after.failures&#39; option 

 > This option (set to false by default), lets you control the execution depth of the @Step methods after a step has failed. If set to true, it will run nested @Step methods as well as top-level ones. 






* [commit:](https://github.com/serenity-bdd/serenity-core/commit/1764651aff9b8a7) Fixed a timeout issue. 

 > Fixed a timeout issue related to using withTimeoutOf(...).waitForElementToDisappear() 



* [commit:](https://github.com/serenity-bdd/serenity-core/commit/7a57c62bcb1dff0) Added basic support for the &#39;dry-run&#39; option. 

 > Rest calls will now be skipped if you activtate &#39;dry-run&#39; mode (e.g. by setting the &#39;serenity.dry.run&#39; system property to true). 









### v1.0.64
**Commits with examples:**

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/21b96f814fd53d6) fix: Improved error messages for remote drivers 

 > Better error message reporting if a remote driver is incorrectly configured, and some minor refactoring. 



### v1.0.62
**Commits with examples:**




### v1.0.61
**Commits with examples:**





### v1.0.59
**Commits with examples:**





### v1.0.58
**Commits with examples:**





### v1.0.57
**Commits with examples:**




### v1.0.56
**Commits with examples:**



### v1.0.54
**Commits with examples:**






### v1.0.53
**Commits with examples:**











* [commit:](https://github.com/serenity-bdd/serenity-core/commit/6421a4ccd0b4964) Added better support for reporting exceptions 

 > We now support reporting exceptions with a zero-parameter constructor as well as a single-parameter constructor. 


### v1.0.52
**Commits with examples:**




### v1.0.51
**Commits with examples:**



* [commit:](https://github.com/serenity-bdd/serenity-core/commit/d0d500c06511a93) Attempt to fix #69 

 > Issue #69 looks like an OS/filesystem-specific issue related to Java 7 atomic copies. This version uses REPLACE_EXISTING instead of ATOMIC_MOVE. 


* [commit:](https://github.com/serenity-bdd/serenity-core/commit/6e7255dc2c22bfc) Deprecate SpringIntegration. 

 > Add SpringIntegrationMethodRule and SpringIntegrationClassRule, as well as the utility runner SpringIntegrationSerenityRunner, which conveniently automatically adds the aforementioned rules. 
 > (Note that some of the main code and test code for the above new classes were originally written in Java 8 and used method references, lambdas and java.util.function.*. To get Java 7 support, these has been replaced by interfaces and anonymous inner classes, but if the project ever moves to Java 8, it is recommended that these are replaced once again). 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/e38147cc49d8c86) Moved the tests in serenity-junit that depended on serenity-spring, into serenity-spring, so serenity-junit no longer depends on serenity-spring. 

 > This is in preparation for an upcoming commit - Not doing this would cause a circular dependency between serenity-junit and serenity-spring. 


### v1.0.50
**Commits with examples:**




### v1.0.49
**Commits with examples:**



### v1.0.48
**Commits with examples:**







* [commit:](https://github.com/serenity-bdd/serenity-core/commit/35250bdb902423f) Made the reporting a bit more robust 

 > Correctly cater for exceptions without an error message. 






* [commit:](https://github.com/serenity-bdd/serenity-core/commit/23af5a66522cc35) Added basic support for RestAssured. 

 > You can now add the serenity-rest-assured module to have tight integration with Rest Assured for testing REST web services. Serenity provides a wrapper around the RestAssured methods that reports on the REST queries sent and the responses recieved. Use the SerenityRest.rest() method as a starting point, e.g. 
 > ```` 
 > rest().given().contentType(&quot;application/json&quot;).content(jsonPet).post(&quot;http://petstore.swagger.io/v2/pet&quot;); 
 > rest().get(&quot;http://petstore.swagger.io/v2/pet/{id}&quot;, pet.getId()).then().statusCode(200) 
 > .and().body(&quot;name&quot;, equalTo(pet.getName())); 
 > ```` 





### v1.0.47
**Commits with examples:**



* [commit:](https://github.com/serenity-bdd/serenity-core/commit/ba4153da4c89e33) Improved automatic detection of file-system requirements hierarchies. 

 > Looks for JBehave or Cucumber feature files and derives the 
 > corresponding requirements structure based on the depth of the 
 > requirements directories. 



* [commit:](https://github.com/serenity-bdd/serenity-core/commit/39d059a4b103ea1) Added a hasClass() method to the WebElementFacade 

 > This method is a convenient way to check whether a web element has a 
 > particular CSS class. 


* [commit:](https://github.com/serenity-bdd/serenity-core/commit/ef5aebc607c0df5) Fixed a bug in the JUnit parameterized reports 

 > Ensure that errors are correctly reported in JUnit parameterized reports. 




* [commit:](https://github.com/serenity-bdd/serenity-core/commit/bdc3c68d6bf902c) Serenity now generates JUnit-compatible XML reports. 

 > These reports have the SERENITY-JUNIT prefix. 











* [commit:](https://github.com/serenity-bdd/serenity-core/commit/7d969e88d54fc0c) Allow EnvironmentVariables and SystemConfiguration fields to be 

 > injected into JUnit tests. 




### v1.0.46
**Commits with examples:**






* [commit:](https://github.com/serenity-bdd/serenity-core/commit/5205c75874d5344) Added better error reporting if a groovy expression in the build info properties was incorrect 

 > Better error handling for Groovy expressions used in the “sysinfo.*” 
 > system properties that appear in the build info page. 


### v1.0.45
**Commits with examples:**



* [commit:](https://github.com/serenity-bdd/serenity-core/commit/42884b1685a5b2d) Don&#39;t display the browser icon for non-web tests. 

 > Distinguish among Serenity Web Tests (Selenium) and Serenity Non-Web Test (#41) 




* [commit:](https://github.com/serenity-bdd/serenity-core/commit/4e17cef7fc39428) Added the &#39;feature.file.language&#39; to support I18N feature files 

 > Narrative text can now be read from non-English feature files, by setting the &#39;feature.file.language&#39; system property. 




### v1.0.44
**Commits with examples:**





### v1.0.43
**Commits with examples:**



### v1.0.42
**Commits with examples:**

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/33ff1a16031cb98) Allows explicit waits on web elements in a page 

 > For example: 
 > withTimeoutOf(5, TimeUnit.SECONDS).waitFor(facebookIcon).click() 


### v1.0.41
**Commits with examples:**




### v1.0.40
**Commits with examples:**





### v1.0.39
**Commits with examples:**












### v1.0.38
**Commits with examples:**











* [commit:](https://github.com/serenity-bdd/serenity-core/commit/d2a20188ab24fd4) Update WhenLoadingTestDataFromACSVFile.java 

 > Added all possible parameters for CSVReader to be able to parse special chars like \n \t ... 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/8043809da640f99) Update WhenLoadingTestDataFromACSVFile.java 

 > Added all possible parameters for CSVReader to be able to parse special chars like \n \t ... 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/aa1c3ed0fa00fc7) Update CSVTestDataSource.java 

 > Added all possible parameters for CSVReader to be able to parse special chars like \n \t ... 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/df893d20c253dbc) Update CSVTestDataSource.java 

 > Added all possible parameters for CSVReader to be able to parse special chars like \n \t ... 




### v1.0.37
**Commits with examples:**






### v1.0.36
**Commits with examples:**






### v1.0.35
**Commits with examples:**



### v1.0.34
**Commits with examples:**








### v1.0.33
**Commits with examples:**





### v1.0.32
**Commits with examples:**



* [commit:](https://github.com/serenity-bdd/serenity-core/commit/388304241495e0c) feat: nested page objects i.e. widget objects 

 > WidgetObject: reusable page fragment with a nested search context implied by the Composition pattern.  This feature was requested here: 
 > https://groups.google.com/forum/#!topic/thucydides-users/-SiQwD86W8I 
 > https://groups.google.com/forum/#!topic/thucydides-users/01oNgOD9TnY 
 > See attached unit tests for usage examples. 






### v1.0.31
**Commits with examples:**






### v1.0.30
**Commits with examples:**




### v1.0.29
**Commits with examples:**


* [commit:](https://github.com/serenity-bdd/serenity-core/commit/fe1ab3e2ce34859) Added a page to the reports containing system and configuration properties and browser capabilities for a given test run. 

 > The browser used for each test is also recorded and displayed as an icon on the test report pages. 
 > You can also add your own custom fields into the build information page. You do this by adding properties with the &quot;sysinfo&quot; prefix to your serenity.properties file. These variables take Groovy expressions, which will be evaluated when the report is run, e.g: 
 > sysinfo.theAnswer = 6*7 
 > sysinfo.homeDir = System.getenv(&quot;HOME&quot;) 


* [commit:](https://github.com/serenity-bdd/serenity-core/commit/8fee3ad84895083) Chrome no longer opens a new window when you specify the browser size. 

 > Also, the browser is now automatically positioned in the top left hand corner of the screen. 
 > Signed-off-by: John Ferguson Smart &lt;john.smart@wakaleo.com&gt; 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/9784811403dd789) Migrated the PageObject class to the serenitybdd namespace. 

 > Signed-off-by: John Ferguson Smart &lt;john.smart@wakaleo.com&gt; 





### v1.0.27
**Commits with examples:**



### v1.0.26
**Commits with examples:**

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/068315f4f0e63d4) Performance improvements: forces WebDriver to force an immediate response for findElements() calls if no matching elements are found, and some other minor improvements. 

 > Also improved step logging to include the test class and method as well as the step name. 
 > Signed-off-by: John Ferguson Smart &lt;john.smart@wakaleo.com&gt; 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/f9d996950d02e31) Made the log messages for each step include the calling class and method. 

 > Signed-off-by: John Ferguson Smart &lt;john.smart@wakaleo.com&gt; 



* [commit:](https://github.com/serenity-bdd/serenity-core/commit/c9f95050aadcd98) Upgrade javassist version to match transitive dep. #16 

 > core&#39;s version was 3.9.0.GA; reflections version is 3.12.1.GA 



### v1.0.25
**Commits with examples:**






* [commit:](https://github.com/serenity-bdd/serenity-core/commit/099d1189d1c5d0c) core build: exclude transitive deps with convergence problems. #16 

 > Declare additional transitive deps. 


* [commit:](https://github.com/serenity-bdd/serenity-core/commit/22d5395e9df2cbc) Top build: fail fast on dependency convergence problems. #16 

 > Added &quot;force version&quot; on transitive versions with convergence 
 > problems. 
 > Issue: While this works to keep gradle build clean, it doesn&#39;t 
 > affect the generated POM/install for clients. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/7a267aa8399a3dd) Build: Add plugins that help with dep versions. #16 

 > - project-report: 
 > - gradlew htmlDependencyReport creates HTML dep report that shows 
 > which deps the build managed to different version. 
 > - com.github.ben-manes.versions: 
 > - gradlew dependencyUpdates shows deps with new versions 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/70325bb74775cb3) Upgrade commons-lang3 to htmlunit&#39;s dep version. #16 

 > HtmlUnit uses 3.3.2, Serenity was using 3.1. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/ceb0c1d103411a9) Upgrade htmlunit to Selenium&#39;s dep version. #16 

 > Selenium uses 2.15, Serenity was using 2.9. 


### v1.0.24
**Commits with examples:**













* [commit:](https://github.com/serenity-bdd/serenity-core/commit/3a71aaea630baf7) refactor: PageObject still returns thucydides WebElementFacadeImpl so that can be cast to serenitybdd namespace 

 > This will need to be cleaned up when the thucydides namespace is retired. 


* [commit:](https://github.com/serenity-bdd/serenity-core/commit/2648daa127fe42d) refactor: Create serenitybdd version of WebElementFacade classes/interfaces 

 > Deprecate Thucydides versions, but still handle them correctly 









### v1.0.23
**Commits with examples:**




### v1.0.22
**Commits with examples:**



* [commit:](https://github.com/serenity-bdd/serenity-core/commit/2aa92f97522d705) SerenityRunner and SerenityParameterizedRunner now contain functionality, and Thucydides equivalents merely extend 

 > Also move a number of helper classes into serenity_bdd package 



### v1.0.21
**Commits with examples:**




### v1.0.18
**Commits with examples:**





### v1.0.17
**Commits with examples:**



* [commit:](https://github.com/serenity-bdd/serenity-core/commit/0a272c47a9a49f2) Revert &quot;Updated libraries&quot; 

 > This reverts commit 44ec91e92d90ebc3742a6221f82d1a404b1baa57. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/f8f476230acb6e8) Revert &quot;Update reports to use new libraries&quot; 

 > This reverts commit f4a75422ecfc46a66fb5ebb617ce808c299a6d4b. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/d017a61caa8d820) Revert &quot;Refactoring to facilitate easier migrating to new versions of the libraries&quot; 

 > This reverts commit 6f12e5389a8499e2f9f9b69478b329f90367d4fb. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/a25fed4b5fe3830) Revert &quot;Updated excanvas&quot; 

 > This reverts commit 5d55b1eae5d424b7185ed1aab68ab6f36c53cbf6. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/b49d68030bb88d0) Revert &quot;Updated JavaScript InfoVis Toolkit&quot; 

 > This reverts commit a3c95dc54f1165c5ea00fcb2719f14a63acba604. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/1b62cb0a07240b4) Revert &quot;Removed old versions of libraries&quot; 

 > This reverts commit 7b26344dea3c0ee710ee90fe7040141a6941f97f. 









### v1.0.16
**Commits with examples:**


* [commit:](https://github.com/serenity-bdd/serenity-core/commit/6376d9951792d7b) This small change makes Serenity compatible with Firefox version 32 or greater 

 > Guava 18.0 is already specified in Gradle. 


### v1.0.15
**Commits with examples:**



### v1.0.14
**Commits with examples:**



### v1.0.13
**Commits with examples:**




### v1.0.12
**Commits with examples:**



### v1.0.12-rc.1
**Commits with examples:**


* [commit:](https://github.com/serenity-bdd/serenity-core/commit/0902fc79603d4f0) Use gradle-git for version and tagging 

 > === If local repository is dirty 
 > -Always builds a SNAPSHOT version. 
 > -Will complain that &#39;Stage {} is not one of [SNAPSHOT] allowed for strategy snapshot.&#39; 
 > === If local repository is not dirty 
 > Set release type using property release.stage. Valid values are: 
 > -milestone 
 > -rc 
 > -final 
 > milestone creates a tag with the next version from tag + -milestone.# 
 > rc similar, but uses rc. Cannot create a milestone after an rc 
 > final creates a version with no endings 
 > If want to use ssh authorization, must ensure ssh-agent contains correct key for repository being worked on. 
 > If you experience issues, try ssh-add -D to clear identities and add the one identity for the repo in question. 
 > The release tags the current commit, and pushes to the remote repository. It does not check if there&#39;s a new commit, so only use it if you really need to. 
 > gradle bintrayUpload release -Prelease.stage={milestone|rc|final} 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/e0a96d7cd7499a4) Fix scm url&#39;s 

 > All were pointing at project.name, when in fact they all exist in the same 
 > serenity-core repository 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/6d6327665844b25) Correct issue with publishing 

 > Main project doesn&#39;t have anything to deploy, and doesn&#39;t have config. This 
 > causes a warning when building the project. 
 > Provide the config that is common across all projects in this config file, 
 > but no config for the main project is required. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/3ee866cd987cfb1) Remove unused files 

 > It would appear that the main project was moved into core sub-directory, and 
 > these files didn&#39;t get cleaned up. 

* [commit:](https://github.com/serenity-bdd/serenity-core/commit/ed62753b69b522f) [namespace] Move Find annotations to serenity_bdd namespace 

 > Create deprecated versions in thucydides namespace but with 2 on name to ensure 
 > caught all changes, and returning objects of correct classes. 
 > Also kept deprecated versions of tests to ensure old versions still work correctly 











* [commit:](https://github.com/serenity-bdd/serenity-core/commit/581dd4753b647b3) Rename main class to reflect new project name, and deprecate old 

 > Eventually, all Thucydides references will be removed. 



### v1.0.9
**Commits with examples:**





### v1.0.8
**Commits with examples:**









### v1.0.7
**Commits with examples:**






### v1.0.6
**Commits with examples:**



### v1.0.5
**Commits with examples:**









### v1.0.4
**Commits with examples:**

















### v1.0.2
**Commits with examples:**












