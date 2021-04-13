package Testing.restservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SearchTest extends AbstractTest{

	@Test
	void Search() {
		Assertions.assertEquals(new Search(-79,38,29),new Search(-666,0,38));
		Assertions.assertNotEquals(new Search(369,-128,69),new Search(69,-256,104));
	}

}
