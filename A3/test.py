from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from   selenium.common.exceptions import TimeoutException

driver = webdriver.Firefox(executable_path='/home/pallavi/Study/BE/Sem2/CL3/FinalCodesCL3/A3/geckodriver')
driver.get("http://localhost:5000")
elem = driver.find_element_by_name("text1")
elem1 = driver.find_element_by_name("text2")
submit = driver.find_element_by_id("Send")
elem.send_keys("4")
elem1.send_keys("3")
submit.click()
assert "2" in driver.page_source

driver.close()

