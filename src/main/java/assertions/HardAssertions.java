package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {

	@Test
	void test() {
		String actTitle="Babu";
		String expTitle = "Babu";
		Assert.assertEquals(actTitle, expTitle);
        // must be last statement
		// will not run the next statement after failed
		
	}

}
