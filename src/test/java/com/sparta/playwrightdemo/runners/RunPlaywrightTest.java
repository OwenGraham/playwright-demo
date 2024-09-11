package com.sparta.playwrightdemo.runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.*;

@Suite
//Add Tests to run here by their tags
@IncludeTags({})
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,value = "com.sparta.playwrightdemo.steps")
//To run tests with combinations of tags, uncomment this line and add the desired tags to the value string
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@Get and @Happy")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "html:../cucumber-report/cucumber.html")
public class RunPlaywrightTest {

}
