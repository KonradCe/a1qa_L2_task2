
## Level 2 - task 2
> a1qa study project

Using Java (TestNG) and Selenium to work with the [userinyerface.com](https://userinyerface.com/), a web page which was designed to provide a bad user experience. The purpose of this task was to get familiar with the [Aquality Selenium](https://github.com/aquality-automation/aquality-selenium-java) library, a company tool for simplifying working with Selenium WebDriver, as well as further learning of Selenium library.


#### test case 1 - filling the form

|  step | expected result  |
| ------------ | ------------ |
|Navigate to home page| Home page is open|
| Go to 'game page' | Card 1 of 4 is open |
| Fill out the form; <br> Accept terms; <br> Click 'next' button; | Card 2 of 4 is open|
| Select 3 random interests; <br> Upload image; <br> Click 'next' button | Card 3 of 4 is displayed |
<br>

#### test case 2 - accepting cookies prompt

|  step | expected result  |
| ------------ | ------------ |
|Navigate to home page| Home page is open|
| Go to 'game page' | Card 1 of 4 is open |
|Accept cookies | Cookies form is closed|

<br>

#### test case 3 - hiding help form

|  step | expected result  |
| ------------ | ------------ |
|Navigate to home page| Home page is open|
| Go to 'game page' | Card 1 of 4 is open |
| Click on the 'send to bottom' button within the help form| Help form is closed |

<br>

#### test case 4 - confirming timer value

|  step | expected result  |
| ------------ | ------------ |
|Navigate to home page| Home page is open|
| Go to 'game page' | Card 1 of 4 is open |
| Read timer value  |Timer should start at 00:00:00 |
