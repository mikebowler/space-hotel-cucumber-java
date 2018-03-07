package com.gargoylesoftware.spacehotel;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;

@RunWith(Cucumber.class)
@CucumberOptions(features="features")
public class CukeRunnerTest {
}