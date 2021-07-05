package uiActions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class TextElementActions {
	@Keyword
	def VerifyTextMatches(String textObjectToGet, String expectedText, boolean isRegex) {

		WebUI.verifyMatch(WebUI.getText(findTestObject(textObjectToGet)), expectedText, isRegex, FailureHandling.CONTINUE_ON_FAILURE);
		//WebUI.delay(GlobalVariable.G_DELAY);
	}

	@Keyword
	def SetTextElement(String element, String value, int delayAmount, FailureHandling failHandler) {

		if(failHandler != null) {
			WebUI.setText(findTestObject(element), GlobalVariable.G_DEFAULT_USER, failHandler);
		}
		else {
			WebUI.setText(findTestObject(element), GlobalVariable.G_DEFAULT_USER);
		}

		if(delayAmount > 0) WebUI.delay(delayAmount);
	}

	@Keyword
	def SetObjectTextElement(String element) {
		WebUI.setText(findTestObject(element), GlobalVariable.G_DEFAULT_USER, FailureHandling.CONTINUE_ON_FAILURE);
		WebUI.delay(GlobalVariable.G_DELAY);
	}
}
