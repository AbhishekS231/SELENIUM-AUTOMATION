package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	@Test
	void test() {
		String actTitle = "Babu";
		String expTitle = "Babu1";
		SoftAssert as = new SoftAssert();
		as.assertEquals(actTitle, expTitle);
		System.out.println("This is soft assertion");
		// create an instance
		// will  run the next statement after failed
		as.assertAll();
		//must use the assertAll at the end

	}
}
