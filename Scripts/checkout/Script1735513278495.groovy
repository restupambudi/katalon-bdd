import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.github.javafaker.Faker

Faker faker = new Faker()

WebUI.callTestCase(findTestCase('addToCart'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/checkout'))

String firstName = faker.name().firstName()

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/firstName'), firstName)

String lastName = faker.name().lastName()

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/lastName'), lastName)

String postcode = faker.address().zipCode()

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/postcode'), postcode)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/continue'))

WebUI.verifyTextPresent('Sauce Labs Backpack', false)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/finish'))

WebUI.verifyTextPresent('Thank you for your order!', false)

