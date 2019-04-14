package data;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "loginSuccess")
    public Object[][] loginSuccess() {
        return new Object[][]{
                {"khang@gmail.com", "123456"},
                {"khang@gmail.com", "123"}
        };
    }

    @DataProvider(name = "loginFailed")
    public Object[][] loginFailed() {
        return new Object[][]{
                {"test@gmail.com", "123", "Email and password do not match"},
                {" ", " ", "Email and password are required"},
                {"a@gmail.com", " ", "Email and password do not match"}};
    }

}
